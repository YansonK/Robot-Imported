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

        public static final int DRIVE_VICTOR_R = 3; // right back motor controller Victor //RB Port 2 Victor
        public static final int DRIVE_TALON_R = 1; // right front motor controller Talon
        public static final int DRIVE_VICTOR_L = 2; // left back motor controller Victor //LB Port 3 victor
        public static final int DRIVE_TALON_L = 0; // left front motor controller Talon

        // public static final int DRIVE_VICTOR_R = 12; // Attatched to motor 4
        // public static final int DRIVE_TALON_R = 13; // Attatched to motor 2
        // public static final int DRIVE_VICTOR_L = 14; // Attatched to motor 3
        // public static final int DRIVE_TALON_L = 15; // Attatched to motor 1
        // IF YOU CHANGE THESE PORTS ALSO CHANGE THEIR ID IN PHOENIX TUNER

        public static final double RADIUSOFWHEEL = 0.075; // meters

    }

    public static class CONTROLLER {
        public static final Joystick JOYSTICK = new Joystick(0);//
        public static final int INVERT_Y = -1;// flip the Yaxis(Joystick is inherintly backward for some reason)

    }

    public static class DIO {
        public static final int DRIVE_ENCODER_LEFT_A = 0;// yellow
        public static final int DRIVE_ENCODER_LEFT_B = 1;// blue

        public static final int DRIVE_ENCODER_RIGHT_A = 2;// yellow
        public static final int DRIVE_ENCODER_RIGHT_B = 3;// blue

    }

}
