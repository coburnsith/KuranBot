package akasugi.icqbot.plugin.kuran;

import java.util.HashMap;
import java.util.Map;

import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cc.moecraft.icq.sender.IcqHttpApi;

public class KuranBattle {
	
	private static Map<Long,KuranBattle> battles = new HashMap<Long, KuranBattle>();
	
	private Long groupId;
	private Long menberId;
	private int timelimit=0;
	private IcqHttpApi api;
	private Thread battleThread;
	
	private KuranBattle(Long groupId, Long menberId , IcqHttpApi api) {
		this.groupId = groupId;
		this.menberId = menberId;
		this.api=api;
	}
	
	private static synchronized int check(Long groupId, Long menberId){
		//没人在出刀
		if(!battles.containsKey(groupId))
			return 0;
		//别人在出刀
		else if(!battles.get(groupId).menberId.equals(menberId))
			return 1;
		//你在出刀
		else
			return 2;
	}
	

	private void fight() {
		
		battles.put(groupId,this);
		
		battleThread=new Thread(()->{
			
			while((timelimit++)<120  && !Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}
			
			battles.remove(this.groupId);
			api.sendGroupMsg(groupId, "出刀结束");
		});
		battleThread.start();
		
	}
	
	public static void startFight(EventGroupMessage event) {
		Long groupId=event.getGroupId();
		Long menberId=event.getSenderId();
		IcqHttpApi api=event.getHttpApi();
		int check=check(groupId,menberId);
		
		switch(check){
		case 0:
			new KuranBattle(groupId,menberId,api).fight();
			api.sendGroupMsg(groupId, "出刀成功");
			break;
		case 1:{
			String menberInBattle=api.getGroupMemberInfo(groupId, menberId).getData().getCard();
			int time = battles.get(groupId).timelimit;
			api.sendGroupMsg(groupId, "出刀失败，"+menberInBattle+"正在出刀("+time+"秒)");
			break;
		}
		case 2:
			int time = battles.get(groupId).timelimit;
			api.sendGroupMsg(groupId, "你已经在出刀了("+time+"秒)");
		}
		
	}
	
	public static void stopFight(EventGroupMessage event) {
		
		Long groupId=event.getGroupId();
		Long menberId=event.getSenderId();
		IcqHttpApi api=event.getHttpApi();
		int check=check(groupId,menberId);
		
		switch(check){
		case 0:
			api.sendGroupMsg(groupId, "并没有人在出刀");
			break;
		case 1:
			String menberInBattle=api.getGroupMemberInfo(groupId, menberId).getData().getCard();
			int time = battles.get(groupId).timelimit;
			api.sendGroupMsg(groupId, "收刀失败，"+menberInBattle+"正在出刀("+time+"秒)");
			break;
		case 2:
			battles.get(groupId).battleThread.interrupt();
			
		}
		
	}
	
}
