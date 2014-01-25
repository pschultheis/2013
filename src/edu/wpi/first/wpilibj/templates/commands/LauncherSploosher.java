/*
 * New Window Motor
 * Extends 60 degrees then retracts 60 degrees
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Developer
 */
public class LauncherSploosher extends CommandBase {
    
    public Timer timer = new Timer();
    double speed;
    boolean timeUp = false;
    boolean firstTime = true;
    public String info ="";
    public int fireNumber = 1;
    
    public LauncherSploosher(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(launcher);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(!launcher.isAtSpeed())
        {
            this.cancel();
        }
        timer.start();
        timer.reset();        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        launcher.sploosh(speed);
        
        if(timer.get() >= .1)
        {
            timeUp = true;
        }
        //info = info + launcher.getInformation();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {  
        if(launcher.getLineSensor() && timeUp)
        {
            return true;
        }else
        {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        launcher.sploosh(0);
        timer.stop();
        timer.reset();
        timeUp = false;
        
        
        //launcher.writeToFile("" + fireNumber + ".txt", info);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
