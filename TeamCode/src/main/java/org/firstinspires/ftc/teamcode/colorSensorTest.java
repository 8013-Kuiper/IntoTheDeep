package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (group = "Testing")
public class colorSensorTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        RevColorSensorV3 sensor = hardwareMap.get(RevColorSensorV3.class, "Color");
        colorInIntakeClass.colors intakeColor = colorInIntakeClass.colorInIntake(sensor.argb());
        ElapsedTime timer = new ElapsedTime();



        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("color: ", sensor.argb());

            switch (intakeColor){
                case noColor:
                    telemetry.addLine("Nothing in intake");

                case neutral:
                    telemetry.addLine("Neutral Sample");

                case red:
                    telemetry.addLine("Red Sample");

                case blue:
                    telemetry.addLine("Blue Sample");

            }
        }
    }
}
