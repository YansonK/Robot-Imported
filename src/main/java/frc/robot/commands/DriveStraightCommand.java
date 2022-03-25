package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;


public class DriveStraightCommand extends CommandBase {
    public final DriveTrainSubsystem m_subsystem = new DriveTrainSubsystem();
    public double m_power;

    public static Command teleDrive(double power, double time) {
        return new DriveStraightCommand(power).withTimeout(time);
    }

    public DriveStraightCommand(double power) {
        m_power = power;
        addRequirements(m_subsystem);

        
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        DriveTrainSubsystem.tankDrive(m_power,m_power);

    }

    @Override
    public void end(boolean interrupted) {
        DriveTrainSubsystem.stop();

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    public class teleDrive {
    }

}
