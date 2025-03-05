/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class gearSystem extends SubsystemBase {

  Compressor compressor;
  DoubleSolenoid shifter;

  public gearSystem() {
    compressor = new Compressor();
    compressor.setClosedLoopControl(true);
    shifter = new DoubleSolenoid(Constants.Chasis.gearChangePort1, Constants.Chasis.gearChangePort2);
  }

  public void gearUp() {
      shifter.set(Value.kForward);
  }

  public void gearDown() {
      shifter.set(Value.kReverse);
  }

  @Override
  public void periodic() {
  }
}