package akasugi.icqbot.command;

import cc.moecraft.icq.event.events.message.EventMessage;

public class CommandReader {
	
	String command;
	int index=1;
	EventMessage event;
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
	
	public boolean nextIsQuotation(){
		return command.charAt(index)=='\"';
	}
	
	public boolean nextIsOption(){
		char next=next();
		if(next=='/' || next=='-'){
			return true;
		}else{
			index--;
			return false;
		}
	}
	
	public char next() {
		return command.charAt(index++);
	}
	
	public String nextPhrase() {
		String phrase;
		if(hasNext()&&nextIsQuotation()){
			
		}
		while(hasNext() && !nextIsSpace()) {
			builder.append(next());
		}
		
		skipSpace();
		phrase=builder.toString();
		builder.setLength(0);
		return phrase;
	}
	
}
