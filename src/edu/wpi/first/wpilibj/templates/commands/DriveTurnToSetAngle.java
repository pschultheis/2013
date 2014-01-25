/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author andreleone
 */
public class DriveTurnToSetAngle extends CommandBase {

    double angle;
    
    public DriveTurnToSetAngle() {
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.angle = SmartDashboard.getNumber("TargetAngle", 0.0);
        drive.resetGyro();
        drive.setSetpoint(this.angle);
        drive.enable();
        
        
    }
        
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(drive.getGyroAngle() - this.angle) < 2)
        {
            return true;    
        }else
        {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.disable();
        new DriveWithGamepad().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
