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

    public vertSlidesAction(DcMotorEx leftVertLinear, DcMotorEx rightVertLinear,
                            List<LynxModule> allHubs){

        this.leftVertLinear = leftVertLinear;
        this.rightVertLinear = rightVertLinear;
        this.allHubs = allHubs;

        this.leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftVertLinear.setTargetPosition(0);
        this.leftVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rightVertLinear.setTargetPosition(0);
        this.rightVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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
