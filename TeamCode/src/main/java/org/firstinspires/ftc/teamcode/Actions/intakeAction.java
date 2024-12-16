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
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import org.firstinspires.ftc.teamcode.DriveConstance;
import org.firstinspires.ftc.teamcode.IntakeMech;
import org.firstinspires.ftc.teamcode.outtakeIntakeMech;
import static java.lang.Thread.sleep;


public class intakeAction {

    public AxonServo IntakeLift;
    CRServoImplEx Wheel;

    IntakeMech  intakeFunc = new IntakeMech(IntakeLift,Wheel);

    private IntakeMech.IntakeLiftEnum pos;

    private  IntakeMech.wheelEnum power;

    public intakeAction(HardwareMap hardwareMap){
        IntakeLift.setServo(hardwareMap.get(ServoImplEx.class, "intakeFlip"), hardwareMap.get(AnalogInput.class, "intakeFlipAnalog"));
        Wheel = hardwareMap.get(CRServoImplEx.class, "Wheel");
        Wheel.setDirection(DcMotorSimple.Direction.REVERSE);

    }


    public class intake implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeFunc.setIntakeLiftToPos(pos);
            return false;
        }
    }

    public Action intake(IntakeMech.IntakeLiftEnum Pos){
        pos =Pos;
        return new intake();
    }

    public class Wheel implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeFunc.setWheelPower(power);
            return false;
        }
    }

    public Action Wheel(IntakeMech.wheelEnum Power){
        power = Power;
        return new Wheel();
    }


}
