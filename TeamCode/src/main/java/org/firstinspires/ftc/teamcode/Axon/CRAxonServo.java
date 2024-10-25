package org.firstinspires.ftc.teamcode.Axon;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.CRServoImplEx;

public class CRAxonServo extends Axon {
    public CRServoImplEx servo;

    public CRAxonServo(String ServoHardwareName, String ServoAnalogInput) {
        setServoHardwareName(ServoHardwareName);
        setServoAnalogInput(ServoAnalogInput);
        initServo();

    }

    protected void initServo() {
        servo = hardwareMap.get(CRServoImplEx.class, ServoHardwareName);
        initAnalog();

    }


}
