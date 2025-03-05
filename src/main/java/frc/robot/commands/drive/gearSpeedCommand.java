/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive.gearSystem;

public class gearSpeedCommand extends CommandBase {

  private final gearSystem gearsystem;

  public gearSpeedCommand(gearSystem gearsubsystem) {

    gearsystem = gearsubsystem;

    addRequirements(gearsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    gearsystem.gearUp();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
