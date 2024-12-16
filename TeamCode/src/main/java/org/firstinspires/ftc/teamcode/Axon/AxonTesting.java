package org.firstinspires.ftc.teamcode.Axon;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp
public class AxonTesting extends LinearOpMode {
    AnalogInput analogInput;
    String ServoHardwareName = "AxonServo";
    String ServoAnalogInput = "AxonServoAnalogInput";
    CRServo axonServo;

    @Override
    public void runOpMode() throws InterruptedException {
        CRServo axonServo = hardwareMap.get(CRServo.class, ServoHardwareName);
        analogInput = hardwareMap.get(AnalogInput.class, ServoAnalogInput);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                axonServo.setPower(1);
            } else if (!gamepad1.a) {
                axonServo.setPower(0);
            }

            telemetry.addData("Position", getAxonServoPosition());
            telemetry.update();
        }
    }

    public double getAxonServoPosition() {
        return analogInput.getVoltage() / 3.3 * 360;
    }
}
