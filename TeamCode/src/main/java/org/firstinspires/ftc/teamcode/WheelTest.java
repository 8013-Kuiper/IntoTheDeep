package org.firstinspires.ftc.teamcode;

import android.text.method.MultiTapKeyListener;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.math.*;

@TeleOp
public class WheelTest extends DriveConstance{

    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime wait = new ElapsedTime();
        double horizontalPower = gamepad1.left_stick_y;
        initRobot();

        enum IntakeLiftE {
            High,
            Middle,
            Low,
            start
        }

        IntakeLiftE intake = IntakeLiftE.start;
        waitForStart();
        while (opModeIsActive()){
            if (gamepad2.right_trigger>.1)
                Wheel.setPower(1);
            else if (gamepad2.left_trigger>.1)
                Wheel.setPower(-1);
            else
                Wheel.setPower(0);


            switch (intake){

                case Low:
                    if(gamepad1.a){
                        //intakeLift.Servo().setPwmEnable();
                        intake = IntakeLiftE.start;
                        break;
                    }

                case Middle:
                    /*intakeLift.Servo().setPosition(.6);
                    if (wait.seconds()>2){
                        //intakeLift.Servo().setPwmDisable();
                        intake = IntakeLiftE.Low;
                    }*/
                    if(gamepad1.b){
                        intake= IntakeLiftE.Low;
                        break;
                    }

                case start:
                   // intakeLift.Servo().setPosition(1);
                    if (gamepad1.y){
                        wait.reset();
                        intake = IntakeLiftE.Middle;
                        break;
                    }
            }


            if (gamepad1.left_bumper)
                outtakeGrab.setPosition(.5);
            if (gamepad1.right_bumper)
                outtakeGrab.setPosition(0);

            if (gamepad1.dpad_up) {
                outtakeSpin.setPosition(1);
                outtakeFlip.setPosition(1);
            }
            if (gamepad1.dpad_down) {
                outtakeSpin.setPosition(0);
                outtakeFlip.setPosition(0);
                outtakeGrab.setPosition(0);
            }


            if(HorizontalLinear.getCurrentPosition()>990) {
                if (gamepad1.left_stick_y>0){
                    horizontalPower=0;
                }
            }

            HorizontalLinear.setPower(horizontalPower);

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            frontLeft.setPower(frontLeftPower);
            backLeft.setPower(backLeftPower);
            frontRight.setPower(frontRightPower);
            backRight.setPower(backRightPower);

            telemetry.addData("servopos", intakeLift.Servo().getPosition());
            telemetry.addData("time", wait);
            telemetry.addData("state",intake);
            telemetry.update();
        }
    }
}
