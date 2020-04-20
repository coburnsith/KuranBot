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
	
	public boolean nextIsOption(){
		if(present()=='/' || present()=='-') {
			index++;
			return true;
		}else {
			return false;
		}
			
	}
	
	public char present() {
		return command.charAt(index);
	}
	
	public char next() {
		return command.charAt(index++);
	}
	
	public String nextPhrase() throws CommandFormatException{
		String phrase;
		boolean quotationPaired = true;
		
		if(present()=='\"') {
			//返回带引号的元素
			index++;
			quotationPaired=false;
			while(hasNext()) {
				if(present()=='\"') {
					index++;
					quotationPaired=true;
					break;
				}
				builder.append(next());
			}
		}else {
			//返回不带引号的元素
			while(hasNext() && !nextIsSpace()) {
				if(present()=='\"') {
					throw new CommandFormatException();
				}
				builder.append(next());
			}
		}
		
		if(!quotationPaired) {
			throw new CommandFormatException();
		}
		
		skipSpace();
		phrase=builder.toString();
		builder.setLength(0);
		return phrase;
	}
	
}
