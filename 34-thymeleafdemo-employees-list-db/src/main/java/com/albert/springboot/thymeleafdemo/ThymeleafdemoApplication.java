package com.albert.springboot.thymeleafdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages={"com.albert.springboot.thymeleafdemo"})
public class ThymeleafdemoApplication extends SpringBootServletInitializer {

	// set up a logger for diagnostics
//	private Logger logger = Logger.getLogger(getClass().getName());

	// set up variable to hold the properties
//	@Autowired
//	private Environment env;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ThymeleafdemoApplication.class);
//		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ThymeleafdemoApplication.class);
	}

	// need a helper method
	// read environment property and convert to int
//	private int getIntProperty(String propName) {
//
//		String propVal = env.getProperty(propName);
//
//		// now convert to int
//		int intPropVal = Integer.parseInt(propVal);
//
//		return intPropVal;
//	}

}
