package class08;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个方法返回的只是"看上去像"的字符串，因为str[i] = 0;这一行，ASCII表中0为空字符，但它也是个字符
 */
public class Code02_PrintAllSubsequences {

	public static void printAllSubsequence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	// 当前来到i位置，要和不要，走两条路
	// 之前的选择，所形成的结果，是str
	public static void process(char[] str, int i) {
		if (i == str.length) {
			System.out.println(String.valueOf(str));
			return;
		}
		process(str, i + 1); // 要当前字符的路
		char tmp = str[i];
		str[i] = 0;
		process(str, i + 1); // 不要当前字符的路
		str[i] = tmp;
	}

	
	public static List<String> getAllSubs(String s){
		char[] str = s.toCharArray();
		String path = "";
		List<String> ans = new ArrayList<>();
		process(str, 0, ans, path);
		
		return ans;
	}
	
	public static void process(char[] str, int index, 
			List<String> ans, String path) {
		if(index == str.length) {
			ans.add(path);
			return;
		}
		String noPath = path;
		process(str, index+1,ans, noPath);
		String yesPath = path + String.valueOf(str[index]);
		process(str, index+1,ans, yesPath);
	}
	
	
	

	public static void main(String[] args) {
//		String test = "abc";
//		printAllSubsquence(test);
		char a = 0; // 空字符
		System.out.println("------");
		System.out.println(a);
		System.out.println("------");
//		List<String> ans = getAllSubs(test);
//
//
//		for(String str : ans) {
//			System.out.println(str);
//		}
	}

}
