package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

import java.util.List;

public abstract class DriveConstance extends LinearOpMode {

    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backLeft;
    public DcMotorEx backRight;

    public DcMotorEx leftVertLinear;
    public DcMotorEx rightVertLinear;
    List<LynxModule> allHubs;

    public DcMotorEx HorizontalLinear;

    ServoImplEx outtakeFlip;
    ServoImplEx outtakeSpin;
    ServoImplEx outtakeGrab;

    CRServoImplEx Wheel;

    public RevColorSensorV3 intakeColorSensor;

    public AxonServo intakeLift = new AxonServo();

    public void initRobot() {


        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        leftVertLinear = hardwareMap.get(DcMotorEx.class, "leftVertLinear");
        leftVertLinear.setDirection(DcMotorSimple.Direction.REVERSE);
        rightVertLinear = hardwareMap.get(DcMotorEx.class, "rightVertLinear");
        allHubs = hardwareMap.getAll(LynxModule.class);

        HorizontalLinear = hardwareMap.get(DcMotorEx.class, "HorizontalLinear");

        outtakeFlip = hardwareMap.get(ServoImplEx.class, "outtakeFlip");
        outtakeSpin = hardwareMap.get(ServoImplEx.class, "outtakeSpin");
        outtakeSpin.setDirection(Servo.Direction.REVERSE);
        outtakeGrab = hardwareMap.get(ServoImplEx.class, "outtakeGrab");
        outtakeGrab.setDirection(Servo.Direction.REVERSE);

        Wheel = hardwareMap.get(CRServoImplEx.class, "Wheel");
        Wheel.setDirection(DcMotorSimple.Direction.REVERSE);

        intakeColorSensor = hardwareMap.get(RevColorSensorV3.class, "intakeColor");

        intakeLift.setServo(hardwareMap.get(ServoImplEx.class, "intakeFlip"), hardwareMap.get(AnalogInput.class, "intakeFlipAnalog"));

    }
}
