package akasugi.icqbot.event;

import akasugi.icqbot.command.CommandManager;
import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cc.moecraft.icq.event.events.message.EventMessage;

public class MsgListener extends IcqListener{
	
	@EventHandler
	public void forwardEvent(EventMessage event){
		
		//监听消息事件，如果收到的是 群消息 且以“/”开头，则转发给CommandManager
		if(event instanceof EventGroupMessage && event.getMessage().trim().startsWith("/")) {
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					CommandManager.forwardGroupCommand((EventGroupMessage)event);
				}
				
			});
			thread.start();;
			
		}
		
		
	}

}
