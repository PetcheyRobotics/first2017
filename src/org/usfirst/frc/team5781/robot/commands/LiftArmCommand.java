package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class LiftArmCommand extends Command {
	long m_time;
	long m_endtime;
	public LiftArmCommand(long milliseconds) {
		requires(Robot.ArmSub);
		m_time = milliseconds;
	}
	
	protected void initialize() {
		long starttime=System.currentTimeMillis();
		m_endtime = starttime+m_time;
	}
	
 
	protected void execute() {
		
		Robot.ArmSub.move(0.5);
	}

	protected boolean isFinished() {
		return System.currentTimeMillis()>=m_endtime;
	}
  
	protected void end() {
		Robot.ArmSub.move(0);
	}
	protected void interrupted() { 
		end();
	}
  
}  
