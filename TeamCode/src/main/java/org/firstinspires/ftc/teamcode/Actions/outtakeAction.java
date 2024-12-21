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


    private outtakeIntakeMech.outtake pos;

    private outtakeIntakeMech.outtakeGrab clawpos;

    outtakeIntakeMech outtakeFunc;


    public outtakeAction( ServoImplEx outtakeFlip,
                          ServoImplEx outtakeSpin, ServoImplEx outtakeGrab,
                          CRServoImplEx Wheel){
        this.outtakeFlip = outtakeFlip;
        this.outtakeSpin = outtakeSpin;
        this.outtakeGrab = outtakeGrab;
        this.Wheel = Wheel;
        this.Wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        this.outtakeFunc = new outtakeIntakeMech(outtakeFlip,outtakeSpin,outtakeGrab,Wheel);

    }


    public class outtakeDown implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFunc.setOuttakePos(outtakeIntakeMech.outtake.GrabPos);
            return false;
        }
    }

    public Action outtakeDown(){
        return new outtakeDown();
    }

    public class outtakeUp implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFunc.setOuttakePos(outtakeIntakeMech.outtake.DropPos);
            return false;
        }
    }

    public Action outtakeUp(){
        return new outtakeUp();
    }


    public class outtakeClaw  implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFunc.setOuttakeGrabPos(clawpos);
            return false;
        }
    }

    public Action outtakeClaw(outtakeIntakeMech.outtakeGrab Pos){
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