package com.romantupikov.lesson2.component;

public interface Camera {

    CameraRoll getCameraRoll();

    void setCameraRoll(CameraRoll cameraRoll);

    boolean doPhotograph();

    void breaking();

    boolean isBroken();

    void ready();

}
