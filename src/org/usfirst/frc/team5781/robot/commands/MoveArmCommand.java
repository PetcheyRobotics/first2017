package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class MoveArmCommand extends Command {
	long m_time;
	long m_endtime;
	private double mAmount;
	
	public MoveArmCommand(long milliseconds, double amount) {
		requires(Robot.ArmSub);
		m_time = milliseconds;
		mAmount = amount;
	}
	
	protected void initialize() {
		long starttime=System.currentTimeMillis();
		m_endtime = starttime+m_time;
	}
	
 
	protected void execute() {
		System.out.println("m_amount="+mAmount);
		
		Robot.ArmSub.move(mAmount);
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
