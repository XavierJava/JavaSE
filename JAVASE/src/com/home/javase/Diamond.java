package com.home.javase;

public class Diamond {

	public static void main(String [] args) {
		String s = new String("abc,def,ghi,gki");
		String[] news =s.split(",");
		System.out.println("按分隔符分割后的字符串是：");
		for(int i=0;i<news.length;i++){
			System.out.println(news[i]);
		}
		
		
	}

}
