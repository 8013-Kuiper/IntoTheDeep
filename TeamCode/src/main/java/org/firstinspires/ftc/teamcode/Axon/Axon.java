package org.firstinspires.ftc.teamcode.Axon;

import com.qualcomm.robotcore.hardware.AnalogInput;

public class Axon {


    private AnalogInput analogInput;

    public double getAnalogPositionAs360(){
        return analogInput.getVoltage()/3.3*360;
    }
    public double getAnalogPosition(){
        return analogInput.getVoltage()/3.3;
    }


    AnalogInput getAnalogInput() {
        return analogInput;
    }

    public void setAnalogInput(AnalogInput analogInput) {
        this.analogInput = analogInput;
    }
}
