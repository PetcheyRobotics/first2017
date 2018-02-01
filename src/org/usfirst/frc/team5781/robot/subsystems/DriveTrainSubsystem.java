/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5781.robot.subsystems;

import org.usfirst.frc.team5781.robot.RobotMap;
import org.usfirst.frc.team5781.robot.commands.*;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrainSubsystem extends Subsystem {
	Spark frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark;
	DifferentialDrive m_drive;
	
	public DriveTrainSubsystem()
	{
		System.out.print("Init drivetrainsubsystem");
		frontLeftSpark = new Spark(RobotMap.frontLeft) ;
		backLeftSpark = new Spark(RobotMap.backLeft) ;
		frontRightSpark = new Spark(RobotMap.frontRight) ; 
		backRightSpark = new Spark(RobotMap.backRight) ;
		SpeedControllerGroup m_left = new SpeedControllerGroup(frontLeftSpark, backLeftSpark);
		SpeedControllerGroup m_right = new SpeedControllerGroup(frontRightSpark, backRightSpark);
		m_drive = new DifferentialDrive(m_left, m_right);
	}
	
	public void drive(double x, double z)
	{
		System.out.print("drive called");
		m_drive.arcadeDrive( x, z, true);
	
	}
		
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		setDefaultCommand(new DriveTrainCommand());
		
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
