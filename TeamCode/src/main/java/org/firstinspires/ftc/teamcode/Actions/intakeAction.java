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
        this.intakeFunc = new IntakeMech(Wheel, axonServo);

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
            //intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.Middle);
            IntakeLift.Servo().setPosition(.2);
            if (timer.seconds()<3)
                return true;
            else{
                //intakeFunc.setIntakeLiftToPos(IntakeMech.IntakeLiftEnum.Low);
                IntakeLift.Servo().setPwmDisable();
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


    public class WheelReverse implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeFunc.setWheelPower(IntakeMech.wheelEnum.Reverse);
            return false;
        }
    }

    public Action WheelReverse(){
        // power = Power;
        return new WheelReverse();
    }

    public class test implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            IntakeLift.Servo().setPosition(.2);
            return false;
        }
    }

    public Action test(){
        // power = Power;
        return new test();
    }

    public class test1 implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            IntakeLift.Servo().setPwmDisable();
            return false;
        }
    }

    public Action test1(){
        // power = Power;
        return new test1();
    }


}
