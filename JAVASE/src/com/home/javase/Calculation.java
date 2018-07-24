package com.home.javase;

public class Calculation {
	public static void main(String[] args) {
		int i=46;
		int j=97;
		char c='a';
		System.out.println("46&97的值是："+(i&j));
		System.out.println("46^a的值是："+(i^c));
		System.out.print("46>>1:"+(i>>1));
	}
}
