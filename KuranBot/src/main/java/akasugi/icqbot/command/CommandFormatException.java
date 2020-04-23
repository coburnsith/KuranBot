package akasugi.icqbot.command;

public class CommandFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -779665754140660990L;
	
	public CommandFormatException(){
	}
	
	public String getMsg() {
		return "命令格式错误";
	}

}
