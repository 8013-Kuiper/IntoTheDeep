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


public class blueLeft extends DriveConstance {

    Pose2d startPose = new Pose2d(12, 58.5, Math.toRadians(90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,clipArm,SpecimenClaw);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .afterTime(.1,outtakeAction.firstOuttakeUp())
                .setTangent(Math.toRadians(270))
                .afterTime(.5,vertSlidesAction.HighBar())
                .splineToConstantHeading(new Vector2d(7,26), Math.toRadians(225))
                .waitSeconds(1)
                .afterTime(.1,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start) )
                .waitSeconds(1)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(8,40), Math.toRadians(0))
                .afterTime(1, vertSlidesAction.resetSlides())//////////////////////////////////
                .afterTime(1,outtakeAction.outtakeUp())
                //back up from bar

                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(31, 18, Math.toRadians(0)), Math.toRadians(179))//30
                .afterTime(1,intakeAction.Middle())
                .splineToConstantHeading(new Vector2d(29,21),Math.toRadians(0))
                //.waitSeconds(1)
                .afterTime(2, intakeAction.Low())
                .afterTime(2, intakeAction.WheelOn())
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(31,24),Math.toRadians(0))//31,20 sat, 31, 24
                .waitSeconds(.5)//
                .afterTime(1, intakeAction.intakeUp())//2
                .waitSeconds(1)
                .afterTime(2, intakeAction.WheelOff())
                //.waitSeconds(1)

                //Pick up 1 sample
                .setReversed(true)
                .strafeToConstantHeading(new Vector2d(35,25))
                .afterTime(1, outtakeAction.outtakeDown())
                .waitSeconds(1)
                .afterTime(1,intakeAction.WheelReverse())
                .afterTime(1,outtakeAction.outtakeUp())
                .afterTime(3,intakeAction.WheelOff())
                .afterTime(3,outtakeAction.outtakeSpin())
                //grab block with outtake

                .splineToSplineHeading(new Pose2d(54,50, Math.toRadians(230)), Math.toRadians(50))
                //move to basket

                .afterTime(1, vertSlidesAction.high())
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(60, 56), Math.toRadians(0))
                .waitSeconds(.5)
                .afterTime(.1,outtakeAction.outtakeClaw(outtakeIntakeMech.outtakeGrab.Release))
                .waitSeconds(1)
                .afterTime(.1, outtakeAction.CLoseClaw())
                .splineToConstantHeading(new Vector2d(50,50),Math.toRadians(0))
                .waitSeconds(.5)
                .afterTime(.5,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start))
                .waitSeconds(1)
                //Deposit sample into basket
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                /*.setTangent(Math.toRadians(0))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(40, 20, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(1)
                .afterTime(1,intakeAction.Middle())
                .afterTime(2, intakeAction.Low())
                .afterTime(2, intakeAction.WheelOn())
                .waitSeconds(2)
                .splineToConstantHeading(new Vector2d(41,20),Math.toRadians(0))
                .afterTime(2, intakeAction.intakeUp())
                .waitSeconds(1)
                .afterTime(2, intakeAction.WheelOff())
                .waitSeconds(1)
                //move to pick up another sample (2)


                .setReversed(true)
                .afterTime(1, outtakeAction.outtakeDown())
                .waitSeconds(1)
                .afterTime(1,intakeAction.WheelReverse())
                .afterTime(1,outtakeAction.outtakeUp())
                .afterTime(3,intakeAction.WheelOff())
                .afterTime(3,outtakeAction.outtakeSpin())
                //grab block with outtake

                .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                .afterTime(1, vertSlidesAction.high())
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(59, 55), Math.toRadians(0))
                .afterTime(1,outtakeAction.outtakeClaw(outtakeIntakeMech.outtakeGrab.Release))
                .waitSeconds(1)
                .splineToConstantHeading(new Vector2d(56,52),Math.toRadians(0))
                .afterTime(2,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start))
                .waitSeconds(4)
                //Deposit sample into basket
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////



                .setReversed(false)
                .splineToLinearHeading(new Pose2d(50, 18, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(2)
                //move to pick up another sample (3)
                .setReversed(true)
                .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket

                 */
                .splineToLinearHeading(new Pose2d(45,10,Math.toRadians(0)),Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(15,9,Math.toRadians(0)),Math.toRadians(90))
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
