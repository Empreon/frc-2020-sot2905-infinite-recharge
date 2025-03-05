/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shoot.limelightAimerSystem;
import frc.robot.vision.Limelight;
import frc.robot.vision.Limelight.LightMode;


public class limelightCommand extends CommandBase {
  
  private final limelightAimerSystem aimerSystem;
  private final Limelight limelight = new Limelight();
  
  public limelightCommand(limelightAimerSystem aimersubsystem) {
    
    aimerSystem = aimersubsystem;

    addRequirements(aimerSystem);
  }

  @Override
  public void initialize() {
    limelight.setLights(LightMode.ON);
    limelight.setDriverMode(false);
  }

  @Override
  public void execute() {
    double x = limelight.getX();
    double y = limelight.getY();

    String Target, Atis;

    if (x >= 4.0){
      aimerSystem.turnDriveRightQuick();
      Atis = "ETME";
    } else if (x <= -4.0){
      aimerSystem.turnDriveLeftQuick();
      Atis = "ETME";
    } else if (x > -4.0 && x <= -2.0){
      aimerSystem.turnDriveLeft();
      Atis = "ETME";
    } else if (x < 4.0 && x >= 2.0){
      aimerSystem.turnDriveRight();
      Atis = "ETME";
    } else if (x > -2.0 && x <= -0.1){
      aimerSystem.turnDriveLeftMin();
      Atis = "ETME";
    } else if (x < 2.0 && x >= 0.1){
      aimerSystem.turnDriveRightMin();
      Atis = "ETME";
    } else{
      aimerSystem.stopDrive();
    }

    if (y >= 4.0){
      aimerSystem.reverseFulllimelightAimer();
    } else if (y <=  -4.0 ){
      aimerSystem.runFulllimelightAimer();
    } else if(y < 4.0 && y >= 3.0){
      aimerSystem.reverseFulllimelightAimer();
    } else if (y > -4.0 && y <= -3.0){
      aimerSystem.runFulllimelightAimer();
    } else if (y < 3.0 && y >= 1.0){
      aimerSystem.reverseHalflimelightAimer();
    } else if (y > -3.0 && y <= -1.0) {
      aimerSystem.runHalflimelightAimer();
    } else if (y < 1.0 && y >= 0.1) {
      aimerSystem.reverseMinlimelightAimer();
    } else if (y > -1.0 && y <= -0.1){
      aimerSystem.runMinlimelightAimer();
    } else {
      aimerSystem.stoplimelightAimer();
    }
    
    if ((x < 0.3) && (x > -0.3) && (y < 0.3) && (y > -0.3)){
      Atis = "SERBEST";
    } else{
      Atis = "ETME";
    }

    if (limelight.getV() == true){
      Target = "VAR";
    } else {
      Target = "YOK";
    }
    SmartDashboard.putString("Hedef", Target);
    SmartDashboard.putString("ATES", Atis);
  }

  @Override
  public void end(boolean interrupted) {
    limelight.setLights(LightMode.OFF);
    limelight.setDriverMode(true);
    aimerSystem.stopDrive();
    aimerSystem.stoplimelightAimer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}