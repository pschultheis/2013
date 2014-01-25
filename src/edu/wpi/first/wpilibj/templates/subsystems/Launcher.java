/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.io.OutputStreamWriter;
import javax.microedition.io.Connector;
import com.sun.squawk.microedition.io.FileConnection;
import java.io.IOException;

 /**
 *
 * @author Developer
 * @version RangerV04 January 24, 2013
 * 
 */
public class Launcher extends Subsystem {
    
    CANJaguar shooterMotorOne;
    CANJaguar shooterMotorTwo;
    
    Victor sploosherMotor;
    DigitalInput lineSensor;
        
    public static final double p = 20;
    public static final double i = 0;
    public static final double d = 0;
    
    public static boolean speedControl = false;
    public static boolean voltageControl = false;
    public static double currentSpeed; 
    
    
    public static boolean atSpeed = false;
    
    public Launcher()
    {
        super("launcher");
        
        sploosherMotor = new Victor(8);
        LiveWindow.addActuator("launcher", "Sploosher Motor", sploosherMotor);
        lineSensor = new DigitalInput(1);
        
        try{
            shooterMotorOne = new CANJaguar(3);
            LiveWindow.addActuator("launcher", "Shooting Motor One", shooterMotorOne);
            shooterMotorOne.getPowerCycled();
                        
            SmartDashboard.putBoolean("CANJaguar3", true);
            
        }
        catch(CANTimeoutException e)
        {
            //e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar3", false);
        }
        
        
        
        try{
            shooterMotorTwo = new CANJaguar(4);
            LiveWindow.addActuator("launcher", "Shooting Motor Two", shooterMotorTwo);
            shooterMotorTwo.getPowerCycled();
            SmartDashboard.putBoolean("CANJaguar4", true);
            
        }
        catch(CANTimeoutException e)
        {
            //e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar4", false);
        }
        setJaguarSettings();
    }
    public void initDefaultCommand() {
        //setDefaultCommand(new MySpecialCommand());   
    }
    
    /**
     * sets the jaguar settings 
     * @param none
     * @return none
     * @author Juliana and Elizabeth 
     */
    private void setJaguarSettings()
    {
        try{
            //shooterMotorOne.configEncoderCodesPerRev(2); // eventually ask the electronics people what this value is
            shooterMotorOne.configFaultTime(.5);
            shooterMotorOne.setPID(p, i, d); // instantiant p i and d, make them doubles, and give them values, these should be static finals
            //shooterMotorOne.setSpeedReference(CANJaguar.SpeedReference.kEncoder); //add method setSpeedRefference
            SmartDashboard.putBoolean("CANJaguar3", true);
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar3", false);
            
        }
        
        try{
            
            //shooterMotorTwo.configEncoderCodesPerRev(2); // eventually ask the electronics people what this value is
            shooterMotorTwo.configFaultTime(.5);
            shooterMotorTwo.setPID(p, i, d); // instantiant p i and d, make them doubles, and give them values, these should be static finals
            //shooterMotorTwo.setSpeedReference(CANJaguar.SpeedReference.kEncoder); //add method setSpeedRefference
            SmartDashboard.putBoolean("CANJaguar4", true);
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar4", false);
        }
    }
    


    public String getInformation()
    {
        String info = "";
        try
        {
            info = info + "S1:" +shooterMotorOne.getOutputVoltage() +":" + shooterMotorOne.getOutputCurrent();
            /*+"," + shooterMotorOne.getOutputVoltage()
                    + shooterMotorOne.getSpeed() + "," + "Shooter 2," + shooterMotorTwo.getOutputCurrent() + "," +
                    shooterMotorTwo.getOutputVoltage() + "," + shooterMotorTwo.getSpeed() + "/n";*/
            
        }
        catch(Exception e)
        {
            
        }
        return info;
    }
    
