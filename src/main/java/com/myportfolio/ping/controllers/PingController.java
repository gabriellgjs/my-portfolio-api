package com.myportfolio.ping.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ping")
public class PingController {
  @GetMapping
  public String ping() {
    return "pong";
  }

  @GetMapping ("/pong")
  public String pingAuth() {
    return "pong logado";
  }
}