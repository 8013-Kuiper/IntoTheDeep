package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class outtakeIntakeMech {


    private ServoImplEx outtakeFlip;
    private ServoImplEx outtakeSpin;
    private ServoImplEx outtakeGrab;
    private CRServoImplEx Wheel;


    public outtakeIntakeMech(ServoImplEx outtakeFlip,
                             ServoImplEx outtakeSpin, ServoImplEx outtakeGrab,
                             CRServoImplEx Wheel){
        this.outtakeFlip = outtakeFlip;
        this.outtakeSpin = outtakeSpin;
        this.outtakeGrab = outtakeGrab;
        this.Wheel = Wheel;

    }










    private outtake outtakePosAsEnum;

    public enum outtake{
        DropPos,
        GrabPos
    }

    public void setOuttakePos(outtake outtakePosEnum){
        switch (outtakePosEnum){
            case DropPos -> {
                outtakeGrab.setPosition(.6);    //new test
                Wheel.setPower(-1);
                outtakeFlip.setPosition(.65);
                this.outtakePosAsEnum = outtakePosEnum;
            }

            case GrabPos -> {
                outtakeSpin.setPosition(0);
                outtakeFlip.setPosition(0);
                outtakeGrab.setPosition(.4);
                this.outtakePosAsEnum = outtakePosEnum;
            }
        }
    }

    public outtake getOuttakePosAsEnum(){
        return outtakePosAsEnum;
    }







    public enum outtakeGrab{
        Grabbed,
        Release
    }

    public void setOuttakeGrabPos(outtakeGrab pos){
        switch (pos){
            case Grabbed -> {
                outtakeGrab.setPosition(.6);
            }
            case Release -> {
                outtakeGrab.setPosition(.4);

            }

        }
    }
}
