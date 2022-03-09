package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveStraightCommand extends CommandBase {
    public final DriveTrainSubsystem m_subsystem = new DriveTrainSubsystem();
<<<<<<< HEAD
    public double m_power;

    public static Command teleDrive(double power, double time) {
        return new DriveStraightCommand(power).withTimeout(time);
    }

    public DriveStraightCommand(double power) {
        m_power = power;
        addRequirements(m_subsystem);

        
=======
    public double m_speed;

    public DriveStraightCommand(double speed) {
        m_speed = speed;
        addRequirements(m_subsystem);
>>>>>>> d042acb68b4a5a37ae007f1831bc8948a5bf2f07
    }

    @Override
    public void initialize() {
<<<<<<< HEAD
        DriveTrainSubsystem.tankDrive(m_power,m_power);
=======
        // DriveTrainSubsystem.distanceTankDrive(m_distance, m_distance);
        // DriveTrainSubsystem.pidPosition.setTolerance(.05);
>>>>>>> d042acb68b4a5a37ae007f1831bc8948a5bf2f07
    }

    @Override
    public void execute() {
<<<<<<< HEAD

=======
        DriveTrainSubsystem.tankDrive(m_speed, m_speed);
>>>>>>> d042acb68b4a5a37ae007f1831bc8948a5bf2f07
    }

    @Override
    public void end(boolean interrupted) {
<<<<<<< HEAD
        DriveTrainSubsystem.stop();

=======

        // DriveTrainSubsystem.stop();
        DriveTrainSubsystem.leftEncoder.reset();
        DriveTrainSubsystem.rightEncoder.reset();
>>>>>>> d042acb68b4a5a37ae007f1831bc8948a5bf2f07
    }

    @Override
    public boolean isFinished() {
<<<<<<< HEAD
=======
        DriveTrainSubsystem.pidPosition.atSetpoint();
>>>>>>> d042acb68b4a5a37ae007f1831bc8948a5bf2f07
        return false;
    }

}
