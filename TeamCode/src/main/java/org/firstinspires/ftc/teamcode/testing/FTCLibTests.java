package org.firstinspires.ftc.teamcode.testing;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.DriveConstance;

public class FTCLibTests extends DriveConstance {
    @Override
    public void runOpMode() throws InterruptedException {
        ServoEx servoEx = new SimpleServo(hardwareMap, "servo_name", 9, 9) {

        };
        waitForStart();
        if (opModeIsActive()){

        }
    }
}
