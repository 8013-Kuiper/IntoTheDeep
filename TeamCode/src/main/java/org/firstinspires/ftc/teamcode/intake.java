package org.firstinspires.ftc.teamcode;

public class intake extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while (opModeIsActive()){
            colorInIntakeClass colorInRange = new colorInIntakeClass();

            colorInIntakeClass.colors intakeColor = colorInIntakeClass.colorInIntake(intakeColorSensor.argb());

            switch (intakeColor){
                case noColor:
                    telemetry.addLine("Nothing in intake");
                    if (gamepad1.a)
                        intake.setPower(1);
                    else if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);

                case neutral:
                    telemetry.addLine("Neutral Sample");
                    if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);

                case red:
                    telemetry.addLine("Red Sample");
                    if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);

                case blue:
                    telemetry.addLine("Blue Sample");
                    if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);
            }

        }
    }
}
