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
public class redLeft extends DriveConstance {

    Pose2d startPose = new Pose2d(-16, -58.5, Math.toRadians(-90));


    public void runOpMode(){
        initRobot();
        MecanumDrive drive = new MecanumDrive(hardwareMap, startPose); //init motors

        org.firstinspires.ftc.teamcode.Actions.intakeAction intakeAction = new intakeAction(Wheel, intakeLift);
        org.firstinspires.ftc.teamcode.Actions.vertSlidesAction vertSlidesAction = new vertSlidesAction(leftVertLinear, rightVertLinear, allHubs, HorizontalLinear);
        org.firstinspires.ftc.teamcode.Actions.outtakeAction outtakeAction = new outtakeAction(outtakeFlip,outtakeSpin,outtakeGrab,Wheel,Arm,SpecimenClaw);

        TrajectoryActionBuilder test = drive.actionBuilder(startPose)
                .afterTime(.1,vertSlidesAction.HoldHortSlides())
                .afterTime(.1,outtakeAction.firstOuttakeUp())
                .setTangent(Math.toRadians(270-180))
                .afterTime(.5,vertSlidesAction.HighBar())
                .splineToConstantHeading(new Vector2d(-6,-26), Math.toRadians(225-180))
                .waitSeconds(.5)
                .afterTime(.1,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start) )
                .waitSeconds(.5)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(-8,-40), Math.toRadians(-180))
                .afterTime(1, vertSlidesAction.resetSlides())//////////////////////////////////
                .afterTime(1,outtakeAction.outtakeUp())
                //back up from bar

                .setTangent(Math.toRadians(-180))
                .splineToSplineHeading(new Pose2d(-35, -18, Math.toRadians(180)), Math.toRadians(-179-180))//30
                .afterTime(1,intakeAction.Middle())
                .splineToConstantHeading(new Vector2d(-22,-16),Math.toRadians(0))
                //.waitSeconds(1)
                .afterTime(2, intakeAction.Low())
                .afterTime(2, intakeAction.WheelOn())
                .waitSeconds(1.5)
                .splineToConstantHeading(new Vector2d(-24,-17),Math.toRadians(0))//31,20 sat, 31, 23
                .waitSeconds(.5)//
                .afterTime(1, intakeAction.intakeUp())//2
                //.waitSeconds(1)
                .afterTime(2, intakeAction.WheelOff())
                //.waitSeconds(1)

                //Pick up 1 sample
                .setReversed(true)
                .strafeToConstantHeading(new Vector2d(-35,-25))
                .afterTime(1.5, outtakeAction.outtakeDown())
                .waitSeconds(1)
                .afterTime(1,intakeAction.WheelReverse())
                .afterTime(1,outtakeAction.outtakeUp())
                .afterTime(2,intakeAction.WheelOff())
                .afterTime(2,outtakeAction.outtakeSpin())
                //grab block with outtake

                .splineToSplineHeading(new Pose2d(-54,-50, Math.toRadians(230-180)), Math.toRadians(50-180))
                //move to basket
                .afterTime(.1, vertSlidesAction.high())
                .waitSeconds(1.5)
                .splineToConstantHeading(new Vector2d(-60, -57), Math.toRadians(0))
                .waitSeconds(.51)
                .afterTime(.1,outtakeAction.outtakeClaw(outtakeIntakeMech.outtakeGrab.Release))
                .waitSeconds(.4)
                .afterTime(.3, outtakeAction.CLoseClaw())
                .splineToConstantHeading(new Vector2d(-50,-51),Math.toRadians(0))
                //.waitSeconds(.5)
                .afterTime(1,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start))
                //.waitSeconds(1)
                //Deposit sample into basket
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                /*.setTangent(Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(-37, -18, Math.toRadians(180)), Math.toRadians(90))//30
                .afterTime(1,intakeAction.Middle())
                .afterTime(1,vertSlidesAction.resetSlides())
                //.waitSeconds(1)
                .afterTime(2, intakeAction.Low())
                .afterTime(2, intakeAction.WheelOn())
                .waitSeconds(2.5)
                .splineToConstantHeading(new Vector2d(-38,-18),Math.toRadians(0))//31,20 sat, 31, 23
                .waitSeconds(.5)//
                .afterTime(1, intakeAction.intakeUp())//2
                //.waitSeconds(1)
                .afterTime(2, intakeAction.WheelOff())
                //.waitSeconds(1)
                //.setReversed(true)
                .strafeToConstantHeading(new Vector2d(-40,-25))
                .afterTime(1.8, outtakeAction.outtakeDown())
                .waitSeconds(1)
                .afterTime(1,intakeAction.WheelReverse())

                .afterTime(2,outtakeAction.outtakeUp())
                .afterTime(3,intakeAction.WheelOff())
                .afterTime(3,outtakeAction.outtakeSpin())
                //grab block with outtake

                .splineToSplineHeading(new Pose2d(-54,-50, Math.toRadians(230-180)), Math.toRadians(50-180))
                //move to basket
                .afterTime(.1, vertSlidesAction.high())
                .waitSeconds(1)
                .splineToConstantHeading(new Vector2d(-60, -56), Math.toRadians(0))
                .waitSeconds(.51)
                .afterTime(.1,outtakeAction.outtakeClaw(outtakeIntakeMech.outtakeGrab.Release))
                .waitSeconds(.5)
                .afterTime(.4, outtakeAction.CLoseClaw())
                .splineToConstantHeading(new Vector2d(-50,-51),Math.toRadians(0))
                .waitSeconds(.5)
                .afterTime(.5,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start))
                //.waitSeconds(1)
                //Deposit sample into basket

                /*.setReversed(false)
                .splineToLinearHeading(new Pose2d(50, 18, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(2)
                //move to pick up another sample (3)
                .setReversed(true)
                .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket

                 */
                .splineToLinearHeading(new Pose2d(-45,-7,Math.toRadians(0-180)),Math.toRadians(90-180))
                .splineToLinearHeading(new Pose2d(-15,-9,Math.toRadians(0-180)),Math.toRadians(90-180))
                //park
                .endTrajectory()
                //park
                .endTrajectory();
                //park
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
