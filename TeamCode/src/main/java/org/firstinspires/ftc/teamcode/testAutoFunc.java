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


public class testAutoFunc extends DriveConstance {

    Pose2d startPose = new Pose2d(35, 58.5, Math.toRadians(90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new  intakeAction(hardwareMap);


        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .stopAndAdd(intakeAction.intake(IntakeMech.IntakeLiftEnum.Middle))
                .waitSeconds(1)
                .stopAndAdd(intakeAction.intake(IntakeMech.IntakeLiftEnum.Low))
                .stopAndAdd(intakeAction.Wheel(IntakeMech.wheelEnum.Forward))
                .waitSeconds(2)
                .stopAndAdd(intakeAction.intake(IntakeMech.IntakeLiftEnum.High))
                .endTrajectory();

        if (opModeIsActive()){

            Actions.runBlocking(
                    new SequentialAction(
                            test.build()

                    )
            );

        }


    }


}
