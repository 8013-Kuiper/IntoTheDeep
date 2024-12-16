package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.Dictionary;
import java.util.Hashtable;

@TeleOp (name = "DataCollection", group = "Testing")
public class DataCollection extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Dictionary<String, Object> Data = new Hashtable<>();
        RevColorSensorV3 intakeColorSensor = hardwareMap.get(RevColorSensorV3.class, "intakeColor");

        float gain = 2F;

        ElapsedTime waitTime = new ElapsedTime();

        waitForStart();
        while (opModeIsActive()) {
            intakeColorSensor.setGain(gain);

            Data.put("Blue", intakeColorSensor.blue());
            Data.put("Red", intakeColorSensor.red());
            Data.put("Green", intakeColorSensor.green());


            if (gamepad1.dpad_up) {
                if (waitTime.milliseconds()>500) {
                    gain += .05F;
                    waitTime.reset();
                }
            }

            if (gamepad1.dpad_down) {
                if (waitTime.milliseconds()>500) {
                    gain -= .05f;
                    waitTime.reset();
                }
            }

            Data.put("Gain", gain);

            telemetry.addData("timer: ", waitTime.milliseconds());
            telemetry.addData("Gain: ", Data.get("Gain"));
            telemetry.addData("Blue: ", Data.get("Blue"));
            telemetry.addData("Red: ", Data.get("Red"));
            telemetry.addData("Green: ", Data.get("Green"));
            telemetry.update();
        }

    }
}
