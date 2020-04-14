package akasugi.icqbot.command;

import java.util.HashMap;
import java.util.Map;

import cc.moecraft.icq.event.events.message.EventMessage;

public class CommandManager {
	
	private Map<String,AbstractCommand> commands=new HashMap<String,AbstractCommand>();
	
	public void registerCommand(AbstractCommand command){
		commands.put(command.getPrefix(),command);
	}
	
	public void forwardCommand(EventMessage event){
		
		String commandPrefix=event.getMessage().split(" ")[0];
		if(commands.containsKey(commandPrefix)){
			commands.get(commandPrefix).receiveEvent(event);
		}
		
	}

}
