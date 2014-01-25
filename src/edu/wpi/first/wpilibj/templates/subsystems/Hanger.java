
 //To change this template, choose Tools | Templates
 //and open the template in the editor.
 
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Hanger extends Subsystem {
    
    static Solenoid hangerSolenoid;
    DigitalInput hangerSwitch;
    //boolean hangerSwitchStatus;
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
       
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Hanger()
    {
        super("hanger");
        hangerSolenoid = new Solenoid(8);
        hangerSwitch = new DigitalInput(8);
        //LiveWindow.addActuator("Hanger","HangerSolenoid", hangerSolenoid);
    }
    
    public boolean hangerSwitch()
    {
        return !hangerSwitch.get();   
    }
    
    public void openHanger()
    {
        hangerSolenoid.set(true);
        //DriverStationLCD.Line("Hanger is open.");
    }
    
    public void closeHanger()
    {
        hangerSolenoid.set(false);
        //DriverStationLCD.Line("Hanger is closed");
    }
}
