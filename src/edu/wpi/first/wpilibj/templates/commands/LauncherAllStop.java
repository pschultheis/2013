/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Juliana 130126
 */
public class LauncherAllStop extends CommandBase {
    
    public LauncherAllStop() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(launcher.getSpeedControl() == true)
        {
            launcher.disableSpeedControl();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.setSpeed(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
