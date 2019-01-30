package frc.team4909.robot.sensors;
import frc.team4909.robot.Robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class PhotoElectricSensors {  // not sure if extends or implements
    public static DigitalInput frontLeftSensor,
                               frontRightSensor,     
                               backLeftSensor, 
                               backRightSensor;
    boolean state = false;
    boolean state2 = false;
    int stage = 0;
    public PhotoElectricSensors() {
        super();
        frontLeftSensor = new DigitalInput(0);
        backLeftSensor = new DigitalInput(1);
        backRightSensor = new DigitalInput(2);
        frontRightSensor = new DigitalInput(3);
    }


    public void lineFollow() { // This is to keep the robot moving straight on the line

      boolean left = backLeftSensor.get();
      boolean right = backRightSensor.get();

      // Should work no matter which side of the robot the cargo ship is on

          if (!left && right) { // back left is on line, back right is not on line
             // System.out.println(left + "  " + right + " off line to RIGHT");
              Robot.drivetrainsub.tankDrive(-0.3, -0.1);
          } 
          else if (left && !right) { // back right is on line, back left is not on line
             // System.out.println(left + "  " + right + " off line to LEFT");
              Robot.drivetrainsub.tankDrive(-0.1, -0.3);
          }
           else {
            //System.out.println(left + "  " + right + " ON LINE");
           // Robot.drivetrainsub.tankDrive(Robot.driverGamepad.getRawAxis(1), Robot.driverGamepad.getRawAxis(5));
           Robot.drivetrainsub.tankDrive(-0.2, -0.2);
          }
        }
}

    