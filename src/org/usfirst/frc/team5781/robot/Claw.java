import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1.robot.RobotMap;

public class Claw extends Subsystem {

    Victor motor = RobotMap.clawMotor;

    public void initDefaultCommand() {
    }

    public void open() {
        motor.set(1);
    }

    public void close() {
        motor.set(-1);
    }

    public void stop() {
        motor.set(0);
    }
}
