package akasugi.icqbot.command;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import akasugi.icqbot.command.*;

class TestCommand {

	@Test
	void test() {
		
		String str=new CommandLine("java","java","java","java","java").toString();
		System.out.println(str);
		
	}

}
