package org.firstinspires.ftc.teamcode.testing;

public class colorInIntakeClass {
    public static int neutralSampleColor = 0;
    public static int redSampleColor = 700;
    public static int blueSampleColor = 0;

    private static int colorRange = 20;

    public enum colors {
        blue,
        red,
        neutral,
        noColor
    }

    public colorInIntakeClass(){
    }

    public colorInIntakeClass(int setColorRange){
        colorRange = setColorRange;

    }

    public static colors colorInIntake(int intakeSampleColor){
        colors color;

        if (getIsColorInRange(neutralSampleColor, intakeSampleColor)){
            color = colors.neutral;
        }
        else if (getIsColorInRange(redSampleColor, intakeSampleColor)){
            color = colors.red;
        }
        else if (getIsColorInRange(blueSampleColor, intakeSampleColor)){
            color = colors.blue;
        }
        else
            color = colors.noColor;

        return color;
    }

    private static int getLowerBoundRange(int number){
        return number-colorRange;
    }

    private static int getUpperBoundRange(int number){
        return number+colorRange;

    }

    private static boolean getIsColorInRange(int color, int sampleColorInIntake){
        boolean isLowerColorInRange = false;
        boolean isUpperColorInRange = false;
        boolean isColorInRange = false;

        if (color>=getLowerBoundRange(sampleColorInIntake)){
            isLowerColorInRange = true;
        }
        if (color<=getUpperBoundRange(sampleColorInIntake)){
            isUpperColorInRange = true;
        }

        if (isLowerColorInRange && isUpperColorInRange){
            isColorInRange = true;
        }

        return isColorInRange;
    }
}
