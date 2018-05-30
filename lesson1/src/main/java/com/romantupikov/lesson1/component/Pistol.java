package com.romantupikov.lesson1.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pistol")
public class Pistol implements Gun {
    private static final Logger log = LoggerFactory.getLogger(Pistol.class);

    private final Cartridge cartridge;

    public Pistol(@Qualifier("pistolRound") Cartridge cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public void trigger() {
        log.info("Нажат на спусковой крючок");
        cartridge.ignite();
    }

    @Override
    public String getInfo() {
        return "Пистолет";
    }
}
