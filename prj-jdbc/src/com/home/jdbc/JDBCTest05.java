package com.home.jdbc;


/*
 * Multithread visit the same database table's record ,other threads need to wait
 * 	(1) there are three solution
 *   	A 、 java :use synchronized
 *   	B 、 database :set lsolation level:Serialization (serializable)
 *   	C 、 SQL Language:keywords (for update)

*/

public class JDBCTest05 {

	public static void main(String[] args) {

	}

}
