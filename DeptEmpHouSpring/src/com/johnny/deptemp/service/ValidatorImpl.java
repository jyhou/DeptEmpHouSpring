package com.johnny.deptemp.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorImpl implements Validator{
	
	private final String userName = "Johnny";
	private final String password = "123";

	@Override
	public boolean validateUser(String userName, String password) {
		if (this.userName.equals(userName) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
