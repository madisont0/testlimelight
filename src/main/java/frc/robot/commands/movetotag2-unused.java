
/* 
package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.MathUtil;
import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.subsystems.limelight3;

public class movetotag2 extends CommandBase {
    private final PIDController xcontroller = new PIDController(Constants.kPx, Constants.kIx, Constants.kDx);
    private final PIDController ycontroller = new PIDController(Constants.kPy, Constants.kIy, Constants.kDy);
    private final PIDController rcontroller = new PIDController(Constants.kPr, Constants.kIr, Constants.kDr);

    private final double targetXDist;
    private final double targetYDist;
    private final double targetR;

    private final drivetrain drivetrain;
    private final limelight3 camera;

    public movetotag2(drivetrain drivetrain, limelight3 camera, double targetXDist, double targetYDist, double targetR) {
        this.targetXDist = targetXDist;
        this.targetYDist = targetYDist;
        this.targetR = targetR;

        this.drivetrain = drivetrain;
        this.camera = camera;

        addRequirements(camera);
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        xcontroller.setTolerance(Constants.xtolerance);
        ycontroller.setTolerance(Constants.ytolerance);
        rcontroller.setTolerance(Constants.rtolerance);
    }

    @Override
    public void execute() {
        double currentXDist = camera.getTZ(); //renamed
        double currentYDist = camera.getTX();
        double currentR = camera.getPitch();

        double xspeed = MathUtil.clamp((xcontroller.calculate(currentXDist, targetXDist)), -Constants.xclamp, Constants.xclamp);
        double yspeed = MathUtil.clamp((ycontroller.calculate(currentYDist, targetYDist)), -Constants.yclamp, Constants.yclamp);
        double rspeed = MathUtil.clamp((rcontroller.calculate(currentR, targetR)), -Constants.rclamp, Constants.rclamp);

        drivetrain.drive(xspeed, yspeed, rspeed);
    }

    @Override
    public void end (boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return (xcontroller.atSetpoint() && ycontroller.atSetpoint() && rcontroller.atSetpoint());
    }


}
*/