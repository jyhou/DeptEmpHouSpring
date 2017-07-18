package com.johnny.deptemp.service;

public class ValidateUser {
	private static final String username = "Johnny";
	private static final String pwd = "123";

	public static boolean validateUser(String userName, String password) {
		if (username.equals(userName) && pwd.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
