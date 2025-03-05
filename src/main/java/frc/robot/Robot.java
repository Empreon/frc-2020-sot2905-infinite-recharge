/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.vision.Limelight;
import frc.robot.vision.Limelight.LightMode;

public class Robot extends TimedRobot {
  private Command autonomousCommand;

  private RobotContainer robotContainer;
  private final Limelight limelight = new Limelight();

  @Override
  public void robotInit() {

    robotContainer = new RobotContainer();

    UsbCamera cvSink = CameraServer.getInstance().startAutomaticCapture();
    cvSink.setFPS(30);
    cvSink.setResolution(225, 225);
  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    
    limelight.setLights(LightMode.ON);
    limelight.setDriverMode(false);

    robotContainer.getAutonomousCommand().schedule();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {

    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    limelight.setLights(LightMode.OFF);
    limelight.setDriverMode(true);
  }

  @Override
  public void teleopPeriodic() {
    double x = limelight.getX();
    double y = limelight.getY();
    double a = limelight.getA();

    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", a);
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
