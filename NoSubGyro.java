
import edu.wpi.first.wpilibj.DriverStationLCD;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Developer
 */
public class NoSubGyro extends CommandBase {
    
    public NoSubGyro() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser2, 1, drive.getGyroAngle() + "");
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
