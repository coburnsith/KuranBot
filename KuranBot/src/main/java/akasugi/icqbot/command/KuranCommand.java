package akasugi.icqbot.command;

import cc.moecraft.icq.event.events.message.EventGroupMessage;

public class KuranCommand extends AbstractCommand{
	
	private String prefix="会战";
	CommandReader reader;
	
	@Override
	public String getPrefix() {
		return prefix;
	}

	@Override
	public void execute(CommandReader reader, EventGroupMessage event) {
		
	}
	
}
