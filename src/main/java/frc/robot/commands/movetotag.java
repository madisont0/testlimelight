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
    //y movement PID: triangle with ty, height difference, and goal y distance
    double currentyangle = camera.getY() + Constants.mountingangle;
    double currentydistance = (Constants.tagheight - Constants.cameraheight)/Math.tan(currentyangle);

    //x movement PID: triangle with tx, current y distance, and goal x distance
    xangle = camera.getX();
    double currentxdistance = currentydistance * Math.tan(xangle);

    //r movement PID
    double currentr = camera.getYaw();

    double xspeed = MathUtil.clamp((xcontroller.calculate(currentxdistance, goalxdist)), -Constants.xclamp, Constants.xclamp);
    double yspeed = MathUtil.clamp((ycontroller.calculate(currentydistance, goalydist)), -Constants.yclamp, Constants.yclamp);
    double rspeed = MathUtil.clamp((rcontroller.calculate(currentr, goalr)), -Constants.rclamp, Constants.rclamp);
    
    Drivetrain.drive(xspeed, yspeed, rspeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
 
    return (xcontroller.atSetpoint() && ycontroller.atSetpoint() && rcontroller.atSetpoint());
  }
}
