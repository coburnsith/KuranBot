package akasugi.icqbot.event;

import akasugi.icqbot.command.CommandManager;
import cc.moecraft.icq.event.EventHandler;
import cc.moecraft.icq.event.IcqListener;
import cc.moecraft.icq.event.events.message.EventGroupMessage;
import cc.moecraft.icq.event.events.message.EventMessage;

public class MsgListener extends IcqListener{
	
	@EventHandler
	public void forwardEvent(EventMessage event){
		
		if(event instanceof EventGroupMessage && event.getMessage().startsWith("/")) {
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
