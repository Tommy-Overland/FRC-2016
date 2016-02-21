
package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The main autonomous command to pickup and deliver the
 * soda to the box.
 */
public class RoughTerrainAutonomous extends CommandGroup {
    public RoughTerrainAutonomous() {
     addSequential(new AutoDriveStraight(4));
     addSequential(new AutoTurn(20, 1));
     addSequential(new AutoDriveStraight(1));
     addSequential(new AutoTurn(-20, -1));
     addSequential(new AutoDriveStraight(1));
     addSequential(new AutoRunRoller());
     
     
    }
}
