package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class WheelTest extends DriveConstance{

    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime wait = new ElapsedTime();
        initRobot();
        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a)
                Wheel.setPower(1);
            else if (gamepad1.b)
                Wheel.setPower(-1);
            else
                Wheel.setPower(0);

           /* if (gamepad1.left_trigger>.1)
                intakeFlip.Servo().setPosition(1);
            if (gamepad1.right_trigger>.1) {
                intakeFlip.Servo().setPosition(0);
                wait.reset();
            }
            if (intakeFlip.Servo().getPosition() > .35) {
                if (wait.milliseconds()>=500 && wait.milliseconds() <1000)
                    intakeFlip.Servo().setPosition(0);
                intakeFlip.Servo().setPwmDisable();
            }
*/
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

            HorizontalLinear.setPower(gamepad1.left_stick_y);

            telemetry.addData("servopos", intakeFlip.Servo().getPosition());
            telemetry.addData("time", wait);
            telemetry.update();
        }
    }
}
