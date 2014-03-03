/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author Samsung
 */
public class Clock {
    long startTime, elapsed, delayTime;
    public Clock(){
    }
    
    public void delay(int seconds){
        delayTime = seconds*1000;
        startTime = System.currentTimeMillis();
        do {
            elapsed = System.currentTimeMillis()-startTime;
        }   while(elapsed<delayTime);
    }
}
