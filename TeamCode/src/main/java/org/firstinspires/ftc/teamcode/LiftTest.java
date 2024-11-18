package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class LiftTest extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();
        while (opModeIsActive()){
            intakeFlip.Servo().setPwmDisable();
        }
    }
}
