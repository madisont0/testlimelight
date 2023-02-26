// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

 
package frc.robot.commands;

import frc.robot.subsystems.limelight3;
import frc.robot.subsystems.drivetrain;
//import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;

//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.math.MathUtil;
//import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Constants;

public class movetotag extends CommandBase {
  private final limelight3 camera;
  private final drivetrain Drivetrain;

  private final PIDController xcontroller = new PIDController(Constants.kPx, Constants.kIx, Constants.kDx);
  private final PIDController ycontroller = new PIDController(Constants.kPy, Constants.kIy, Constants.kDy);
  private final PIDController rcontroller = new PIDController(Constants.kPr, Constants.kIr, Constants.kDr);

  private final double goalxdist;
  private final double goalydist;
  private final double goalr;
  double yangledif;
  double xangle;

  public movetotag(limelight3 camera, drivetrain Drivetrain, double goalxdist, double goalydist, double goalr) {
    this.camera = camera;
    this.Drivetrain = Drivetrain;
    this.goalxdist = goalxdist;
    this.goalydist = goalydist;
    this.goalr = goalr;

    addRequirements(camera);
    addRequirements(Drivetrain);
  }

  @Override
  public void initialize() {
    xcontroller.setTolerance(Constants.xtolerance);
    ycontroller.setTolerance(Constants.ytolerance);
    rcontroller.setTolerance(Constants.rtolerance);
  }

  @Override
  public void execute() {    
    //y, forward/backward distance from tagpose_cameraspace, meters
    double currentydistance = camera.getZ(); //? getY?

    //x, left/right distance from tagpose_cameraspace, meters
    double currentxdistance = camera.getX();

    //r, rotation of tag around z-axis (up/down) from tagpose_cameraspace, in degrees
    double currentr = camera.getPitch();
    

    double xspeed = -1 * MathUtil.clamp((xcontroller.calculate(currentxdistance, goalxdist)), -Constants.xclamp, Constants.xclamp);
    double yspeed = -1 * MathUtil.clamp((ycontroller.calculate(currentydistance, goalydist)), -Constants.yclamp, Constants.yclamp);
    double rspeed = -0.5 * MathUtil.clamp((rcontroller.calculate(currentr, goalr)), -Constants.rclamp, Constants.rclamp); //only works with clockwise rotation for some reason
      //^ mecanum drive, +/- xspeed, rspeed might be issue

    //System.out.println(xspeed); //xspeed negative when counterclockwise
    //System.out.println(rspeed); //rotation negative when counterclockwise

    //stopping individually since command only ends with all 3
    if (xcontroller.atSetpoint()){
      xspeed = 0;
    }
    if (ycontroller.atSetpoint()){
      yspeed = 0;
    }
    if (ycontroller.atSetpoint()){
      rspeed = 0;
    }

    //stopping abrupt movement at end
    if (xspeed < 0.02){
      xspeed = 0;
    }
    if (yspeed < 0.02){
      yspeed = 0;
    }
    if (rspeed < 0.02){
      rspeed = 0;
    }

    Drivetrain.drive(xspeed, yspeed, rspeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return (xcontroller.atSetpoint() && ycontroller.atSetpoint() && rcontroller.atSetpoint()); //was accidentally running without stopping rcontroller in church 2/26
  }
}
