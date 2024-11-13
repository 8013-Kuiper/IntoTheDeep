package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

public abstract class DriveConstance extends LinearOpMode {

    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backLeft;
    public DcMotorEx backRight;

    public DcMotorEx leftVertLinear;
    public DcMotorEx rightVertLinear;

    ServoImplEx outtakeFlip;
    ServoImplEx outtakeSpin;
    ServoImplEx outtakeGrab;

    CRServoImplEx Wheel;

    public RevColorSensorV3 intakeColorSensor;

    public CRServoImplEx intake;

    public AxonServo axonServo = new AxonServo();

    public void initRobot() {


        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        leftVertLinear = hardwareMap.get(DcMotorEx.class, "leftVertLinear");
        rightVertLinear = hardwareMap.get(DcMotorEx.class, "rightVertLinear");

        outtakeFlip = hardwareMap.get(ServoImplEx.class, "");
        outtakeSpin = hardwareMap.get(ServoImplEx.class, "");
        outtakeGrab = hardwareMap.get(ServoImplEx.class, "");

        Wheel = hardwareMap.get(CRServoImplEx.class, "WheelServo");

        intakeColorSensor = hardwareMap.get(RevColorSensorV3.class, "intakeColor");

        axonServo.setServo(hardwareMap.get(ServoImplEx.class, "axonServo"), hardwareMap.get(AnalogInput.class, "axonAnalogInput"));

    }
}
