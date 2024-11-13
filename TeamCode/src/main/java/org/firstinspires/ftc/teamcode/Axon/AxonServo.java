package org.firstinspires.ftc.teamcode.Axon;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class AxonServo extends Axon {

    private ServoImplEx axonServo;

    public void isInitialized(){
        try{
            getAnalogInput().getConnectionInfo();
        } catch (Exception exception) {
            throw new NullPointerException("Did you forget to init the Analog Input? ");
        }
        finally {
            try {
                Servo().getConnectionInfo();
            } catch (Exception exception) {
                throw new NullPointerException("Did you forget to init the Servo? ");
            }
        }
    }

    public ServoImplEx Servo() {
        return axonServo;
    }

    public void setAxonServo(ServoImplEx axonServo) {
        this.axonServo = axonServo;
    }

    public void setServo(ServoImplEx axonServo, AnalogInput analogInput){
        this.axonServo = axonServo;
        setAnalogInput(analogInput);
    }

    static class CRAxonServo extends Axon{

        private CRServoImplEx axonServo;

        public void isInitialized(){
            try{
                getAnalogInput().getConnectionInfo();
            } catch (Exception exception) {
                throw new NullPointerException("Did you forget to init the Analog Input? ");
            }
            finally {
                try {
                    axonServo().getConnectionInfo();
                } catch (Exception exception) {
                    throw new NullPointerException("Did you forget to init the Servo? ");
                }
            }
        }

        public CRServoImplEx axonServo() {
            return axonServo;
        }

        public void setAxonServo(CRServoImplEx axonServo) {
            this.axonServo = axonServo;
        }

        public void setServo(CRServoImplEx axonServo, AnalogInput analogInput){
            this.axonServo = axonServo;
            setAnalogInput(analogInput);
        }
    }
}
