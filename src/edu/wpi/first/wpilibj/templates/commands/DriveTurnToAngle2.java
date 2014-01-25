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
public class DriveTurnToAngle2 extends CommandBase {

    double angle;
    
    double OneFifthOfAngle;
    double TwoFifthOfAngle;
    double ThreeFifthOfAngle;
    double FourFifthOfAngle;
    double FiveFifthOfAngle;
    
    public DriveTurnToAngle2(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drive.resetGyro();
        
        
        this.OneFifthOfAngle = this.angle/5;
        this.TwoFifthOfAngle = this.OneFifthOfAngle * 2;
        this.ThreeFifthOfAngle = this.OneFifthOfAngle * 3;
        this.FourFifthOfAngle = this.OneFifthOfAngle * 4;
        this.FiveFifthOfAngle = this.OneFifthOfAngle * 5;
    }
        
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, drive.getGyroAngle() + "");
        DriverStationLCD.getInstance().updateLCD();
        
        if(this.angle > 0)
        {
            if(drive.getGyroAngle() < this.OneFifthOfAngle)
            {
               drive.arcadeDrive(0, 0.4, false);
            }else if(drive.getGyroAngle() < this.TwoFifthOfAngle)
            {
              drive.arcadeDrive(0, 0.7, false);
            }else if(drive.getGyroAngle() < this.ThreeFifthOfAngle)
            {
               drive.arcadeDrive(0, 0.5, false);
            }else if(drive.getGyroAngle() < this.FourFifthOfAngle)
            {
               drive.arcadeDrive(0, 0.2, false);
            }else if(drive.getGyroAngle() < this.FiveFifthOfAngle)
            {
                drive.arcadeDrive(0, 0.15, false);
            }else
            {
                drive.arcadeDrive(0, -0.2, false);
            }
            
        }else if(this.angle < 0)
        {
            if(drive.getGyroAngle() > this.OneFifthOfAngle)
            {
                 drive.arcadeDrive(0, -0.4, false);
            }else if(drive.getGyroAngle() > this.TwoFifthOfAngle)
            {
                 drive.arcadeDrive(0, -0.7, false);
            }else if(drive.getGyroAngle() > this.ThreeFifthOfAngle)
            {
                 drive.arcadeDrive(0, -0.5, false);
            }else if(drive.getGyroAngle() > this.FourFifthOfAngle)
            {
                 drive.arcadeDrive(0, -0.2, false);
            }else if(drive.getGyroAngle() > this.FiveFifthOfAngle)
            {
                 drive.arcadeDrive(0, -0.15, false);
            }else
            {
                drive.arcadeDrive(0, 0.2, false);
            }
        }
        
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(drive.getGyroAngle() - this.angle) < 1)
        {
            return true;    
        }else
        {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        new DriveWithGamepad().start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}