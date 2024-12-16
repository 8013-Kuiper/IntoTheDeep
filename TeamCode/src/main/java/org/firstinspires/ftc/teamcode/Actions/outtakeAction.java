package org.firstinspires.ftc.teamcode.Actions;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import org.firstinspires.ftc.teamcode.DriveConstance;
import org.firstinspires.ftc.teamcode.IntakeMech;
import org.firstinspires.ftc.teamcode.outtakeIntakeMech;
import static java.lang.Thread.sleep;

public class outtakeAction {

    private ServoImplEx outtakeFlip;
    private ServoImplEx outtakeSpin;
    private ServoImplEx outtakeGrab;
    private CRServoImplEx Wheel;


    outtakeIntakeMech outtakeFunc = new outtakeIntakeMech(outtakeFlip, outtakeSpin, outtakeGrab, Wheel);

    private outtakeIntakeMech.outtake pos;

    private outtakeIntakeMech.outtakeGrab clawpos;

    public outtakeAction(HardwareMap hardwareMap){
        outtakeFlip = hardwareMap.get(ServoImplEx.class, "outtakeFlip");

        outtakeSpin = hardwareMap.get(ServoImplEx.class, "outtakeSpin");
        outtakeSpin.setDirection(Servo.Direction.REVERSE);

        outtakeGrab = hardwareMap.get(ServoImplEx.class, "outtakeGrab");
        outtakeGrab.setDirection(Servo.Direction.REVERSE);

        Wheel = hardwareMap.get(CRServoImplEx.class, "Wheel");
        Wheel.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    public class outtakePos implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFunc.setOuttakePos(pos);
            return false;
        }
    }

    public Action outtakePos(outtakeIntakeMech.outtake Pos){
        pos =Pos;
        return new outtakePos();
    }


    public class outtakeClaw  implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFunc.setOuttakeGrabPos(clawpos);
            return false;
        }
    }

    public Action outtakePos(outtakeIntakeMech.outtakeGrab Pos){
        clawpos =Pos;
        return new outtakeClaw();
    }

    public class outtakeSpin  implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeSpin.setPosition(1);
            return false;
        }
    }

    public Action outtakeSpin(){
        return new outtakeSpin();
    }


}