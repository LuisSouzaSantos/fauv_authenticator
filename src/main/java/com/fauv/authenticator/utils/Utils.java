package com.fauv.authenticator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {

	public final static ObjectMapper objectMapper = new ObjectMapper();
	public final static String EMAIL_REGEX_PATTERN = "^(.+)@(\\S+)$";
	
	public static String removeAllUnecessaryBlankSpaces(String value) {
		if (value == null) { return value; }
		
		return value.trim();
	}
	
}
