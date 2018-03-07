package org.usfirst.frc.team5781.robot.subsystems;


import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *l
 */
public class WinchSubsystem extends Subsystem {
	
	Talon mController = new Talon(5);
	final static double SPEED = 0.5;
	
	
	public void move(double x) {
			mController.set(x);
	
	}
	
	public void stop() {
		mController.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}
