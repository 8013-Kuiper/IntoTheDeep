package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class LinearFunc {

    public int HighBasket = 0;
    public int LowBasket = 0;
    public int HighBar = 0;
    public int LowBar = 0;

    public DcMotorEx leftVertLinear;
    public DcMotorEx rightVertLinear;

    List<LynxModule> allHubs;


    public LinearFunc(@NonNull DcMotorEx leftVertLinear, @NonNull DcMotorEx rightVertLinear, @NonNull List<LynxModule> allHubs) {
        this.leftVertLinear = leftVertLinear;
        this.rightVertLinear = rightVertLinear;
        this.allHubs = allHubs;

        for (LynxModule hub : allHubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    public enum LinearPosEnum{
        HighBasket,
        LowBasket,
        HighBar,
        LowBar
    }

    private LinearPosEnum LinearPos = null;

    public Dictionary<DcMotorEx, Integer> getLinearPos(){
        for (LynxModule hub : allHubs) {
            hub.clearBulkCache();
        }
        Dictionary<DcMotorEx, Integer> positions= new Hashtable<>();

        positions.put(leftVertLinear, leftVertLinear.getCurrentPosition());
        positions.put(rightVertLinear, rightVertLinear.getCurrentPosition());

        return positions;
    }

    public void setLinearPos(LinearPosEnum PosEnum){
        switch (PosEnum){
            case HighBasket -> {

            }
            case HighBar -> {

            }
            case LowBasket -> {

            }
            case LowBar -> {

            }
        }

    }
}
