/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot;

//Wpilib
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

//Commands
import frc.robot.commands.automode.autonomousCommand;
import frc.robot.commands.climb.climbCommand;
import frc.robot.commands.climb.climbReCommand;
import frc.robot.commands.climb.liftCommand;
import frc.robot.commands.climb.liftReCommand;
import frc.robot.commands.drive.gearDefenceCommand;
import frc.robot.commands.drive.gearSpeedCommand;
import frc.robot.commands.intake.intakeCommand;
import frc.robot.commands.intake.intakeDownCommand;
import frc.robot.commands.intake.intakeReCommand;
import frc.robot.commands.intake.intakeUpCommand;
import frc.robot.commands.shoot.aimerCommand;
import frc.robot.commands.shoot.aimerReCommand;
import frc.robot.commands.shoot.limelightCommand;
import frc.robot.commands.shoot.shootCommand;
import frc.robot.commands.shoot.shootMaxCommand;
import frc.robot.commands.shoot.shootMinCommand;
import frc.robot.commands.transport.transportCommand;
import frc.robot.commands.transport.transportReCommand;
import frc.robot.commands.transport.transportShootCommand;
//Subststems
import frc.robot.subsystems.climb.climbSystem;
import frc.robot.subsystems.climb.liftSystem;
import frc.robot.subsystems.drive.driveSystem;
import frc.robot.subsystems.drive.gearSystem;
import frc.robot.subsystems.intake.intakeLiftSystem;
import frc.robot.subsystems.intake.intakeSystem;
import frc.robot.subsystems.shoot.limelightAimerSystem;
import frc.robot.subsystems.shoot.shootSystem;
import frc.robot.subsystems.transport.transportSystem;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class RobotContainer {

  //Joystick
  public Joystick attack = new Joystick(Constants.Joystick.attack3Port);
  public XboxController gamepad;

  //Button
  public JoystickButton climbButton;
  public JoystickButton liftButton;
  public JoystickButton climbReButton;
  public JoystickButton liftReButton;

  public JoystickButton intakeButton;
  public JoystickButton intakeReButton;
  public JoystickButton intakeLiftUpButton;
  public JoystickButton intakeLiftDownButton;

  public JoystickButton transportButton;
  public JoystickButton transportReButton;
  public JoystickButton transportShootButton;

  public JoystickButton blueDetectButton;
  public JoystickButton greenDetectButton;
  public JoystickButton redDetectButton;
  public JoystickButton yellowDetectButton;
  public JoystickButton discTurnerButton;
  public JoystickButton colorDetectliftOnButton;
  public JoystickButton colorDetectliftOffButton;
 
  public JoystickButton shootButton;
  public JoystickButton shootmaxButton;
  public JoystickButton shootminButton;
  public JoystickButton limelightButton;

  public JoystickButton gearSpeedButton;
  public JoystickButton gearDefenceButton;

  //POVbutton
  public POVButton aimerUpPovButton;
  public POVButton aimerDownPovButton;

  //Climb
  private final climbSystem climbsystem = new climbSystem();

  private final climbCommand climbcommand = new climbCommand(climbsystem);
  private final climbReCommand climbrecommand = new climbReCommand(climbsystem);

  //Intake
  private final intakeSystem intakesystem = new intakeSystem();

  private final intakeCommand intakecommand = new intakeCommand(intakesystem);
  private final intakeReCommand intakerecommand = new intakeReCommand(intakesystem);

  //IntakeLift
  private final intakeLiftSystem intakeliftsystem = new intakeLiftSystem();

  private final intakeUpCommand intakeupcommand = new intakeUpCommand(intakeliftsystem);
  private final intakeDownCommand intakedowncommand = new intakeDownCommand(intakeliftsystem);

  //Transport
  private final transportSystem transportsystem = new transportSystem();

  private final transportCommand transportcommand = new transportCommand(transportsystem);
  private final transportReCommand transportrecommand = new transportReCommand(transportsystem);  
  private final transportShootCommand transportshootcommand = new transportShootCommand(transportsystem);

  //DriveTrain
  private final driveSystem drivetrain = new driveSystem(attack);

  //Gear
  private final gearSystem gearsystem = new gearSystem();

  private final gearDefenceCommand geardefencecommand = new gearDefenceCommand(gearsystem);
  private final gearSpeedCommand gearspeedcommand = new gearSpeedCommand(gearsystem);

  //Lift
  private final liftSystem liftsystem = new liftSystem();

  private final liftCommand liftcommand = new liftCommand(liftsystem);
  private final liftReCommand liftrecommand = new liftReCommand(liftsystem);

  //Shoot
  private final shootSystem shootsystem = new shootSystem();

  private final shootCommand shootcommand = new shootCommand(shootsystem);
  private final shootMaxCommand shootmaxcommand = new shootMaxCommand(shootsystem);
  private final shootMinCommand shootmincommand = new shootMinCommand(shootsystem);

  //Limelight
  private final limelightAimerSystem limelightaimersystem = new limelightAimerSystem();

  private final limelightCommand limelightcommand = new limelightCommand(limelightaimersystem);

  private final aimerCommand aimercommand = new aimerCommand(limelightaimersystem);
  private final aimerReCommand aimerrecommand = new aimerReCommand(limelightaimersystem);

  //Automode
  private final Command autonomouscommand = new autonomousCommand(drivetrain, intakeliftsystem, intakesystem, transportsystem, limelightaimersystem, shootsystem);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
  public RobotContainer() {
    
    //Joystick
    gamepad = new XboxController(Constants.Joystick.gamepadPort);

    //DriveTrain
    CommandScheduler.getInstance().registerSubsystem(drivetrain);

    //Gear
    gearSpeedButton = new JoystickButton(attack, Constants.Button.gearspeedbutton_attack);
    gearDefenceButton = new JoystickButton(attack, Constants.Button.geardefencebutton_attack);

    //Climb
    climbButton = new JoystickButton(attack, Constants.Button.climbbutton_attack);
    climbReButton = new JoystickButton(attack, Constants.Button.climbrebutton_attack);

    //Intake
    intakeButton = new JoystickButton(attack, Constants.Button.intakebutton_attack);
    intakeReButton = new JoystickButton(attack, Constants.Button.intakerebutton_attack);

    //IntakeLift
    intakeLiftUpButton = new JoystickButton(attack, Constants.Button.intakeliftupbutton_attack);
    intakeLiftDownButton = new JoystickButton(attack, Constants.Button.intakeliftdownbutton_attack);

    //Tranport
    transportButton = new JoystickButton(gamepad, Constants.Button.transportbutton_gamepad);
    transportReButton = new JoystickButton(gamepad, Constants.Button.transportrebutton_gamepad);
    transportShootButton = new JoystickButton(gamepad, Constants.Button.transportshootbutton_gamepad);

    //Lift
    liftButton = new JoystickButton(attack, Constants.Button.liftbutton_attack);
    liftReButton = new JoystickButton(attack, Constants.Button.liftrebutton_attack);

    //Shoot
    shootButton = new JoystickButton(gamepad, Constants.Button.shootbutton_gamepad);
    shootmaxButton = new JoystickButton(gamepad, Constants.Button.shootmaxbutton_gamepad);
    shootminButton = new JoystickButton(gamepad, Constants.Button.shootminbutton_gamepad);

    //Limelight
    limelightButton = new JoystickButton(gamepad, Constants.Button.limelightbutton_gamepad);

    aimerUpPovButton = new POVButton(gamepad, Constants.POVbutton.aimerupangle_gamepad);
    aimerDownPovButton = new POVButton(gamepad, Constants.POVbutton.aimerdownangle_gamepad);
        
    //Default
    configureButtonBindings();
  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  private void configureButtonBindings() {
    //DriveTrain
    CommandScheduler.getInstance().schedule(new RunCommand(() -> drivetrain.drive.arcadeDrive(
      attack.getY(GenericHID.Hand.kLeft),
      attack.getX(GenericHID.Hand.kLeft)),
      drivetrain));
    gearSpeedButton.whenPressed(gearspeedcommand);
    gearDefenceButton.whenPressed(geardefencecommand);

    //Climb
    climbButton.whileActiveContinuous(climbcommand);
    climbReButton.whileActiveContinuous(climbrecommand);
    liftButton.whileActiveContinuous(liftcommand);
    liftReButton.whileActiveContinuous(liftrecommand);

    //Intake
    intakeButton.whileActiveContinuous(intakecommand);
    intakeReButton.whileActiveContinuous(intakerecommand);
    intakeLiftUpButton.whenPressed(intakeupcommand);
    intakeLiftDownButton.whenPressed(intakedowncommand);

    //Transport
    transportButton.whileActiveContinuous(transportcommand);
    transportReButton.whileActiveContinuous(transportrecommand);
    transportShootButton.whileActiveContinuous(transportshootcommand);

    //Shoot
    shootButton.whileActiveContinuous(shootcommand);
    shootmaxButton.whileActiveContinuous(shootmaxcommand);
    shootminButton.whileActiveContinuous(shootmincommand);
    limelightButton.whileActiveContinuous(limelightcommand);

    aimerUpPovButton.whileActiveContinuous(aimercommand);
    aimerDownPovButton.whileActiveContinuous(aimerrecommand);

  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public Command getAutonomousCommand() {
    return autonomouscommand;
  }
}
