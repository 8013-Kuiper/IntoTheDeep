package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

@TeleOp (group = "Testing")
public class DataCollection extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Dictionary<String, Integer> Data = new Hashtable<>();
        RevColorSensorV3 intakeColorSensor = hardwareMap.get(RevColorSensorV3.class, "intakeColor");

        waitForStart();
        if (opModeIsActive()) {
            if (gamepad1.a)
                Data.put("Blue", intakeColorSensor.argb());
            if (gamepad1.b)
                Data.put("Red", intakeColorSensor.argb());
            if (gamepad1.x)
                Data.put("Neutral", intakeColorSensor.argb());


            telemetry.addData("Blue: ", Data.get("Blue"));
            telemetry.addData("Red: ", Data.get("Red"));
            telemetry.addData("Red: ", Data.get("Neutral"));
            telemetry.update();
        }

    }
}
