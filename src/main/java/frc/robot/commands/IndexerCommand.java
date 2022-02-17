package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IndexerCommand extends CommandBase{
    private final IndexerSubsystem m_subsystem;

    public IndexerCommand(IndexerSubsystem subsystem){
        m_subsystem = subsystem;
        
        addRequirements(m_subsystem);
    }

    @Override
    public void initialize()
    {
        m_subsystem.run(VictorSPXControlMode.PercentOutput, 0.5);
    }

    @Override
    public void execute(){}

    @Override
    public void end(boolean interrupted)
    {
        m_subsystem.run(VictorSPXControlMode.PercentOutput, 0);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
    
}
