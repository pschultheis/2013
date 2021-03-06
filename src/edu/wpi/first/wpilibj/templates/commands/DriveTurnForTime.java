/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author andreleone
 */
public class DriveTurnForTime extends CommandBase {
    
    double speedLeft;
    double speedRight;
    double time;
    
    public DriveTurnForTime(double speed, double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
        this.speedLeft = speed * -1;
        this.speedRight = speed;
        this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setTimeout(this.time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.tankDrive(this.speedLeft, this.speedRight);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(isTimedOut())
        {
            return true;
        }else
        {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
