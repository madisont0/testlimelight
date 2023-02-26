// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  public static class PortConstants {
    public static final int kDriverControllerPort = 0;
    public static final int flport = 10;
    public static final int frport = 5;
    public static final int blport = 6;
    public static final int brport = 7;
  }

  //drivejoystick
  public static double kX = 0.5;
  public static double kY = 0.5;
  public static double kR = 0.5;
  public static int xaxis = 0; //joystick
  public static int yaxis = 1; //joystick
  public static int raxis = 3; //slider

  //movetotag
  //PID constants
  public static double kPx = 0.5; //meters
  public static double kPy = 0.3; //meters
  public static double kPr = 0.05; //degrees
  public static double kDx = 0;
  public static double kDy = 0;
  public static double kDr = 0;
  public static double kIx = 0;
  public static double kIy = 0;
  public static double kIr = 0;

  public static double xclamp = 0.8; //slides sideways very slowly
  public static double yclamp = 0.4;
  public static double rclamp = 0.2;

  //public static double tagheight = 0.49; //19.3 inches to meters

  public static double xtolerance = 0; 
  public static double ytolerance = 0.3; 
  public static double rtolerance = 5; //degrees

  public static double mountingangle = 0; //for adjustable camera
  public static double cameraheight = 0.356; //14-ish inches, to meters
}
