package org.example.apps.twitter.spring;

import org.example.apps.twitter.TwitterCLIApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * `@SpringBootApplication` is a convenient annotation that adds all of the following:
 *
 * - @Configuration
 * - @EnableAutoConfiguration
 * - @ComponentScan
 */
@SpringBootApplication(scanBasePackages = "org.example.apps.twitter")
public class TwitterCLISpringBoot implements CommandLineRunner {

    private TwitterCLIApp app;

    @Autowired
    public TwitterCLISpringBoot(TwitterCLIApp app) { this.app = app; }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TwitterCLISpringBoot.class);

        //turn off web
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        app.run(args);
    }
}
