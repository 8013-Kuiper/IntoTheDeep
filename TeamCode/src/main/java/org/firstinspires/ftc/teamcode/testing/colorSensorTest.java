package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
@Disabled
@TeleOp
public class colorSensorTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        colorInIntakeClass colorInRange = new colorInIntakeClass();
        RevColorSensorV3 sensor = hardwareMap.get(RevColorSensorV3.class, "Color");
        ElapsedTime timer = new ElapsedTime();
        int color = 0;

        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.a) {
                color = sensor.argb();
                telemetry.addData("color: ", color);

            }

            if (sensor.argb()!=color) {
                timer.reset();
                telemetry.addData("Color: ", color);
                telemetry.addData("Delay (Milli): ", timer.milliseconds());
                telemetry.addData("Delay (Nano): ", timer.nanoseconds());

            }
            telemetry.update();
        }
    }
}
