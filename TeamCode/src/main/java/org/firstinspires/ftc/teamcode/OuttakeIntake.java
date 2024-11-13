package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;

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

        AxonServo axonServo = new AxonServo();
        axonServo.setServo(hardwareMap.get(ServoImplEx.class, "axonServo"), hardwareMap.get(AnalogInput.class, "axonAnalogInput"));
        CRServoImplEx Wheel = hardwareMap.get(CRServoImplEx.class, "WheelServo");




        if (gamepad1.a)
            Wheel.setPower(1);
        else if (gamepad1.b)
            Wheel.setPower(-1);
        else
            Wheel.setPower(0);

        if (gamepad1.y)
            axonServo.axonServo().setPosition(1);
        if (gamepad1.x)
            axonServo.axonServo().setPosition(0);


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
                axonServo.axonServo().setPosition(1);

                if (gamepad1.x) {
                    axonServo.axonServo().setPosition(0);
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
                axonServo.axonServo().setPosition(0);

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
