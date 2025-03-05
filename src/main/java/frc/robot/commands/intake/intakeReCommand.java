/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.intakeSystem;

public class intakeReCommand extends CommandBase {

  private final intakeSystem intakesystem;
 
  public intakeReCommand(intakeSystem intakesubsystem) {

    intakesystem = intakesubsystem;

    addRequirements(intakesystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intakesystem.reverseIntake();
  }

  @Override
  public void end(boolean interrupted) {
    intakesystem.stopIntake();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
