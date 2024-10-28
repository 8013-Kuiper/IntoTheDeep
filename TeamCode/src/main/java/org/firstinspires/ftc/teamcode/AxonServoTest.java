package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

@TeleOp
public class AxonServoTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        AxonServo.CRAxonServo axonServo = new AxonServo.CRAxonServo() {
            @Override
            public void initServo() {
                analogInput = hardwareMap.get(AnalogInput.class, "AxonServo");
                servo = hardwareMap.get(CRServoImplEx.class, "AxonServo");
            }
        };

        waitForStart();
        while (opModeIsActive()){

            if (gamepad1.a) {
                axonServo.servo.setPower(1);
            } else if (!gamepad1.a) {
                axonServo.servo.setPower(0);
            }

            telemetry.addData("Position", axonServo.getAxonServoPosition());
            telemetry.update();
        }
    }
}