    public void writeToFile(String filename, String contents)
    {
        String url = "file:///" + filename;
        try
        {
            FileConnection c = (FileConnection) Connector.open(url);
            OutputStreamWriter writer = new OutputStreamWriter(c.openOutputStream());
            writer.write(contents);
            c.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    /**
     * sets the speed
     * @param speed 
     * @return none
     */    
    public void setSpeed(double speed)
    {
        try{
            //if(speed < 0.1)
            //{
            if(speed < 1)
            {
                shooterMotorOne.setX(speed);
                currentSpeed = speed;
            }else
            {
                //shooterMotorOne.setX(speed - 0.1);
                //currentSpeed = speed - 0.1;
                shooterMotorOne.setX(speed - 1);
                currentSpeed = speed - 1;
                
            }
            SmartDashboard.putBoolean("CANJaguar3", true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar3", false);
        }
        
        try{
            shooterMotorTwo.setX(speed);
            currentSpeed = speed;
            SmartDashboard.putBoolean("CANJaguar4", true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar4", false);
        }
    }
    
    
    public void sploosh(double speed)
    {
        sploosherMotor.set(speed*-1);
    }
    public boolean getLineSensor()
    {
        return lineSensor.get();
    }
    
    /**
     * starts speed control
     * @param none
     * @return none
     * @author Elizabeth and Juliana
     */
    public void enableSpeedControl()
    {
          try{
              shooterMotorOne.changeControlMode(CANJaguar.ControlMode.kVoltage);
              shooterMotorOne.enableControl();
              speedControl = true;
              SmartDashboard.putBoolean("CANJaguar3", true);
              
          }
          catch(Exception e)
          {
              e.printStackTrace();
              SmartDashboard.putBoolean("CANJaguar3", false);
          }
          
          try{
              shooterMotorTwo.changeControlMode(CANJaguar.ControlMode.kVoltage);
              shooterMotorTwo.enableControl();
              speedControl = true;
              
              SmartDashboard.putBoolean("CANJaguar4", true);
              
          }
          catch(Exception e)
          {
              e.printStackTrace();
              SmartDashboard.putBoolean("CANJaguar4", false);
          }
    }
    
    /**
     * stops speed control
     * @param none
     * @return none
     * @author Elizabeth and Juliana
     */
    public void disableSpeedControl() 
    {
        try{
            shooterMotorOne.disableControl();
            shooterMotorOne.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            speedControl = false;
            SmartDashboard.putBoolean("CANJaguar3", true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar3", false);
        }
        
        try{
            shooterMotorTwo.disableControl();
            shooterMotorTwo.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            speedControl = false;
            SmartDashboard.putBoolean("CANJaguar4", true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            SmartDashboard.putBoolean("CANJaguar4", false);
        }
    }
    /**
     * returns is speedControl is enabled or not
     * @param none
     * @return speedControl
     * @author Juliana 130126
     */
    public boolean getSpeedControl()
    {
        return speedControl;
    }
    public boolean getVoltageControl(){
        return voltageControl;
    }
    
    
    /**
     * checks if at speed
     * @param boolean 
     * @return none
     * @author Elizabeth and Juliana
     */
    public boolean isAtSpeed()
    {
        if(!speedControl&&!voltageControl)
        {
            return true;
        }
        try{
           if(Math.abs(shooterMotorOne.getOutputVoltage()-shooterMotorOne.getX())<.1
                   && Math.abs(shooterMotorTwo.getOutputVoltage()-shooterMotorTwo.getX())<.1)
           {
               atSpeed = true;
           }
           else
           {
               atSpeed = false;
           }
        }
        catch(Exception e)
        {
           e.printStackTrace();
           //SmartDashboard.putBoolean("Exception isAtSpeed CANJaguar 3 and 4", false);
        }
        
        return atSpeed;
    }

    
    /**
     * checks if power cycled
     * @param none
     * @return none
     * @author Juliana and Elizabeth
     * */
    public void jaguarCheckUp()
    {
        boolean powerCycledOne = false;
        boolean powerCycledTwo = false;
        
        try{
           powerCycledOne = shooterMotorOne.getPowerCycled();
           
           SmartDashboard.putBoolean("CANJaguar3", true);
        }
        catch(Exception e)
        {
           e.printStackTrace();
           SmartDashboard.putBoolean("CANJaguar3", false);
        }
        
        try{
           powerCycledTwo = shooterMotorTwo.getPowerCycled();
           SmartDashboard.putBoolean("CANJaguar4", true);
        }
        catch(Exception e)
        {
            
           e.printStackTrace();
           SmartDashboard.putBoolean("CANJaguar4", false);
        }
        
        if(powerCycledOne == true && powerCycledTwo == true)
        {
            this.setJaguarSettings();
            this.setSpeed(currentSpeed);
            
            
            
        }
        
    }
    

    /**
     * uses the distance from the camera to return an speed
     * @param double 
     * @return double
     * @author Juliana 130126
     */
    public double distanceToSpeed(double distance)
    {
        return 0.0;
    }
} 