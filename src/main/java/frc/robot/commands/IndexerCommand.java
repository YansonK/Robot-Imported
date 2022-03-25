package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IndexerCommand extends CommandBase {
    private final IndexerSubsystem m_subsystem;

    public static Command teleIndex(IndexerSubsystem subsystem, double time) {
        return new IndexerCommand(subsystem).withTimeout(time);
    }

    public IndexerCommand(IndexerSubsystem subsystem) {
        m_subsystem = subsystem;

        addRequirements(m_subsystem);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        m_subsystem.run();
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
