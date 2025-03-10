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


public class redclipauton extends DriveConstance {

    Pose2d startPose = new Pose2d(12,-56,Math.toRadians(180));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose);//init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,Arm,SpecimenClaw);

        telemetry.addData("arm",Arm.getCurrentPosition());
        telemetry.update();
        TrajectoryActionBuilder test = drive.actionBuilder(startPose)

                .turn(Math.toRadians(-1))
                .afterTime(.00001,outtakeAction.clipClawClose())
                //start of drop off
                .afterTime(.000001,outtakeAction.clipArmUp())
                .setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(0,-25,Math.toRadians(90)),Math.toRadians(90))
                //move to drop off
                .waitSeconds(.00001)
                .afterTime(.00001,outtakeAction.clipArmDown())
                .waitSeconds(.2)
                .afterTime(.4, outtakeAction.clipClawOpen())
                .lineToY(-30)
                //end of first drop off

                .splineToConstantHeading(new Vector2d(50,-35),Math.toRadians(90))//0
                .splineToLinearHeading(new Pose2d(37,-6,Math.toRadians(90)),Math.toRadians(90))//0
                .splineToConstantHeading(new Vector2d(49,-6),Math.toRadians(-90))
                //move to push block
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(38,-59),Math.toRadians(180))
                //push first block
                .splineToLinearHeading(new Pose2d(50,-8,Math.toRadians(90)),Math.toRadians(-90))
                //move to push block
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(42,-58),Math.toRadians(180))
                //push second block

                .splineToLinearHeading(new Pose2d(39,-55,Math.toRadians(90)),Math.toRadians(180))
                //move to pick up second block
                .waitSeconds(.000001)
                .lineToY(-59.5)
                .waitSeconds(.0001)
                .afterTime(.0001,outtakeAction.clipClawClose())
                .waitSeconds(.1)
                //pick up second block
                .setReversed(false)
                .afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(-18,-50),Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-6,-46), Math.toRadians(90))
                //.waitSeconds(.000001)
                .splineToConstantHeading(new Vector2d(-6,-23.5),Math.toRadians(90))
                //move to drop off
                .waitSeconds(.000001)
                .afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.15)
                .afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(-30)
                //end of second drop off

                .waitSeconds(.1)
                .setTangent(-45)
                .splineToLinearHeading(new Pose2d(32,-55,Math.toRadians(90)),Math.toRadians(0))
                //move to pick up third block
                .waitSeconds(.000001)
                .lineToY(-59.5)
                .waitSeconds(.0001)
                .afterTime(.0001,outtakeAction.clipClawClose())
                .waitSeconds(.1)
                //pick up third block
                .setReversed(false)
                .afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(-11,-50), Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-11,-22),Math.toRadians(90))
                //move to drop off third block
                .waitSeconds(.000001)
                .afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.15)
                .afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(-30)
                //third drop off

                .waitSeconds(.1)
                .setTangent(-45)
                .splineToLinearHeading(new Pose2d(32,-55,Math.toRadians(90)),Math.toRadians(0))
                //move to pick up fourth block
                .waitSeconds(.000001)
                .lineToY(-59)
                .waitSeconds(.00001)
                .afterTime(.00001,outtakeAction.clipClawClose())
                .waitSeconds(.1)
                //pick up fourth block
                .setReversed(false)
                .afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(-15,-50), Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-15,-21),Math.toRadians(90))
                //move to drop off fourth block
                .waitSeconds(.000001)
                .afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.15)
                .afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(-30)
                //drop fourth block

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
