package edu.caensup.sio.td3.messagerie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootTd3Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTd3Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootTd3Application.class);
    }

}
