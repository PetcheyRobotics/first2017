/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5781.robot;

import org.usfirst.frc.team5781.robot.commands.OpenClawCommand;
import org.usfirst.frc.team5781.robot.commands.PinchCommand;
import org.usfirst.frc.team5781.robot.commands.PusherPushCommand;
import org.usfirst.frc.team5781.robot.commands.PusherRetractCommand;
import org.usfirst.frc.team5781.robot.commands.WinchCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */ public class OI {
	 
	 //public static final int X_AXIS= 0;
	 //public static final int Y_AXIS= 1;
	 //public static final int Z_TWIST_AXIS= 5;
	 public static final int THROTTLE_AXIS= 2;
	 
	public Joystick Driver = new Joystick(0);
	Button trigger = new JoystickButton(Driver, 1), //Trigger
			L1 = new JoystickButton(Driver, 2), //L1
			square = new JoystickButton(Driver, 5), //Square
			circle = new JoystickButton(Driver, 7), //O
			
			button3 = new JoystickButton(Driver, 3), //R3
			L3 = new JoystickButton(Driver, 4), //L3
			button6 = new JoystickButton(Driver, 6);//X
	public Button Triangle = new JoystickButton(Driver, 8); //Triangle
	
			
	
	
	public OI() {
		Driver.setThrottleChannel(THROTTLE_AXIS);
		//Driver.setZChannel(Z_TWIST_AXIS);
		//Driver.setXChannel(X_AXIS);
		//Driver.setYChannel(Y_AXIS);

		trigger.whenPressed(new PusherPushCommand());
		trigger.whenReleased(new PusherRetractCommand());
		
		square.whenPressed(new PinchCommand());
		circle.whenPressed(new OpenClawCommand());
		
		Triangle.whenPressed(new WinchCommand());

	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
