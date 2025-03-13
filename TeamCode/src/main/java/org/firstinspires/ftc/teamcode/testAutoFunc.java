package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;
import org.firstinspires.ftc.teamcode.Actions.outtakeAction;
import org.firstinspires.ftc.teamcode.Actions.vertSlidesAction;
import org.firstinspires.ftc.teamcode.roadRunner.MecanumDrive;


@Autonomous
@Disabled


public class testAutoFunc extends DriveConstance {

    Pose2d startPose = new Pose2d(35, 58.5, Math.toRadians(90));


    public void runOpMode(){

        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs, HorizontalLinear);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,Arm,SpecimenClaw);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                //.splineToConstantHeading(new Vector2d(35,40),Math.toRadians(0))
                .turn(Math.toRadians(1))
                .afterTime(1,intakeAction.Middle())
                .afterTime(3, intakeAction.Low())
                .afterTime(2, intakeAction.WheelOn())
                .afterTime(5, intakeAction.intakeUp())
                .waitSeconds(6)
                .turn(Math.toRadians(-1))
                .afterTime(1, intakeAction.WheelOff())
                .waitSeconds(1)



                /*.waitSeconds(5)
                .stopAndAdd(intakeAction.intake(IntakeMech.IntakeLiftEnum.Low))
                .stopAndAdd(intakeAction.Wheel(IntakeMech.wheelEnum.Forward))
                .waitSeconds(2)
                .stopAndAdd(intakeAction.intake(IntakeMech.IntakeLiftEnum.High))*/
                ;

                TrajectoryActionBuilder test1 = drive.actionBuilder(startPose)
                                //.splineToConstantHeading(new Vector2d(35,48),Math.toRadians(0))
                        .turn(Math.toRadians(.4))
                        .afterTime(1, vertSlidesAction.high())
                        .waitSeconds(3)
                        .afterTime(1,outtakeAction.outtakeClaw(outtakeIntakeMech.outtakeGrab.Release))
                        .waitSeconds(1)
                        .afterTime(1,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start))
                                                .waitSeconds(10);

                TrajectoryActionBuilder test2 = drive.actionBuilder(startPose)
                                .turn(Math.toRadians(.3))
                                        .afterTime(1, outtakeAction.outtakeDown())
                                                .waitSeconds(2)
                                                        .afterTime(.5,intakeAction.WheelReverse())
                                                        .afterTime(2,outtakeAction.outtakeUp())
                                                            .afterTime(3,intakeAction.WheelOff())
                                                                .afterTime(3,outtakeAction.outtakeSpin())
                                                                .waitSeconds(1);





        waitForStart();
        if (opModeIsActive()){

            telemetry.addData("left",leftVertLinear.getCurrentPosition());
            telemetry.update();


            Actions.runBlocking(
                    new SequentialAction(
                            test.build(),
                            test2.build(),
                            test1.build()

                    )
            );

        }


    }


}
