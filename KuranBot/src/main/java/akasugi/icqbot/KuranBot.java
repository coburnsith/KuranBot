package akasugi.icqbot;

import akasugi.icqbot.event.GroupMsgListener;
import cc.moecraft.icq.PicqBotX;
import cc.moecraft.icq.PicqConfig;

public class KuranBot {

	public static void main(String[] args) {
		
		PicqConfig config = new PicqConfig(31092) ;
		PicqBotX bot = new PicqBotX(config);
		bot.addAccount("bot1","127.0.0.1",31091);
		
		bot.getEventManager().registerListener(new GroupMsgListener());
		
		bot.startBot();

	}

}
