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
public class NoSubvisionProcoff extends CommandBase {
    
    public NoSubvisionProcoff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putBoolean("VisionProc", false);
        this.setTimeout(.25);
        SmartDashboard.putNumber("wLeftMotorSpeed2", 65000);
        SmartDashboard.putNumber("wRightMotorSpeed2", 20000);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        SmartDashboard.putNumber("wLeftMotorSpeed2", 0);
        SmartDashboard.putNumber("wRightMotorSpeed2", 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        this.end();
    }
}
