package org.firstinspires.ftc.teamcode.Axon;

import com.qualcomm.robotcore.hardware.AnalogInput;

abstract class Axon {

    public abstract void initServo();

    public AnalogInput analogInput;

    public double getAxonServoPosition() {
        return analogInput.getVoltage() / 3.3 * 360;
    }
}
