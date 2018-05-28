package com.romantupikov.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("shotgunShell")
public class ShotgunShell implements Cartridge {
    private static final Logger log = LoggerFactory.getLogger(ShotgunShell.class);

    @Override
    public void ignite() {
        log.info("Выпустил дробь!");
    }
}
