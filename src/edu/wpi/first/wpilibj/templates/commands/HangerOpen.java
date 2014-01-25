
 //To change this template, choose Tools | Templates
 //and open the template in the editor.
 
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class HangerOpen extends CommandBase {
    
    public HangerOpen() {
        // Use requires() here to declare subsystem dependencies
        requires(hanger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       SmartDashboard.putBoolean("HangerOpen",true); 
       SmartDashboard.putNumber("wLeftMotorSpeed", 36000);
       SmartDashboard.putNumber("wRightMotorSpeed", 48000);
       SmartDashboard.putBoolean("OtherCam", true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        hanger.openHanger();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
