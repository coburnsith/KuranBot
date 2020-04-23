package akasugi.icqbot.command;

import cc.moecraft.icq.event.events.message.EventMessage;

public abstract class AbstractCommand<T extends EventMessage> {
	
	
	abstract public String getPrefix();
	
	abstract public void execute(CommandReader<T> reader) throws CommandFormatException;
	
	

}
