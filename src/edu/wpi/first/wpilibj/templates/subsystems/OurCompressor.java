/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.OurCompressorOn;

/**
 *
 * @author Developer
 */
public class OurCompressor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Compressor compressor1;
    
    public OurCompressor()
    {
        compressor1 = new Compressor(5,8);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new OurCompressorOn());
    }
    
    public void compressorOn()
    {
        compressor1.start();
    }
    
    public void compressorOff()
    {
        compressor1.stop();
    }
    
    
}
