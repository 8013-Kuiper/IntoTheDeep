package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Axon.CRAxonServo;

@TeleOp
public class AxonServoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        CRAxonServo axonServo = new CRAxonServo("AxonServo", "AxonServoAnalogInput");

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
