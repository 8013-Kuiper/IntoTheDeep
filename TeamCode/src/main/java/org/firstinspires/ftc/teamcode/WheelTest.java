package org.firstinspires.ftc.teamcode;

import android.text.method.MultiTapKeyListener;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class WheelTest extends DriveConstance{

    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime wait = new ElapsedTime();
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
            if (gamepad1.a)
                Wheel.setPower(1);
            else if (gamepad1.b)
                Wheel.setPower(-1);
            else
                Wheel.setPower(0);


            switch (intake){

                case Low:
                    if(gamepad1.dpad_right){
                        //intakeLift.Servo().setPwmEnable();
                        intake = IntakeLiftE.start;
                    }

                case Middle:
                    /*intakeLift.Servo().setPosition(.6);
                    if (wait.seconds()>2){
                        //intakeLift.Servo().setPwmDisable();
                        intake = IntakeLiftE.Low;
                    }*/
                    if(gamepad1.dpad_left){
                        intake= IntakeLiftE.Low;
                    }

                case start:
                   // intakeLift.Servo().setPosition(1);
                    if (gamepad1.right_trigger>.1){
                        wait.reset();
                        intake = IntakeLiftE.Middle;
                    }
            }


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

            telemetry.addData("servopos", intakeLift.Servo().getPosition());
            telemetry.addData("time", wait);
            telemetry.addData("state",intake);
            telemetry.update();
        }
    }
}
