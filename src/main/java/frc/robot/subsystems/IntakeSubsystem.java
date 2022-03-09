package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;
import jdk.jfr.Percentage;

import java.util.function.DoubleSupplier;

public class IntakeSubsystem extends SubsystemBase{

    private final CANSparkMax motor = new CANSparkMax(Constants.CAN.INTAKE_SPARK, MotorType.kBrushless);

    public IntakeSubsystem() {
        motor.setInverted(true);

    }

    public void run(double percent) {
        //motor.set(ControlMode.MotionMagic, targetDistance, DemandType.AuxPID, desiredRobotHeading);
        motor.set(percent);
    }

    public void stop(){
        motor.set(0);
    }

    public void reverse(double percent) {
        motor.set(-percent);
    }
}

