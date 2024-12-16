package org.firstinspires.ftc.teamcode.Actions;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import org.firstinspires.ftc.teamcode.DriveConstance;
import org.firstinspires.ftc.teamcode.IntakeMech;
import org.firstinspires.ftc.teamcode.LinearMech;
import org.firstinspires.ftc.teamcode.LinearMech;
import org.firstinspires.ftc.teamcode.outtakeIntakeMech;
import static java.lang.Thread.sleep;

import java.util.List;

public class vertSlidesAction {

    private DcMotorEx leftVertLinear;
    private DcMotorEx rightVertLinear;

    List<LynxModule> allHubs;

    LinearMech linearFunc = new LinearMech(leftVertLinear, rightVertLinear, allHubs);

    private LinearMech.LinearPosEnum pos;

    public vertSlidesAction(HardwareMap hardwareMap){

        leftVertLinear = hardwareMap.get(DcMotorEx.class, "leftVertLinear");
        leftVertLinear.setDirection(DcMotorSimple.Direction.REVERSE);
        rightVertLinear = hardwareMap.get(DcMotorEx.class, "rightVertLinear");
        allHubs = hardwareMap.getAll(LynxModule.class);

        leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftVertLinear.setTargetPosition(0);
        leftVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightVertLinear.setTargetPosition(0);
        rightVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public class setVertSlidesPos implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            linearFunc.setLinearPosAsEnum(pos);
            return false;
        }
    }

    public Action outtakePos(LinearMech.LinearPosEnum Pos){
        pos =Pos;
        return new setVertSlidesPos();
    }

}
