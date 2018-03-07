package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
/**
 *l
 */
public class WinchCommand extends Command {

    public WinchCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.WinchSub);
 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.WinchSub.move(-0.8);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//remember to add when its finished
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
