/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.shoot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.VictorSP;

public class shootSystem extends SubsystemBase {

  public VictorSP shootMotor;
  public VictorSP shootMotor2;

   public shootSystem() {

    shootMotor = new VictorSP(Constants.Shoot.shootPort);
    shootMotor2 = new VictorSP(Constants.Shoot.shootPort2);
  }
  public void runMinShoot()
  {
    shootMotor2.set(-0.6);
    shootMotor.set(0.6);
  }

  public void runShoot()
  {
    shootMotor2.set(-0.75);
    shootMotor.set(0.75);
  }

  public void runMaxShoot() 
  {
    shootMotor2.set(-0.9);
    shootMotor.set(0.9);
  }

  public void stopShoot()
  {
    shootMotor.set(0.0);
    shootMotor2.set(0.0);
  }

  @Override
  public void periodic() {
  }
}