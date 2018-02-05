package org.usfirst.frc.team5781.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	
	Talon mController = new Talon(4);
	
	public void moveUp() {
		mController.setPosition(1);
	}
	
	public void moveDown() {
		mController.setPosition(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

