package com.romantupikov.lesson2.component;

import com.romantupikov.lesson2.annotation.NotAvailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@NotAvailable(fallbackClass = com.romantupikov.lesson2.component.CameraSonni.class)
@PropertySource("classpath:config/application.properties")
public class CameraImpl implements Camera {
    private static final Logger log = LoggerFactory.getLogger(CameraImpl.class);

    private CameraRoll cameraRoll;

    @Value("${camera.base.broken}")
    private boolean broken;

    public CameraImpl(@Qualifier("blackAndWhiteCameraRoll") CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public boolean doPhotograph() {
        if (isBroken()) {

            log.info("Фотоаппарат сломан!");
            return false;
        }
        log.info("Сделана фотография!");
        cameraRoll.processing();
        return true;
    }

    @PostConstruct
    @Override
    public void ready() {
        log.info("Фотоаппарат готов к использованию!");
    }
}
