package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class GabeTempJava extends LinearOpMode{

    private float stickSensitivity = 0.1f; //> than this gets registered as input

    public DcMotor leftMotor1;
    public DcMotor rightMotor1;
    public DcMotor leftMotor2;
    public DcMotor rightMotor2;

    /*public DcMotor drawerMotor;
    public float drawrMotorSensititivy = 0.6f;

    public Servo ratchetServo;*/

    public float motorPower = 1.0f;

    /*public Servo intakePivotServo;
    public float intakePivotServoPos = 0.5f; //What the servo above's current pos is; Sets to this at start
    public float intakePivotSensitivity = 200;*/

    public DcMotor liftPivotMotor;
    public float liftPivotServoPos = 0; //What the motor above's current pos is; Sets to this at start
    public float liftPivotSensitivity = 0.6f;
    private boolean liftLocked; //If true, the lift stays in place
    private float liftLockPower = 0.5f; //What the motors's power needs to be to stay in place holding our lift's weight

    public boolean isIntakeActive;
    public DcMotor leftIntakeMotor;
    public DcMotor rightIntakeMotor;
    @Override
    public void runOpMode()
    {

        //connects motors to hub & phone- use name in quotes for config
        leftMotor1 = hardwareMap.get(DcMotor.class, "left_Motor1");
        rightMotor1 = hardwareMap.get(DcMotor.class, "right_Motor1");
        leftMotor2 = hardwareMap.get(DcMotor.class, "left_Motor2");
        rightMotor2 = hardwareMap.get(DcMotor.class, "right_Motor2");
        liftPivotMotor= hardwareMap.get(DcMotor.class, "lift_Motor");
        leftIntakeMotor = hardwareMap.get(DcMotor.class, "leftIntakeMotor");
        rightIntakeMotor = hardwareMap.get(DcMotor.class, "rightIntakeMotor");
        //intakePivotServo = hardwareMap.get(Servo.class, "intakePivotServo");
        //ratchetServo = hardwareMap.get(Servo.class, "ratchetServo");

        leftMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor1.setDirection(DcMotor.Direction.FORWARD);
        rightMotor1.setDirection(DcMotor.Direction.FORWARD);
        leftMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotor2.setDirection(DcMotor.Direction.FORWARD);
        rightMotor2.setDirection(DcMotor.Direction.FORWARD);
        //drawerMotor.setDirection(DcMotor.Direction.REVERSE);
        //drawerMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftPivotMotor.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        liftPivotMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        liftPivotMotor.setTargetPosition(0);

        //intakePivotServo.setPosition(intakePivotServoPos);

        //drawerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //drawerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart(); //press play button, actives opMode

        //ratchetServo.setPosition(0);

        while (opModeIsActive())
        {
            drive();
            //pivotIntake();
            pivotLift();
            toggleIntake();
            /*toggleDrawerSlides();
            toggleRatchetServo();*/
            telemetry.addData("motorPower", motorPower);
            //telemetry.addData("drawerPos", drawerMotor.getCurrentPosition());
            //telemetry.addData("drawerMotor", drawerMotor.getCurrentPosition());
        }//opModeIsActive

    }//runOpMode
    public void drive()
    {
        if((Math.abs(gamepad1.left_stick_x) > stickSensitivity) || (Math.abs(gamepad1.left_stick_y) > stickSensitivity))
        {
            leftMotor1.setPower(-(gamepad1.left_stick_x + gamepad1.left_stick_y) * motorPower * 2);
            rightMotor1.setPower(-(gamepad1.left_stick_x + -gamepad1.left_stick_y) * motorPower * 2);
            leftMotor2.setPower (-(gamepad1.left_stick_x + gamepad1.left_stick_y) * motorPower * 2);
            rightMotor2.setPower(-(gamepad1.left_stick_x + -gamepad1.left_stick_y) * motorPower * 2);
        }
        else
        {
            leftMotor1.setPower(0);
            rightMotor1.setPower(0);
            leftMotor2.setPower(0);
            rightMotor2.setPower(0);
        }

        telemetry.addData("Left Motor 1: ", leftMotor1.getPower());
        telemetry.addData("Right Motor 1: ", rightMotor1.getPower());
        telemetry.addData("Left Motor 2: ", leftMotor2.getPower());
        telemetry.addData("Right Motor 2: ", rightMotor2.getPower());
        telemetry.update();

        if(gamepad1.left_bumper)
            motorPower = 1.0f;
        else if(gamepad1.right_bumper)
            motorPower = 0.6f;
    }

    /*public void pivotIntake()
    {
        if((intakePivotServo.getPosition() + (-gamepad2.right_stick_y / intakePivotSensitivity) > 0.38f) && (intakePivotServo.getPosition() + (-gamepad2.right_stick_y / intakePivotSensitivity) < 0.8f))
            intakePivotServo.setPosition(intakePivotServo.getPosition() + (-gamepad2.right_stick_y / intakePivotSensitivity));
        telemetry.addData("IntakePosition", intakePivotServo.getPosition());
    }*/

    public void toggleIntake()
    {
        while(gamepad2.y)
        {
            leftIntakeMotor.setPower(0.5);
            rightIntakeMotor.setPower(-0.5);
        }
        while(gamepad2.b)
        {
            leftIntakeMotor.setPower(0);
            rightIntakeMotor.setPower(0);
        }
        if(gamepad2.a)
        {
            leftIntakeMotor.setPower(-0.5);
            rightIntakeMotor.setPower(0.5);
        }
        if((!gamepad2.a || gamepad2.y) && leftIntakeMotor.getPower() != 0)
        {
            leftIntakeMotor.setPower(0);
            rightIntakeMotor.setPower(0);
        }
    }

    public void pivotLift() {
        if(Math.abs(gamepad2.left_stick_y) > stickSensitivity)
            liftPivotMotor.setPower(-gamepad2.left_stick_y * liftPivotSensitivity);
        else
            liftPivotMotor.setPower(0);
        /*if (gamepad2.right_bumper) {
            liftPivotMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            liftPivotMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            liftPivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftPivotMotor.setTargetPosition(1650);
            liftPivotMotor.setPower(0.35f);
        }
        if (gamepad2.left_bumper) {
            liftPivotMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            liftPivotMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            liftPivotMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            liftPivotMotor.setTargetPosition(-1650);
            liftPivotMotor.setPower(0.35f);
        }*/
    }
    /*public void toggleDrawerSlides()
    {
        if(gamepad2.dpad_up && drawerMotor.getCurrentPosition() < 8400)
        {
            //drawerMotor.setTargetPosition(-1000);
            drawerMotor.setPower(1 * drawrMotorSensititivy);
        }
        else if(gamepad2.dpad_down)

        {
            //drawerMotor.setTargetPosition(1000);
            drawerMotor.setPower(-1 * drawrMotorSensititivy);
        }
        else
            drawerMotor.setPower(0);
        //if(!gamepad1.dpad_down && !gamepad1.dpad_up)
        //telemetry.addData("in toggleDrawerSlides", drawerMotor.getPower());
        telemetry.update();
    }*/

    /*public void toggleRatchetServo()
    {
        if(gamepad2.right_bumper)
            ratchetServo.setPosition(1);
        else if(gamepad2.left_bumper)
            ratchetServo.setPosition(0);
    }*/
    //  drawerMotor.setPower(0);
}
