package akasugi.icqbot.command;

public class CommandReader {
	
	String command;
	int index=0;
	StringBuilder builder=new StringBuilder("");
	
	private boolean nextIsSpace() {
		return command.charAt(index)==' ';
	}
	
	private void skipSpace() {
		while(hasNext() && nextIsSpace())
			index++;
	}
	
	public CommandReader(String command) {
		this.command=command.trim();
	}
	
	public boolean hasNext() {
		return index < command.length();
	}
	
	public char next() {
		return command.charAt(index++);
	}
	
	public String nextPhrase() {
		String phrase;
		while(hasNext() && !nextIsSpace()) {
			builder.append(next());
		}
		skipSpace();
		phrase=builder.toString();
		builder.setLength(0);
		return phrase;
	}
	
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
