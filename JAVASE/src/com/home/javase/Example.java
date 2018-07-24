package com.home.javase;

import java.util.Date;
import java.util.Locale;

public class Example {

	public static void main(String[] args) {
		Date today = new Date();
		String a = String.format(Locale.US, "%tb",today);
		String b = String.format(Locale.US, "%tB",today);
		String c = String.format("%ta",today);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);


	}

}
