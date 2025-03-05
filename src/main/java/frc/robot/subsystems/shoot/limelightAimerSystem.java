/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.shoot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.driveSystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;


public class limelightAimerSystem extends SubsystemBase {
  
  public TalonSRX limelightAimerMotor;

  private Joystick attack1 = new Joystick(1);

  private final driveSystem drivetrain1 = new driveSystem(attack1);

  public limelightAimerSystem()
  {
    limelightAimerMotor = new TalonSRX(Constants.Shoot.shootAimerId);

    limelightAimerMotor.configFactoryDefault();
  }

  public void runlimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, -0.25);
  }
  public void reverselimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, 0.25);
  }
  public void runMaxlimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, -0.35);
  }
  public void runFulllimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, -0.13);
  }
  public void reverseFulllimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, 0.13);
  }
  public void runHalflimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, -0.085);
  }

  public void reverseHalflimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, 0.085);
  }
  public void runMinlimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, -0.06);
  }

  public void reverseMinlimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, 0.06);
  }
  public void stoplimelightAimer()
  {
    limelightAimerMotor.set(ControlMode.PercentOutput, 0.0);
  }
  
  public void turnDriveRightQuick()
  {
    drivetrain1.drive.tankDrive(0.5, -0.5);
  }
  public void turnDriveLeftQuick()
  {
    drivetrain1.drive.tankDrive(-0.5, 0.5);
  }
  public void turnDriveRightMin()
  {
    drivetrain1.drive.tankDrive(0.3, -0.3);
  }
  public void turnDriveLeftMin()
  {
    drivetrain1.drive.tankDrive(-0.3, 0.3);
  }
  public void turnDriveRight()
  {
    drivetrain1.drive.tankDrive(0.4, -0.4);
  }
  public void turnDriveLeft()
  {
    drivetrain1.drive.tankDrive(-0.4, 0.4);
  }
  public void stopDrive()
  {
    drivetrain1.drive.tankDrive(0.0, 0.0);
  }
  
  @Override
  public void periodic() {
  }
}
