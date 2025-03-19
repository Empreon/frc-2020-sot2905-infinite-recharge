/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight implements INetworkTablesTrackingCamera {
  private final NetworkTable table;

  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
  }

  public double getX() {
    return table.getEntry("tx").getDouble(0);
  }

  public double getY() {
    return table.getEntry("ty").getDouble(0);
  }

  public boolean getV() {
    return table.getEntry("tv").getDouble(0) == 1;
  }

  public double getA() {
    return table.getEntry("ta").getDouble(0.0);
  }

  public void setDriverMode(final boolean driverMode) {
    if (driverMode) {
      table.getEntry("camMode").setDouble(1.0);
    } else {
      table.getEntry("camMode").setDouble(0.0);
    }
  }

  public void setPipeline(final int pipeline) {
    table.getEntry("pipeline").setDouble(pipeline);
  }

  public void setLights(final LightMode mode) {
    if (mode == LightMode.ON) {
      table.getEntry("ledMode").setDouble(3);
    } else if (mode == LightMode.DEFAULT) {
      table.getEntry("ledMode").setDouble(0);
    } else if (mode == LightMode.OFF) {
      table.getEntry("ledMode").setDouble(1);
    } else if (mode == LightMode.BLINKY) {
      table.getEntry("ledMode").setDouble(2);}}

  public enum LightMode {
    ON, OFF, DEFAULT, BLINKY
  }
}
