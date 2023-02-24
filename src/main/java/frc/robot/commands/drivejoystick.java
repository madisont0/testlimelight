// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.drivetrain;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.wpilibj2.command.CommandBase;

//import edu.wpi.first.networktables.NetworkTableInstance;
//import edu.wpi.first.networktables.NetworkTableEntry;

public class drivejoystick extends CommandBase {
  private final drivetrain Drivetrain;
  private final XboxController joystick;

  public drivejoystick(drivetrain Drivetrain, XboxController joystick) {
    this.Drivetrain = Drivetrain;
    this.joystick = joystick;
    addRequirements(Drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() { 
    double xcoord = joystick.getRawAxis(Constants.xaxis);
    double ycoord = -joystick.getRawAxis(Constants.yaxis); //y joystick is reversed
    double rot = joystick.getRawAxis(Constants.raxis);

    Drivetrain.drive(xcoord * Constants.kX, ycoord * Constants.kY, rot * Constants.kR);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
