package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class LinearMech {

    public int HighBasket =  2760;//1300;
    public int LowBasket = 0;//+846;
    public int HighBar = 850;//543;
    public int LowBar = 0;
    public int start = 0;

    public int HortPosMax = 975;

    public DcMotorEx leftVertLinear;
    public DcMotorEx rightVertLinear;
    public DcMotorEx HortSlide;

    List<LynxModule> allHubs;

    public LinearMech(@NonNull DcMotorEx leftVertLinear, @NonNull DcMotorEx rightVertLinear, @NonNull List<LynxModule> allHubs, @NonNull DcMotorEx HortSlide) {
        this.leftVertLinear = leftVertLinear;
        this.rightVertLinear = rightVertLinear;
        this.allHubs = allHubs;
        this.HortSlide = HortSlide;

        /*for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }*/
    }

    public void runHubReadings(){
        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }
    }

    public enum LinearPosEnum{
        HighBasket,
        LowBasket,
        HighBar,
        LowBar,
        start
    }

    private LinearPosEnum LinearPos = LinearPosEnum.start;

    public Dictionary<DcMotorEx, Integer> getLinearPos(){
        Dictionary<DcMotorEx, Integer> positions= new Hashtable<>();

        positions.put(leftVertLinear, leftVertLinear.getCurrentPosition());
        positions.put(rightVertLinear, rightVertLinear.getCurrentPosition());

        return positions;
    }

    public LinearPosEnum getpos() {
        return LinearPos;
    }

    public void setLinearPosAsEnum(LinearPosEnum PosEnum){
        switch (PosEnum){
            case HighBasket -> {
                setVertPosition(HighBasket);
                LinearPos = PosEnum;
            }
            case HighBar -> {
                setVertPosition(HighBar);
                LinearPos = PosEnum;
            }
            case LowBasket -> {
                setVertPosition(LowBasket);
                LinearPos = PosEnum;
            }
            case LowBar -> {
                setVertPosition(LowBar);
                LinearPos = PosEnum;
            }
            case start -> {
                setVertPosition(start);
                LinearPos = PosEnum;
            }
        }

    }
    private void setVertPosition(int pos){
        setLeftVertPos(pos);
        setRightVertPos(pos);
    }

    private void setLeftVertPos(int pos){
        leftVertLinear.setTargetPosition(pos);

        if (leftVertLinear.getCurrentPosition()+ 20 >= Math.abs(pos) &&
                leftVertLinear.getCurrentPosition() - 20 <= Math.abs(pos))
            leftVertLinear.setPower(.3);
        else
            leftVertLinear.setPower(1);

    }

    private void setRightVertPos(int pos){
        rightVertLinear.setTargetPosition(pos);

        if (rightVertLinear.getCurrentPosition()+ 20 >= Math.abs(pos) &&
                rightVertLinear.getCurrentPosition() - 20 <= Math.abs(pos))
            rightVertLinear.setPower(.3);
        else
            rightVertLinear.setPower(1);

    }

    public void HortSlideHoldPos(){
        HortSlide.setTargetPosition(0);
        HortSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        HortSlide.setPower(.2);


    }
}
