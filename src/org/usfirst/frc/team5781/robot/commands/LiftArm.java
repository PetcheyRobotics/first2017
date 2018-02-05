package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class LiftArm extends Command {
	public LiftArm() {
		requires(Robot.ArmSub);
	}
    //     Robot.ArmSub.lift(Robot.OI.Driver.getz());
  //  }     
	
 
	protected void execute() {
		Robot.ArmSub.moveUp();
	}

	protected boolean isFinished() {
		return Robot.ArmSub.isTop();
	}
  
	protected void end() {
	  
	}
	protected void interrupted() { 
		end();
	}
  
}  
