package org.usfirst.frc.team5781.robot.subsystems;

import org.usfirst.frc.team5781.robot.commands.PusherRetractedAtStart;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PusherSubsystem extends Subsystem {
	
	DoubleSolenoid mPusher = new DoubleSolenoid(1,2);
	
	public void push() {
		mPusher.set(DoubleSolenoid.Value.kForward); 
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void retract() {
		mPusher.set(DoubleSolenoid.Value.kReverse);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new PusherRetractedAtStart());
		// TODO Auto-generated method stub
		
	}
}

