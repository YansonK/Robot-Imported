package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveStraightCommand extends CommandBase {
    public final DriveTrainSubsystem m_subsystem = new DriveTrainSubsystem();
    public double m_speed;

    public DriveStraightCommand(double speed) {
        m_speed = speed;
        addRequirements(m_subsystem);
    }

    @Override
    public void initialize() {
        // DriveTrainSubsystem.distanceTankDrive(m_distance, m_distance);
        // DriveTrainSubsystem.pidPosition.setTolerance(.05);
    }

    @Override
    public void execute() {
        DriveTrainSubsystem.tankDrive(m_speed, m_speed);
    }

    @Override
    public void end(boolean interrupted) {

        // DriveTrainSubsystem.stop();
        DriveTrainSubsystem.leftEncoder.reset();
        DriveTrainSubsystem.rightEncoder.reset();
    }

    @Override
    public boolean isFinished() {
        DriveTrainSubsystem.pidPosition.atSetpoint();
        return false;
    }

}
