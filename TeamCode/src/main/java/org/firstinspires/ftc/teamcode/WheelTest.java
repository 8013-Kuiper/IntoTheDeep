package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class WheelTest extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a)
                Wheel.setPower(1);
            else if (gamepad1.b)
                Wheel.setPower(-1);
            else
                Wheel.setPower(0);

            if (gamepad1.left_trigger>.1)
                intakeFlip.Servo().setPosition(1);
            if (gamepad1.right_trigger>.1)
                intakeFlip.Servo().setPosition(0);

            if (gamepad1.x)
                outtakeGrab.setPosition(.5);
            if (gamepad1.y)
                outtakeGrab.setPosition(0);

            if (gamepad1.dpad_up) {
                outtakeSpin.setPosition(1);
                outtakeFlip.setPosition(1);
            }
            if (gamepad1.dpad_down) {
                outtakeSpin.setPosition(0);
                outtakeFlip.setPosition(0);
            }
        }
    }
}
