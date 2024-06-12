package com.vhsdev.contentcalendar;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

    // Handy trick for getting a list of all the Beans in the application context
    Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    // IntelliJ IDEA has a built-in feature for this, but it's still a handy trick to know.
  }

}
