package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class AxonServo {

    private String ServoHardwareName;
    private String ServoAnalogInput;

    public AxonServo(String ServoHardwareName, String ServoAnalogInput) {
        this.ServoHardwareName = ServoHardwareName;
        this.ServoAnalogInput = ServoAnalogInput;

    }

    final ServoImplEx servo = hardwareMap.get(ServoImplEx.class, ServoHardwareName);
    private final AnalogInput analogInput = hardwareMap.get(AnalogInput.class, ServoAnalogInput);


    public double getAxonServoPosition(){
        return analogInput.getVoltage() / 3.3 * 360;
    }
}