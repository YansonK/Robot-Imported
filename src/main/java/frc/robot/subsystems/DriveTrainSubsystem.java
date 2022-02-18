package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import jdk.jfr.Percentage;

import static frc.robot.Constants.*;

public class DriveTrainSubsystem {

    private final WPI_TalonSRX leftFront = new WPI_TalonSRX(CAN.DRIVE_LF);
    private final WPI_TalonSRX rightFront = new WPI_TalonSRX(CAN.DRIVE_RF);
    private final WPI_TalonSRX leftBack = new WPI_TalonSRX(CAN.DRIVE_LB);
    private final WPI_TalonSRX rightBack = new WPI_TalonSRX(CAN.DRIVE_RB);

    private final Encoder leftEncoder = new Encoder(DIO.DRIVE_ENCODER_LEFT_A, DIO.DRIVE_ENCODER_LEFT_B);
    private final Encoder rightEncoder = new Encoder(DIO.DRIVE_ENCODER_RIGHT_A, DIO.DRIVE_ENCODER_RIGHT_B);

    public static void driveStraight(Percentage power) {
        // WPI_TalonSRX leftFront.set(ControlMode.PercentOutput, power);

    }

}
