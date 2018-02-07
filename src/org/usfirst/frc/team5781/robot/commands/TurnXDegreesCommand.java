package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class TurnXDegreesCommand extends Command {
	
		int m_turnAngle;
		Gyro m_gyro;
	
	public TurnXDegreesCommand (int turnAngle) {
			m_turnAngle = turnAngle;
			m_gyro =new AnalogGyro(1);
			requires(Robot.DriveTrainSub);
		}
	protected void intitialize() {
		m_gyro.reset();
	}
	
	protected void execute() {
		Robot.DriveTrainSub.drive(0, (m_turnAngle>0)?0.5:-0.5);
	}

	protected boolean isFinished() {
		if(m_turnAngle>0)
			return m_gyro.getAngle() >= m_turnAngle;
		else
			return m_gyro.getAngle() <= (360+m_turnAngle);

	}

	protected void end() {
		Robot.DriveTrainSub.drive(0, 0);
	}

}
