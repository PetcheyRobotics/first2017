package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public abstract class ArmLittleBase extends Command {
	boolean isDone;
	Timer timer;
	static private double timeSpan = 1.0;
	
	
    public ArmLittleBase() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ArmSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isDone = false; 
    	timer.start();
    
    }

    public abstract void moveALittle();
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(! isDone ) {     		
    		moveALittle();
	    	if(Robot.ArmSub.isBot() ||
	    	   Robot.ArmSub.isTop() || 
	    	   timer.hasPeriodPassed(timeSpan))
	    		isDone = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ArmSub.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	isDone = true;
    }
}



