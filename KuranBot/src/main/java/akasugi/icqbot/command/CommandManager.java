package akasugi.icqbot.command;

import java.util.HashMap;
import java.util.Map;

import cc.moecraft.icq.event.events.message.EventGroupMessage;

public class CommandManager {
	
	private static Map<String,AbstractCommand> commands=new HashMap<String,AbstractCommand>();
	
	public static void registerCommand(AbstractCommand command){
		commands.put(command.getPrefix(),command);
	}
	
	public static void forwardGroupCommand(EventGroupMessage event){
		String command=event.getMessage();
		CommandReader reader=new CommandReader(command);
		String prefix=reader.nextPhrase();
		if(commands.containsKey(prefix)){
			commands.get(prefix).receiveGroupCommand(reader, event);
		}
		
	}

}
