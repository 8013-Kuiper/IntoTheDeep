package org.firstinspires.ftc.teamcode;

public class OuttakeIntake extends DriveConstance {
    enum State{
        low,
        outtakeUp,
        grab,
        drop
    }

    State state = null;

    @Override
    public void runOpMode() throws InterruptedException {


        if (gamepad1.a)
            Wheel.setPower(1);
        else if (gamepad1.b)
            Wheel.setPower(-1);
        else
            Wheel.setPower(0);

        if (gamepad1.y)
            intakeLift.Servo().setPosition(1);
        if (gamepad1.x)
            intakeLift.Servo().setPosition(0);


        switch (state) {
            case low -> {
                if (gamepad1.a)
                    Wheel.setPower(1);
                else if (gamepad1.b)
                    Wheel.setPower(-1);
                else
                    Wheel.setPower(0);

                if (gamepad1.y) {
                    state = State.outtakeUp;

                }
            }

            case outtakeUp -> {
                intakeLift.Servo().setPosition(1);

                if (gamepad1.x) {
                    intakeLift.Servo().setPosition(0);
                    state = State.low;

                }

                if (gamepad1.y) {
                    outtakeGrab.setPosition(1);
                    state = State.grab;
                }
            }

            case grab -> {
                if (outtakeGrab.getPosition() == 1) {
                    outtakeSpin.setPosition(1);
                    outtakeFlip.setPosition(1);
                    state = State.drop;
                }
            }

            case drop -> {
                if (gamepad1.a) {
                    outtakeGrab.setPosition(0);
                }
            }
            default -> {
                outtakeGrab.setPosition(0);
                Wheel.setPower(0);
                intakeLift.Servo().setPosition(0);

            state = State.low;
            }
        }
    }



    enum wheel {
        Forward,
        Reverse,
        Off
    }
    enum outtake{
        BackOpen,
        BackClosed,
        LowOpen,
        LowClosed
    }
}
