/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shoot.shootSystem;


public class shootCommand extends CommandBase {
  
  private final shootSystem shootsystem;
  
  
  public shootCommand(shootSystem shootsubsystem) {
    
    shootsystem = shootsubsystem;

    addRequirements(shootsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    shootsystem.runShoot();
  }

  @Override
  public void end(boolean interrupted) {
    shootsystem.stopShoot();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

