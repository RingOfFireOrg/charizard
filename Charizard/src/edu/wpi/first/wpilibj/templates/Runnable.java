/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author PyroTech
 */
public interface Runnable {
    
    public void start(double s); 
    
    public void drive(double x, double y, double z, double gyro);
    
    public void stop(); 
          
}
