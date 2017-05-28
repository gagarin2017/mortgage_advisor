package com.greenland.model;

import java.util.*;

public class Authenticator {

	private static Map<String, String> userPool = new HashMap<String, String>();

	static {
		userPool.put("John Smith", "john1");
		userPool.put("Ivy Smith", "ivy1");
	}

	public boolean accessGrantedForName (final String username, 
		final String password) {

		boolean accessGranted = false;

		for(final String name : userPool.keySet()) {
			if(name.equalsIgnoreCase(username) 
				&& password.equalsIgnoreCase(userPool.get(name))) {
				accessGranted = true;
				break;
			}
		}

	return accessGranted;
	}
}