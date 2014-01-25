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
public class LauncherLowSpeed extends CommandBase {
    
    public LauncherLowSpeed() 
    {
        requires(launcher);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
        launcher.enableVoltageControl();
        launcher.jaguarCheckUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //launcher.setSpeed(0.7); percent voltage
        launcher.setSpeed(4.5);
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1,launcher.getInformation());
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
        end();
    }
}
