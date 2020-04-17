package akasugi.icqbot.command;


import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestCommandReader {
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"/java -jar test.java",new String[] {"/java","-jar","test.java"}}
			,{"/shutdown -s -t 3600",new String[] {"/shutdown","-s","-t","3600"}}
		});
	}
	
	private String input;
	private String[] expected;
	
	public TestCommandReader(String input, String[] expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void testPhrase() {
		
		CommandReader reader=new CommandReader(input);
		ArrayList<String> actual=new ArrayList<String>();
		int length=0;
		while(reader.hasNext()) {
			actual.add(reader.nextPhrase());
			length++;
		}
		assertArrayEquals(expected, actual.toArray(new String[length]));
		
	}
	
}
