# FRC 2020 Infinite Recharge Robot Code
**Team SOT2905** | *FIRST Robotics Competition*  
[![BSD 3-Clause License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](LICENSE)

## Project Overview
This repository contains the competition code for our 2020 FRC robot designed for the *Infinite Recharge* challenge. The codebase implements a command-based architecture with advanced vision processing using Limelight cameras.

### Key Features
- **Command-Based Architecture** with 15+ subsystem-specific commands
- **Autonomous Routines** for:
  - Shield Generator activation
  - Power Cell scoring
  - Color wheel manipulation
- **Vision Processing**:
  - Limelight-based target tracking
  - Reflective tape detection
  - Real-time distance estimation
- **Subsystem Modularization**:
  - Climb mechanism control
  - Precision shooting system
  - Intake management
  - Transport coordination

## Repository Structure
```
src/main/java/frc/robot/
├── commands
│ ├── automode/ # Autonomous routines
│ ├── climb/ # Climbing mechanisms
│ ├── drive/ # Drivetrain operations
│ ├── intake/ # Power Cell handling
│ ├── shoot/ # Shooting mechanisms
│ └── transport/ # Internal conveying
├── subsystems
│ ├── climb/ # Elevation controls
│ ├── drive/ # Drivebase functions
│ ├── intake/ # Collection systems
│ ├── shoot/ # Launch systems
│ └── transport/ # Internal movement
├── vision/ # Computer vision integration
│ ├── INetworkTablesTrackingCamera.java
│ └── Limelight.java
├── Constants.java # Tuning parameters
├── Main.java # Runing Robot.java
├── Robot.java # Main robot class
└── RobotContainer.java # Control bindings
```

## Dependencies
- WPILib v2020.3.2
- JDK 11
- Vendor Libraries:
  - CTRE Phoenix (v5.18.3)
  - REV Robotics (v1.12.0)
  - Limelight (v2.0.4)


## Autonomous Modes
| Command File | Purpose | Target Location |
|--------------|---------|-----------------|
| `driveStraight.java` | Baseline movement | Initiation line |
| `gearDefenceCommand.java` | Defense positioning | Trench Run |
| `limelightCommand.java` | Vision-aligned shooting | Power Port |

## Vision Processing
The Limelight integration uses HSV thresholding for reflective target detection:

## License
BSD 3-Clause License - See [LICENSE](LICENSE) file for details.  
**Important:** Maintain original FIRST copyright headers in all source files.

---

**Team SOT2905** - 2020 Season  
*FIRST® Robotics Competition - Infinite Recharge* 
