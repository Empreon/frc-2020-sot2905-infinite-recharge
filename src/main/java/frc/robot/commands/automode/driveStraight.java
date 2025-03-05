/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.automode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.driveSystem;;

public class driveStraight extends CommandBase {

  private final driveSystem drivesystem;
 
  public driveStraight(driveSystem drivesubsystem) {

    drivesystem = drivesubsystem;

    addRequirements(drivesystem);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    drivesystem.driveStraight();
  }

  @Override
  public void end(boolean interrupted) {
    drivesystem.driveStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
