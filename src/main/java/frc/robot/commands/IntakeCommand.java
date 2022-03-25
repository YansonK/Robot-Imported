package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeCommand extends CommandBase{
    private final IntakeSubsystem m_subsystem;
    private final double m_power;

    public static Command teleIntake(IntakeSubsystem subsystem, double power) {
        return new IntakeCommand(subsystem, power).withTimeout(.2);
    }

    public static Command autoIntake(IntakeSubsystem subsystem, double power, double time){
        return new IntakeCommand(subsystem, power).withTimeout(time);
    }

    public IntakeCommand(IntakeSubsystem subsystem, double power) {
        m_subsystem = subsystem;
        m_power = power;

        addRequirements(m_subsystem);
    }

    @Override
    public void initialize() {
        m_subsystem.run(m_power);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        m_subsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
