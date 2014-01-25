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
public class NoSubPrintLines extends CommandBase {
    
    public NoSubPrintLines() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
       DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser3, 1, drive.getCurrentCommand().getName() + " ");
       DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser4, 1, hanger.getCurrentCommand().getName()+ " ");
       DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser5, 1, climb.getCurrentCommand().getName()+ " ");
       DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser6, 1, launcher.getCurrentCommand().getName()+ " ");
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
