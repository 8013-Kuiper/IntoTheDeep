package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class LinearFunc {

    public int HighBasket = 1300;
    public int LowBasket = 806;//+846;
    public int HighBar = 556;//543;
    public int LowBar = 0;
    public int start = 0;

    public int HortPosMax = 975;

    public DcMotorEx leftVertLinear;
    public DcMotorEx rightVertLinear;

    List<LynxModule> allHubs;


    public LinearFunc(@NonNull DcMotorEx leftVertLinear, @NonNull DcMotorEx rightVertLinear, @NonNull List<LynxModule> allHubs) {
        this.leftVertLinear = leftVertLinear;
        this.rightVertLinear = rightVertLinear;
        this.allHubs = allHubs;

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

    private LinearPosEnum LinearPos = null;

    public Dictionary<DcMotorEx, Integer> getLinearPos(){
        Dictionary<DcMotorEx, Integer> positions= new Hashtable<>();

        positions.put(leftVertLinear, leftVertLinear.getCurrentPosition());
        positions.put(rightVertLinear, rightVertLinear.getCurrentPosition());

        return positions;
    }

    public void setLinearPos(LinearPosEnum PosEnum){
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

        if (leftVertLinear.getCurrentPosition()+ 20 > pos ||
                leftVertLinear.getCurrentPosition() - 20 > pos)
            leftVertLinear.setPower(1);
        else
            leftVertLinear.setPower(.3);

    }

    private void setRightVertPos(int pos){
        rightVertLinear.setTargetPosition(pos);

        if (rightVertLinear.getCurrentPosition()+ 20 > pos ||
                rightVertLinear.getCurrentPosition() - 20 > pos)
            rightVertLinear.setPower(1);
        else
            rightVertLinear.setPower(.3);

    }
}
