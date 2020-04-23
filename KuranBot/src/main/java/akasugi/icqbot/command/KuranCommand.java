package akasugi.icqbot.command;

import akasugi.icqbot.plugin.kuran.KuranBattle;
import cc.moecraft.icq.event.events.message.EventGroupMessage;

public class KuranCommand extends AbstractCommand<EventGroupMessage>{
	
	private String prefix="会战";
	CommandReader<EventGroupMessage> reader;
	
	@Override
	public String getPrefix() {
		return prefix;
	}

	@Override
	public void execute(CommandReader<EventGroupMessage> reader) throws CommandFormatException {
		
		if(reader.hasNext() && reader.nextIsOption()){
			switch(reader.nextPhrase()){
			case "出刀":
				KuranBattle.startFight(reader.getEvent());
				break;
			case "收刀":
				KuranBattle.stopFight(reader.getEvent());
			}
		}
		
	}
	
}
