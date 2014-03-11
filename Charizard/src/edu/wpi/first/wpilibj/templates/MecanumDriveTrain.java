/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.RobotDrive;


/**
 *
 * @author Kyle
 */
public class MecanumDriveTrain implements Runnable{
    int pwm1, pwm2, pwm3, pwm4;
    boolean inversion, activeGyro, invertForward;
    private RobotDrive driveTrain;
    boolean foo;
    double threshold = 0.5;
    
    public MecanumDriveTrain(int pwm1, int pwm2, int pwm3, int pwm4, boolean inversion, boolean activeGyro, boolean invertForward) {
        driveTrain = new RobotDrive(pwm1, pwm2, pwm3, pwm4);
        foo = inversion;
    }
    public void start(double s) {}
    
    public void drive(double x, double y, double rotation, double gyro){ 
        rotation = this.desensitizeTwist(rotation);
        if (invertForward) {
            rotation *= -1;
        }
        if (!activeGyro) {
            gyro = 0;
        }
        driveTrain.mecanumDrive_Cartesian(x, y, rotation, gyro);
    }
    public void stop() {
        this.drive(0,0,0,0);
    }
    
    private double desensitizeTwist(double rot){
        if (Math.abs(rot) < threshold) {
            rot = 0;
        } else if (rot > 0) {
            rot -= threshold;
        } else {
            rot += threshold;
        }
        return rot;
    }
    
    public void setup() {
        if(foo) {
            driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
            driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        }
    }
}
