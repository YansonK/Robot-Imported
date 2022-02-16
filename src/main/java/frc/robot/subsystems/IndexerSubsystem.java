package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import jdk.jfr.Percentage;

import java.util.function.DoubleSupplier;

public class IndexerSubsystem extends SubsystemBase{

    private final VictorSPX motor = new VictorSPX (Constants.CAN.INDEXER);

    public IndexerSubsystem() {

    }

    public void run(VictorSPXControlMode pControlMode, double percent) {
        //motor.set(ControlMode.MotionMagic, targetDistance, DemandType.AuxPID, desiredRobotHeading);
        motor.set(pControlMode, percent);
    }

    public void reverse() {

    }
}
