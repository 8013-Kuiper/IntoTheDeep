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

        RoadRunnerBotEntity hookPlusThreeYellow = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                //.setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity oneBluePlusThreeYellow = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity redhookPlusThreeYellow = new DefaultBotBuilder(meepMeep)
                //.setConstraints(60,60,Math.toRadians(180),Math.toRadians(180), 15)
                        .build();












        hookPlusThreeYellow.runAction(hookPlusThreeYellow.getDrive().actionBuilder(blueLeft)
                .setTangent(Math.toRadians(270))
                .splineToConstantHeading(new Vector2d(8,32), Math.toRadians(225))
                .waitSeconds(2)
                //Drop specimen on bar
                .splineToConstantHeading(new Vector2d(8,40), Math.toRadians(0))
                //back up from bar
                .setTangent(Math.toRadians(0))
                .splineToSplineHeading(new Pose2d(25, 15, Math.toRadians(0)), Math.toRadians(179))
                //.splineToConstantHeading(new Vector2d(30,25), Math.toRadians(0))
                .waitSeconds(2)
                //Pick up 1 sample
                .setReversed(true)
                .strafeToConstantHeading(new Vector2d(25,25))
                .splineToSplineHeading(new Pose2d(57,55, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket
                /*
                .setTangent(Math.toRadians(0))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(35, 15, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(2)
                //move to pick up another sample (2)
                .setReversed(true)
                        .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,55, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket
                .setTangent(Math.toRadians(0))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(45, 15, Math.toRadians(0)), Math.toRadians(0))
                .waitSeconds(2)
                //move to pick up another sample (3)
                .setReversed(true)
                        .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(57,55, Math.toRadians(230)), Math.toRadians(50))
                .waitSeconds(2)
                //Deposit sample into basket

                 */
                //.setReversed(false)
                .splineToConstantHeading(new Vector2d(45,10),Math.toRadians(0))
                .splineToLinearHeading(new Pose2d(15,10,Math.toRadians(0)),Math.toRadians(90))
                //park
                .build());



        oneBluePlusThreeYellow.runAction(oneBluePlusThreeYellow.getDrive().actionBuilder(blueLeft)
                        .setTangent(Math.toRadians(270))
                        .splineToLinearHeading(new Pose2d(58, 50, Math.toRadians(250)), Math.toRadians(0))
                        //Drop sample in basket and pick up another then drop again.
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(61, 48, Math.toRadians(270)), Math.toRadians(0))
                        //adjust for next pick up, pick up, then drop
                        .setTangent(Math.toRadians(200))
                        .splineToSplineHeading(new Pose2d(50, 35, Math.toRadians(340)), Math.toRadians(230))
                        //Reach out and pick up sample
                        .setTangent(Math.toRadians(110))
                        .splineToSplineHeading(new Pose2d(60, 48, Math.toRadians(269)), Math.toRadians(0))
                        //Deposit sample into basket
                        //Park
                        .build());

        redhookPlusThreeYellow.runAction((redhookPlusThreeYellow.getDrive().actionBuilder(redLeft))
                .setTangent(Math.toRadians(90)) // Flipped starting direction
                .splineToConstantHeading(new Vector2d(-8, -32), Math.toRadians(45)) // Adjusted x, y, and heading
                .waitSeconds(2)
// Drop specimen on bar
                .splineToConstantHeading(new Vector2d(-8, -40), Math.toRadians(180)) // Adjusted y, heading
// Back up from bar
                .setTangent(Math.toRadians(180))
                .splineToSplineHeading(new Pose2d(-30, -25, Math.toRadians(180)), Math.toRadians(45)) // Flipped
                .waitSeconds(2)
// Pick up 1 sample
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(-62, -60, Math.toRadians(50)), Math.toRadians(230)) // Adjusted
                .waitSeconds(2)
// Deposit sample into basket
                .setTangent(Math.toRadians(180))
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-40, -25, Math.toRadians(180)), Math.toRadians(180))
                .waitSeconds(2)
// Move to pick up another sample (2)
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(-62, -60, Math.toRadians(50)), Math.toRadians(230))
                .waitSeconds(2)
// Deposit sample into basket
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-50, -25, Math.toRadians(180)), Math.toRadians(180))
                .waitSeconds(2)
// Move to pick up another sample (3)
                .setReversed(true)
                .splineToSplineHeading(new Pose2d(-62, -60, Math.toRadians(50)), Math.toRadians(230))
                .waitSeconds(2)
// Deposit sample into basket
                .setReversed(false)
                .splineToLinearHeading(new Pose2d(-24, -10, Math.toRadians(180)), Math.toRadians(270)) // Adjusted
// Park
                .build());








        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(redhookPlusThreeYellow)
                .addEntity(hookPlusThreeYellow)
                //.addEntity(oneBluePlusThreeYellow)
                .start();
    }
}