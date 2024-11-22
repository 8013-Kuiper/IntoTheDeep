package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class outtakeIntakeMech {

    private AxonServo IntakeLift;
    private ServoImplEx outtakeFlip;
    private ServoImplEx outtakeSpin;
    private ServoImplEx outtakeGrab;
    private CRServoImplEx Wheel;

    public outtakeIntakeMech(AxonServo intakeLift, ServoImplEx outtakeFlip,
                             ServoImplEx outtakeSpin, ServoImplEx outtakeGrab,
                             CRServoImplEx Wheel){
        this.IntakeLift = intakeLift;
        this.outtakeFlip = outtakeFlip;
        this.outtakeSpin = outtakeSpin;
        this.outtakeGrab = outtakeGrab;
        this.Wheel = Wheel;

    }



    public enum IntakeLiftEnum {
        High,
        Middle,
        Low
    }

    private IntakeLiftEnum IntakeLiftAsEnum;

    public void setIntakeLiftToPos(IntakeLiftEnum IntakeLiftEnum) {
        switch (IntakeLiftEnum) {
            case Low -> {
                IntakeLift.Servo().setPosition(0);
                IntakeLiftAsEnum = IntakeLiftEnum;

                if (IntakeLift.Servo().getPosition()<.1)
                    IntakeLift.Servo().setPwmDisable();


            }

            case Middle -> {
                IntakeLift.Servo().setPosition(.5);
                IntakeLiftAsEnum = IntakeLiftEnum;
            }

            case High -> {
                IntakeLift.Servo().setPwmEnable();
                IntakeLift.Servo().setPosition(1);
                IntakeLiftAsEnum = IntakeLiftEnum;
            }

        }
    }

    public IntakeLiftEnum getIntakePosAsEnum(){
        return IntakeLiftAsEnum;
    }



    private outtake outtakePosAsEnum;
    public enum outtake{
        DropPos,
        GrabPos
    }

    public void setOuttakePos(outtake outtakePosEnum){
        switch (outtakePosEnum){
            case DropPos -> {
                outtakeFlip.setPosition(1);
                outtakeSpin.setPosition(1);
                this.outtakePosAsEnum = outtakePosEnum;
            }
            case GrabPos -> {
                outtakeFlip.setPosition(0);
                outtakeSpin.setPosition(0);
                this.outtakePosAsEnum = outtakePosEnum;
            }
        }
    }

    public outtake getOuttakePosAsEnum(){
        return outtakePosAsEnum;
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



    public enum outtakeGrab{
        Grabbed,
        Release
    }

    public void setOuttakeGrabPos(outtakeGrab pos){
        switch (pos){
            case Grabbed -> {
                outtakeGrab.setPosition(1);
            }
            case Release -> {
                outtakeGrab.setPosition(.3);

            }

        }
    }
}
