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

    public static final double WHEEL_RADIUS = 0.075; // Meters
    //used for autonomus turning
    //(Revolution here refers to the robot pivotings 360 degrees)
    public static final double FULL_REVO_DIST = 1.915; // Meters
    public static final double DIST_PER_DEGREE = FULL_REVO_DIST/360;//Meters
    public static final double PULSES_PER_REVO = 365.76; // Pulses
    public static final double PULSES_PER_HALF_REVO = PULSES_PER_REVO/2;

    public static final double MAX_SPEED = 5.0; // meters per second

    public static class CAN {
        //Drive train motors
        public static final int DRIVE_VICTOR_R = 12; // Attatched to motor 4
        public static final int DRIVE_TALON_R = 13; // Attatched to motor 2
        public static final int DRIVE_VICTOR_L = 14; // Attatched to motor 3
        public static final int DRIVE_TALON_L = 15; // Attatched to motor 1

        //Intake motor
        public static final int INTAKE_SPARK = 4;

        //Indexer motors
        public static final int INDEXER_TALON = 1;
        public static final int INDEXER_VICTOR = 0;

        //IF YOU CHANGE THESE PORTS ALSO CHANGE THEIR ID IN THEIR RESPECTIVE SOFTWARE MANAGERS
        //TALONS/VICTORS USE PHOENIX TUNER
        //SPARKS USE REV Hardware Client
    }

    public static class CONTROLLER {
        public static final Joystick JOYSTICK = new Joystick(0);//
        public static final int INVERT_Y = 1;// flip the Yaxis(Joystick is inherintly backward for some reason)
        public static final int INVERT_ROT = 1;


    }

    public static class DIO {
        public static final int DRIVE_ENCODER_LEFT_A = 0;// yellow
        public static final int DRIVE_ENCODER_LEFT_B = 1;// green

        public static final int DRIVE_ENCODER_RIGHT_A = 2;// yellow
        public static final int DRIVE_ENCODER_RIGHT_B = 3;// green

    }

}
