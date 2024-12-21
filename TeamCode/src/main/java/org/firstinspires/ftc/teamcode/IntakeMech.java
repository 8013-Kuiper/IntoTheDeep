package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;
import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import static java.lang.Thread.sleep;

public class IntakeMech {

    public AxonServo IntakeLift;
    public CRServoImplEx Wheel;

    public IntakeMech(CRServoImplEx Wheel, AxonServo axonServo){
        this.IntakeLift = axonServo;
        this.Wheel = Wheel;
    }

    public enum IntakeLiftEnum {
        High,
        Middle,
        Low
    }

    private IntakeLiftEnum IntakeLiftAsEnum;

    public void setIntakeLiftToPos(IntakeLiftEnum IntakeLiftEnum)  {
        switch (IntakeLiftEnum) {

            case Low -> {
                IntakeLift.Servo().setPwmDisable();
                IntakeLiftAsEnum = IntakeLiftEnum;
                break;
            }

            case Middle -> {
                IntakeLift.Servo().setPwmEnable();
                IntakeLift.Servo().setPosition(.1);
                IntakeLiftAsEnum = IntakeLiftEnum;
                break;
            }

            case High -> {
                IntakeLift.Servo().setPwmEnable();
                IntakeLift.Servo().setPosition(0.8);
                IntakeLiftAsEnum = IntakeLiftEnum;
                break;
            }

        }
    }

    public IntakeLiftEnum getIntakePosAsEnum(){
        return IntakeLiftAsEnum;
    }

    public enum wheelEnum {
        Forward,
        Reverse,
        Off
    }

    private wheelEnum wheelAsEnum;

    public void setWheelPower(wheelEnum wheelPower) {
        switch (wheelPower) {
            case Forward -> {
                Wheel.setPower(1);
                wheelAsEnum = wheelPower;
                break;
            }

            case Reverse -> {
                Wheel.setPower(-1);
                wheelAsEnum = wheelPower;
                break;
            }

            case Off -> {
                Wheel.setPower(0);
                wheelAsEnum = wheelPower;
                break;
            }

        }
    }

    public wheelEnum getWheelPowerAsEnum(){
        return wheelAsEnum;
    }
}
