package akasugi.icqbot;

import akasugi.icqbot.command.CommandManager;
import akasugi.icqbot.command.KuranCommand;
import akasugi.icqbot.command.ShortcutCommand;
import akasugi.icqbot.event.MsgListener;
import cc.moecraft.icq.PicqBotX;
import cc.moecraft.icq.PicqConfig;

public class KuranBot{

	public static void main(String[] args) {
		
		PicqConfig config = new PicqConfig(31092) ;
		PicqBotX bot = new PicqBotX(config);
		bot.addAccount("bot1","127.0.0.1",31091);
		
		CommandManager.registerCommand(new KuranCommand());
		ShortcutCommand.initShortcut();
		bot.getEventManager().registerListener(new MsgListener());
		
		bot.startBot();

	}

}
