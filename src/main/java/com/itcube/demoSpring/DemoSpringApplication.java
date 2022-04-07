package com.itcube.demoSpring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class DemoSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "Hello ".concat(name);
  }

  @GetMapping("/")
  public String getCookieValue(@CookieValue(value = "SESSION_ID", defaultValue = "World") String cookie) {
    return "Cookie " + cookie;
  }
}
