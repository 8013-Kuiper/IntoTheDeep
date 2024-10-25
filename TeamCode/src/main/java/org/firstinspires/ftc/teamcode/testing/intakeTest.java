package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveConstance;

@TeleOp
public class intakeTest extends DriveConstance {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        waitForStart();

        while (opModeIsActive()){
            if (gamepad1.a){
                intake.setPower(1);
                intake1.setPower(1);

            }
        }
    }
}
