package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author unicorn ninja
 */
public class ClimbClawToward extends CommandBase {
    
    public ClimbClawToward() {
        // Use requires() here to declare subsystem dependencies
         requires(climb);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        climb.towardClimb();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return climb.getInnerSwitch();
    }

    // Called once after isFinished returns true
    protected void end()
    {
        climb.getInnerSwitch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
