package com.sjd.mockrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public String callIt() {

		String called = restTemplate.getForObject("http://localhost:8080/api/called", String.class);
		return called;

	}

}
