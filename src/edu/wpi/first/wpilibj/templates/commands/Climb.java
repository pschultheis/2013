/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author unicorn ninja
 */
public class Climb extends CommandGroup {
    
    public Climb() 
    {
        // Climb to third bar:
         //addSequential(new ClimbOpenUpClaw());
         //addSequential(new ClimbOpenDownClaw());
         addSequential(new ClimbAway());
         //addSequential(new ClimbCloseUpClaw());
         //addSequential(new ClimbOpenDownClaw());
         addSequential(new ClimbClawToward());
         //addSequential(new ClimbCloseDownClaw());//first bar
         //addSequential(new ClimbOpenUpClaw());
         addSequential(new ClimbAway());
         //addSequential(new ClimbCloseUpClaw());
         //addSequential(new ClimbOpenDownClaw());
         addSequential(new ClimbClawToward());
         //addSequential(new ClimbCloseDownClaw());//second bar
         //addSequential(new ClimbOpenUpClaw());
         addSequential(new ClimbAway());
         //addSequential(new ClimbCloseUpClaw());
         //addSequential(new ClimbOpenDownClaw());
         addSequential(new ClimbClawToward());
         //addSequential(new ClimbCloseDownClaw());//third bar
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
