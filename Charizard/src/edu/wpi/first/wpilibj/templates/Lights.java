/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Jonathan
 */
public class Lights {
    private Relay lightSpike; 
    
    boolean pre = false; 
    boolean lightState;
    
    public Lights(int pwm){
        lightSpike = new Relay(pwm);
    }
    
    public void setLight(boolean oButton){
        if(oButton && !pre){
            if(lightState){
                lightState = false;
                lightSpike.set(Relay.Value.kOff);
            } else {
                lightState = true;
                lightSpike.set(Relay.Value.kForward);
            }
        }
        pre = oButton;
    }
}
