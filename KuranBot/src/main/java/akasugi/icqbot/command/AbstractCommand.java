package akasugi.icqbot.command;

import cc.moecraft.icq.event.Event;

public abstract class AbstractCommand {
	
	String prefix;
	
	public String getPrefix(){
		return prefix;
	}
	
	abstract public void receiveEvent(Event event);
	
	

}
