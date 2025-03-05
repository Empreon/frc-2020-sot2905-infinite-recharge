/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.climb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class climbSystem extends SubsystemBase {
  public TalonSRX climbMotor;

  public climbSystem() {

  climbMotor = new TalonSRX(Constants.Climb.climbId);
  climbMotor.configOpenloopRamp(0.50); 
  }
  public void runClimb()
  {
    
    climbMotor.set(ControlMode.PercentOutput, 0.7);
  }
  public void reverseClimb()
  {
    
    climbMotor.set(ControlMode.PercentOutput, -0.5);
  }
  public void stopClimb()
  {
    climbMotor.set(ControlMode.PercentOutput, 0.0);
  }

 

  @Override
  public void periodic() {
  }
}

