/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.DriveWithGamepad;

/**
 *
 * @author Andre Leone
 */
public class Drive extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static final double Kp = 1;
    private static final double Ki = 0;
    private static final double Kd = 0;
    
    Jaguar driveLeftMotor;
    Jaguar driveRightMotor;
    
    Gyro gyro;
    
    public Drive()
    {
        super("drive", Kp, Ki, Kd);
        driveLeftMotor = new Jaguar(1);
        driveRightMotor = new Jaguar(2);
        LiveWindow.addActuator("drive", "Left Motor", driveLeftMotor);
        LiveWindow.addActuator("drive", "Right Motor", driveRightMotor);
        gyro = new Gyro(1);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new DriveWithJoystick());
        setDefaultCommand(new DriveWithGamepad());
    }
    
    
    protected double returnPIDInput() {
        return gyro.getAngle();
    }
    
    protected void usePIDOutput(double output) {
        tankDrive(output, output * (-1));
    }
    
    
    /**
     * Reset Gyro
     * This function sets the Gyro's reference point to 0.00 and to the position the Gyro is currently at.
     */
    public void resetGyro()
    {
        gyro.reset();
    }
   
    /**
     * Getting The Gyro Angle
     * This function returns the angle the Gyro is currently positioned at.
     * @return A Decimal value of the angle the Gyro is currently positioned at.
     */
    public double getGyroAngle()
    {
        return gyro.getAngle();
    }
    
    /**
     * Tank drive implements two joystick driving.
     * This function lets you directly provide joystick values from any source.
     * @param leftJoy The value to use for left motor speed.
     * @param rightJoy The value to use for right motor speed and is negated within the method to account for change in polarity.
     */
    public void tankDrive(double leftJoy, double rightJoy)
    {
        //set motor speeds
        driveLeftMotor.set(leftJoy);
        driveRightMotor.set(rightJoy*-1);
        
    }
    
     /**
     * Arcade drive implements single stick driving.
     * This function lets you directly provide joystick values from any source.
     * @param moveValue The value to use for forwards/backwards
     * @param rotateValue The value to use for the rotate right/left
     * @param squaredInputs If set, decreases the sensitivity at low speeds
     */
    public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs) {
        // local variables to hold the computed PWM values for the motors
        double leftMotorSpeed;
        double rightMotorSpeed;

        if (squaredInputs) {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power
            if (moveValue >= 0.0) {
                moveValue = (moveValue * moveValue);
            } else {
                moveValue = -(moveValue * moveValue);
            }
            if (rotateValue >= 0.0) {
                rotateValue = (rotateValue * rotateValue);
            } else {
                rotateValue = -(rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }

        tankDrive(leftMotorSpeed, rightMotorSpeed);
    }

}
