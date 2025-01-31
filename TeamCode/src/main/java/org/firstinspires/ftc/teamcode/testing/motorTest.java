package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.DriveConstance;
@Disabled
@TeleOp
public class motorTest extends DriveConstance {
    int motorPortNum = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime wait = new ElapsedTime();
        initRobot();


        waitForStart();
        if (opModeIsActive()){
            if (wait.milliseconds()>300) {
                if (gamepad1.a){
                    motorPortNum++;
                    wait.reset();
                }
                if (gamepad1.b){
                    motorPortNum--;
                    wait.reset();
                }
            }

            switch (motorPortNum){
                case 0:
                    frontLeft.setPower(gamepad1.right_stick_y);
                case 1:
                    frontRight.setPower(gamepad1.right_stick_y);
                case 2:
                    backLeft.setPower(gamepad1.right_stick_y);
                case 3:
                    backRight.setPower(gamepad1.right_stick_y);
            }
            telemetry.addData("motorPortNum: ", motorPortNum);
            telemetry.update();

        }
    }
}
