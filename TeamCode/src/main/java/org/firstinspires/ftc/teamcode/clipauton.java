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
                .waitSeconds(.5)
                //first drop off
                .setTangent(Math.toRadians(-270))
                .splineToLinearHeading(new Pose2d(-46,12.5,Math.toRadians(-90)),Math.toRadians(300))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-49,60),Math.toRadians(0))
                //push first block
                .splineToLinearHeading(new Pose2d(-60,12.5,Math.toRadians(-90)),Math.toRadians(90))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-45,60),Math.toRadians(0))
                //push second block
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                .waitSeconds(.000001)
                .lineToY(65)
                //pick up second block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(.5)
                //second drop off
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(65)
                //pick up third block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(.5)
                //drop third block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(65)
                //pick up forth block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(.5)
                //drop off forth block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(65)
                //pick up fith block
                .setReversed(false)
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
