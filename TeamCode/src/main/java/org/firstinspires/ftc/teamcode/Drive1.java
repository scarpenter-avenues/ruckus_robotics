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
        double r;


    public Drive1() {
    }

    public void runOpMode() {

        motorLD = hardwareMap.get(DcMotor.class, "motorLD");
        motorLD.setDirection(Direction.REVERSE);
        motorRD = hardwareMap.get(DcMotor.class, "motorRD");
        motorRD.setDirection(Direction.REVERSE);
        motorLU = hardwareMap.get(DcMotor.class, "motorLU");
        motorRU = hardwareMap.get(DcMotor.class, "motorRU");

        telemetry.addData(">", "Press Start to run Motors.");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {
            r = Math.hypot(-gamepad1.left_stick_y, gamepad1.left_stick_x);
            double robotAngle = Math.atan2(gamepad1.left_stick_x, -gamepad1.left_stick_y) - Math.PI/4;
            double rightX = gamepad1.right_stick_x;
            final double v4 = r * Math.cos(robotAngle) - rightX;
            final double v3 = r * Math.sin(robotAngle) - rightX;
            final double v2 = r * Math.sin(robotAngle) + rightX;
            final double v1 = r * Math.cos(robotAngle) + rightX;

            motorRD.setPower(Range.clip(-v4, -1.0D, 1.0D));
            motorLD.setPower(Range.clip(-v3, -1.0D, 1.0D));
            motorRU.setPower(Range.clip(-v2, -1.0D, 1.0D));
            motorLU.setPower(Range.clip(-v1, -1.0D, 1.0D));
            telemetry.update();
        }

        telemetry.addData(">", "Done");
        telemetry.update();
    }
}
