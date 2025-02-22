package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class SpecimenMech {

    Servo SpecimenClaw;
    //AxonServo SpecimenArm;
    DcMotorEx Arm;

    public SpecimenMech(Servo SpecimenClaw, /*AxonServo SpecimenArm*/ DcMotorEx Arm) {
        //this.SpecimenArm = SpecimenArm;
        this.Arm = Arm;
        this.Arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.SpecimenClaw = SpecimenClaw;
    }

    private final double SpecimenClawOpenPos = 0;
    private final double SpecimenClawClosePos = .5;
    private final int SpecimenArmDropPos = 100;
    private final int SpecimenArmUpPos = 150;
    private final int SpecimenArmDownPos = 0;

    private SpecimenClawPos specimenClawPos = SpecimenClawPos.Close;
    private SpecimenArmPos specimenArmPos = SpecimenArmPos.Down;

    public enum SpecimenClawPos {
        Close,
        Open
    }

    public SpecimenClawPos getSpecimenClawPos() {
        return specimenClawPos;
    }

    public void OpenSpecimenClaw() {
        SpecimenClaw.setPosition(SpecimenClawOpenPos);
        specimenClawPos = SpecimenClawPos.Open;
    }


    public void CloseSpecimenClaw() {
        SpecimenClaw.setPosition(SpecimenClawClosePos);
        specimenClawPos = SpecimenClawPos.Close;
    }


    public enum SpecimenArmPos {
        Up,
        Down,
        Drop
    }

    public void setSpecimenArmPos(SpecimenArmPos setArmPos) {
        switch (specimenArmPos) {
            case Up -> {
                //SpecimenArm.Servo().setPosition(SpecimenArmUpPos);
                Arm.setTargetPosition(SpecimenArmUpPos);
                Arm.setPower(1);
                specimenArmPos = setArmPos;
            }
            case Down -> {
                //SpecimenArm.Servo().setPosition(SpecimenArmDownPos);
                Arm.setTargetPosition(SpecimenArmDownPos);
                Arm.setPower(1);
                specimenArmPos = setArmPos;
            }
            case Drop -> {
                //SpecimenArm.Servo().setPosition(SpecimenArmDropPos);
                Arm.setTargetPosition(SpecimenArmDropPos);
                Arm.setPower(1);
                specimenArmPos = setArmPos;
            }
        }
    }


    public SpecimenArmPos getSpecimenArmEnum() {
        return specimenArmPos;
    }


    public void setSpecimenClawPos(SpecimenClawPos setClawPos) {
        switch (specimenClawPos) {
            case Open -> {
                SpecimenClaw.setPosition(SpecimenClawOpenPos);
                specimenClawPos = setClawPos;
            }
            case Close -> {
                SpecimenClaw.setPosition(SpecimenClawClosePos);
                specimenClawPos = setClawPos;
            }
        }
    }

    public SpecimenClawPos getSpecimenClawEnum(){
        return specimenClawPos;
    }
}