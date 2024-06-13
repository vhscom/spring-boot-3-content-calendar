package com.vhsdev.contentcalendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Value("${cc.welcomeMessage:Welcome to Content Calendar!}")
  private String welcomeMessage;

  @GetMapping("/")
  public String home() {
    return welcomeMessage;
  }
}
