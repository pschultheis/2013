/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author unicorn ninja
 */
public class ClimbCloseUpClaw extends CommandBase {
    
    public ClimbCloseUpClaw() {
        // Use requires() here to declare subsystem dependencies
        requires(climb);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        this.setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        climb.closeUpClaw();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
