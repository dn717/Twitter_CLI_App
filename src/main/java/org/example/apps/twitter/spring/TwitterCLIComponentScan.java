package org.example.apps.twitter.spring;

import org.example.apps.twitter.TwitterCLIApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(value = "org.example.apps.twitter")
public class TwitterCLIComponentScan {
    public static void main(String[] args) {
        //IoC container
        ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCLIComponentScan.class);
        TwitterCLIApp app = context.getBean(TwitterCLIApp.class);
        app.run(args);
    }
}
