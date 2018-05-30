package com.romantupikov.component;

import com.romantupikov.config.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Client {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Camera camera = context.getBean(Camera.class);

        camera.doPhotograph();

        context.close();
    }

}
