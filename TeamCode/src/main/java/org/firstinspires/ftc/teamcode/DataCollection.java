package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.Dictionary;
import java.util.Hashtable;

public class DataCollection extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Dictionary<String, Integer> Data = new Hashtable<>();

        waitForStart();

        Data.put("Blue", 1);
        Data.put("Red", 1);
        Data.put("Neutral", 1);

        telemetry.addLine();
    }
}
