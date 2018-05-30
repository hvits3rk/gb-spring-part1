package com.romantupikov.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("classpath:config/application.properties")
public class CameraImpl implements Camera {

    private CameraRoll cameraRoll;

    @Value("${camera.broken}")
    private boolean broken;

    public CameraImpl(CameraRoll cameraRoll) {
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

            System.out.println("Фотоаппарат сломан!");
            return false;
        }
        System.out.println("Сделана фотография!");
        cameraRoll.processing();
        return true;
    }

    @PostConstruct
    @Override
    public void ready() {
        System.out.println("Фотоаппарат готов к использованию!");
    }
}
