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
			{"/java -jar test.java",new String[] {"java","-jar","test.java"}}
			,{"/shutdown -s -t 3600",new String[] {"shutdown","-s","-t","3600"}}
			,{"/会战 -删除成员 张三",new String[]{"会战","-删除成员","张三"}}
			,{"/复读 -次数 3 -间隔 2 我是复读机",new String[]{"复读","-次数","3","-间隔","2","我是复读机"}}
			,{"/我 是 谁 皮 卡 丘",new String[]{"我","是","谁","皮","卡","丘"}}
			,{"/会战 删除成员 \"完 全 一 致\"",new String[]{"会战","删除成员","完 全 一 致"}}
			,{"/会战 删除成员 \"完 全 一 致\" 才怪",new String[]{"会战","删除成员","完 全 一 致","才怪"}}
			,{"/会战 添加成员 \"我 是 火 车 人\" \"真 的\"",new String[]{"会战","添加成员","我 是 火 车 人","真 的"}}
			,{"/会战 添加成员 \"我 是 火 车 人\" 真 的\"",new String[]{}}
			,{"/会战 添加成员 \"我 是 火 车 人\" 真 的 \"",new String[]{}}
			,{"/会战 添加成员 \"我 是 火 车 人 真 的",new String[]{}}
			,{"/会战 添加成员 我 是 火 车 人\" 真 的",new String[]{}}
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
		
		CommandReader reader=new CommandReader(input,null);
		ArrayList<String> actual=new ArrayList<String>();
		int length=0;
		try {
			while(reader.hasNext()) {
				actual.add(reader.nextPhrase());
				length++;
			}
			assertArrayEquals(expected, actual.toArray(new String[length]));
		}catch (CommandFormatException e) {
			System.out.println(e.getMsg());
			e.printStackTrace();
		}
		
	}
	
}
