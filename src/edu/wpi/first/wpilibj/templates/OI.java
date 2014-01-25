
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    
    
    Joystick xboxDriver = new Joystick(1);
    Joystick xboxCoDriver = new Joystick(2);
    
    Button Driverbutton1A = new JoystickButton(xboxDriver, 1);
    Button Driverbutton2B = new JoystickButton(xboxDriver, 2);
    Button Driverbutton3X = new JoystickButton(xboxDriver, 3);
    Button Driverbutton4Y = new JoystickButton(xboxDriver, 4);
    Button Driverbutton5LB = new JoystickButton(xboxDriver, 5);
    Button Driverbutton6RB = new JoystickButton(xboxDriver, 6);
    
    Button Driverbutton7BACK = new JoystickButton(xboxDriver, 7);
    Button Driverbutton8START = new JoystickButton(xboxDriver, 8);
    
    Button CoDriverbutton1A = new JoystickButton(xboxCoDriver, 1);
    Button CoDriverbutton2B = new JoystickButton(xboxCoDriver, 2);
    Button CoDriverbutton3X = new JoystickButton(xboxCoDriver, 3);
    Button CoDriverbutton4Y = new JoystickButton(xboxCoDriver, 4);
    Button CoDriverbutton5LB = new JoystickButton(xboxCoDriver, 5); //stop shooter
    Button CoDriverbutton6RB = new JoystickButton(xboxCoDriver, 6); //start shooter
    Button CoDriverbutton7BACK = new JoystickButton(xboxCoDriver, 7);
    Button CoDriverbutton8START = new JoystickButton(xboxCoDriver, 8);
    
    Button CoDriverbutton9LeftJoy = new JoystickButton(xboxCoDriver, 9);
    
    public class AnalogRight extends Button
    {
        public boolean get()
        {
            return (xboxCoDriver.getRawAxis(3)<-0.5);
            
        }
     
    }
    
    AnalogRight CoDriverAnalogRight = new AnalogRight();
    
    public OI()
    {
        
        //Driverbutton1A.whenPressed(new DriveTurnToSetAngle2());
        Driverbutton1A.whenPressed(new LauncherLowSpeed());
//        Driverbutton2B.whenPressed(new LauncherAllStop());
//        Driverbutton3X.whenPressed(new LauncherLowSpeed());
//        Driverbutton4Y.whenPressed(new LauncherFullSpeed2());
        //Driverbutton3X.whenPressed(new DriveTurnToAngle2(10)); //can be deleted after testing
        //Driverbutton4Y.whenPressed(new DriveTurnToAngle2(-10)); //can be deleted after testing
        Driverbutton5LB.whenPressed(new HangerClose());
        Driverbutton6RB.whenPressed(new HangerOpen());
        Driverbutton7BACK.whenPressed(new OurCompressorOff());
        Driverbutton8START.whenPressed(new OurCompressorOn());
        
        
        CoDriverbutton5LB.whenPressed(new LauncherAllStop());
        CoDriverbutton6RB.whenPressed(new LauncherSpeedAtDistance());
        CoDriverbutton2B.whenPressed(new LauncherMediumSpeed());
        CoDriverbutton1A.whenPressed(new LauncherLowSpeed());
        CoDriverbutton3X.whenPressed(new LauncherToSpeed(7.1));
        //CoDriverbutton3X.whenPressed(new LauncherToSpeed(6.9));
        CoDriverbutton4Y.whenPressed(new LauncherFullSpeed2());
        
        CoDriverAnalogRight.whenPressed(new LauncherShoot());
        
        CoDriverbutton9LeftJoy.whenPressed(new LauncherCANReset());
        
        CoDriverbutton7BACK.whenPressed(new NoSubSelectMedium());
        CoDriverbutton8START.whenPressed(new NoSubSelectHigh());
        
        
        
    }
    
    //public double getLeftJoySpeed()
    //{
   //     return leftJoy.getY();
    //}
    
    //public double getRightJoySpeed()
    //{
    //    return rightJoy.getY();
    //}
    
    public double getMoveValue()
    {
        return xboxDriver.getY();
    }
    public double getRotateValue()
    {
        return xboxDriver.getX();
    }
    public double getZValue()
    {
        return xboxDriver.getZ()*.25;
    }
    
    public double getHalfMoveValue()
    {
        return (xboxDriver.getRawAxis(5)/2.0);
    }
    public double getHalfRotateValue()
    {
        return ((xboxDriver.getRawAxis(4))*2.0/3.0);
    }
}

