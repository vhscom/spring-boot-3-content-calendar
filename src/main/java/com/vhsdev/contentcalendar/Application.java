package com.vhsdev.contentcalendar;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    //ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

    // Handy trick for getting a list of all the Beans in the application context
    //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    // IntelliJ IDEA has a built-in feature for this, but it's still a handy trick to know.

    // You can also get a specific Bean by name
    // We cast the Bean to a RestTemplate because we know that's what it is
    //RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
    //log.info("RestTemplate Bean: {}", restTemplate);
  }

}
