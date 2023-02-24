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
    //limelight is 8?, not using
  }

  //drivejoystick
  public static double kX = 0.2;
  public static double kY = 0.2;
  public static double kR = 0.2;
  public static int xaxis = 5; //change
  public static int yaxis = 6; //change
  public static int raxis = 7; //change

  //movetotag
  //PID constants
  public static double kPx = 0.3; //measurement in feet
  public static double kPy = 0.3; //measurement in feet
  public static double kPr = 0.05; //measurement in degrees
  public static double kDx = 0;
  public static double kDy = 0;
  public static double kDr = 0;
  public static double kIx = 0;
  public static double kIy = 0;
  public static double kIr = 0;

  public static double xclamp = 0.5;
  public static double yclamp = 0.5;
  public static double rclamp = 0.5;

  /* 
  public static double goalydist = 3; //feet for now
  public static double goalxdist = 0; //feet
  public static double goalr = 180; //degrees
  */

  public static double tagheight = 5; //feet

  public static double xtolerance = 3; //degrees
  public static double ytolerance = 0.1; //feet, distance
  public static double rtolerance = 3; //degrees

  public static double mountingangle = 0; //degrees?, limelight crosshair
  public static double cameraheight = 0; //degrees
  
}
