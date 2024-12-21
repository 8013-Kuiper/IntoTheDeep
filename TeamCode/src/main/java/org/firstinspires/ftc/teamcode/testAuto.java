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

    Pose2d startPose = new Pose2d(12, 58.5, Math.toRadians(90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(8,32), Math.toRadians(225))
                .waitSeconds(1)
                //Drop specimen on bar
                .splineToConstantHeading(new Vector2d(8,40), Math.toRadians(0))
                //back up from bar
                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(30, 18, Math.toRadians(0)), Math.toRadians(179))
                //.splineToConstantHeading(new Vector2d(30,25), Math.toRadians(0))
                .splineToConstantHeading(new Vector2d(30,20),Math.toRadians(0))

                .afterTime(2,intakeAction.Middle())
                .afterTime(3, intakeAction.Low())
                .afterTime(3, intakeAction.WheelOn())
                .afterTime(7, intakeAction.intakeUp())
                .waitSeconds(6)
                .turn(Math.toRadians(-1))
                .afterTime(1, intakeAction.WheelOff())

                .waitSeconds(2)
                //Pick up 1 sample
                .setReversed(true)
                .strafeToConstantHeading(new Vector2d(35,25))
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket
                .setTangent(Math.toRadians(0))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(40, 18, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(2)
                //move to pick up another sample (2)
                .setReversed(true)
                .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(50, 18, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(2)
                //move to pick up another sample (3)
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(24,10,Math.toRadians(0)),Math.toRadians(90))
                //park
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
