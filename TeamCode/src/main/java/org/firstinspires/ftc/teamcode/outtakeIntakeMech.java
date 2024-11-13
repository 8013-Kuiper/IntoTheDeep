package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class outtakeIntakeMech {

    AxonServo IntakeLift;
    CRServoImplEx Wheel;

    public outtakeIntakeMech(AxonServo IntakeLift, CRServoImplEx Wheel){
        this.IntakeLift = IntakeLift;
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
