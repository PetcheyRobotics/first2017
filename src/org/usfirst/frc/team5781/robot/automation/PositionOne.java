package org.usfirst.frc.team5781.robot.automation;

import org.usfirst.frc.team5781.robot.RobotMap;
import org.usfirst.frc.team5781.robot.commands.DriveStraight;
import org.usfirst.frc.team5781.robot.commands.MoveArmCommand;
import org.usfirst.frc.team5781.robot.commands.OpenClawCommand;
import org.usfirst.frc.team5781.robot.commands.PinchCommand;
import org.usfirst.frc.team5781.robot.commands.Turn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PositionOne extends CommandGroup {
	

    public PositionOne() {
    	
    	System.out.println("Running position one");
    	addSequential(new PinchCommand());
    	addParallel(new MoveArmCommand(RobotMap.OneSecond, RobotMap.drivePower)); 
    	addSequential(new DriveStraight(-1*RobotMap.drivePower, RobotMap.fourSeconds));
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println("gamedata="+gameData);
    	if(gameData.length() > 0) {
    		if(gameData.charAt(0) == 'L') {
    			System.out.println("Turning");
    	    	addSequential(new Turn(-1*RobotMap.turnPower, RobotMap.ninetyDegrees));
    	    	addSequential(new DriveStraight(-1*RobotMap.turnPower, RobotMap.OneSecond));
    	    	addSequential(new OpenClawCommand());
    			
    		}
    	}
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
