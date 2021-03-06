/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class LauncherSpeedAtDistance extends CommandBase {
    
    public LauncherSpeedAtDistance() {
        requires(launcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(launcher.getVoltageControl() == false)
        {
            launcher.enableVoltageControl();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed = launcher.distanceToSpeed(SmartDashboard.getNumber("Distance", 0));
        launcher.setSpeed(speed);     
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
