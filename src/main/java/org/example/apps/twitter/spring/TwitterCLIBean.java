package org.example.apps.twitter.spring;

import org.example.apps.twitter.TwitterCLIApp;
import org.example.apps.twitter.controller.Controller;
import org.example.apps.twitter.controller.TwitterController;
import org.example.apps.twitter.dao.CrdDao;
import org.example.apps.twitter.dao.TwitterDao;
import org.example.apps.twitter.dao.helper.HttpHelper;
import org.example.apps.twitter.dao.helper.TwitterHttpHelper;
import org.example.apps.twitter.service.Service;
import org.example.apps.twitter.service.TwitterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration file which defines dependency relationship
 */
@Configuration
public class TwitterCLIBean {
    public static void main(String[] args) {
        //create a IoC container
        ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCLIBean.class);
        TwitterCLIApp app = context.getBean(TwitterCLIApp.class);
        app.run(args);
    }

    @Bean
    public TwitterCLIApp twitterCLIApp(Controller controller) {
        return new TwitterCLIApp(controller);
    }

    @Bean
    public Controller controller(Service service) {
        return new TwitterController(service);
    }

    @Bean
    public Service service(CrdDao dao) {
        return new TwitterService(dao);
    }

    @Bean
    public CrdDao crdDao(HttpHelper httpHelper) {
        return new TwitterDao(httpHelper);
    }

    @Bean
    HttpHelper httpHelper() {
        String consumerKey = System.getenv("consumerKey");
        String consumerSecret = System.getenv("consumerSecret");
        String accessToken = System.getenv("accessToken");
        String tokenSecret = System.getenv("tokenSecret");
        return new TwitterHttpHelper(consumerKey, consumerSecret, accessToken, tokenSecret);
    }


}
