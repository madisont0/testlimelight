// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class MecanumDrive extends SubsystemBase {

  private final CANSparkMax frontLeft = new CANSparkMax(Constants.PortConstants.flport, MotorType.kBrushless);
  private final CANSparkMax backLeft = new CANSparkMax(Constants.PortConstants.blport, MotorType.kBrushless);
  private final CANSparkMax frontRight = new CANSparkMax(Constants.PortConstants.frport, MotorType.kBrushless);
  private final CANSparkMax backRight = new CANSparkMax(Constants.PortConstants.brport, MotorType.kBrushless);


  public MecanumDrive() {
    frontLeft.setInverted(false);
    backLeft.setInverted(false);
    frontRight.setInverted(true);
    backRight.setInverted(true);
  }

  public void drive(double xspeed,double yspeed, double power, double rot){

    double theta = 0;

    if (xspeed == 0){
        theta = Math.PI/2;
    } else {
        theta = Math.atan2(yspeed,xspeed);
    }
    

    double sin = Math.sin(theta - Math.PI/4);
    double cos = Math.cos(theta - Math.PI/4);

    double max = Math.max(Math.abs(sin), Math.abs(cos));

    double flPower = power * cos/max + rot;
    double frPower = power * sin/max - rot;
    double blPower = power * sin/max + rot;
    double brPower = power * cos/max - rot;

    frontLeft.set(flPower);
    frontRight.set(frPower);
    backLeft.set(blPower);
    backRight.set(brPower);

    if((power + Math.abs(rot) > 1)){
      flPower /= power + rot;
      frPower /= power + rot;
      blPower /= power + rot;
      brPower /= power + rot;

    }


  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
*/