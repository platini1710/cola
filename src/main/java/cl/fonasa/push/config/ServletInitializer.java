package cl.fonasa.push.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

import cl.fonasa.push.main.JmsReaderConsumerApplication;


public class ServletInitializer extends SpringBootServletInitializer implements WebApplicationInitializer {
	   @Override   
	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(JmsReaderConsumerApplication.class);   }
}
