package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class TurnXDegreesCommand extends Command {
	
	int m_turnAngle;
	
	public TurnXDegreesCommand (int turnAngle) {
			m_turnAngle = turnAngle;
			requires(Robot.DriveTrainSub);
			requires(Robot.GyroSub);
		}

	protected void execute() {
		System.out.println("current angle="+Robot.GyroSub.getGyro().getAngle());
		Robot.DriveTrainSub.drive(0, (m_turnAngle>0)?0.5:-0.5);
	}

	protected boolean isFinished() {
		if(m_turnAngle>0)
			return Robot.GyroSub.getGyro().getAngle() >= m_turnAngle;
		else
			return Robot.GyroSub.getGyro().getAngle() <= (360+m_turnAngle);

	}

	protected void end() {
		Robot.DriveTrainSub.drive(0, 0);
	}

}
