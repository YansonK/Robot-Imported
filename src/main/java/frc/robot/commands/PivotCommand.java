package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants;
import frc.robot.Constants.CAN;

public class PivotCommand extends CommandBase {
    public final DriveTrainSubsystem m_subsystem = new DriveTrainSubsystem();
    public double m_degrees;
    public double m_targetDist;
    double speed;

    public PivotCommand(double degrees) {
        m_degrees = degrees;
        addRequirements(m_subsystem);

        m_targetDist = Constants.DIST_PER_DEGREE * degrees;
        
        speed = 0.5;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if(m_degrees > 0){
            DriveTrainSubsystem.tankDrive(speed,-speed);
        }
        else if(m_degrees < 0){
            DriveTrainSubsystem.tankDrive(-speed,speed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        DriveTrainSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        if(Math.abs(DriveTrainSubsystem.leftEncoder.getDistance()) >= m_targetDist && Math.abs(DriveTrainSubsystem.rightEncoder.getDistance()) <= m_targetDist)
            return true;
        return false;
    }

}
