package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (group = "Testing")
public class colorSensorTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        NormalizedColorSensor sensor = hardwareMap.get(NormalizedColorSensor.class, "intakeColor");
        //colorInIntakeClass.colors intakeColor = colorInIntakeClass.colorInIntake();
        ElapsedTime timer = new ElapsedTime();



        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("color: ", sensor.getNormalizedColors().red);

            /*switch (intakeColor){
                case noColor:
                    telemetry.addLine("Nothing in intake");

                case neutral:
                    telemetry.addLine("Neutral Sample");

                case red:
                    telemetry.addLine("Red Sample");

                case blue:
                    telemetry.addLine("Blue Sample");

            }

             */

            telemetry.update();
        }
    }
}
