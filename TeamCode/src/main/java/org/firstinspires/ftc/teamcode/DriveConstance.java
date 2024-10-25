package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PwmControl;

public abstract class DriveConstance extends LinearOpMode {
    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backLeft;
    public DcMotorEx backRight;

    public CRServoImplEx intake;
    public CRServoImplEx intake1;
    public RevColorSensorV3 intakeColorSensor;

    public void initRobot() {
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        intake = hardwareMap.get(CRServoImplEx.class, "intake");
        intake1 = hardwareMap.get(CRServoImplEx.class, "intake1");
        intakeColorSensor = hardwareMap.get(RevColorSensorV3.class, "intakeColor");

        intake1.setPwmRange(new PwmControl.PwmRange(500, 2500));
        intake.setPwmRange(new PwmControl.PwmRange(500, 2500));

    }
}
