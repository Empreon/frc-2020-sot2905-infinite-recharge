/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class intakeLiftSystem extends SubsystemBase {

  Compressor compressor;
  DoubleSolenoid liftSolenoid;

  public intakeLiftSystem() {
    compressor = new Compressor();
    compressor.setClosedLoopControl(true);
    liftSolenoid = new DoubleSolenoid(Constants.Intake.intakePneumaticsPort1, Constants.Intake.intakePneumaticsPort2);
  }

  public void feedMode() {
      liftSolenoid.set(Value.kForward);
  }

  public void closeMode() {
      liftSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
  }
}
