package com.itcube.demoSpring;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Greeting {
  private final long id;
  private final String content;

  public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  @GetMapping ("/hel")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "Hello ".concat(name);
  }
}
