package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;

@TeleOp
public class MechTech extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        outtakeIntakeMech outtakeFunc = new outtakeIntakeMech(
                outtakeFlip, outtakeSpin, outtakeGrab, Wheel);

        IntakeMech intakeFunc = new IntakeMech(intakeLift,Wheel);

        LinearFunc linerFunc = new LinearFunc(leftVertLinear, rightVertLinear, allHubs);

        waitForStart();
        while (opModeIsActive()){

            if (gamepad1.right_bumper)
                linerFunc.setLinearPosAsEnum(LinearFunc.LinearPosEnum.HighBasket);


            if (gamepad1.a)
                intakeFunc.setWheelPower(IntakeMech.wheelEnum.Forward);
            else if (gamepad1.b)
                intakeFunc.setWheelPower(IntakeMech.wheelEnum.Reverse);
            else
                intakeFunc.setWheelPower(IntakeMech.wheelEnum.Off);

            if (gamepad1.y)
                intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.Low);
            if (gamepad1.x)
                intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.High);


            if (gamepad1.dpad_down)
                outtakeFunc.setOuttakePos(outtakeIntakeMech.outtake.GrabPos);
            if (gamepad1.dpad_up)
                outtakeFunc.setOuttakePos(outtakeIntakeMech.outtake.DropPos);

            if (gamepad1.left_trigger > .1)
                outtakeFunc.setOuttakeGrabPos(outtakeIntakeMech.outtakeGrab.Grabbed);
            if (gamepad1.right_trigger > .1)
                outtakeFunc.setOuttakeGrabPos(outtakeIntakeMech.outtakeGrab.Release);

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

            telemetry.addData("axon state",intakeFunc.getIntakePosAsEnum());
            telemetry.addData("axon pos", intakeLift.Servo().getPosition());
            telemetry.addData("Axon Analog Pos: ", intakeLift.getAnalogInput().getVoltage());
            telemetry.update();

        }
    }
}
