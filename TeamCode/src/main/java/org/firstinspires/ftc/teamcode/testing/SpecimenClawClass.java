package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.DriveConstance;

public class SpecimenClawClass extends DriveConstance {
    @Override
    public void runOpMode() throws InterruptedException {
        Servo SpecimenClaw = hardwareMap.get(Servo.class, "");
        TouchSensor touchSensor = hardwareMap.get(TouchSensor.class, "");



    }
    private SpecimenPos specimenPos = SpecimenPos.DownClose;
    private SpecimenClawPos specimenClawPos = SpecimenClawPos.Close;
    private SpecimenArmPos specimenArmPos = SpecimenArmPos.Start;

    enum SpecimenArmPos {
        Up,
        Down,
        Start
    }

    enum SpecimenClawPos {
        Close,
        Open
    }

    enum SpecimenPos {
        UpClose,
        DownClose,
        UpOpen,
        DownOpen
    }

    public SpecimenPos getSpecimenPos(){
        return specimenPos;
    }
    void ClawArmPosToSpecimenPos(SpecimenArmPos ArmPos, SpecimenClawPos ClawPos){
        if (ArmPos == SpecimenArmPos.Up && ClawPos == SpecimenClawPos.Close){
            setSpecimenPos();

        }
    }

    public void setSpecimenPos(){
        switch (specimenPos){
            case UpOpen -> {

            }
            case UpClose -> {

            }
            case DownOpen -> {

            }
            case DownClose -> {

            }
        }
    }
}
