package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class AxonServoTest extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a){
                axonServo.servo.setPower(1);
            }else if (!gamepad1.a){
                axonServo.servo.setPower(0);
            }

            telemetry.addData("Position", axonServo.getAxonServoPosition());
            telemetry.update();


        }
    }
}
