/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.transport;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class transportSystem extends SubsystemBase {
  public TalonSRX transportMotor;

  public transportSystem() {

    transportMotor = new TalonSRX(Constants.Transport.transportId);
  
  }
  public void runTransport()
  {
    transportMotor.set(ControlMode.PercentOutput, -0.75);
  }
  public void reverseTransport()
  {
    transportMotor.set(ControlMode.PercentOutput, 0.75);
  }
  public void runShootTransport()
  {
    transportMotor.set(ControlMode.PercentOutput, -0.5);
  }
  public void stopTransport()
  {
    transportMotor.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void periodic() {
  }
}
