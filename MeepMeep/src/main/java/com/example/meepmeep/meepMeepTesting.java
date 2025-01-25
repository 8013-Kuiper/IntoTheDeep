package com.example.meepmeep;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.VelConstraint;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class meepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);

        Pose2d blueLeft = new Pose2d(12, 58.5, Math.toRadians(90));

        Pose2d redLeft = new Pose2d(-12,-58.5, Math.toRadians(-90));

        Pose2d blueRight = new Pose2d(-12,58.5, Math.toRadians(90));

        Pose2d redRight = new Pose2d(12,-58.5,Math.toRadians(-90));

        RoadRunnerBotEntity hookPlusThreeYellow = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity bluepark = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity redhookPlusThreeYellow = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                        .build();

        RoadRunnerBotEntity redpark = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity bigboy = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                .build();



        bigboy.runAction(bigboy.getDrive().actionBuilder(blueRight)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(-7,26), Math.toRadians(225))
                .waitSeconds(1)
                //first drop off
                .setTangent(Math.toRadians(-270))
                .splineToLinearHeading(new Pose2d(-46,12.5,Math.toRadians(-90)),Math.toRadians(300))
                .waitSeconds(.1)
                //move to push block
                .lineToY(55)
                //push first block
                .splineToLinearHeading(new Pose2d(-60,12.5,Math.toRadians(-90)),Math.toRadians(90))
                //move to push block
                .lineToY(55)
                //push second block

                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(1)
                //second drop off

                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                //pick up third block
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(1)
                //drop third block
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                //pick up forth block
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                .waitSeconds(1)
                //drop off forth block
                .splineToLinearHeading(new Pose2d(-34,60,Math.toRadians(-90)),Math.toRadians(0))
                //pick up fith block
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(90)), Math.toRadians(225))
                //drop off fith block



                //.splineToConstantHeading(new Vector2d(-44, 65),Math.toRadians(90))
                .build()
        )
        ;


        bluepark.runAction(bluepark.getDrive().actionBuilder(blueRight)
                .waitSeconds(5)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(-7,26), Math.toRadians(225))
                .waitSeconds(1)
                .waitSeconds(1)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(-8,40), Math.toRadians(0))
                //back up from bar

                .waitSeconds(1)
                .splineTo(new Vector2d(-50,60),Math.toRadians(90))
                .build())
        ;


        redpark.runAction(bluepark.getDrive().actionBuilder(redRight)
                .waitSeconds(5)
                .setTangent(Math.toRadians(-270))
                .splineToConstantHeading(new Vector2d(7,-26), Math.toRadians(-225))
                .waitSeconds(1)
                .waitSeconds(1)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(8,-40), Math.toRadians(0))
                //back up from bar

                .waitSeconds(1)
                .splineTo(new Vector2d(50,-60),Math.toRadians(-90))
                .build())
        ;




        hookPlusThreeYellow.runAction(hookPlusThreeYellow.getDrive().actionBuilder(blueLeft)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(7,26), Math.toRadians(225))
                .waitSeconds(1)
                .waitSeconds(1)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(8,40), Math.toRadians(0))
                //back up from bar

                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(31, 18, Math.toRadians(0)), Math.toRadians(179))//30
                .splineToConstantHeading(new Vector2d(29,21),Math.toRadians(0))
                //.waitSeconds(1)
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(31,20),Math.toRadians(0))
                .waitSeconds(.5)//
                .waitSeconds(1)
                //.waitSeconds(1)

                //Pick up 1 sample
                .setReversed(true)
                .strafeToConstantHeading(new Vector2d(35,25))
                .waitSeconds(1)
                //grab block with outtake

                .splineToSplineHeading(new Pose2d(54,50, Math.toRadians(230)), Math.toRadians(50))
                //move to basket
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(60, 56), Math.toRadians(0))
                .waitSeconds(1)
                .waitSeconds(.5)
                .splineToConstantHeading(new Vector2d(55,51),Math.toRadians(0))
                .waitSeconds(.5)
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
                .endTrajectory()
                //park
                .build());





        redhookPlusThreeYellow.runAction((redhookPlusThreeYellow.getDrive().actionBuilder(redLeft))


                .setTangent(Math.toRadians(270-180))
                .splineToConstantHeading(new Vector2d(-7,-26), Math.toRadians(225-180))
                .waitSeconds(1)
                .waitSeconds(1)
                //Drop specimen on bar

                .splineToConstantHeading(new Vector2d(-8,-40), Math.toRadians(-180))
                //back up from bar

                .setTangent(Math.toRadians(-180))
                .splineToSplineHeading(new Pose2d(-31, -18, Math.toRadians(180)), Math.toRadians(-179-180))//30
                .splineToConstantHeading(new Vector2d(-29,-21),Math.toRadians(0))
                //.waitSeconds(1)
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(-31,-20),Math.toRadians(0))
                .waitSeconds(.5)//
                .waitSeconds(1)
                //.waitSeconds(1)

                //Pick up 1 sample
                .setReversed(true)

                .strafeToConstantHeading(new Vector2d(-35,-25))
                .waitSeconds(1)
                //grab block with outtake

                .splineToSplineHeading(new Pose2d(-54,-50, Math.toRadians(230-180)), Math.toRadians(50-180))
                //move to basket
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(-60, -56), Math.toRadians(0))
                .waitSeconds(1)
                .waitSeconds(.5)
                .splineToConstantHeading(new Vector2d(-55,-51),Math.toRadians(0))
                .waitSeconds(.5)
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
                .splineToLinearHeading(new Pose2d(-45,-10,Math.toRadians(0-180)),Math.toRadians(90-180))
                .splineToLinearHeading(new Pose2d(-15,-9,Math.toRadians(0-180)),Math.toRadians(90-180))
                //park
                .endTrajectory()
                //park
                .build());








        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                //.addEntity(redhookPlusThreeYellow)
                //.addEntity(hookPlusThreeYellow)
               // .addEntity(bluepark)
                //.addEntity(redpark)
                .addEntity(bigboy)
                .start();
    }
}