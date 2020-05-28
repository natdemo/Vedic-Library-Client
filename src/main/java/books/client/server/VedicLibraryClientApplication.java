package books.client.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class VedicLibraryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(VedicLibraryClientApplication.class, args);
	}


}
