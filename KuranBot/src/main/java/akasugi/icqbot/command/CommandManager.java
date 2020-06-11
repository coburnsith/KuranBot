package akasugi.icqbot.command;

import java.util.HashMap;
import java.util.Map;

import cc.moecraft.icq.event.events.message.EventGroupMessage;

public class CommandManager {
	
	private static Map<String,AbstractCommand> commands=new HashMap<String,AbstractCommand>();
	
	public static void registerCommand(AbstractCommand command){
		commands.put(command.getPrefix(),command);
	}
	
	//转发命令
	public static void forwardGroupCommand(EventGroupMessage event){
		//如果是快捷命令，则转化为对于对应的长命令
		String command=ShortcutCommand.transformShortcut(event.getMessage());
		CommandReader reader=new CommandReader(command,event);
		//根据命令前缀，转发命令
		String prefix;
		try {
			prefix = reader.nextPhrase();
			if(commands.containsKey(prefix)){
				commands.get(prefix).execute(reader);
			}
		}
		//如果命令格式错误，则通知群
		catch (CommandFormatException e) {
			event.getHttpApi().sendGroupMsg(event.getGroupId(), e.getMsg());
			e.printStackTrace();
		}
		
	}

}
