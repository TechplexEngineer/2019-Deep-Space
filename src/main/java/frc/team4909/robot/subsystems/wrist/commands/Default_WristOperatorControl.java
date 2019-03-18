package frc.team4909.robot.subsystems.wrist.commands;

import frc.team4909.robot.Robot;
import frc.team4909.robot.RobotConstants;
import frc.team4909.robot.operator.controllers.BionicF310;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Default_WristOperatorControl extends Command {

    public Default_WristOperatorControl() {
        requires(Robot.wristSubsystem);
        SmartDashboard.putString("Wrist - Status", "Constructor");
    }

    @Override
    public void execute() {
        // Sets speed to manipulator gamepad right Y stick value
        double moveSpeed = -Robot.manipulatorGamepad.getThresholdAxis(BionicF310.RY)
                * RobotConstants.elevatorArmSpeedMultiplier;

        if (moveSpeed == 0) { // If Y-stick value is not moving, HOLD position
            SmartDashboard.putString("Wrist - Status", "Hold");
            Robot.wristSubsystem.setPosition(Robot.wristSubsystem.holdingPosition);
        } else { // Set speed to Y-stick value and HOLD position
            SmartDashboard.putString("Wrist - Status", "Move");
            Robot.wristSubsystem.elevatorArmSetSpeed(moveSpeed);
            Robot.wristSubsystem.holdingPosition = Robot.wristSubsystem.getPosition();
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void interrupted() {
        SmartDashboard.putString("Wrist - Status", "Interrupted");
    }

}