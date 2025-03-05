/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Modified by Team 2905 Sultans of Türkiye (2020) for INFINITE RECHARGE competition.

package frc.robot;

public final class Constants {

////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public final class Chasis{
        
        //Left Motor
        public static final int leftFrontId = 10;
        public static final int leftBackId = 9;
        public static final int leftBelowId = 11;

        //Right Motor
        public static final int rightFrontId = 7;
        public static final int rightBackId = 6;
        public static final int rightBelowId = 8;

        //Pneumatics
        public static final int gearChangePort1 = 6;
        public static final int gearChangePort2 = 7;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final class Intake{

        //Motor
        public static final int intakeMotorId = 1;

        //Pneumatics
        public static final int intakePneumaticsPort1 = 4;
        public static final int intakePneumaticsPort2 = 5;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public final class Climb{

        //Motor
        public static final int climbId = 2;
        public static final int liftPort = 1;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final class Shoot{

        //Motor
        public static final int shootAimerId = 5;
        public static final int shootPort = 0;
        public static final int shootPort2 = 2;
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public final class Transport{

        //Motor
        public static final int transportId = 3;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////      
    public final class Joystick{

        //Joystick
        public static final int gamepadPort = 0;
        public static final int attack3Port = 1;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public final class Button{

        //Chasis
        public static final int gearspeedbutton_attack = 3;
        public static final int geardefencebutton_attack = 2;

        //Climb
        public static final int climbbutton_attack = 6;
        public static final int liftbutton_attack = 10;
        public static final int climbrebutton_attack = 7; 
        public static final int liftrebutton_attack = 11; //Emergency

        //Intake
        public static final int intakebutton_attack = 1;
        public static final int intakerebutton_attack = 9; //Emergency
        public static final int intakeliftupbutton_attack = 4;
        public static final int intakeliftdownbutton_attack = 5;

        //Transport
        public static final int transportbutton_gamepad = 7;
        public static final int transportrebutton_gamepad = 12; //Emergency
        public static final int transportshootbutton_gamepad = 2;

        //Shoot
        public static final int shootbutton_gamepad = 5;
        public static final int shootmaxbutton_gamepad = 11;
        public static final int limelightbutton_gamepad = 8;
        public static final int shootminbutton_gamepad = 4;
    }   

////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public final class POVbutton {

        public static final int aimerupangle_gamepad = 0;
        public static final int aimerdownangle_gamepad = 180;
    }
}