/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author PyroTech
 */
public class RunnableMotors implements Runnable{
    Jaguar motor1;
    Jaguar motor2;
    Jaguar motor3;
    Jaguar motor4;
    public RunnableMotors(int pwm) {
        motor1 = new Jaguar(pwm);
        motor2 = new Jaguar(pwm+1);
        motor3 = new Jaguar(pwm+2);
        motor4 = new Jaguar(pwm+3);
    }
    
    public void start(double s) {
        this.setMotors(s);
    }
    public void stop() {
        this.setMotors(0);
    }
    
    public void setMotors(double speed) {
        motor1.set(speed);
        motor2.set(speed);
        motor3.set(-speed);
        motor4.set(-speed);
    }
}
