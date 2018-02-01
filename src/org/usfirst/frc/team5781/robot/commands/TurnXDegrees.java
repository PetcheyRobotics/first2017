package org.usfirst.frc.team5781.robot.commands;




public class TurnXDegrees extends Command {
	
		int m_turnAngle;
		Gyro m_gyro
	
	public TurnXDegrees (int turnAngle) {
			m_turnAngle = turnAngle;
			m_gyro =new AnalogGyro(1);
			requires(Robot.DriveTrainSub);
		}
	protected void intitialize() {
		Robot.gyro.reset();
	}
	
	protected void execute() {
		Robot.DriveTrainSub.drive(0, (m_turnAngle>0))?0.5:-0.5);
	}
	
execute()
	protected boolean isFinished() {
		if(turnAngle>0)
			return Robot.gyro.getAngle() >= turnAngle;
		else
			return Robot.gyro.getAngle() <= (360+turnAngle);

	}

	protected void end() {
		Robot.DriveTrainSub.drive(0, 0);
	}
}
