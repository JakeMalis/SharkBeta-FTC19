package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp(name="OpMode", group="Linear OpMode")
public class JavaOpMode extends LinearOpMode {

    public DcMotor leftMotor1;
    public DcMotor rightMotor1;
    public DcMotor leftMotor2;
    public DcMotor rightMotor2;
    public DcMotor liftPivotMotor;
    public DcMotor leftIntakeMotor;
    public DcMotor rightIntakeMotor;

    @Override
    public void runOpMode(){
        leftMotor1 = hardwareMap.get(DcMotor.class, "leftMotor1");
        leftMotor2 = hardwareMap.get(DcMotor.class, "leftMotor2");
        rightMotor1 = hardwareMap.get(DcMotor.class, "rightMotor1");
        rightMotor2 = hardwareMap.get(DcMotor.class, "rightMotor2");
        liftPivotMotor= hardwareMap.get(DcMotor.class, "pivotMotor");
        leftIntakeMotor = hardwareMap.get(DcMotor.class, "leftIntakeMotor");
        rightIntakeMotor = hardwareMap.get(DcMotor.class, "rightIntakeMotor");

        leftMotor1.setDirection(DcMotor.Direction.FORWARD);
        leftMotor2.setDirection(DcMotor.Direction.FORWARD);
        rightMotor1.setDirection(DcMotor.Direction.REVERSE);
        rightMotor2.setDirection(DcMotor.Direction.REVERSE);
        leftIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        rightIntakeMotor.setDirection(DcMotor.Direction.REVERSE);
        /*
        leftMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftPivotMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        */

        waitForStart();

        while (opModeIsActive()){
            double leftPower;
            double rightPower;
            leftPower  = -gamepad1.left_stick_y;
            rightPower = -gamepad1.right_stick_y;
            leftMotor1.setPower(leftPower);
            leftMotor2.setPower(leftPower);
            rightMotor1.setPower(rightPower);
            rightMotor2.setPower(rightPower);


            boolean intakePower;
            boolean outTakePower;
            intakePower = gamepad2.right_bumper;
            outTakePower = gamepad2.left_bumper;

            if (intakePower){ leftIntakeMotor.setPower(-0.5); rightIntakeMotor.setPower(-1); }
            else { leftIntakeMotor.setPower(0); rightIntakeMotor.setPower(0); }

            if (outTakePower){ leftIntakeMotor.setPower(0.5); rightIntakeMotor.setPower(1); }
            else { leftIntakeMotor.setPower(0); rightIntakeMotor.setPower(0); }


            double liftPower;
            liftPower = -gamepad2.left_stick_y;
            liftPivotMotor.setPower(liftPower);
        }
    }
}
