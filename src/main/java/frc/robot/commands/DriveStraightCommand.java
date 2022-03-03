package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveStraightCommand extends CommandBase {
    public final DriveTrainSubsystem m_subsystem = new DriveTrainSubsystem();
    public double m_distance;

    public DriveStraightCommand(double distance) {
        m_distance = distance;
        addRequirements(m_subsystem);
    }

    @Override
    public void initialize() {
        // DriveTrainSubsystem.distanceTankDrive(m_distance, m_distance);
    }

    @Override
    public void execute() {
        DriveTrainSubsystem.distanceTankDrive(m_distance, m_distance);
    }

    @Override
    public void end(boolean interrupted) {
        DriveTrainSubsystem.stop();

    }

    @Override
    public boolean isFinished() {
        if(DriveTrainSubsystem.leftEncoder.getDistance() == m_distance )
            return true;
        return false;
    }

}
