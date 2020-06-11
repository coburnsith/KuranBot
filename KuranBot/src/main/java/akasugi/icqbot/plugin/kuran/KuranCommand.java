package akasugi.icqbot.plugin.kuran;

import akasugi.icqbot.command.AbstractCommand;
import akasugi.icqbot.command.CommandFormatException;
import akasugi.icqbot.command.CommandReader;

public class KuranCommand extends AbstractCommand{
	
	private String prefix="会战";
	CommandReader reader;
	
	@Override
	public String getPrefix() {
		return prefix;
	}

	@Override
	public void execute(CommandReader reader) throws CommandFormatException {
		
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
