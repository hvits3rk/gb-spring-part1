package com.romantupikov.lesson2.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("colorCameraRoll")
public class ColorCameraRoll implements CameraRoll {
    private static final Logger log = LoggerFactory.getLogger(ColorCameraRoll.class);

    public void processing() {
        log.info("-1 цветной кадр");
    }

}
