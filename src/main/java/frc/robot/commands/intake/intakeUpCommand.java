/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.intakeLiftSystem;

public class intakeUpCommand extends CommandBase {

  private final intakeLiftSystem intakeliftsystem;

  public intakeUpCommand(intakeLiftSystem intakeliftsubsystem) {

    intakeliftsystem = intakeliftsubsystem;

    addRequirements(intakeliftsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intakeliftsystem.closeMode();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
