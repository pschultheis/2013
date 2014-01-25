package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 * @author ninja unicorn
 */
public class Climber extends Subsystem //climb V01 1/26/13
{
    
        Jaguar climbMotor;
        
        Solenoid stinger;
        Solenoid upGrip;
        Solenoid downGrip;
        
        DigitalInput outerSwitch;
        DigitalInput innerSwitch;
        
        
    public Climber()
    {
        super("climb");
       climbMotor = new Jaguar(5);
       LiveWindow.addActuator("climber", "Cimber Motor", climbMotor);
       
       stinger = new Solenoid(3);
       upGrip = new Solenoid(4);
       downGrip = new Solenoid(5);
       
       outerSwitch = new DigitalInput(2);
       innerSwitch = new DigitalInput(3);
     }
    
    public void StingerOut()
    {
        stinger.set(false);
    }
    public void StingerIn()
    {
        stinger.set(false);
    }
    public void OpenUpClaw()
    {
        upGrip.set(true);
    }
    public void OpenDownClaw()
    {
        downGrip.set(true);
    }
    public void closeUpClaw()
    {
        upGrip.set(false);
    }
    public void CloseDownClaw()
    {
        downGrip.set(false);
    }
    public void stop()
    {
        climbMotor.set(0);
    }
    
    public void towardClimb()
    {
        if(innerSwitch.get()== false)
        {
            climbMotor.set(-.5);
        }
        else
        {
            climbMotor.set(0);
        }
    }
    
    public void awayClimb()
    {
        if(outerSwitch.get()== false)
        {
            climbMotor.set(.5);
        }
        else
        {
            climbMotor.set(0);
        }
    }
    
    public boolean getInnerSwitch()
    {
        return innerSwitch.get();
    }
    public boolean getOuterSwitch()
    {
        return outerSwitch.get();
    }
    
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
