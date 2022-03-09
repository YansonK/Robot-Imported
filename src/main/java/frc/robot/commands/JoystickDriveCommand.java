package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class JoystickDriveCommand extends CommandBase {

    public final DriveTrainSubsystem m_subsystem;

    public JoystickDriveCommand(DriveTrainSubsystem subsystem) {

        m_subsystem = subsystem;
        addRequirements(m_subsystem);
    }

    @Override
    public void execute() {

        DriveTrainSubsystem.arcadeDrive();// use joystick to drive around
    }

    public void stop() {
    }

}
