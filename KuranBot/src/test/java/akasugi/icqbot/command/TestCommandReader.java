package akasugi.icqbot.command;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestCommandReader {
	String[] commands= {"/dir test","/cd test","/会战 出刀","/抽卡 十连 一发入魂"};
	String[] prefixs= {"/dir","/cd","/会战","/抽卡"};
	String[] secondPhrase= {"test","test","出刀","十连 一发入魂"};
	
	@Test
	public void nextPhraseTest(){
		int i=0;
		for(String c:commands) {
			commands[i++]=new CommandReader(c).nextPhrase();
		}
		assertArrayEquals(commands, prefixs);
	}

}
