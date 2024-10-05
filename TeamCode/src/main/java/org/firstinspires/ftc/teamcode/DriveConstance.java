package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class DriveConstance extends LinearOpMode {

    public static int neutralSampleColor = 0;
    public static int redSampleColor = 0;
    public static int blueSampleColor = 0;

    public static int colorRange = 20;


    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backLeft;
    public DcMotorEx backRight;

    public CRServo intake;

    public RevColorSensorV3 intakeColorSensor;


    public void initRobot() {
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        intake = hardwareMap.get(CRServo.class, "intake");
        intakeColorSensor = hardwareMap.get(RevColorSensorV3.class, "intakeColor");

    }

    public static int colorInIntake(int intakeSampleColor){
        int color;

        if (isColorInRange(neutralSampleColor, intakeSampleColor)){
            color = 1;
        }
        else if (isColorInRange(redSampleColor, intakeSampleColor)){
            color = 2;
        }
        else if (isColorInRange(blueSampleColor, intakeSampleColor)){
            color = 3;
        }
        else
            color = 0;

        return color;
    }

    public static int getLowerBoundRange(int number){
        return number-colorRange;
    }

    public static int getUpperBoundRange(int number){
        return number+colorRange;

    }

    public static boolean isColorInRange(int color, int sampleColorInIntake){
        boolean isLowerColorInRange = false;
        boolean isUpperColorInRange = false;
        boolean isColorInRange = false;

        if (color>=getLowerBoundRange(sampleColorInIntake)){
           isLowerColorInRange = true;
        }
        if (color<=getUpperBoundRange(sampleColorInIntake)){
            isUpperColorInRange = true;
        }

        if (isLowerColorInRange && isUpperColorInRange){
            isColorInRange = true;
        }

        return isColorInRange;
    }
}


