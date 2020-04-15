package akasugi.icqbot.command;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestCommands {
	String[] commands= {"/dir test","/cd test","/会战 出刀","/抽卡 十连 一发入魂"};
	String[] prefixs= {"/dir","/cd","/会战","/抽卡"};
	String[] preRemoved= {"test","test","出刀","十连 一发入魂"};
	
	@Test
	public void testPrefix() {
		int i=0;
		for(String c:commands) {
			commands[i++]=Commands.getPrefix(c);
		}
		assertArrayEquals(commands, prefixs);;
	}
	
	@Test
	public void testRemovePrefix() {
		int i=0;
		for(String c:commands) {
			commands[i++]=Commands.removePrefix(c);
		}
		assertArrayEquals(commands, preRemoved);;
		
	}

}
