package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class outtakeIntakeMech {

    AxonServo IntakeLift;
    ServoImplEx outtakeFlip;
    ServoImplEx outtakeSpin;
    ServoImplEx outtakeGrab;
    CRServoImplEx Wheel;

    public outtakeIntakeMech(@NonNull AxonServo IntakeLift, @NonNull ServoImplEx outtakeFlip,
                             @NonNull ServoImplEx outtakeSpin, @NonNull ServoImplEx outtakeGrab,
                             @NonNull CRServoImplEx Wheel){
        this.IntakeLift = IntakeLift;
        this.outtakeFlip = outtakeFlip;
        this.outtakeSpin = outtakeSpin;
        this.outtakeGrab = outtakeGrab;
        this.Wheel = Wheel;
    }

    public enum outtakeLiftEnum {
        High,
        Middle,
        Low
    }

    private outtakeLiftEnum outtakeLiftAsEnum;

    public void setOuttakeToPos(outtakeLiftEnum outtakeLiftEnum) {
        switch (outtakeLiftEnum) {
            case Low -> {
                IntakeLift.Servo().setPosition(0);
                outtakeLiftAsEnum = outtakeIntakeMech.outtakeLiftEnum.Low;
            }

            case Middle -> {
                IntakeLift.Servo().setPosition(.5);
                outtakeLiftAsEnum = outtakeIntakeMech.outtakeLiftEnum.Middle;
            }

            case High -> {
                IntakeLift.Servo().setPosition(1);
                outtakeLiftAsEnum = outtakeIntakeMech.outtakeLiftEnum.High;
            }

        }
    }

    public outtakeLiftEnum getOuttakePosAsEnum(){
        return outtakeLiftAsEnum;
    }

    public enum outtake{
        BackPosOpen,
        BackPosClosed,
        LowPosOpen,
        LowPosClosed
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
                wheelAsEnum = wheelEnum.Forward;
            }

            case Reverse -> {
                Wheel.setPower(-1);
                wheelAsEnum = wheelEnum.Reverse;
            }

            case Off -> {
                Wheel.setPower(0);
                wheelAsEnum = wheelEnum.Off;
            }

        }
    }

    public wheelEnum getWheelPowerAsEnum(){
        return wheelAsEnum;
    }



}
