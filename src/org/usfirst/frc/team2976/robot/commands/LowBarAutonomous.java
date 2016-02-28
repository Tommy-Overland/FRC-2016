package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author JasmineCheng
 * Drives under low bar, turns and shoots
 */
public class LowBarAutonomous extends CommandGroup {
    public LowBarAutonomous() {
     addSequential(new AutoDriveStraight(0.5, 1.0));
     addSequential(new AutoTurn(0.5, 0.5));
     addSequential(new AutoDriveStraight(0.5, 1.0));
     addSequential(new AutoRunRoller(1));    
    }
}