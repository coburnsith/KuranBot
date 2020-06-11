package akasugi.icqbot.command;

public abstract class AbstractCommand {
	
	
	abstract public String getPrefix();
	
	abstract public void execute(CommandReader reader) throws CommandFormatException;
	
	

}
