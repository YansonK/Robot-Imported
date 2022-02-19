package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveTrainCommand extends CommandBase {
    private final DriveTrainSubsystem m_subsystem;
    private double m_power;

    public static Command teleDrive(DriveTrainSubsystem subsystem, double power) {
        return new DriveTrainCommand(subsystem, power).withTimeout(.2);
    }

    public DriveTrainCommand(DriveTrainSubsystem subsystem, double power) {
        m_subsystem = subsystem;
        m_power = power;
        addRequirements(m_subsystem);
    }

    @Override
    public void initialize() {
        DriveTrainSubsystem.driveStraight(m_power);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        DriveTrainSubsystem.driveStraight(0);

    }

    public boolean isFinished() {
        return false;
    }

}
