package com.proliferay.impl;

import com.proliferay.api.HelloApi;

public class HelloApiImpl implements HelloApi{

	@Override
	public String sayHello(String name) {
		
		return "Hello "+name;
	}

}
