package com.romantupikov.lesson2.component;

import com.romantupikov.lesson2.annotation.UnproducableCameraRoll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
@Qualifier("blackAndWhiteCameraRoll")
public class BlackAndWhiteCameraRoll implements CameraRoll {
    private static final Logger log = LoggerFactory.getLogger(BlackAndWhiteCameraRoll.class);

    public void processing() {
        log.info("-1 черно-белый кадр");
    }
}
