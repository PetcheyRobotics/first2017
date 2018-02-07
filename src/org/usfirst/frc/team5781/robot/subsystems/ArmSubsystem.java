package org.usfirst.frc.team5781.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	
	Talon mController = new Talon(4);
	final static double SPEED = 0.5;
	
	 DigitalInput m_highLimit = new DigitalInput(5);
	 DigitalInput m_lowLimit = new DigitalInput(6);
	
	public void moveUp() {
		if (!isTop())
		{
			mController.setPosition(1);
		}
	}
	
	public void moveDown() {
		if (!isBot())
		{
			mController.setPosition(0);
		}
	}
	
	public boolean isTop() {
		return m_highLimit.get();
		
	}
	
	public boolean isBot() {
		return m_lowLimit.get();
	}
	
	public void MoveDownLittle() {
		mController.setSpeed(SPEED);
	}
	
	public void MoveUpLittle() {
		mController.setSpeed(-SPEED);
	}
	public void stop() {
		mController.stopMotor();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
