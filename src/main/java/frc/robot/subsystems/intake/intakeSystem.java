/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class intakeSystem extends SubsystemBase {
  public TalonSRX intakeMotor;

  public intakeSystem() {

  intakeMotor = new TalonSRX(Constants.Intake.intakeMotorId);
  
  }
  public void runIntake()
  {
    
    intakeMotor.set(ControlMode.PercentOutput, -0.7);
  }
  public void reverseIntake()
  {
    
    intakeMotor.set(ControlMode.PercentOutput, 0.7);
  }
  public void stopIntake()
  {
    intakeMotor.set(ControlMode.PercentOutput, 0.0);
  }

 

  @Override
  public void periodic() {
  }
}
