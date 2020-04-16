package akasugi.icqbot.command;

import cc.moecraft.icq.event.events.message.EventGroupMessage;

public abstract class AbstractCommand {
	
	
	abstract public String getPrefix();
	
	abstract public void receiveGroupCommand(CommandReader reader,EventGroupMessage event);
	
	

}
