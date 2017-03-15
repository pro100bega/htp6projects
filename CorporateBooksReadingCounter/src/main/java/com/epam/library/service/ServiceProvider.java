package com.epam.library.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {

	public static final ServiceProvider instance = new ServiceProvider();
	
	private Map<Integer, Service> services = new HashMap<>();
	
	private static final Integer ADD_BOOK_CODE = 1;
	
	private ServiceProvider() {
		services.put(ADD_BOOK_CODE, new AddBookService());
	}
	
	public Service getService(int code) throws IllegalCodeException {
		if (code > 0) {
			return services.get(code);
		} else {
			throw new IllegalCodeException("Service code must be greater than null");
		}
	}
}
