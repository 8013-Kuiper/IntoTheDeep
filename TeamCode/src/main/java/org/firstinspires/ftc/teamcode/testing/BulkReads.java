package org.firstinspires.ftc.teamcode.testing;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.List;

@Disabled
public class BulkReads extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);

        waitForStart();
        while (opModeIsActive()) {
            for (LynxModule module : allHubs) {
                telemetry.addData("Thing", module);
            }
            telemetry.update();
        }
    }
}
