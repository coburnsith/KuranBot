package akasugi.icqbot.command;

import java.util.HashMap;
import java.util.Map;

public class ShortcutCommand {
	
	private static Map<String,String> shortcuts=new HashMap<String, String>();
	
	public static void initShortcut(){
		
		shortcuts.put("/出刀", "/会战 -出刀");
		shortcuts.put("/收刀", "/会战 -收刀");
		
	}
	
	public static String transformShortcut(String command){
		if(shortcuts.containsKey(command))
			return shortcuts.get(command);
		else
			return command;
	}

}
