package com.sjd.mockrest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalledController {

	@RequestMapping("/called")
	public String sayHello() {
		return "Called Me";
	}

}
