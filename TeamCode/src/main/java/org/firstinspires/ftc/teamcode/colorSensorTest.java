package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class colorSensorTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        RevColorSensorV3 sensor = hardwareMap.get(RevColorSensorV3.class, "Color");
        ElapsedTime timer = new ElapsedTime();

        sensor.setI2cAddress(new I2cAddr(400));
        waitForStart();
        while (opModeIsActive()){
            int color = 0;
            if (gamepad1.a) {
                color = sensor.argb();
                telemetry.addData("color: ", color);
                telemetry.update();

            }

            if (sensor.argb()!=color) {
                timer.reset();
                telemetry.addData("Color: ", sensor.argb());
                telemetry.addData("Delay (Milli): ", timer.milliseconds());
                telemetry.addData("Delay (Nano): ", timer.nanoseconds());
                telemetry.update();
            }
        }
    }
}
