package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;
import org.firstinspires.ftc.teamcode.Actions.outtakeAction;
import org.firstinspires.ftc.teamcode.Actions.vertSlidesAction;
import org.firstinspires.ftc.teamcode.roadRunner.MecanumDrive;


@Autonomous


public class blueRight extends DriveConstance {

    Pose2d startPose = new Pose2d(-12, 58.5, Math.toRadians(90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,Arm,SpecimenClaw);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .waitSeconds(5)
                .afterTime(.1,outtakeAction.firstOuttakeUp())
                .setTangent(Math.toRadians(270))
                .afterTime(.1,vertSlidesAction.HighBar())
                .splineToConstantHeading(new Vector2d(-7,26), Math.toRadians(225))
                .waitSeconds(1)
                .afterTime(.1,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start) )
                .waitSeconds(2)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(-8,40), Math.toRadians(0))
                //back up from bar

                .waitSeconds(1)
                .splineTo(new Vector2d(-50,60),Math.toRadians(90))
                .endTrajectory();
        //park





        waitForStart();
        if (opModeIsActive()){

            Actions.runBlocking(
                    new SequentialAction(
                            test.build()

                    )
            );

        }


    }


}
