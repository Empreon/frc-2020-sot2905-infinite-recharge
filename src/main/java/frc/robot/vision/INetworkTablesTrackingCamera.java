/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.vision;

public interface INetworkTablesTrackingCamera {

  double getX();

  double getY();

  boolean getV();

  double getA();

  void setDriverMode(boolean driverMode);

  void setPipeline(int pipeline);
}