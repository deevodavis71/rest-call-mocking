# rest-call-mocking

The secret is to @Autowire the RestTemplate into both the @Service class and the @SpringBootTest class

Also, need to create a method to return a RestTemplate @Bean in the @Service class

 @Service
 public class MyService {
 
 	@Autowired
 	private RestTemplate restTemplate;
 
 	@Bean
 	public RestTemplate restTemplate() {
 		return new RestTemplate();
 	}
 
 ...