package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class colorsensortest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ColorSensor sensor = hardwareMap.get(ColorSensor.class, "Color");
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("Color: ", sensor.argb());
            telemetry.update();//just test this first

        }
    }
}
