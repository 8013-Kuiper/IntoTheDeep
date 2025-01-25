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


public class clipauton extends DriveConstance {

    Pose2d startPose = new Pose2d(-12, 58.5, Math.toRadians(90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(-7,26), Math.toRadians(225))
                .waitSeconds(1)
                //first drop off
                .setTangent(Math.toRadians(-270))
                .splineToLinearHeading(new Pose2d(-46,12.5,Math.toRadians(-90)),Math.toRadians(300))
                .waitSeconds(.1)
                //move to push block
                .lineToY(55)
                //push first block
                .splineToLinearHeading(new Pose2d(-60,12.5,Math.toRadians(-90)),Math.toRadians(90))
                //move to push block
                .lineToY(55)
                //push second block

                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(1)
                //second drop off

                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                //pick up third block
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(1)
                //drop third block
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                //pick up forth block
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(1)
                //drop off forth block
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                //pick up fith block
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                //drop off fith block



                //.splineToConstantHeading(new Vector2d(-44, 65),Math.toRadians(90))
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
