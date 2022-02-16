package frc.robot.subsystems;

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Util;
import jdk.jfr.Percentage;

import java.util.function.DoubleSupplier;

public class IndexerSubsystem extends SubsystemBase{

    private final VictorSPX motor = new VictorSPX (Constants.CAN.INDEXER);

    public IndexerSubsystem() {

    }

    public void run() {

    }

    public void reverse() {

    }
}
