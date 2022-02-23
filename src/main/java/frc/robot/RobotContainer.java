// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.IndexerCommand;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.commands.DriveTrainCommand;

import frc.robot.Constants.CONTROLLER;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();

  // private final IndexerCommand indexerCommand = new
  // IndexerCommand(indexerSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton indexerButton = new JoystickButton(CONTROLLER.JOYSTICK, 1);
    indexerButton.whileActiveContinuous(IndexerCommand.teleIndex(indexerSubsystem), true);

    JoystickButton driveButton = new JoystickButton(CONTROLLER.JOYSTICK, 2);
    driveButton.whileActiveContinuous(DriveTrainCommand.teleDrive(0.2), true);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return (new SequentialCommandGroup(IndexerCommand.teleIndex(indexerSubsystem), new WaitCommand(1),
        IndexerCommand.teleIndex(indexerSubsystem)));

  }
}
