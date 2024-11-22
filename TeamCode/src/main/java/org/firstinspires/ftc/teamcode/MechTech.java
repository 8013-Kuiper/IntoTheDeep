package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MechTech extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        outtakeIntakeMech outtakeFunc = new outtakeIntakeMech(intakeLift,
                outtakeFlip, outtakeSpin, outtakeGrab, Wheel);

        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a)
                outtakeFunc.setWheelPower(outtakeIntakeMech.wheelEnum.Forward);
            else if (gamepad1.b)
                outtakeFunc.setWheelPower(outtakeIntakeMech.wheelEnum.Reverse);
            else
                outtakeFunc.setWheelPower(outtakeIntakeMech.wheelEnum.Off);

            if (gamepad1.y)
                outtakeFunc.setIntakeLiftToPos(outtakeIntakeMech.IntakeLiftEnum.Low);
            if (gamepad1.x)
                outtakeFunc.setIntakeLiftToPos(outtakeIntakeMech.IntakeLiftEnum.High);

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

        }
    }
}
