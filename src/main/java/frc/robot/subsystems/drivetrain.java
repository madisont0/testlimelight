// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.math.geometry.Pose3d;
//import edu.wpi.first.math.geometry.Rotation3d;
//import edu.wpi.first.math.geometry.Transform3d;
//import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableInstance;
//import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.Constants.PortConstants;

public class drivetrain extends SubsystemBase {
  private final CANSparkMax frontleft = new CANSparkMax(PortConstants.flport, MotorType.kBrushless);
  private final CANSparkMax backleft = new CANSparkMax(PortConstants.blport, MotorType.kBrushless);
  private final CANSparkMax frontright = new CANSparkMax(PortConstants.frport, MotorType.kBrushless);
  private final CANSparkMax backright = new CANSparkMax(PortConstants.brport, MotorType.kBrushless);

  public drivetrain() {
    frontleft.setInverted(false);
    backleft.setInverted(false);
    frontright.setInverted(true);
    backright.setInverted(true); 
  }

  public void drive(double xspeed, double yspeed, double rspeed){ //from gobilda mecanum wheels guide
    frontleft.set(xspeed + yspeed + rspeed);
    backleft.set(-xspeed + yspeed + rspeed);
    frontright.set(-xspeed + yspeed - rspeed);
    backright.set(xspeed + yspeed - rspeed);
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
