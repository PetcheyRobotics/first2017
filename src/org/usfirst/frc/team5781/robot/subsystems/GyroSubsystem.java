package org.usfirst.frc.team5781.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class GyroSubsystem extends Subsystem {
	
	Gyro m_gyro;
	public GyroSubsystem() {
		m_gyro =new AnalogGyro(1);
		
		m_gyro.reset();
		m_gyro.calibrate();
	}
	
	public Gyro getGyro() {
		return m_gyro;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

