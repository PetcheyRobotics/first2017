package org.usfirst.frc.team5781.robot.commands;

import org.usfirst.frc.team5781.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

public class LiftArm extends Command {
	   DigitalInput m_highLimit;
	   DigitalInput m_lowLimit;
	  
	public LiftArm () {
		m_highLimit = new DigitalInput(5);
		m_lowLimit = new DigitalInput(6);
		 requires (Robot.ArmSub);
		 
	}
    //     Robot.ArmSub.lift(Robot.OI.Driver.getz());
  //  }     
  protected boolean isFinished() {
	  return (m_highLimit.get() | m_lowLimit.get());
  }
  
  protected void end() {
	  //Robot.ArmSub.Lift(0);
	  
  }
  protected void interrupted() { 
	  end();
  }
  
}  
