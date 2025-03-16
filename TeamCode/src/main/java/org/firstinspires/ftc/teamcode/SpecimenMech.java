package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public class SpecimenMech {

    Servo SpecimenClaw;
    AxonServo SpecimenArm;

    public SpecimenMech(Servo SpecimenClaw, AxonServo SpecimenArm) {
        this.SpecimenArm = SpecimenArm;
        this.SpecimenClaw = SpecimenClaw;
    }

    private final double SpecimenClawOpenPos = 1;
    private final double SpecimenClawClosePos = .5;
    private final double SpecimenArmDropPos = .5;
    private final double SpecimenArmDownPos = .05;
    private final double SpecimenArmUpPos = .25;

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
                SpecimenArm.Servo().setPosition(SpecimenArmUpPos);
                specimenArmPos = setArmPos;
            }
            case Down -> {
                SpecimenArm.Servo().setPosition(SpecimenArmDownPos);
                specimenArmPos = setArmPos;
            }
            case Drop -> {
                SpecimenArm.Servo().setPosition(SpecimenArmDropPos);
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