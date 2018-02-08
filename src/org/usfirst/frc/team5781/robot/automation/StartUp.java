package org.usfirst.frc.team5781.robot.automation;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StartUp extends InstantCommand {

    public StartUp() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	DriverStation ds = DriverStation.getInstance();
    	switch(ds.getLocation()) {
	    	case 1:
	    		new PositionOne();
	    		break;
	    	case 2:
	    		new PositionTwo();
	    		break;
	    	case 3:
	    		new PositionThree();
	    		break;
			default:
				break;
	    }
    }

}
