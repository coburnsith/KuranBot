package akasugi.icqbot.command;

import java.util.ArrayList;
import java.util.Collections;

public class CommandLine {
	
	private String cmd;
	private ArrayList<String> args;
	
	protected CommandLine(String cmd,String ... args){
		this.cmd=cmd;
		this.args=new ArrayList<String>();
		Collections.addAll(this.args, args);
	}
	
	public String getCommand(){
		return cmd;
	}
	
	public String getArgAt(int index){
		return args.get(index);
	}
	
	public int getNumOfArgs(){
		return args.size();
	}
	
	@Override
	public String toString() {
		StringBuilder str=new StringBuilder(cmd);
		args.forEach(arg->str.append(' ').append(arg));
		return str.toString();
	}

}
