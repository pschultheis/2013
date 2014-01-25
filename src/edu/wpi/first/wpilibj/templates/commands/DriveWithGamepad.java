/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 *
 * @author Developer
 */
public class DriveWithGamepad extends CommandBase {
    
    public DriveWithGamepad() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Math.abs(oi.getZValue()) > 0)
        {
            drive.tankDrive(oi.getZValue(), oi.getZValue());
        }
        else if(Math.abs(oi.getHalfMoveValue())+Math.abs(oi.getHalfRotateValue()) > 0.2)
        {
            drive.arcadeDrive(oi.getHalfMoveValue(), oi.getHalfRotateValue(), false);
        }
        else
        {
            drive.arcadeDrive(oi.getMoveValue(), oi.getRotateValue(), true);
        }
        
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "lm: " + drive.getLeftMotor());
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, "rm: " + drive.getRightMotor());
        DriverStationLCD.getInstance().updateLCD();
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
