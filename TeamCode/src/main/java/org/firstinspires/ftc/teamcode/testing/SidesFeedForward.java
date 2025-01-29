package org.firstinspires.ftc.teamcode.testing;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;

import org.firstinspires.ftc.teamcode.DriveConstance;

public class SidesFeedForward extends DriveConstance {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        if (opModeIsActive()){
            MotorEx test = new MotorEx(hardwareMap, "frontLeft");
            test.set(.9);
        }
    }
}
