package com.fauv.authenticator.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordUtils {
	
	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean validateHashWithPassword(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
		
}
