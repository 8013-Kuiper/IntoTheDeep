package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;
import org.firstinspires.ftc.teamcode.roadRunner.MecanumDrive;


@Autonomous


public class testAuto extends DriveConstance {

    Pose2d startPose = new Pose2d(35, 58.5, Math.toRadians(90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

       // org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new  intakeAction(hardwareMap);


        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(8,32), Math.toRadians(225))
                //Drop specimen on bar
                .splineToConstantHeading(new Vector2d(8,40), Math.toRadians(0))
                //back up from bar
                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(35, 25, Math.toRadians(0)), Math.toRadians(225))
                .splineToConstantHeading(new Vector2d(40,25), Math.toRadians(0))
                //Pick up 1 sample
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(62,60, Math.toRadians(230)), Math.toRadians(50))
                //Deposit sample into basket
                .setTangent(Math.toRadians(0))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(50, 25, Math.toRadians(0)), Math.toRadians(0))
                //move to pick up another sample (2)
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(62,60, Math.toRadians(230)), Math.toRadians(50))
                //Deposit sample into basket
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(60, 25, Math.toRadians(0)), Math.toRadians(0))
                //move to pick up another sample (3)
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(62,60, Math.toRadians(230)), Math.toRadians(50))
                //Deposit sample into basket
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(24,10,Math.toRadians(0)),Math.toRadians(90))
                //park
                .endTrajectory();


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
