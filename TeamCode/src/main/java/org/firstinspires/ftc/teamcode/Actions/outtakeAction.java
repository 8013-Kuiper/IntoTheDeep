package org.firstinspires.ftc.teamcode.Actions;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.Axon.Axon;
import org.firstinspires.ftc.teamcode.Axon.AxonServo;
import org.firstinspires.ftc.teamcode.DriveConstance;
import org.firstinspires.ftc.teamcode.IntakeMech;
import org.firstinspires.ftc.teamcode.SpecimenMech;
import org.firstinspires.ftc.teamcode.outtakeIntakeMech;
import static java.lang.Thread.sleep;

public class outtakeAction {

    private ServoImplEx outtakeFlip;
    private ServoImplEx outtakeSpin;
    private ServoImplEx outtakeGrab;
    private CRServoImplEx Wheel;
    //private AxonServo clipArm;
    private Servo SpecimenClaw;
    private DcMotorEx Arm;


    private outtakeIntakeMech.outtake pos;

    private outtakeIntakeMech.outtakeGrab clawpos;

    outtakeIntakeMech outtakeFunc;
    SpecimenMech SpecimenFunc;


    public outtakeAction(ServoImplEx outtakeFlip,
                         ServoImplEx outtakeSpin, ServoImplEx outtakeGrab,
                         CRServoImplEx Wheel, /*AxonServo axonServo*/ DcMotorEx Arm, Servo claw){
        this.outtakeFlip = outtakeFlip;
        this.outtakeSpin = outtakeSpin;
        this.outtakeGrab = outtakeGrab;
        this.Wheel = Wheel;
        this.Wheel.setDirection(DcMotorSimple.Direction.REVERSE);
        this.SpecimenClaw = claw;
        //this.clipArm = axonServo;
        this.Arm = Arm;
        //this.Arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.outtakeFunc = new outtakeIntakeMech(outtakeFlip,outtakeSpin,outtakeGrab,Wheel);
        this.SpecimenFunc = new SpecimenMech(SpecimenClaw,Arm);

    }



    public class clipArmDown implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //clipArm.Servo().setPosition(.6);
            //SpecimenFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.Down);
            Arm.setTargetPosition(15);
            Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm.setPower(1);
            return false;
        }
    }

    public Action clipArmDown(){
        return new clipArmDown();
    }




    public class clipArmDrop implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //clipArm.Servo().setPosition(.9);
            //SpecimenFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.Drop);
            Arm.setTargetPosition(600);
            Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm.setPower(1);
            return false;
        }
    }

    public Action clipArmDrop(){
        return new clipArmDrop();
    }




    public class clipArmUp implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //clipArm.Servo().setPosition(.2);
            //SpecimenFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.Up);
            Arm.setTargetPosition(1500);
            Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm.setPower(1);
            return false;
        }
    }

    public Action clipArmUp(){
        return new clipArmUp();
    }




    public class clipArmStart implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //clipArm.Servo().setPosition(.2);
            //SpecimenFunc.setSpecimenArmPos(SpecimenMech.SpecimenArmPos.start);
            Arm.setTargetPosition(300);
            Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Arm.setPower(1);
            return false;
        }
    }

    public Action clipArmStart(){
        return new clipArmStart();
    }






    public class clipClawOpen implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            //SpecimenFunc.setSpecimenClawPos(SpecimenMech.SpecimenClawPos.Open);
            SpecimenClaw.setPosition(0);

            return false;
        }
    }

    public Action clipClawOpen(){
        return new clipClawOpen();
    }






    public class clipClawClose implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            SpecimenFunc.setSpecimenClawPos(SpecimenMech.SpecimenClawPos.Close);
            return false;
        }
    }

    public Action clipClawClose(){
        return new clipClawClose();
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





    public class CloseClaw  implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFunc.setOuttakeGrabPos(outtakeIntakeMech.outtakeGrab.Grabbed);
            return false;
        }
    }

    public Action CLoseClaw(){
        return new CloseClaw();
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






    public class firstOuttakeUp  implements Action  {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            outtakeFlip.setPosition(.5);
            return false;
        }
    }

    public Action firstOuttakeUp(){
        return new firstOuttakeUp();
    }


}