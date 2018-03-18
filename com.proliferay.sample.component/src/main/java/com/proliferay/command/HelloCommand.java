
package com.proliferay.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.proliferay.api.HelloApi;

@Component(
	immediate = true,
	property = {
        "osgi.command.scope=proliferay",
        "osgi.command.function=hello"
    },
    service = Object.class
)
public class HelloCommand {

	

	public void hello(String name) {
		String message = _helloApi.sayHello(name);
		
		System.out.println("############# Message ###############" + message); 
	}

	@Reference
	private HelloApi _helloApi;
}