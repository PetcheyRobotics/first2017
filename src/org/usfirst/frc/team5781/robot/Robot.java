package org.usfirst.frc.team5781.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;

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
	// Create a robot drive object using PWMs 1, 2, 3 and 4
	RobotDrive m_robotDrive = new RobotDrive(1, 2, 3, 4);

	// Define joystick being used at USB port 1 on the Driver Station
	Joystick m_driveStick = new Joystick(1);

	// Create a special gyro controller object
	ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();

	// Keeps track of time state was entered
	Timer m_autonStateTimer;

	// List of possible states
	enum AutonState {
		AUTON_STATE_FORWARD, AUTON_STATE_BACKWARD, AUTON_STATE_LEFT, AUTON_STATE_RIGHT, AUTON_STATE_FORWARD_LEFT, AUTON_STATE_BACKWARD_RIGHT, AUTON_STATE_FORWARD_RIGHT, AUTON_STATE_BACKWARD_LEFT, AUTON_STATE_CLOCKWISE, AUTON_STATE_ANTI_CLOCKWISE, AUTON_STATE_FORWARD_CLOCKWISE, AUTON_STATE_BACKWARD_ANTI_CLOCKWISE, AUTON_STATE_END
	}

	AutonState m_autonState;

	void changeAutonState(AutonState newState) {
		if (newState != m_autonState) {
			m_autonState = newState;
			m_autonStateTimer.reset();
		}
	}

	public void autonomousInit() {
		m_autonState = AutonState.AUTON_STATE_FORWARD;
		m_autonStateTimer = new Timer();
		m_autonStateTimer.start();

	}

	void doOperation(double x, double y, double z, AutonState nextState) {
		doOperation(x, y, z, nextState, 0);
	}

	void doOperation(double x, double y, double z, AutonState nextState, double gyroAngle) {
		double adj=0.5;
		m_robotDrive.mecanumDrive_Cartesian(x*adj, y*adj, z*adj, gyroAngle);
		if (m_autonStateTimer.hasPeriodPassed(2.0)) {
			changeAutonState(nextState);
		}
	}

	public void autonomousPeriodic() {
		switch (m_autonState) {
		case AUTON_STATE_FORWARD: {
			doOperation(0, -1, 0, AutonState.AUTON_STATE_BACKWARD);
			break;
		}
		case AUTON_STATE_BACKWARD: {
			doOperation(0, 1, 0, AutonState.AUTON_STATE_LEFT);
			break;
		}
		case AUTON_STATE_LEFT: {
			doOperation(-1, 0, 0, AutonState.AUTON_STATE_RIGHT);
			break;
		}
		case AUTON_STATE_RIGHT: {
			doOperation(1, 0, 0, AutonState.AUTON_STATE_FORWARD_LEFT);
			break;
		}
		case AUTON_STATE_FORWARD_LEFT: {
			doOperation(-1, -1, 0, AutonState.AUTON_STATE_BACKWARD_RIGHT);
			break;
		}
		case AUTON_STATE_BACKWARD_RIGHT: {
			doOperation(1, 1, 0, AutonState.AUTON_STATE_FORWARD_RIGHT);
			break;
		}
		case AUTON_STATE_FORWARD_RIGHT: {
			doOperation(1, -1, 0, AutonState.AUTON_STATE_BACKWARD_LEFT);
			break;
		}
		case AUTON_STATE_BACKWARD_LEFT: {
			doOperation(-1, 1, 0, AutonState.AUTON_STATE_CLOCKWISE);
			break;
		}
		case AUTON_STATE_CLOCKWISE: {
			doOperation(0, 0, 1, AutonState.AUTON_STATE_ANTI_CLOCKWISE);
			break;
		}
		case AUTON_STATE_ANTI_CLOCKWISE: {
			doOperation(0, 0, -1, AutonState.AUTON_STATE_FORWARD_CLOCKWISE);
			break;
		}
		case AUTON_STATE_FORWARD_CLOCKWISE: {
			doOperation(0, -1, 1, AutonState.AUTON_STATE_BACKWARD_ANTI_CLOCKWISE, m_gyro.getAngle());
			break;
		}
		case AUTON_STATE_BACKWARD_ANTI_CLOCKWISE: {
			doOperation(0, 1, -1, AutonState.AUTON_STATE_END, m_gyro.getAngle());
			break;
		}
		case AUTON_STATE_END:
			break;
		}
	}

	public void robotInit() {
		// Set the gyro controller to zero on init.
		m_gyro.reset();
	}

	public void teleopPeriodic() {
		double x = m_driveStick.getX();
		x = x * abs(x);
		double y = m_driveStick.getY();
		y = y * abs(y);
		
		m_robotDrive.mecanumDrive_Cartesian(x, y, m_driveStick.getTwist(),
				m_gyro.getAngle());
	}
}
