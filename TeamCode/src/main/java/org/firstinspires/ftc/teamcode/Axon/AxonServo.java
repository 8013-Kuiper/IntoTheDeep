package org.firstinspires.ftc.teamcode.Axon;

import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public abstract class AxonServo extends Axon{

    public ServoImplEx servo;

    public static abstract class CRAxonServo extends Axon{
        public CRServoImplEx servo;

    }
}
