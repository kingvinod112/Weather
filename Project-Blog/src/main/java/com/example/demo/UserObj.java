package com.example.demo;

public class UserObj {
	private static  String name;

	@SuppressWarnings("static-access")
	public UserObj(String name) {
		super();
		this.name = name;
	}

	public static String getName() {
		return name;
	}

	
	
	

}
