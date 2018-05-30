package com.romantupikov.lesson1.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("shotgun")
public class Shotgun implements Gun {
    private static final Logger log = LoggerFactory.getLogger(Shotgun.class);

    private final Cartridge cartridge;

    public Shotgun(@Qualifier("shotgunShell") Cartridge cartridge) {
        this.cartridge = cartridge;
    }

    @Override
    public void trigger() {
        log.info("Нажат спусковой крючок.");
        cartridge.ignite();
    }

    @Override
    public String getInfo() {
        return "Дробовик";
    }

}
