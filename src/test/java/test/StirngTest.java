package test;

import java.util.Date;

public class StirngTest {

	public static void main(String[] args) {
		String str=String.format("%s:%s", 1,2);
		String str1=String.format("%2$s:%2$s", 1,2);
		System.out.println(str);
		System.out.println(str1);
		String s2 = String.format("%1$tY-%1$tm-%1$te", new Date());  
		System.out.println(s2);
		
		
	}
	
	
}
