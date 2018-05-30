package com.romantupikov.component;

import com.romantupikov.annotation.UnproducableCameraRoll;
import org.springframework.stereotype.Component;

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll {

    public void processing() {
        System.out.println("-1 черно-белый кадр");
    }
}
