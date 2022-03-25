package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import jdk.jfr.Percentage;

import java.util.function.DoubleSupplier;

public class IndexerSubsystem extends SubsystemBase{

    // private final VictorSPX motorFollow = new VictorSPX (Constants.CAN.INDEXER_VICTOR);
    private final TalonSRX motorLead = new TalonSRX (Constants.CAN.INDEXER_TALON);
    private static DoubleSupplier m_powerSupplier;

    public IndexerSubsystem() {
        // motorFollow.follow((IMotorController) motorLead);

    }

    public void run() {
        //motor.set(ControlMode.MotionMagic, targetDistance, DemandType.AuxPID, desiredRobotHeading);
        double percent = m_powerSupplier.getAsDouble()*10;
        motorLead.set(ControlMode.PercentOutput, 1);
    }

    public static void setPowerSupplier(DoubleSupplier powerSupplier) {
        m_powerSupplier = powerSupplier;
    }

    public void stop(){ 
        motorLead.set(TalonSRXControlMode.PercentOutput, 0);
    }

    public void reverse() {

    }
}
