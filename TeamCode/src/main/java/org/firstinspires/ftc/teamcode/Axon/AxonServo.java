package org.firstinspires.ftc.teamcode.Axon;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class AxonServo {

    private ServoImplEx axonServo;
    private AnalogInput analogInput;

    public ServoImplEx Servo() {
        return axonServo;
    }

    public void setAxonServo(ServoImplEx axonServo) {
        this.axonServo = axonServo;
    }

    public void setServo(ServoImplEx axonServo, AnalogInput analogInput){
        this.axonServo = axonServo;
        this.analogInput = analogInput;
    }

    public double getAnalogPositionAs360(){
        return analogInput.getVoltage()/3.3*360;
    }
    public double getAnalogPosition(){
        return analogInput.getVoltage()/3.3;
    }


    AnalogInput getAnalogInput() {
        return analogInput;
    }

    static class CRAxonServo {

        private CRServoImplEx axonServo;
        private AnalogInput analogInput;

        public CRServoImplEx axonServo() {
            return axonServo;
        }

        public void setAxonServo(CRServoImplEx axonServo) {
            this.axonServo = axonServo;
        }

        public void setServo(CRServoImplEx axonServo, AnalogInput analogInput){
            this.axonServo = axonServo;
            this.analogInput = analogInput;
        }

        public double getAnalogPositionAs360(){
            return analogInput.getVoltage()/3.3*360;
        }
        public double getAnalogPosition(){
            return analogInput.getVoltage()/3.3;
        }


        AnalogInput getAnalogInput() {
            return analogInput;
        }
    }
}
