package com.training.TrainingWorks.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET, path="/hello")
	public String helloWorld() {
		return "Hello World"; 
	}

	@RequestMapping(method=RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-path-variable/{name}")
	public HelloWorldBean helloWorldPathVariables(@PathVariable
			String name) {
		return new HelloWorldBean("Hello World " + name);
	}
}
