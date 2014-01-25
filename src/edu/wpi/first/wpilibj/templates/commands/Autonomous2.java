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
public class Autonomous2 extends CommandGroup {
    
    public Autonomous2() {
        //addParallel(new LauncherMediumSpeed());
        addParallel(new LauncherToSpeed(7.15));
        addSequential(new WaitCommand(5));
        addSequential(new LauncherShoot());
        addSequential(new WaitCommand(3));
        addSequential(new LauncherShoot());
        addSequential(new WaitCommand(3.5));
        addSequential(new LauncherShoot());    
        addParallel(new LauncherAllStop());
        addSequential(new DriveStraight(.5,.5));
        addSequential(new DriveTurnToAngle2(180));
        //addSequential(new DriveStraight(.5,4));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
