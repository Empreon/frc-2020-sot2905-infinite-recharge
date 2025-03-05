/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.*;

public class driveSystem extends SubsystemBase {
  public DifferentialDrive drive;

  public Joystick attack;

  public driveSystem(Joystick attack) {

    this.attack = attack;

    WPI_TalonSRX belowLeftMotor = new WPI_TalonSRX(Constants.Chasis.leftBelowId);
    WPI_TalonSRX belowRightMotor = new WPI_TalonSRX(Constants.Chasis.rightBelowId);
  
    /* Follower Talons + Victors for six motor drives */
    WPI_TalonSRX leftFrontSlave = new WPI_TalonSRX(Constants.Chasis.leftFrontId);
    WPI_TalonSRX rightFrontSlave = new WPI_TalonSRX(Constants.Chasis.rightFrontId);
    WPI_TalonSRX leftBackSlave = new WPI_TalonSRX(Constants.Chasis.leftBackId);
    WPI_TalonSRX rightBackSlave = new WPI_TalonSRX(Constants.Chasis.rightBackId);
    
    //Differantial Drive
    drive = new DifferentialDrive(belowLeftMotor, belowRightMotor);

    belowLeftMotor.configFactoryDefault();
		belowRightMotor.configFactoryDefault();
		leftFrontSlave.configFactoryDefault();
		rightFrontSlave.configFactoryDefault();
		leftBackSlave.configFactoryDefault();
    leftFrontSlave.configFactoryDefault();
    
    leftFrontSlave.follow(belowLeftMotor);
		leftBackSlave.follow(belowLeftMotor);
		rightFrontSlave.follow(belowRightMotor);
    rightBackSlave.follow(belowRightMotor);

    
		belowLeftMotor.setInverted(false);
		belowRightMotor.setInverted(true);
    leftFrontSlave.setInverted(InvertType.FollowMaster);
		rightFrontSlave.setInverted(InvertType.FollowMaster);
		leftBackSlave.setInverted(InvertType.FollowMaster);
    rightBackSlave.setInverted(InvertType.FollowMaster);

    // drive motors ramp values
    belowLeftMotor.configOpenloopRamp(0.25);
    belowRightMotor.configOpenloopRamp(0.25);
    leftFrontSlave.configOpenloopRamp(0.25);
    rightFrontSlave.configOpenloopRamp(0.25);
    leftBackSlave.configOpenloopRamp(0.25);
    rightBackSlave.configOpenloopRamp(0.25);

    drive.setRightSideInverted(false);
  }

  //AutoMode
  public void driveStraight() {

    drive.tankDrive(0.6, 0.6);
  }
  
  public void driveBack() {

    drive.tankDrive(-0.6, -0.6);
  }
    
  public void driveLeft() {

    drive.tankDrive(-0.6, 0.6);
  }
    
  public void driveRight() {

    drive.tankDrive(0.6, -0.6);
  }

  public void driveStop() {

    drive.tankDrive(0.0, 0.0);
  }

  @Override
  public void periodic() {
    drive.arcadeDrive(attack.getY(GenericHID.Hand.kLeft),
    attack.getX(GenericHID.Hand.kRight));
  }
}