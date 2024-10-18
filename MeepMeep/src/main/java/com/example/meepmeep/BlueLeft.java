package com.example.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class BlueLeft {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(750);

        Pose2d startPose = new Pose2d(38, 62, Math.toRadians(0));

        RoadRunnerBotEntity hookPlusThreeYellow = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        RoadRunnerBotEntity oneBluePlusThreeYellow = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        hookPlusThreeYellow.runAction(hookPlusThreeYellow.getDrive().actionBuilder(startPose)
                        .setTangent(Math.toRadians(270))
                        .splineToConstantHeading(new Vector2d(25,0), Math.toRadians(225))
                //Drop specimen on bar
                        .setTangent(Math.toRadians(0))
                        .splineToSplineHeading(new Pose2d(47, 20, Math.toRadians(80)), Math.toRadians(90))
                        //Pick up 1 sample
                        .splineToSplineHeading(new Pose2d(52,50, Math.toRadians(230)), Math.toRadians(50))
                //Deposit sample into basket
                        .setTangent(Math.toRadians(0))
                        .splineToSplineHeading(new Pose2d(60, 48, Math.toRadians(269)), Math.toRadians(0))
                //Pick up sample then deposit
                        .setTangent(Math.toRadians(230))
                        .splineToSplineHeading(new Pose2d(50, 35, Math.toRadians(340)), Math.toRadians(230))
                //Reach out and pick up sample
                        .setTangent(Math.toRadians(110))
                .splineToSplineHeading(new Pose2d(60, 48, Math.toRadians(269)), Math.toRadians(0))
                //Deposit sample into basket
                        //Park

                .build());



        oneBluePlusThreeYellow.runAction(oneBluePlusThreeYellow.getDrive().actionBuilder(startPose)
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

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                //.addEntity(hookPlusThreeYellow)
                .addEntity(oneBluePlusThreeYellow)
                .start();
    }
}