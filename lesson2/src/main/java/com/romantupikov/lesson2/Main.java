package com.romantupikov.lesson2;

import com.romantupikov.lesson2.component.Camera;
import com.romantupikov.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Создаем контекст...");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        log.info("Берем бин из контекста...");
        Camera camera = context.getBean(Camera.class);

        log.info("Делаю фото!");
        camera.doPhotograph();

        context.close();
    }

}
