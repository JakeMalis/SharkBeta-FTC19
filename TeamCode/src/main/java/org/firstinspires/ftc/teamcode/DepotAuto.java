package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Depot Auto", group="Java OpMode")
public class DepotAuto extends LinearOpMode {
    public DcMotor leftMotor1;
    public DcMotor rightMotor1;
    public DcMotor leftMotor2;
    public DcMotor rightMotor2;
    public DcMotor pivotMotor;
    public DcMotor leftIntakeMotor;
    public DcMotor rightIntakeMotor;

    @Override
    public void runOpMode(){
        leftMotor1 = hardwareMap.get(DcMotor.class, "leftMotor1");
        leftMotor2 = hardwareMap.get(DcMotor.class, "leftMotor2");
        rightMotor1 = hardwareMap.get(DcMotor.class, "rightMotor1");
        rightMotor2 = hardwareMap.get(DcMotor.class, "rightMotor2");
        pivotMotor = hardwareMap.get(DcMotor.class, "pivotMotor");
        leftIntakeMotor = hardwareMap.get(DcMotor.class, "leftIntakeMotor");
        rightIntakeMotor = hardwareMap.get(DcMotor.class, "rightIntakeMotor");

        leftMotor1.setDirection(DcMotor.Direction.REVERSE);
        leftMotor2.setDirection(DcMotor.Direction.REVERSE);
        rightMotor1.setDirection(DcMotor.Direction.FORWARD);
        rightMotor2.setDirection(DcMotor.Direction.FORWARD);
        pivotMotor.setDirection(DcMotor.Direction.REVERSE);
        leftIntakeMotor.setDirection(DcMotor.Direction.FORWARD);
        rightIntakeMotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        while (opModeIsActive()){
            leftMotor1.setPower(1);
            leftMotor2.setPower(1);
            rightMotor1.setPower(1);
            rightMotor2.setPower(1);
            sleep(800);

            leftMotor1.setPower(0);
            leftMotor2.setPower(0);
            rightMotor1.setPower(0);
            rightMotor2.setPower(0);

            leftIntakeMotor.setPower(0.25);
            rightIntakeMotor.setPower(0.25);
            sleep(1000);
            leftIntakeMotor.setPower(0);
            rightIntakeMotor.setPower(0);


            /*leftMotor1.setPower(1);
            leftMotor2.setPower(1);
            rightMotor1.setPower(-1);
            rightMotor2.setPower(-1);
            sleep(750);

            leftMotor1.setPower(1);
            leftMotor2.setPower(1);
            rightMotor1.setPower(1);
            rightMotor2.setPower(1);
            sleep(1000);
            */

            break;

        }
    }
}
