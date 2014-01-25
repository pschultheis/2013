
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author bradmiller
 */
public class DriveTurnToAngle extends CommandBase {

    double angle;
    
    public DriveTurnToAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        drive.resetGyro();
        drive.setSetpoint(this.angle);
        drive.enable();
        
        
    }
        
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(drive.getGyroAngle() - this.angle) < 2)
        {
            return true;    
        }else
        {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drive.disable();
    }
}
