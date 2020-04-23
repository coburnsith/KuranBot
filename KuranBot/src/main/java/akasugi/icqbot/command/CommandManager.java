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
		String command=ShortcutCommand.transformShortcut(event.getMessage());
		CommandReader<EventGroupMessage> reader=new CommandReader<EventGroupMessage>(command,event);
		String prefix;
		try {
			prefix = reader.nextPhrase();
			if(commands.containsKey(prefix)){
				commands.get(prefix).execute(reader);
			}
		} catch (CommandFormatException e) {
			event.getHttpApi().sendGroupMsg(event.getGroupId(), e.getMsg());
			e.printStackTrace();
		}
		
	}

}
