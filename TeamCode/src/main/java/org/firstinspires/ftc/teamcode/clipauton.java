package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Actions.intakeAction;
import org.firstinspires.ftc.teamcode.Actions.outtakeAction;
import org.firstinspires.ftc.teamcode.Actions.vertSlidesAction;
import org.firstinspires.ftc.teamcode.roadRunner.MecanumDrive;


@Autonomous


public class clipauton extends DriveConstance {

    Pose2d startPose = new Pose2d(-12, 58.5, Math.toRadians(0));//-90


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);//init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,Arm,SpecimenClaw);

        telemetry.addData("arm",Arm.getCurrentPosition());
        telemetry.update();
        TrajectoryActionBuilder test = drive.actionBuilder(startPose)

                //                .splineToLinearHeading(new Pose2d(-28,55,Math.toRadians(-90)),Math.toRadians(0))

                .turn(Math.toRadians(1))
                .afterTime(.00001,outtakeAction.clipClawClose())
                //start of drop off
                .afterTime(.000001,outtakeAction.clipArmUp())
                .setTangent(Math.toRadians(-90))
                //.splineToConstantHeading(new Vector2d(2,24), Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(9,24,Math.toRadians(-90)),Math.toRadians(-90))
                .waitSeconds(.000001)
                .afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.1)
                .afterTime(.4, outtakeAction.clipClawOpen())
                //end of first drop off
                .lineToY(30)
                .splineToConstantHeading(new Vector2d(-46,35),Math.toRadians(-90))//0
                //.waitSeconds(3)
                //.setTangent(Math.toRadians(-270))new
                .splineToLinearHeading(new Pose2d(-38,6,Math.toRadians(-90)),Math.toRadians(90))//0
                .waitSeconds(.00001)//new
                .strafeToConstantHeading(new Vector2d(-45,6))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-40,54),Math.toRadians(0))
                //push first block
                .splineToLinearHeading(new Pose2d(-55,8,Math.toRadians(-90)),Math.toRadians(90))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-45,56),Math.toRadians(0))
                //push second block
                //.splineToLinearHeading(new Pose2d(-60,10,Math.toRadians(-90)),Math.toRadians(90))
                //move to push third block
                //.setTangent(Math.toRadians(90))
                //.splineToConstantHeading(new Vector2d(-45,55),Math.toRadians(0))
                //push third block
                .splineToLinearHeading(new Pose2d(-39,55,Math.toRadians(-90)),Math.toRadians(0))
                .waitSeconds(.000001)
                .lineToY(59.5)
                .waitSeconds(1)
                .afterTime(.5,outtakeAction.clipClawClose())
                .waitSeconds(1)
                //pick up second block
                .setReversed(false)
                .afterTime(.0001,outtakeAction.clipArmUp())
                //.setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(3,40), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(3,23),Math.toRadians(-90))
                .waitSeconds(.000001)
                .afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.1)
                .afterTime(.5, outtakeAction.clipClawOpen())
                //end of first drop off
                .lineToY(30)
                .waitSeconds(.1)
                //second drop off
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-30,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(59.5)
                .waitSeconds(1)
                .afterTime(.5,outtakeAction.clipClawClose())
                .waitSeconds(1)
                //pick up third block
                .setReversed(false)
                .afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(-6,50), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(-6,21),Math.toRadians(-90))
                .waitSeconds(.000001)
                .afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.1)
                .afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(30)
                //.waitSeconds(.5)
                //drop third block
                /*.setTangent(90)
                .splineToLinearHeading(new Pose2d(-28,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up forth block
                .setReversed(false)
                .afterTime(.8, outtakeAction.clipArmUp())
                .splineToLinearHeading(new Pose2d(6,29,Math.toRadians(-90)), Math.toRadians(225))
                .afterTime(.1,outtakeAction.clipArmDown())
                //.waitSeconds(.5)
                //drop off forth block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-28,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up fith block
                .setReversed(false)
                .afterTime(.8, outtakeAction.clipArmUp())
                .splineToLinearHeading(new Pose2d(8,29,Math.toRadians(-90)), Math.toRadians(225))
                .afterTime(.1,outtakeAction.clipArmDown())
                //drop off fith block



                //.splineToConstantHeading(new Vector2d(-44, 65),Math.toRadians(90))

                 */
                        .endTrajectory();
        //park



        SpecimenClaw.setPosition(.5);
        waitForStart();
        if (opModeIsActive()){
telemetry.addData("arm",Arm.getCurrentPosition());
telemetry.update();
            Actions.runBlocking(
                    new SequentialAction(
                            test.build()

                    )
            );

        }


    }


}
