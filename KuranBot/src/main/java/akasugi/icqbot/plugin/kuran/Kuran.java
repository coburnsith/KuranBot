package akasugi.icqbot.plugin.kuran;

import java.util.HashMap;
import java.util.Map;

public class Kuran {
	
	private static Map<Long, Kuran> kurans = new HashMap<Long, Kuran>();
	
	Long groupId;
	Long[] menbers;
	
	private static Kuran readKuranFromJson(Long groupId){
		return null;
	}
	
	private static Kuran getKuran(Long groupId){
		if(kurans.containsKey(groupId)){
			return kurans.get(groupId);
		}
		else{
			return readKuranFromJson(groupId);
		}
	}

}
