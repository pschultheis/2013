
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.Climb;
import edu.wpi.first.wpilibj.templates.commands.LauncherAllStop;
import edu.wpi.first.wpilibj.templates.commands.LauncherFullSpeed2;
import edu.wpi.first.wpilibj.templates.commands.LauncherSploosher;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    
    
    Joystick xboxDriver = new Joystick(1);
    Joystick xboxCodeDriver = new Joystick(2);
    
    Button button1A = new JoystickButton(xboxCodeDriver, 1);
    Button button2B = new JoystickButton(xboxCodeDriver, 2);
    Button button3X = new JoystickButton(xboxCodeDriver, 3);
    Button button4Y = new JoystickButton(xboxCodeDriver, 4);
    Button button5LB = new JoystickButton(xboxCodeDriver, 5); //stop shooter
    Button button6RB = new JoystickButton(xboxCodeDriver, 6); //start shooter
    Button button7BACK = new JoystickButton(xboxCodeDriver, 7);
    Button button8START = new JoystickButton(xboxCodeDriver, 8);
    
    public class AnalogRight extends Button
    {
        public boolean get()
        {
            return (xboxCodeDriver.getRawAxis(3)<-0.5);
            
        }
     
    }
    
    AnalogRight analogRight = new AnalogRight();
    
    public OI()
    {
        //button1A.whenPressed(new LauncherSploosher(0.4));
        button5LB.whenPressed(new LauncherAllStop());
        button6RB.whenPressed(new LauncherFullSpeed2());
        button4Y.whenPressed(new Climb());
        analogRight.whenPressed(new LauncherSploosher(0.4));
        button7BACK.whenPressed(new );
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
        return xboxDriver.getX()*-1;
    }
    public double getZValue()
    {
        return xboxDriver.getZ()*.25;
    }
}

