package com.vhsdev.contentcalendar.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

  @Override
  public void run(String... args) {
    System.out.println("Do nothing in development mode based on profile.");
  }
}
