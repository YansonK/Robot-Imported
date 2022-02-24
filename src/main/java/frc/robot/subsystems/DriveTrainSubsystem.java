package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
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
import frc.robot.commands.DriveTrainCommand;

import frc.robot.Constants;
import jdk.jfr.Percentage;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTrainSubsystem extends SubsystemBase {

    // motor controllers
    private static final MotorController leftTalon = new WPI_TalonSRX(CAN.DRIVE_TALON_L);
    private static final MotorController rightTalon = new WPI_TalonSRX(CAN.DRIVE_TALON_R);

    private static final VictorSPX leftVictor = new VictorSPX(CAN.DRIVE_VICTOR_L);
    private static final VictorSPX rightVictor = new VictorSPX(CAN.DRIVE_VICTOR_R);

    private static boolean slow = false;

    // private static final WPI_TalonSRX rightFront = new
    // WPI_TalonSRX(CAN.DRIVE_RF);
    // private static final WPI_TalonSRX leftFront = new WPI_TalonSRX(CAN.DRIVE_LF);

    // grouping the motor controllers
    // private static MotorControllerGroup leftControllers = new
    // MotorControllerGroup(leftFront, leftBack);
    // private static MotorControllerGroup rightControllers = new
    // MotorControllerGroup(rightFront, rightBack);

    //
    // private static DifferentialDrive m_drive = new
    // DifferentialDrive(leftControllers, rightControllers);

    // encoders
    // private final Encoder leftEncoder = new Encoder(DIO.DRIVE_ENCODER_LEFT_A,
    // DIO.DRIVE_ENCODER_LEFT_B);
    // private final Encoder rightEncoder = new Encoder(DIO.DRIVE_ENCODER_RIGHT_A,
    // DIO.DRIVE_ENCODER_RIGHT_B);

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
        // leftVictor.follow((IMotorController) leftTalon);
        // rightVictor.follow((IMotorController) rightTalon);
        // leftFront.setInverted(true);
        // rightVictor.setInverted(true);
        // leftVictor.setInverted(true);
    }

    public void periodic() {

    }

    public static void driveStraight(double speed) {
        // WPI_TalonSRX leftFront.set(ControlMode.PercentOutput, power);

        // m_drive.tankDrive(power, power);

        leftTalon.set(speed);
        rightTalon.set(speed);
        // leftVictor.set(ControlMode.PercentOutput, speed);
        // rightVictor.set(ControlMode.PercentOutput, speed + 0.01);
    }

    public static void stop() {
        // WPI_TalonSRX leftFront.set(ControlMode.PercentOutput, power);

        // m_drive.stopMotor();
        leftTalon.set(0);
        rightTalon.set(0);
        // leftVictor.set(ControlMode.PercentOutput, 0);
        // rightVictor.set(ControlMode.PercentOutput, 0);

    }

    public static void arcadeDrive() {
        double yAxis = CONTROLLER.JOYSTICK.getY();
        double rotAxis = CONTROLLER.JOYSTICK.getTwist();

        double ySensitivity = slow ? 0.75 : 1.0;
        double rotSensitivity = slow ? 0.2 : 0.4;

        double speed = yAxis * ySensitivity;

        double rotation = rotAxis * rotSensitivity;

        double left, right;

        if (speed >= 0.0) {
            left = speed + rotation;
            right = speed - rotation;

        } else {
            left = speed - rotation;
            right = speed + rotation;
        }
    }

    // public void MotorSafetyHelper() {
    // ((WPI_TalonSRX) leftFront).setSafetyEnabled(false);
    // leftBack.setSafetyEnabled(false);
    // rightBack.setSafetyEnabled(false);
    // rightFront.setSafetyEnabled(false);
    // }

    public void initDefaultCommand() {
        setDefaultCommand(DriveTrainCommand.teleDrive(0.0));
    }

}
