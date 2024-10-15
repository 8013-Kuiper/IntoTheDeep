package org.firstinspires.ftc.teamcode;

public class colorDataType {
    private float min;
    private float max;

    public colorDataType(float min, float max){
        this.min = min;
        this.max = max;

    }

    public float getMin(){
        return min;
    }

    public float getMax(){
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public void setMin(float min) {
        this.min = min;
    }
}
