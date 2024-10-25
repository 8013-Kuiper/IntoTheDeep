package org.firstinspires.ftc.teamcode.Axon;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.AnalogInput;

public class Axon {
    String ServoHardwareName;
    private String ServoAnalogInput;
    public AnalogInput analogInput;

    protected void setServoHardwareName(String servoHardwareName) {
        ServoHardwareName = servoHardwareName;
    }

    protected void setServoAnalogInput(String servoAnalogInput) {
        ServoAnalogInput = servoAnalogInput;
    }

    public double getAxonServoPosition() {
        return analogInput.getVoltage() / 3.3 * 360;
    }

    protected void initAnalog(){
        analogInput = hardwareMap.get(AnalogInput.class, ServoAnalogInput);
    }
}
