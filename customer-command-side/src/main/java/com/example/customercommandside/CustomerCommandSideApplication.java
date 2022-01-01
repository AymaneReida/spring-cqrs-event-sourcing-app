package com.example.customercommandside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;

@SpringBootApplication
public class CustomerCommandSideApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerCommandSideApplication.class, args);
  }

  @Bean
  public CommandBus commandBus() {
    return SimpleCommandBus.builder().build();
  }

}
