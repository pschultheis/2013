/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Developer
 */
public class Autonomous3 extends CommandGroup {
    
    public Autonomous3() {
        
        addParallel(new LauncherToSpeed(7.15));
        addSequential(new WaitCommand(5));
        addSequential(new LauncherShoot());
        addSequential(new WaitCommand(3.5));
        addSequential(new LauncherShoot());
        addSequential(new WaitCommand(3.5));
        addSequential(new LauncherShoot());    
        addParallel(new LauncherAllStop());
    }
}
