package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class Autonomous extends LinearOpMode{

    public DcMotor leftMotor1;
    public DcMotor rightMotor1;
    public DcMotor leftMotor2;
    public DcMotor rightMotor2;


    public float motorPower = 2.0f;


    @Override
    public void runOpMode()
    {

        //connects motors to hub & phone- use name in quotes for config
        leftMotor1 = hardwareMap.get(DcMotor.class, "left_Motor1");
        rightMotor1 = hardwareMap.get(DcMotor.class, "right_Motor1");
        leftMotor2 = hardwareMap.get(DcMotor.class, "left_Motor2");
        rightMotor2 = hardwareMap.get(DcMotor.class, "right_Motor2");

        leftMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor1.setDirection(DcMotor.Direction.FORWARD);
        rightMotor1.setDirection(DcMotor.Direction.FORWARD);
        leftMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor2.setDirection(DcMotor.Direction.FORWARD);
        rightMotor2.setDirection(DcMotor.Direction.FORWARD);


        waitForStart(); //press play button, actives opMode

        //ratchetServo.setPosition(0);

        leftMotor1.setPower(1);
        leftMotor2.setPower(1);
        rightMotor1.setPower(-1);
        rightMotor2.setPower(-1);
        sleep(10000);
        leftMotor1.setPower(0);
        leftMotor2.setPower(0);
        rightMotor1.setPower(0);
        rightMotor2.setPower(0);

    }

}
