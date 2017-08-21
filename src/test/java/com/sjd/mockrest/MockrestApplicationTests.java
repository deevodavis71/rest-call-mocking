package com.sjd.mockrest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockrestApplicationTests {

	@Autowired
	private MyService myService;

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@Before
	public void setUp() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMockService() {

		mockServer.expect(requestTo("http://localhost:8080/api/called")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("SPOOFED ME UP", MediaType.TEXT_PLAIN));

		String result = myService.callIt();

		mockServer.verify();

		Assert.assertEquals("SPOOFED ME UP", result);
	}
}
