package akasugi.icqbot.command;

import cc.moecraft.icq.event.events.message.EventGroupMessage;

public class CommandReader {
	
	private String command;
	private	int index=1;
	private EventGroupMessage event;
	private	StringBuilder builder=new StringBuilder("");
	
	public CommandReader(String command,EventGroupMessage event) {
		this.command=command.trim();
		this.event=event;
	}
	
	public EventGroupMessage getEvent() {
		return event;
	}
	
	private boolean nextIsSpace() {
		return command.charAt(index)==' ';
	}
	
	private void skipSpace() {
		while(hasNext() && nextIsSpace())
			index++;
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
	
	//返回当前语句块，并将光标移动到下一个语句块开头
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
