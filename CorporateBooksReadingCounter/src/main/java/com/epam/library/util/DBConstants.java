package com.epam.library.util;

import java.util.ResourceBundle;

public class DBConstants {
	private static final String DRIVER_NAME_KEY = "database.driverName";
	
	private static final String CONNECTION_STRING_KEY = "database.connectionString";
	
	private static final String USERNAME_KEY = "database.username";
	
	private static final String P_WORD_KEY = "database.p-word";
	
	private static final String BUNDLE_NAME = "database";
	
	private static final ResourceBundle bundle = 
			ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static final String DRIVER_NAME = 
			bundle.getString(DRIVER_NAME_KEY);
	
	public static final String CONNECTION_STRING = 
			bundle.getString(CONNECTION_STRING_KEY);
	
	public static final String USERNAME = bundle.getString(USERNAME_KEY);
	
	public static final String P_WORD = bundle.getString(P_WORD_KEY);
}
