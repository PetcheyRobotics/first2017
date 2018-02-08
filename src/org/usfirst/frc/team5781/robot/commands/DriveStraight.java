package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	protected double power;
	protected long time;
	protected long endTime;
    
	public DriveStraight(double power, long timeInMillis) {
		this.power = power;
		this.time = timeInMillis;
		requires(Robot.DriveTrainSub);
	}
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    // Called just before this Command runs the first time
    protected void initialize() {
    	long startTime = System.currentTimeMillis();
    	endTime = startTime + this.time; 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DriveTrainSub.drive(power, 0);
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() >= endTime;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DriveTrainSub.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
