package org.usfirst.frc.team5781.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
 
/*
 * Simplest program to drive a robot with mecanum drive using a single Logitech
 * Extreme 3D Pro joystick and 4 drive motors connected as follows:
 *   - Digital Sidecar 1:
 *     - PWM 1 - Connected to front left drive motor
 *     - PWM 2 - Connected to rear left drive motor
 *     - PWM 3 - Connected to front right drive motor
 *     - PWM 4 - Connected to rear right drive motor
 */

public class Robot extends IterativeRobot {

	Spark m_frontLeft = new Spark(1);
	Spark m_rearLeft = new Spark(2);
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	Spark m_frontRight = new Spark(3);
	Spark m_rearRight = new Spark(4);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

	DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);


	// Define joystick being used at USB port 1 on the Driver Station
	Joystick m_driveStick = new Joystick(1);

	// Create a special gyro controller object
	ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();

	// Keeps track of time state was entered
	Timer m_autonStateTimer;

	DoubleSolenoid m_dsol = new DoubleSolenoid(0, 1);

	public void autonomousInit() {
		m_autonStateTimer = new Timer();
		m_autonStateTimer.start();

	}


	//To Be Filled with Periodic Stuff
	public void autonomousPeriodic() {		
	}

	public void robotInit() {
		// Set the gyro controller to zero on init.
		m_gyro.reset();
	}
	
	public double dumpInput(double x) {
		if( x < 0.1 && x > -0.1 ) {
			return 0;
		}
		
		int sign;
		if( x < 0 ) {
			sign = -1;
		}
		else {
			sign =1;
		}
		
		x = 0.9*x + (0.1 * sign); 
		x = x * Math.abs(x);
		return x;
	}

	public void teleopPeriodic() {
		joystickDrive();
		joystickButtons();
	}

	public void joystickDrive() {
		double x = dumpInput( m_driveStick.getX() );
		double y = dumpInput( m_driveStick.getY() );
		double z = dumpInput( m_driveStick.getTwist() );

		double leftSpeed = 0;
		double rightSpeed = 0;
		
		if(z != 0) {
			leftSpeed = -z;
			rightSpeed = z;
		}
		else if(y != 0) {
			leftSpeed = y;
			rightSpeed = y;				
		}

		m_drive.tankDrive( leftSpeed, rightSpeed );
	}

			
	public void joystickButtons() {
		boolean triggerPressed = m_driveStick.getTrigger();
		if(m_driveStick.getTrigger()){
			m_dsol.set(DoubleSolenoid.Value.kForward);
		}else{
			m_dsol.set(DoubleSolenoid.Value.kReverse);
		}
	}		

}
