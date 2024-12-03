package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class WheelTest extends DriveConstance{

    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime wait = new ElapsedTime();
        ElapsedTime outtakeTime = new ElapsedTime();
        initRobot();
        leftVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        enum IntakeLiftE {
            Middle,
            Low,
            start
        }

        enum outtakeOrder{
            start,
            middle,
            end,
            down
        }

        IntakeLiftE intake = IntakeLiftE.start;

        outtakeOrder outtake = outtakeOrder.down;
        waitForStart();
        while (opModeIsActive()){
            double horizontalPower = -gamepad2.left_stick_y;
            double VertPower = gamepad2.right_stick_y;


            /*LinearFunc linearFunc = new LinearFunc(leftVertLinear, rightVertLinear, allHubs);
            if (gamepad1.x)
                linearFunc.setLinearPosAsEnum(LinearFunc.LinearPosEnum.HighBasket);
            if (gamepad1.b)
                linearFunc.setLinearPosAsEnum(LinearFunc.LinearPosEnum.start);

*/



            if (gamepad2.right_trigger>.1)
                Wheel.setPower(1);
            else if (gamepad2.left_trigger>.1)
                Wheel.setPower(-1);
            else
                Wheel.setPower(0);


            switch (intake){

                case Low:
                    if(gamepad2.y){
                        intakeLift.Servo().setPwmEnable();
                        intake = IntakeLiftE.start;
                        break;
                    }
                    break;
                case Middle:
                    intakeLift.Servo().setPosition(.2);
                    if (wait.seconds()>0.8){
                        intakeLift.Servo().setPwmDisable();
                        intake = IntakeLiftE.Low;
                        break;
                    }

                    break;
                case start:
                    intakeLift.Servo().setPosition(0.8);
                    if (gamepad2.b){
                        wait.reset();
                        intake = IntakeLiftE.Middle;
                        break;
                    }
                    break;
            }


            if (gamepad2.left_bumper)
                outtakeGrab.setPosition(.5);
            if (gamepad2.right_bumper)
                outtakeGrab.setPosition(0);



            switch(outtake){
                case down:
                    outtakeSpin.setPosition(0);
                    outtakeFlip.setPosition(0);
                    outtakeGrab.setPosition(0);
                    if (gamepad2.x){
                        outtakeTime.reset();
                        outtake = outtakeOrder.start;
                        break;
                    }
                    break;
                case start:
                    outtakeGrab.setPosition(.5);
                    if (outtakeTime.seconds()>.5){
                        outtakeTime.reset();
                        outtake = outtakeOrder.middle;
                        break;
                    }
                    break;
                case middle:
                    Wheel.setPower(-1);
                    outtakeFlip.setPosition(.7);
                    if (outtakeTime.seconds()>.8){
                        outtakeSpin.setPosition(1);
                        outtake = outtakeOrder.end;
                        break;
                    }
                    break;
                case end:
                    Wheel.setPower(0);
                    if (gamepad2.a){
                        outtake=outtakeOrder.down;
                        break;
                    }
                    break;

            }



            /*if (gamepad2.x) {
                //   outtakeSpin.setPosition(1);
                outtakeFlip.setPosition(.7);
            }
            if (gamepad2.a) {
                outtakeSpin.setPosition(0);
                outtakeFlip.setPosition(0);
                outtakeGrab.setPosition(0);
            }

            if (gamepad2.left_stick_button)
                    outtakeSpin.setPosition(1);



             */
            if(HorizontalLinear.getCurrentPosition()>=975) {
                if (horizontalPower > 0) {
                    HorizontalLinear.setPower(.5);
                    HorizontalLinear.setTargetPosition(975);
                    HorizontalLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                } else {
                    HorizontalLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                    HorizontalLinear.setPower(horizontalPower);
                }
            }
            else
                HorizontalLinear.setPower(horizontalPower);


            rightVertLinear.setPower(VertPower);
            leftVertLinear.setPower(rightVertLinear.getPower());




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

            telemetry.addData("hor", HorizontalLinear.getCurrentPosition());
            telemetry.addData("time", wait);
            telemetry.addData("controller", gamepad2.left_stick_y);
            telemetry.addData("state",intake);
            telemetry.addData("leftVertLinear: ", leftVertLinear.getCurrentPosition());
            telemetry.addData("rightVerLinear: ", rightVertLinear.getCurrentPosition());
            telemetry.addData("leftvert target", leftVertLinear.getTargetPosition());
            telemetry.addData("rightvert target", rightVertLinear.getTargetPosition());

            telemetry.update();
        }
    }
}
