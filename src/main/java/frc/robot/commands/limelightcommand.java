// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.limelight3;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.wpilibj2.command.CommandBase;

//import edu.wpi.first.networktables.NetworkTableInstance;
//import edu.wpi.first.networktables.NetworkTableEntry;


//just for testing

public class limelightcommand extends CommandBase {
  private final limelight3 camera;
  public limelightcommand(limelight3 camera) {
    this.camera = camera;
    addRequirements(camera);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() { //testing, printing values

    int targetId = camera.getId();
    //System.out.println("id " + targetId);
    //System.out.println("x " + camera.getX());
    //System.out.println("y " + camera.getY());


    double xangle = camera.getX() * Math.PI / 180; //in radians
    double yangle = camera.getY() * Math.PI / 180; // in radians

    double [] ntvalues = camera.getCamtoTarget();
    for(int i=3;i<6;i++){

      System.out.println(ntvalues[i]);
    }
      //[1], y value is negative for up and positive for down
    
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
