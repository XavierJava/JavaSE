package com.home.javase;

public class CheckHandSetNum {

	public static void main(String[] args) {
		String phone1 ="11024588795";
		String phone2 ="15044268138";
		System.out.println(check(phone1));

		System.out.println(check(phone2));
		
		
	}

	private static String check(String phone) {
		String regex="1[3,5,8]\\d{9}$";
		if(phone.matches(regex)) {
			return phone+"是合法手机号";
		}else {
			return phone+"不是合法手机号";
		}
			
	}

}
