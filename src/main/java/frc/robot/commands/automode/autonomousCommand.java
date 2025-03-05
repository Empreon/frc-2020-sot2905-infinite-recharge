/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.automode;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.commands.shoot.aimerReCommand;
import frc.robot.commands.shoot.limelightCommand;
import frc.robot.commands.shoot.shootMaxCommand;
import frc.robot.commands.transport.transportCommand;


import frc.robot.subsystems.drive.driveSystem;
import frc.robot.subsystems.intake.intakeLiftSystem;
import frc.robot.subsystems.intake.intakeSystem;
import frc.robot.subsystems.shoot.limelightAimerSystem;
import frc.robot.subsystems.shoot.shootSystem;
import frc.robot.subsystems.transport.transportSystem;

public class autonomousCommand extends SequentialCommandGroup {

  public autonomousCommand(final driveSystem drivesystem,
                           final intakeLiftSystem intakeliftsystem,
                           final intakeSystem intakesystem,
                           final transportSystem transportsystem,
                           final limelightAimerSystem limelightaimersystem,
                           final shootSystem shootsystem) {
    super(
      new aimerReMaxCommand(limelightaimersystem).withTimeout(0.2),
      new aimerReCommand(limelightaimersystem).withTimeout(0.75),
      new limelightCommand(limelightaimersystem).withTimeout(2.0),
      new shootMaxCommand(shootsystem).withTimeout(0.75),
      new ParallelRaceGroup(
        new limelightCommand(limelightaimersystem).withTimeout(4.5),
        new shootMaxCommand(shootsystem).withTimeout(4.5),
        new transportCommand(transportsystem).withTimeout(4.5)
      ),
      new driveBack(drivesystem).withTimeout(2.0)
    );
  }
}