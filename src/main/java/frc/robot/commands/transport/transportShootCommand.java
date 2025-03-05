/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.transport;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.transport.transportSystem;

public class transportShootCommand extends CommandBase {

  private final transportSystem transportsystem;
 
  public transportShootCommand(transportSystem transportsubsystem) {

    transportsystem = transportsubsystem;

    addRequirements(transportsystem);
  }


  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    transportsystem.runShootTransport();
  }

  @Override
  public void end(boolean interrupted) {
    transportsystem.stopTransport();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}