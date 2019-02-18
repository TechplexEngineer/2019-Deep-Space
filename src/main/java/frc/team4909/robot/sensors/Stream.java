package frc.team4909.robot.sensors;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.*;
import frc.team4909.robot.operator.controllers.*;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.cameraserver.CameraServer;
//Init of Camera and Bandwidth control.
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;

public class Stream {

  boolean seeHatchCam = true;
  public void toggleCamera(){
      seeHatchCam = !seeHatchCam;
  }
  //Max Bandwidth: 4mbps, 1.6 for each camera.
  public Stream(){
    
  };
  public void streamCamera(){
    new Thread(() -> {
      //Cameras 3 and 4 have mutual toggle function.
      UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0); //Function: 
      UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1); //Function: 
      UsbCamera camera3 = CameraServer.getInstance().startAutomaticCapture(2); //Function: 
      UsbCamera camera4 = CameraServer.getInstance().startAutomaticCapture(3); //Function: 
      camera1.setResolution(160, 120);
      camera2.setResolution(160, 120);
      camera1.setFPS(14);
      camera2.setFPS(14);
      camera3.setResolution(160, 120);
      camera4.setResolution(160, 120);
      camera3.setFPS(14);
      camera4.setFPS(14);
      System.out.println(seeHatchCam);
      //VideoSink intakeServer = CameraServer.getInstance().getServer("Intake Cam");
      
      //CvSink cvSink1 = CameraServer.getInstance().getVideo();//CvSource outputStream = CameraServer.getInstance().putVideo("Source 1", 160, 120);//CvSink cvSink2 = CameraServer.getInstance().getVideo();//CvSource outputStream2 = CameraServer.getInstance().putVideo("Source 2", 160, 120);//CvSink cvSink3 = CameraServer.getInstance().getVideo();//CvSource outputStream3 = CameraServer.getInstance().putVideo("Source 3", 160, 120);//CvSink cvSink4 = CameraServer.getInstance().getVideo();//CvSource outputStream4 = CameraServer.getInstance().putVideo("Source 4", 160, 120);
      //Mat source1 = new Mat();//Mat source2 = new Mat();//Mat output1 = new Mat();//Mat output2 = new Mat();//Mat source3 = new Mat();//Mat source4 = new Mat();//Mat output3 = new Mat();//Mat output4 = new Mat();
      /*Mat image1 = new Mat(cvSink1.grabFrame(source1));int height1 = image1.rows();int length1 = image1.cols();MatOfPoint2f src = new MatOfPoint2f(new Point((1/6)*height1, 0),new Point((5/6)*height1,0),new Point(height1-1,length1-1),new Point(0,length1-1));
      MatOfPoint2f dst = new MatOfPoint2f(new Point(0, 0),new Point(height1-1,0),new Point(0,length1-1),new Point(height1-1,length1-1));Mat hatchWatchMatrix = Imgproc.getPerspectiveTransform(src, dst);*/
      
      while(!Thread.interrupted()) {
          if (seeHatchCam == true){
              //Show Camera for Hatches
              //intakeServer.setSource(new CvSink.grabFrame()); This is throwing an exception and interrupting the thread.
              System.out.println("lololooololol");
              NetworkTable nt = NetworkTableInstance.getDefault().getTable("");
              
          } else if (seeHatchCam == false) {
              //Show Cargo Intake Camera
              //intakeServer.setSource(camera4);
          }
          //cvSink1.grabFrame(source1);//Imgproc.warpPerspective(source1, output1, hatchWatchMatrix, new Size(height1, length1));//Imgproc.cvtColor(source1, output1, Imgproc.COLOR_BGR2HSV);//outputStream.putFrame(output1);//cvSink2.grabFrame(source2);//Imgproc.cvtColor(source2, output2, Imgproc.COLOR_BGR2HSV);//outputStream2.putFrame(output2);//cvSink3.grabFrame(source3);//Imgproc.cvtColor(source3, output3, Imgproc.COLOR_BGR2HSV);//outputStream3.putFrame(output3);//cvSink4.grabFrame(source4);//Imgproc.cvtColor(source4, output4, Imgproc.COLOR_BGR2HSV);//outputStream4.putFrame(output4);
  }
  }).start();
  }
}