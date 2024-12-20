package org.firstinspires.ftc.teamcode.Actions;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import org.firstinspires.ftc.teamcode.DriveConstance;
import org.firstinspires.ftc.teamcode.IntakeMech;
import org.firstinspires.ftc.teamcode.outtakeIntakeMech;
import static java.lang.Thread.sleep;


public class intakeAction {

    public AxonServo IntakeLift;
    CRServoImplEx Wheel;

    ElapsedTime timer = new ElapsedTime();

    private  IntakeMech.wheelEnum power;
    IntakeMech intakeFunc;

    public intakeAction(CRServoImplEx Wheel, AxonServo axonServo){
        this.IntakeLift = axonServo;
        this.Wheel = Wheel;
        this.Wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        this.intakeFunc = new IntakeMech(Wheel, IntakeLift);

    }



    public class intakeUp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.High);
            return false;
        }
    }

    public Action intakeUp(){
        return new intakeUp();
    }


    public class intakeDown implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.Middle);
            if (timer.seconds()<3)
                return true;
            else{
                intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.Low);
                return false;
            }
        }
    }

    public Action intakeDown(){
        timer.reset();
        return new intakeDown();
    }



    public class WheelOn implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeFunc.setWheelPower(IntakeMech.wheelEnum.Forward);
            return false;
        }
    }

    public Action WheelOn(){
       // power = Power;
        return new WheelOn();
    }

    public class WheelOff implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeFunc.setWheelPower(IntakeMech.wheelEnum.Off);
            return false;
        }
    }

    public Action WheelOff(){
        // power = Power;
        return new WheelOff();
    }

}
