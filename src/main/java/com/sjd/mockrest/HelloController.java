package com.sjd.mockrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	@Autowired
	private MyService myService;

	@RequestMapping("/hello")
	public String sayHello() {

		String called = myService.callIt();
		return "Hello World (" + called + ")";

	}

}
