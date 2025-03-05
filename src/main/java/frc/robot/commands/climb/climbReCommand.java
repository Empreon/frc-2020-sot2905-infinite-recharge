/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climb.climbSystem;

public class climbReCommand extends CommandBase {

  private final climbSystem climbsystem;
 
  public climbReCommand(climbSystem climbsubsystem) {

    climbsystem = climbsubsystem;

    addRequirements(climbsystem);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    climbsystem.reverseClimb();
  }

  @Override
  public void end(boolean interrupted) {
    climbsystem.stopClimb();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
