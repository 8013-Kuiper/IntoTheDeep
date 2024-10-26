package org.firstinspires.ftc.teamcode.Axon;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.PwmControl;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class AxonServo extends Axon {
    public ServoImplEx servo;

    public AxonServo(String ServoHardwareName, String ServoAnalogInput) {
        setServoHardwareName(ServoHardwareName);
        setServoAnalogInput(ServoAnalogInput);
        initServo();

    }

    private void initServo() {
        servo = hardwareMap.get(ServoImplEx.class, getServoHardwareName());
        servo.setPwmRange(new PwmControl.PwmRange(500, 2500));
        initAnalog();

    }

    public static class CRAxonServoTest extends AxonServo{
        public CRServoImplEx servo;

        public CRAxonServoTest(String ServoHardwareName, String ServoAnalogInput) {
            super(ServoHardwareName, ServoAnalogInput);
            initServo();

        }

        private void initServo() {
            servo = hardwareMap.get(CRServoImplEx.class, getServoHardwareName());
            servo.setPwmRange(new PwmControl.PwmRange(500, 2500));
            initAnalog();

        }

    }
}