package akasugi.icqbot.command;

public class Commands {
	
	public static String getPrefix(String command) {
		StringBuilder prefix=new StringBuilder("");
		char c=0;
		for(int i=0;i<command.length()&&(c=command.charAt(i))!=' ';i++) {
			prefix.append(c);
		}
		return prefix.toString();
	}
	
	public static String removePrefix(String command) {
		return command.replace(getPrefix(command), "").trim();
	}

}
