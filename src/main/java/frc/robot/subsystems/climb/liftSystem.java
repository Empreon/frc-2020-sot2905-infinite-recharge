/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.climb;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.VictorSP;



public class liftSystem extends SubsystemBase {

  public VictorSP liftMotor;

  public liftSystem() {

    liftMotor = new VictorSP(Constants.Climb.liftPort);
  }
  public void runLift()
  {
    
    liftMotor.set(0.5);
  }
  public void reverseLift()
  {
    
    liftMotor.set(-0.5);
  }
  public void stopLift()
  {
    liftMotor.set(0.0);
  }

 

  @Override
  public void periodic() {
  }
}

