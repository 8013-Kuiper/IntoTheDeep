package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.roadRunner.MecanumDrive;

@TeleOp
public class TeleOP extends DriveConstance{

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(0, 0, 0));
        initRobot();
        LinearMech linearFunc = new LinearMech(leftVertLinear, rightVertLinear, allHubs);
        SpecimenMech clipFunc = new SpecimenMech(SpecimenClaw,Arm);

        ElapsedTime wait = new ElapsedTime();
        ElapsedTime outtakeTime = new ElapsedTime();
        ElapsedTime liftTime = new ElapsedTime();



        enum IntakeLiftE {
            Middle,
            Low,
            start
        }

        enum outtakeOrder{
            start,
            Grabbing,
            DropPos,
            GrabPos
        }

        enum liftState{
            manual,
            auto
        }

        enum armState{
            auto,
            manual
        }

        IntakeLiftE intake = IntakeLiftE.start;

        outtakeOrder outtake = outtakeOrder.DropPos;

        liftState lift = liftState.auto;
        armState ArmState = armState.auto;
        //leftVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rightVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();
        while (opModeIsActive()){
            double horizontalPower = -gamepad2.left_stick_y;
            double VertPower = gamepad2.right_stick_y;
            double armPower = -gamepad1.right_stick_y;
            double coefitiat =1;

            if (gamepad1.right_stick_button){
                coefitiat =.5;
            }
            else {
                coefitiat=1;
            }


            switch (ArmState) {
                case auto -> {
                    if (gamepad1.a) {
                        clipFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.Down);
                    }
                    if (gamepad1.b) {
                        clipFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.start);
                    }


                    if (gamepad1.y){
                        clipFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.Up);
                    }

                    if (gamepad1.left_bumper){
                        Arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                        ArmState = armState.manual;
                    }

                }
                case manual -> {
                   Arm.setPower(armPower);
                   if (gamepad1.right_bumper){
                       Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                       Arm.setTargetPosition(0);
                       Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                       ArmState = armState.auto;
                   }
                }
            }



            if (gamepad1.right_trigger>.1){
                clipFunc.setSpecimenClawPos(SpecimenMech.SpecimenClawPos.Close);
            }
            if (gamepad1.left_trigger>.1){
                clipFunc.setSpecimenClawPos(SpecimenMech.SpecimenClawPos.Open);
            }



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
                    intakeLift.Servo().setPosition(0.8);//maybe too much
                    if (gamepad2.b){
                        wait.reset();
                        intake = IntakeLiftE.Middle;
                        break;
                    }
                    break;
            }


            if (gamepad2.left_bumper)
                outtakeGrab.setPosition(.6);
            if (gamepad2.right_bumper)
                outtakeGrab.setPosition(.4);



            switch(outtake){
                case GrabPos:
                    outtakeSpin.setPosition(0);
                    outtakeFlip.setPosition(0);
                    outtakeGrab.setPosition(.4);
                    if (gamepad2.x){
                        outtakeTime.reset();
                        outtake = outtakeOrder./*start*/Grabbing;   //was start
                        break;
                    }
                    break;
              /*  case start:
                    outtakeGrab.setPosition(.6);
                    if (outtakeTime.seconds()>.5){
                        outtakeTime.reset();
                        outtake = outtakeOrder.Grabbing;
                        break;

                    }
                    break;

               */
                case Grabbing:
                    outtakeGrab.setPosition(.6);    //new test
                    Wheel.setPower(-1);
                    outtakeFlip.setPosition(.8);
                    if (outtakeTime.seconds()>.8){
                        outtakeSpin.setPosition(1);
                        outtake = outtakeOrder.DropPos;
                        break;
                    }
                    break;
                case DropPos:
                    //Wheel.setPower(0);
                    if (gamepad2.a){
                        outtake=outtakeOrder.GrabPos;
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
            if (HorizontalLinear.getCurrentPosition()>=945) {//1030
                if (horizontalPower > 0) {
                    HorizontalLinear.setPower(0);
                } else {
                    HorizontalLinear.setPower(horizontalPower);
                }
            }
            else if (HorizontalLinear.getCurrentPosition() <= 0) {
                    if (horizontalPower < 0) {
                        HorizontalLinear.setPower(0);
                    } else {
                        HorizontalLinear.setPower(horizontalPower);
                    }
                } else
                    HorizontalLinear.setPower(horizontalPower);


            switch (lift) {
                case auto -> {
                    if (gamepad2.right_stick_y > .1) {
                        liftTime.reset();
                        linearFunc.setLinearPosAsEnum(LinearMech.LinearPosEnum.start);
                    }
                    if (gamepad2.right_stick_y < -.1)
                        linearFunc.setLinearPosAsEnum(LinearMech.LinearPosEnum.HighBasket);

                    if(liftTime.seconds()>1.4 && rightVertLinear.getTargetPosition() == 0){
                        //leftVertLinear.setPower(0);
                        //rightVertLinear.setPower(0);
                        leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        leftVertLinear.setTargetPosition(0);
                        leftVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rightVertLinear.setTargetPosition(0);
                        rightVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        telemetry.addLine("testing");
                    }

                    //if(rightVertLinear.getTargetPosition()==0 && gamepad1.right_stick_button)

                    if (gamepad2.dpad_down){
                        rightVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                        leftVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                        lift = liftState.manual;
                    }
                }
                case manual ->{
                    rightVertLinear.setPower(VertPower);
                    leftVertLinear.setPower(rightVertLinear.getPower());
                    //must bring slides to bottom before switching back
                    if (gamepad2.dpad_up){
                        leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        leftVertLinear.setTargetPosition(0);
                        leftVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rightVertLinear.setTargetPosition(0);
                        rightVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        lift = liftState.auto;
                    }
                }

            }



            drive.setDrivePowers(new PoseVelocity2d(
                    new Vector2d(
                            -gamepad1.left_stick_y*coefitiat,
                            -gamepad1.left_stick_x*coefitiat
                    ),
                    -gamepad1.right_stick_x*coefitiat
            ));

            /*double y = -gamepad1.left_stick_y;
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


             */
            telemetry.addData("hor", HorizontalLinear.getCurrentPosition());
            telemetry.addData("arm",Arm.getCurrentPosition());
            //telemetry.addData("time", wait);
            //telemetry.addData("controller", gamepad2.left_stick_y);
            telemetry.addData("state(intake)",intake);
            telemetry.addData("state(linear)", lift);
            telemetry.addData("leftVertLinear: ", leftVertLinear.getCurrentPosition());
            telemetry.addData("rightVerLinear: ", rightVertLinear.getCurrentPosition());
            telemetry.addData("leftvert target", leftVertLinear.getTargetPosition());
            telemetry.addData("rightvert target", rightVertLinear.getTargetPosition());

            telemetry.update();
        }
    }
}