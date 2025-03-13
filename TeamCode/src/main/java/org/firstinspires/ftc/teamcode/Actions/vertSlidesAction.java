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
    private DcMotorEx HortSlide;

    List<LynxModule> allHubs;

    LinearMech linearFunc;

    private LinearMech.LinearPosEnum pos;

    public vertSlidesAction(DcMotorEx leftVertLinear, DcMotorEx rightVertLinear,
                            List<LynxModule> allHubs, DcMotorEx HortSlide){

        this.leftVertLinear = leftVertLinear;
        this.rightVertLinear = rightVertLinear;
        this.allHubs = allHubs;
        this.HortSlide = HortSlide;

        this.leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.leftVertLinear.setTargetPosition(0);
        this.leftVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rightVertLinear.setTargetPosition(0);
        this.rightVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        this.HortSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        this.linearFunc = new LinearMech(leftVertLinear, rightVertLinear, allHubs, HortSlide);

        linearFunc.runHubReadings();

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

    public class highbasket implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            linearFunc.setLinearPosAsEnum(LinearMech.LinearPosEnum.HighBasket);
            return false;
        }
    }

    public Action high(){
        return new highbasket();
    }


    public class HighBar implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            linearFunc.setLinearPosAsEnum(LinearMech.LinearPosEnum.HighBar);
            return false;
        }
    }

    public Action HighBar(){
        return new HighBar();
    }

    public class resetSlides implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            leftVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightVertLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftVertLinear.setTargetPosition(0);
            leftVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightVertLinear.setTargetPosition(0);
            rightVertLinear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            return false;
        }
    }

    public Action resetSlides(){
        return new resetSlides();
    }

    public class HoldHortSlides implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            linearFunc.HortSlideHoldPos();
            return false;
        }
    }
    public Action HoldHortSlides(){
        return new HoldHortSlides();
    }

}
