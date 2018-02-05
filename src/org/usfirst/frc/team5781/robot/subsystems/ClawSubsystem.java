package org.usfirst.frc.team5781.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubsystem extends Subsystem {
	
	DoubleSolenoid claw = new DoubleSolenoid(1,1);
	
	public void openClaw() {
		claw.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void closeClaw() {
		claw.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stop() {
		claw.set(DoubleSolenoid.Value.kOff);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

