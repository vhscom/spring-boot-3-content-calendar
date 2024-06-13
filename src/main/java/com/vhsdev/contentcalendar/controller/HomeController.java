package com.vhsdev.contentcalendar.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Value("${cc.welcomeMessage:Welcome to Content Calendar!}")
  private String welcomeMessage;

  @Value("${cc.about:This is a simple content calendar application.}")
  private String about;

  @GetMapping("/")
  public Map<String, String> home() {
    return Map.of("welcomeMessage", welcomeMessage, "about", about);
  }
}
