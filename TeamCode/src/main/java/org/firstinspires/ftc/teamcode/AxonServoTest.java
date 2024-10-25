package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

@TeleOp
public class AxonServoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        AxonServo.CRAxonServoTest axonServo = new AxonServo.CRAxonServoTest("AxonServo", "AxonServoAnalogInput");

        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a){
                axonServo.servo.setPower(1);
            }else if (!gamepad1.a){
                axonServo.servo.setPower(0);
            }


        }
    }
}
