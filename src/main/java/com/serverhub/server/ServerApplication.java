package com.serverhub.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;
//imports below are only required during initial seeding
//import com.serverhub.server.model.Server;
//import com.serverhub.server.repository.ServerRepository;
//import org.springframework.boot.CommandLineRunner;
//import static com.serverhub.server.enumeration.Status.SERVER_DOWN;
//import static com.serverhub.server.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	// Only run once to seed database also temporarily change DDL-AUTO in application.yml to CREATE when running
//	@Bean
//	CommandLineRunner run (ServerRepository serverRepository){
//		return args -> {
//			serverRepository.save(new Server(null, "192.168.2.1", "Ubuntu Linux", "16 GB",
//					"Personal PC", "server1.png", SERVER_UP));
//			serverRepository.save(new Server(null, "192.16.22.11", "Ubuntu", "32 GB",
//					"Xbox", "server2.png", SERVER_UP));
//			serverRepository.save(new Server(null, "192.168.64.12", "Mobile Device", "8 GB",
//					"iPad pro", "server4.png", SERVER_DOWN));
//			serverRepository.save(new Server(null, "192.168.99.65", "Windows", "64 GB",
//					"Macbook Pro", "server3.png", SERVER_UP));
//		};
//	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration () ;
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
			"Accept","Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Jwt-Token","Authorization",
			"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT", "PATCH", "DELETE","OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}
