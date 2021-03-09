package com.recsystem.spring;

import com.recsystem.controllers.RecommendationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = RecommendationController.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
