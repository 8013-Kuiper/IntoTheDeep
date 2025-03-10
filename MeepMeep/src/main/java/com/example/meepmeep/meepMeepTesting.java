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

        Pose2d blueRight = new Pose2d(-12,58.5, Math.toRadians(0));

        Pose2d redRight = new Pose2d(12,-58.5,Math.toRadians(0));

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

        RoadRunnerBotEntity clip5 = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity clip4blue = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity clip4red = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                .build();


        RoadRunnerBotEntity newclip5 = new DefaultBotBuilder(meepMeep)
                .setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                .build();

        newclip5.runAction(newclip5.getDrive().actionBuilder(blueRight)
                .setTangent(Math.toRadians(-90))
                ///////////////////////////////////////
                .splineToConstantHeading(new Vector2d(-2,26), Math.toRadians(-90))
                //////////////////////////////////////////
                .waitSeconds(.5)
                //first drop off
                .splineToLinearHeading(new Pose2d(-7,35,Math.toRadians(250)),Math.toRadians(0))
                .turn(Math.toRadians(-90))
                //push first block
                .turn(Math.toRadians(85))
                .splineToConstantHeading(new Vector2d(-15,35),Math.toRadians(0))
                .turn(Math.toRadians(-90))
                //push second block
                .turn(Math.toRadians(85))
                .splineToConstantHeading(new Vector2d(-25,35),Math.toRadians(0))
                .turn(Math.toRadians(-90))
                //push third block
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(0))
                .waitSeconds(.000001)
                .lineToY(56)
                .waitSeconds(4)
                //pick up second block
                .setReversed(false)
                /////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                ////////////////////////////////////////////////////////
                .waitSeconds(.5)
                //second drop off
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up third block
                .setReversed(false)
                /////////////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                ////////////////////////////////////////////////////////
                .waitSeconds(.5)
                //drop third block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up forth block
                .setReversed(false)
                //////////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                ////////////////////////////////////////////////
                .waitSeconds(.5)
                //drop off forth block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up fith block
                .setReversed(false)
                /////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                //////////////////////////////////////////////////
                //drop off fith block



                //.splineToConstantHeading(new Vector2d(-44, 65),Math.toRadians(90))
                .build()
        )
        ;




        clip5.runAction(clip5.getDrive().actionBuilder(blueRight)
                .setTangent(Math.toRadians(-90))
                ///////////////////////////////////////
                .splineToConstantHeading(new Vector2d(-2,26), Math.toRadians(-90))
                //////////////////////////////////////////
                .waitSeconds(.5)
                //first drop off
                .splineToConstantHeading(new Vector2d(-7,35),Math.toRadians(0))
                .setTangent(Math.toRadians(-270))
                .splineToLinearHeading(new Pose2d(-45,6,Math.toRadians(-90)),Math.toRadians(0))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-40,55),Math.toRadians(0))
                //push first block
                .splineToLinearHeading(new Pose2d(-55,10,Math.toRadians(-90)),Math.toRadians(90))
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
                /////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                ////////////////////////////////////////////////////////
                .waitSeconds(.5)
                //second drop off
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up third block
                .setReversed(false)
                /////////////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                ////////////////////////////////////////////////////////
                .waitSeconds(.5)
                //drop third block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up forth block
                .setReversed(false)
                //////////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                ////////////////////////////////////////////////
                .waitSeconds(.5)
                //drop off forth block
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-25,55,Math.toRadians(-90)),Math.toRadians(90))
                .waitSeconds(.000001)
                .lineToY(56)
                //pick up fith block
                .setReversed(false)
                /////////////////////////////////////////////////
                .splineToLinearHeading(new Pose2d(-7,26,Math.toRadians(-90)), Math.toRadians(225))
                //////////////////////////////////////////////////
                //drop off fith block



                //.splineToConstantHeading(new Vector2d(-44, 65),Math.toRadians(90))
                .build()
        )
        ;

        clip4blue.runAction(clip4blue.getDrive().actionBuilder(blueRight)
                .turn(Math.toRadians(-1))
                //.afterTime(.00001,outtakeAction.clipClawClose())
                //start of drop off
                //.afterTime(.000001,outtakeAction.clipArmUp())
                .setTangent(Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-3,25,Math.toRadians(-90)),Math.toRadians(-90))
                //move to drop off
                .waitSeconds(.00001)
                //.afterTime(.00001,outtakeAction.clipArmDown())
                .waitSeconds(.2)
                //.afterTime(.4, outtakeAction.clipClawOpen())
                .lineToY(30)
                //end of first drop off

                .splineToConstantHeading(new Vector2d(-50,35),Math.toRadians(-90))//0
                .splineToLinearHeading(new Pose2d(-38,6,Math.toRadians(-90)),Math.toRadians(270))//0
                .splineToConstantHeading(new Vector2d(-47,6),Math.toRadians(90))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-38,59),Math.toRadians(0))
                //push first block
                .splineToLinearHeading(new Pose2d(-55,8,Math.toRadians(-90)),Math.toRadians(90))
                //move to push block
                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(-42,58),Math.toRadians(0))
                //push second block

                .splineToLinearHeading(new Pose2d(-39,55,Math.toRadians(-90)),Math.toRadians(0))
                //move to pick up second block
                .waitSeconds(.000001)
                .lineToY(59)
                .waitSeconds(.0001)
                //.afterTime(.0001,outtakeAction.clipClawClose())
                .waitSeconds(.1)
                //pick up second block
                .setReversed(false)
                //.afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(7,46), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(7,21),Math.toRadians(-90))
                //move to drop off
                .waitSeconds(.000001)
                //.afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.15)
                //.afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(30)
                //end of second drop off

                .waitSeconds(.1)
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-30,55,Math.toRadians(-90)),Math.toRadians(90))
                //move to pick up third block
                .waitSeconds(.000001)
                .lineToY(59)
                .waitSeconds(.0001)
                //.afterTime(.0001,outtakeAction.clipClawClose())
                .waitSeconds(.1)
                //pick up third block
                .setReversed(false)
                //.afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(11,50), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(11,21),Math.toRadians(-90))
                //move to drop off third block
                .waitSeconds(.000001)
                //.afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.15)
                //.afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(30)
                //third drop off

                .waitSeconds(.1)
                .setTangent(90)
                .splineToLinearHeading(new Pose2d(-30,55,Math.toRadians(-90)),Math.toRadians(90))
                //move to pick up forth block
                .waitSeconds(.000001)
                .lineToY(60)
                .waitSeconds(.00001)
                //.afterTime(.00001,outtakeAction.clipClawClose())
                .waitSeconds(.1)
                //pick up forth block
                .setReversed(false)
                //.afterTime(.0001,outtakeAction.clipArmUp())
                .splineToConstantHeading(new Vector2d(14,50), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(14,21),Math.toRadians(-90))
                //move to drop off forth block
                .waitSeconds(.000001)
                //.afterTime(.0001,outtakeAction.clipArmDown())
                .waitSeconds(.15)
                //.afterTime(.5, outtakeAction.clipClawOpen())
                .lineToY(30)

                .build()
        );

        clip4red.runAction(clip4red.getDrive().actionBuilder(redRight)
                        .turn(Math.toRadians(1))
//                .afterTime(.00001,outtakeAction.clipClawClose())
                        //start of drop off
//                .afterTime(.000001,outtakeAction.clipArmUp())
                        .setTangent(Math.toRadians(90))
                        .splineToLinearHeading(new Pose2d(3,-25,Math.toRadians(90)),Math.toRadians(90))
                        //move to drop off
                        .waitSeconds(.00001)
//                .afterTime(.00001,outtakeAction.clipArmDown())
                        .waitSeconds(.2)
//                .afterTime(.4, outtakeAction.clipClawOpen())
                        .lineToY(-30)
                        //end of first drop off

                        .splineToConstantHeading(new Vector2d(50,-35),Math.toRadians(90))//0
                        .splineToLinearHeading(new Pose2d(38,-6,Math.toRadians(90)),Math.toRadians(90))//0
                        .splineToConstantHeading(new Vector2d(47,-6),Math.toRadians(-90))
                        //move to push block
                        .setTangent(Math.toRadians(-90))
                        .splineToConstantHeading(new Vector2d(38,-59),Math.toRadians(180))
                        //push first block
                        .splineToLinearHeading(new Pose2d(55,-8,Math.toRadians(90)),Math.toRadians(-90))
                        //move to push block
                        .setTangent(Math.toRadians(-90))
                        .splineToConstantHeading(new Vector2d(42,-58),Math.toRadians(180))
                        //push second block

                        .splineToLinearHeading(new Pose2d(39,-55,Math.toRadians(90)),Math.toRadians(180))
                        //move to pick up second block
                        .waitSeconds(.000001)
                        .lineToY(-59)
                        .waitSeconds(.0001)
//                .afterTime(.0001,outtakeAction.clipClawClose())
                        .waitSeconds(.1)
                        //pick up second block
                        .setReversed(false)
//                .afterTime(.0001,outtakeAction.clipArmUp())
                        .splineToConstantHeading(new Vector2d(-7,-46), Math.toRadians(90))
                        .splineToConstantHeading(new Vector2d(-7,-21),Math.toRadians(90))
                        //move to drop off
                        .waitSeconds(.000001)
//                .afterTime(.0001,outtakeAction.clipArmDown())
                        .waitSeconds(.15)
//                .afterTime(.5, outtakeAction.clipClawOpen())
                        .lineToY(-30)
                        //end of second drop off

                        .waitSeconds(.1)
                        .setTangent(-45)
                        .splineToLinearHeading(new Pose2d(30,-55,Math.toRadians(90)),Math.toRadians(0))
                        //move to pick up third block
                        .waitSeconds(.000001)
                        .lineToY(-59)
                        .waitSeconds(.0001)
//                .afterTime(.0001,outtakeAction.clipClawClose())
                        .waitSeconds(.1)
                        //pick up third block
                        .setReversed(false)
//                .afterTime(.0001,outtakeAction.clipArmUp())
                        .splineToConstantHeading(new Vector2d(-11,-50), Math.toRadians(90))
                        .splineToConstantHeading(new Vector2d(-11,-21),Math.toRadians(90))
                        //move to drop off third block
                        .waitSeconds(.000001)
//                .afterTime(.0001,outtakeAction.clipArmDown())
                        .waitSeconds(.15)
//                .afterTime(.5, outtakeAction.clipClawOpen())
                        .lineToY(-30)
                        //third drop off

                        .waitSeconds(.1)
                        .setTangent(-45)
                        .splineToLinearHeading(new Pose2d(30,-55,Math.toRadians(90)),Math.toRadians(0))
                        //move to pick up fourth block
                        .waitSeconds(.000001)
                        .lineToY(-60)
                        .waitSeconds(.00001)
//                .afterTime(.00001,outtakeAction.clipClawClose())
                        .waitSeconds(.1)
                        //pick up fourth block
                        .setReversed(false)
//                .afterTime(.0001,outtakeAction.clipArmUp())
                        .splineToConstantHeading(new Vector2d(-14,-50), Math.toRadians(90))
                        .splineToConstantHeading(new Vector2d(-14,-21),Math.toRadians(90))
                        //move to drop off fourth block
                        .waitSeconds(.000001)
//                .afterTime(.0001,outtakeAction.clipArmDown())
                        .waitSeconds(.15)
//                .afterTime(.5, outtakeAction.clipClawOpen())
                        .lineToY(-30)
                        //drop fourth block






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

                .setTangent(Math.toRadians(0))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(40, 20, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(1)
                //.afterTime(1,intakeAction.Middle())
                //.afterTime(2, intakeAction.Low())
                //.afterTime(2, intakeAction.WheelOn())
                .waitSeconds(2)
                .splineToConstantHeading(new Vector2d(41,20),Math.toRadians(0))
                //.afterTime(2, intakeAction.intakeUp())
                .waitSeconds(1)
                //.afterTime(2, intakeAction.WheelOff())
                .waitSeconds(1)
                //move to pick up another sample (2)


                .setReversed(true)
                //.afterTime(1, outtakeAction.outtakeDown())
                .waitSeconds(1)
                //.afterTime(1,intakeAction.WheelReverse())
                //.afterTime(1,outtakeAction.outtakeUp())
                //.afterTime(3,intakeAction.WheelOff())
                //.afterTime(3,outtakeAction.outtakeSpin())
                //grab block with outtake

                .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,53, Math.toRadians(230)), Math.toRadians(50))
                //.afterTime(1, vertSlidesAction.high())
                .waitSeconds(3)
                .splineToConstantHeading(new Vector2d(59, 55), Math.toRadians(0))
                //.afterTime(1,outtakeAction.outtakeClaw(outtakeIntakeMech.outtakeGrab.Release))
                .waitSeconds(1)
                .splineToConstantHeading(new Vector2d(56,52),Math.toRadians(0))
                //.afterTime(2,vertSlidesAction.outtakePos(LinearMech.LinearPosEnum.start))
                .waitSeconds(4)
                //Deposit sample into basket
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*


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
                //.addEntity(clip4blue)
                .addEntity(redhookPlusThreeYellow)
               // .addEntity(clip5)
                .start();
    }
}