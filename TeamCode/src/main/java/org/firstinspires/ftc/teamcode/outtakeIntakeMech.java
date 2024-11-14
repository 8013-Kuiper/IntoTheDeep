package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class outtakeIntakeMech {

    AxonServo IntakeLift;
    ServoImplEx outtakeFlip;
    ServoImplEx outtakeSpin;
    ServoImplEx outtakeGrab;
    CRServoImplEx Wheel;

    public outtakeIntakeMech(DriveConstance DriveConstance){
        this.IntakeLift = DriveConstance.intakeFlip;
        this.outtakeFlip = DriveConstance.outtakeFlip;
        this.outtakeSpin = DriveConstance.outtakeSpin;
        this.outtakeGrab = DriveConstance.outtakeGrab;
        this.Wheel = DriveConstance.Wheel;

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
            }

            case Middle -> {
                IntakeLift.Servo().setPosition(.5);
                IntakeLiftAsEnum = IntakeLiftEnum;
            }

            case High -> {
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
}
