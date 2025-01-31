package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.DriveConstance;

public class SpecimenClawClass extends DriveConstance {
    Servo SpecimenClaw;
    TouchSensor touchSensor;
    @Override
    public void runOpMode() throws InterruptedException {
        SpecimenClaw = hardwareMap.get(Servo.class, "");
        touchSensor = hardwareMap.get(TouchSensor.class, "");

    }
    private final double SpecimenClawOpenPos = 0;
    private final double SpecimenClawClosePos = 0;
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

    public void TouchAutoClose(){
        while (opModeIsActive()){
            if (touchSensor.isPressed()){
                SpecimenClaw.setPosition(SpecimenClawClosePos);
            }
        }
    }

    public void OpenSpecimenClaw(){
        SpecimenClaw.setPosition(SpecimenClawOpenPos);
        specimenClawPos = SpecimenClawPos.Open;
    }

    public void CloseSpecimenClaw(){
        SpecimenClaw.setPosition(SpecimenClawClosePos);
        specimenClawPos = SpecimenClawPos.Close;
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
