package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class colorsensortest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        RevColorSensorV3 sensor = hardwareMap.get(RevColorSensorV3.class, "Color");
        ElapsedTime timer = new ElapsedTime();
        waitForStart();
        while (opModeIsActive()){

            timer.reset();
            telemetry.addData("Color: ", sensor.argb());

            telemetry.update();//just test this first

        }
    }
}
