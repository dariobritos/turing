package org.proygrad.turing.restapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("org.proygrad.turing.restapi")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }



}
