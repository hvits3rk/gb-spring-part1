package com.romantupikov.lesson1.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Client {
    private static final Logger log = LoggerFactory.getLogger(Client.class);

    private final Gun gun;

    public Client(@Qualifier("shotgun") Gun gun) {
        this.gun = gun;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void shootOnSight() {
        log.info("Взял оружие: {}", gun.getInfo());
        gun.trigger();
    }
}
