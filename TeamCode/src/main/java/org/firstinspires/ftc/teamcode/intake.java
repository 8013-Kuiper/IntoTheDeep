package org.firstinspires.ftc.teamcode;

public class intake extends DriveConstance{
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while (opModeIsActive()){
            int intakeColor = colorInIntake(intakeColorSensor.argb());

            switch (intakeColor){
                case 0:
                    telemetry.addLine("Nothing in intake");
                    if (gamepad1.a)
                        intake.setPower(1);
                    else if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);

                case 1:
                    telemetry.addLine("Neutral Sample");
                    if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);

                case 2:
                    telemetry.addLine("Red Sample");
                    if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);

                case 3:
                    telemetry.addLine("Blue Sample");
                    if (gamepad1.b)
                        intake.setPower(-1);
                    else
                        intake.setPower(0);
            }

        }
    }
}
