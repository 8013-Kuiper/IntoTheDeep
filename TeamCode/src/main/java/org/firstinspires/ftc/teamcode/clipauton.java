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

    Pose2d startPose = new Pose2d(-12, 58.5, Math.toRadians(-90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,clipArm);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(-2,26), Math.toRadians(-90))
                .waitSeconds(.5)
                //first drop off
                .splineToConstantHeading(new Vector2d(-7,35),Math.toRadians(0))
                .setTangent(Math.toRadians(-270))
                .splineToLinearHeading(new Pose2d(-45,6,Math.toRadians(-90)),Math.toRadians(0))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-40,55),Math.toRadians(0))
                //push first block
                .splineToLinearHeading(new Pose2d(-55,12.5,Math.toRadians(-90)),Math.toRadians(90))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-45,55),Math.toRadians(0))
                //push second block
                .splineToLinearHeading(new Pose2d(-58,10,Math.toRadians(-90)),Math.toRadians(90))
                //move to push third block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-45,55),Math.toRadians(0))
                //push third block
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(0))
                .waitSeconds(.000001)
                .lineToY(56)
                .waitSeconds(4)
                //pick up second block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                .waitSeconds(.5)
                //second drop off
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up third block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                .waitSeconds(.5)
                //drop third block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up forth block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                .waitSeconds(.5)
                //drop off forth block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up fith block
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
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
