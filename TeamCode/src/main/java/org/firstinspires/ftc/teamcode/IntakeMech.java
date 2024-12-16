package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;
import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import static java.lang.Thread.sleep;

public class IntakeMech {

    public AxonServo IntakeLift;
    public CRServoImplEx Wheel;





    public IntakeMech(AxonServo intakeLift, CRServoImplEx Wheel){
        this.IntakeLift = intakeLift;
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
            }

            case Middle -> {
                IntakeLift.Servo().setPosition(.2);
            }

            case High -> {
                IntakeLift.Servo().setPwmEnable();
                IntakeLift.Servo().setPosition(0.8);
                IntakeLiftAsEnum = IntakeLiftEnum;
            }
            default -> {
                IntakeLiftEnum = IntakeMech.IntakeLiftEnum.Low;
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
            }

            case Reverse -> {
                Wheel.setPower(-1);
                wheelAsEnum = wheelPower;
            }

            case Off -> {
                Wheel.setPower(0);
                wheelAsEnum = wheelPower;
            }

        }
    }

    public wheelEnum getWheelPowerAsEnum(){
        return wheelAsEnum;
    }
}
