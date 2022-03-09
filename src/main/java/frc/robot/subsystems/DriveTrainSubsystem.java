package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.Constants;
import frc.robot.Robot;
import jdk.jfr.Percentage;

import static frc.robot.Constants.*;

import javax.xml.transform.ErrorListener;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTrainSubsystem extends SubsystemBase {

    private static final double kF = 1 / 2.1; // Percentage output per m/s
    // motor controllers
    public static final WPI_TalonSRX leftTalon = new WPI_TalonSRX(CAN.DRIVE_TALON_L);
    private static final WPI_TalonSRX rightTalon = new WPI_TalonSRX(CAN.DRIVE_TALON_R);


    private static final VictorSPX leftVictor = new VictorSPX(CAN.DRIVE_VICTOR_L);
    private static final VictorSPX rightVictor = new VictorSPX(CAN.DRIVE_VICTOR_R);


    public final static Encoder leftEncoder = new Encoder(DIO.DRIVE_ENCODER_LEFT_A, DIO.DRIVE_ENCODER_LEFT_B);
    public final static Encoder rightEncoder = new Encoder(DIO.DRIVE_ENCODER_RIGHT_A, DIO.DRIVE_ENCODER_RIGHT_B);

    private static boolean slow = false;

    public static PIDController leftPID = new PIDController(0.95, 0, 0);
    public static PIDController rightPID = new PIDController(0.95, 0, 0);

    public static DifferentialDrive robotDrive = new DifferentialDrive(leftTalon, rightTalon);


    // private static final WPI_TalonSRX rightFront = new
    // WPI_TalonSRX(CAN.DRIVE_RF);
    // private static final WPI_TalonSRX leftFront = new WPI_TalonSRX(CAN.DRIVE_LF);

    // grouping the motor controllers
    // private static MotorControllerGroup leftControllers = new
    // MotorControllerGroup(leftFront, leftBack);
    // private static MotorControllerGroup rightControllers = new
    // MotorControllerGroup(rightFront, rightBack);

    //
    // private static DifferentialDrive m_drive = new DifferentialDrive(leftTalon,
    // rightTalon);

    // encoders

    // public class Robot {
    // MotorController m_frontLeft = new PWMVictorSPX(1);
    // MotorController m_rearLeft = new PWMVictorSPX(2);
    // MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft,
    // m_rearLeft);

    // MotorController m_frontRight = new PWMVictorSPX(3);
    // MotorController m_rearRight = new PWMVictorSPX(4);
    // MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight,
    // m_rearRight);

    // DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
    // }

    public DriveTrainSubsystem() {
        leftVictor.follow((IMotorController) leftTalon);
        rightVictor.follow((IMotorController) rightTalon);
        rightVictor.setInverted(true);
        // rightVictor.setInverted(true);
        rightTalon.setInverted(true);//inverts motor so it can drive straight
    }

    public void periodic() {

    }

    public static void tankDrive(double leftTarget, double rightTarget) {
        // WPI_TalonSRX leftFront.set(ControlMode.PercentOutput, power);

        // setpointPos = setPtDistance;

        // leftTalon.set(Lspeed);
        // rightTalon.set(Rspeed);

        leftTarget = MathUtil.clamp(leftTarget, -MAX_SPEED, MAX_SPEED);
        rightTarget = MathUtil.clamp(rightTarget, -MAX_SPEED, MAX_SPEED);

        final double ffLeft = kF * leftTarget;
        final double ffRight = kF * rightTarget;

        final double adjustedLeft = leftPID.calculate(-leftEncoder.getRate(), leftTarget) + ffLeft;
        final double adjustedRight = rightPID.calculate(rightEncoder.getRate(), rightTarget) + ffRight;

        robotDrive.tankDrive(adjustedLeft, adjustedRight);

        System.out.println("Left:" + leftEncoder.getDistance());
        System.out.println("Right:" + rightEncoder.getDistance());
        System.out.println("--------");
    }

    public static void stop() {
        // WPI_TalonSRX leftFront.set(ControlMode.PercentOutput, power);

        // m_drive.stopMotor();
        leftTalon.set(ControlMode.Velocity, 0);
        rightTalon.set(ControlMode.Velocity, 0);
        // leftVictor.set(ControlMode.PercentOutput, 0);
        // rightVictor.set(ControlMode.PercentOutput, 0);

    }

    // public static void PID() {
    // while (true) {
    // double error = setpoint;
    // integral += previous_integral + error * .02;
    // double derivative = (error - previous_error) / 0.02;
    // output = kP * error + kI * integral + kD * derivative;

    // previous_error = error;
    // previous_integral = integral;
    // }
    // }

    public static void arcadeDrive() {
        double yAxis = CONTROLLER.JOYSTICK.getY() * Constants.CONTROLLER.INVERT_Y;
        double rotAxis = CONTROLLER.JOYSTICK.getTwist() * Constants.CONTROLLER.INVERT_ROT;

        double ySensitivity = slow ? 0.75 : 1.0;
        double rotSensitivity = slow ? 0.2 : 0.6;

        double speed = yAxis * ySensitivity;

        double rotation = rotAxis * rotSensitivity;

        if (rotation > -0.13 && rotation < 0.0 && yAxis>0) {
            rotation = 0;
        }

        double left, right;

        //if (speed >= 0.0) {
            left = speed + rotation;
            right = speed - rotation;

        // } //else {
        //     left = speed - rotation;
        //     right = speed + rotation;
        // }

        System.out.println("L" + left);
        System.out.println("R" + right);
        System.out.println("Rot:" + rotation);
        System.out.println("-------------");

        robotDrive.tankDrive(left,right);
    }

    // public void MotorSafetyHelper() {
    // ((WPI_TalonSRX) leftFront).setSafetyEnabled(false);
    // leftBack.setSafetyEnabled(false);
    // rightBack.setSafetyEnabled(false);
    // rightFront.setSafetyEnabled(false);
    // }

}
