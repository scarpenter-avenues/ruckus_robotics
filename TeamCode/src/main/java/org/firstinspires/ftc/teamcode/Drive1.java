package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction;
import com.qualcomm.robotcore.util.Range;

@TeleOp(
        name = "Drive1"
)
public class Drive1 extends LinearOpMode {
    DcMotor motorRD;
    DcMotor motorRU;
    DcMotor motorLD;
    DcMotor motorLU;
    double leftPower;
    double rightPower;
    double r;


    public Drive1() {
    }

    public void runOpMode() {
        motorLD = hardwareMap.get(DcMotor.class, "right_drive_D");
        motorRD = hardwareMap.get(DcMotor.class, "left_drive_D");
        motorRD.setDirection(Direction.REVERSE);
        motorLU = hardwareMap.get(DcMotor.class, "right_drive_U");
        motorRU = hardwareMap.get(DcMotor.class, "left_drive_U");
        motorRU.setDirection(Direction.REVERSE);

        telemetry.addData(">", "Press Start to run Motors.");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {
//            if ((double)gamepad1.left_stick_y < -0.01D) {
//                leftPower = -(1.0D - Math.sqrt((double)(1.0F - gamepad1.left_stick_y * gamepad1.left_stick_y)));
//            } else if ((double)gamepad1.left_stick_y > 0.01D) {
//                leftPower = 1.0D - Math.sqrt((double)(1.0F - gamepad1.left_stick_y * gamepad1.left_stick_y));
//            } else {
//                leftPower = 0.0D;
//            }
//
//            if ((double)gamepad1.right_stick_y < -0.01D) {
//                rightPower = -(1.0D - Math.sqrt((double)(1.0F - gamepad1.right_stick_y * gamepad1.right_stick_y)));
//            } else if ((double)gamepad1.right_stick_y > 0.01D) {
//                rightPower = 1.0D - Math.sqrt((double)(1.0F - gamepad1.right_stick_y * gamepad1.right_stick_y));
//            } else {
//                rightPower = 0.0D;
//            }

            r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI/4;
            double rightX = gamepad1.left_stick_x;
            final double v1 = r * Math.cos(robotAngle) + rightX;
            final double v2 = r * Math.sin(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) + rightX;
            final double v4 = r * Math.cos(robotAngle) - rightX;

            motorRD.setPower(Range.clip(-v4, -1.0D, 1.0D));
            motorLD.setPower(Range.clip(-v3, -1.0D, 1.0D));
            motorRU.setPower(Range.clip(-v2, -1.0D, 1.0D));
            motorLU.setPower(Range.clip(-v1, -1.0D, 1.0D));

//            servoLocker.setDirection(com.qualcomm.robotcore.hardware.Servo.Direction.REVERSE);
//            if (gamepad1.y) {
//                servoLocker.setPosition(0.2D);
//            }
//
//            if (gamepad1.x) {
//                servoLocker.setPosition(0.5D);
//            }

//            if (gamepad1.right_bumper) {
//                motorU.setPower(0.7D);
//            } else if (gamepad1.left_bumper) {
//                motorU.setPower(-0.7D);
//            } else if (gamepad1.dpad_up) {
//                motorU.setPower(-0.3D);
//            } else {
//                motorU.setPower(0.0D);
//            }

//            if (gamepad2.left_bumper) {
//                horizontalMotor.setPower(1.0D);
//            } else if (gamepad2.right_bumper) {
//                horizontalMotor.setPower(-1.0D);
//            } else {
//                horizontalMotor.setPower(0.0D);
//            }

//            if (gamepad2.dpad_up) {
//                verticalMotor.setPower(-0.7D);
//            } else if (gamepad2.dpad_down) {
//                verticalMotor.setPower(0.7D);
//            } else {
//                verticalMotor.setPower(0.0D);
//            }

//            if (gamepad2.a) {
//                servoCollection.setPosition(1.0D);
//            } else if (gamepad2.x) {
//                servoCollection.setPosition(0.0D);
//            } else if (gamepad2.b) {
//                servoCollection.setPosition(0.5D);
//            }

//            telemetry.addData("leftStick", gamepad1.left_stick_y);
//            telemetry.addData("rightStick", gamepad1.right_stick_y);
//            telemetry.addData("leftPower", motorLD.getPower());
//            telemetry.addData("rightPower", motorRD.getPower());
//            telemetry.addData("leftPower", motorLU.getPower());
//            telemetry.addData("rightPower", motorRU.getPower());
            telemetry.update();
        }

        telemetry.addData(">", "Done");
        telemetry.update();
    }
}
