package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
@Disabled
public class getSlideVals extends DriveConstance{

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
       //ew LinearFunc linearFunc = new LinearFunc(leftVertLinear, rightVertLinear, allHubs);

        leftVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightVertLinear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            //leftVertLinear.setMotorDisable();
            //rightVertLinear.setMotorDisable();
            if (gamepad1.a) {
                leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }

            if (gamepad1.b)
                HorizontalLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


            telemetry.addData("Hort: ", HorizontalLinear.getCurrentPosition());
            telemetry.addData("leftVertLinear: ", leftVertLinear.getCurrentPosition());
            telemetry.addData("rightVerLinear: ", rightVertLinear.getCurrentPosition());
            telemetry.update();
        }
    }
}
