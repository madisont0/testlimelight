
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.drivejoystick;
import frc.robot.commands.limelightcommand;
import frc.robot.commands.movetotag;
//import frc.robot.commands.movetotag2;
import frc.robot.subsystems.drivetrain;
//import frc.robot.subsystems.MecanumDrive;//
import frc.robot.subsystems.limelight3;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Commands;
//import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  private limelight3 camera = new limelight3();
  private drivetrain Drivetrain = new drivetrain();
  //private MecanumDrive drivetrain = new MecanumDrive();
  private XboxController joystick;

  public RobotContainer() {
   // Drivetrain.setDefaultCommand(new drivejoystick(Drivetrain, joystick));
    //camera.setDefaultCommand(new limelightcommand(camera));
    //this.joystick = joystick;

    joystick = new XboxController(0);
    //Drivetrain.setDefaultCommand(new drivejoystick(Drivetrain, joystick));
    Drivetrain.setDefaultCommand(new movetotag(camera, Drivetrain, 0, 0.5, 0)); //in meters

    configureButtonBindings();

  }

  
  private void configureButtonBindings() {
    //new JoystickButton(joystick, Button.kX.value).onTrue(new movetotag(camera, Drivetrain, 0, 3, 180));
    //new JoystickButton(joystick, Button.kY.value).onTrue(new movetotag2(drivetrain, camera, (double) 0, 0.7, (double) 0));
  }

  public Command getAutonomousCommand(){
    return new limelightcommand(camera);
    //return new movetotag2(drivetrain, camera, (double) 0, 0.7, (double) 0);
  }
}
