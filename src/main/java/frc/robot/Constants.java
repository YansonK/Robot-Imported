// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static class CAN {
        public static final int SHOOTER = 15;// 15; // Left Shooter port

        public static final int INDEXER = 10; // Port for indexer motor

        public static final int DRIVE_RB = 0; // right back motor controller
        public static final int DRIVE_RF = 1; // right front motor controller
        public static final int DRIVE_LB = 2; // left back motor controller
        public static final int DRIVE_LF = 3; // left front motor controller

    }

    public static class CONTROLLER {
        public static final Joystick JOYSTICK = new Joystick(0);
    }

    public static class DIO {
        public static final int DRIVE_ENCODER_LEFT_A = 0;// yellow
        public static final int DRIVE_ENCODER_LEFT_B = 1;// blue

        public static final int DRIVE_ENCODER_RIGHT_A = 2;// yellow
        public static final int DRIVE_ENCODER_RIGHT_B = 3;// blue

    }

}
