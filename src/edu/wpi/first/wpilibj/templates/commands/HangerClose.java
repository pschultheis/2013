
 //To change this template, choose Tools | Templates
 //and open the template in the editor.
 
package edu.wpi.first.wpilibj.templates.commands;

//import edu.wpi.first.wpilibj.DriverStationLCD;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class HangerClose extends CommandBase {
    
    public HangerClose() {
        // Use requires() here to declare subsystem dependencies
        requires(hanger);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       SmartDashboard.putBoolean("HangerOpen",false);
       SmartDashboard.putNumber("wLeftMotorSpeed", 0);
       SmartDashboard.putNumber("wRightMotorSpeed", 0);
       SmartDashboard.putBoolean("OtherCam", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        hanger.closeHanger();
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
