package com.romantupikov.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pistolRound")
public class PistolRound implements Cartridge {
    private static final Logger log = LoggerFactory.getLogger(PistolRound.class);

    @Override
    public void ignite() {
        log.info("Выпустил пулю!");
    }
}
