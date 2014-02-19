/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;

/**
 *
 * @author Kyle
 */
public class SuperCompressor {
    int compressorPwm, switchPwm;
    private Compressor compressor;
    boolean pressureSwitchVal, pressureSwitchPreval = true;
    boolean prevalue;
    
    public SuperCompressor(int compressorPwm, int switchPwm) {
        compressor = new Compressor(1, 1);
    }
    
    public void update() {
        pressureSwitchVal = compressor.getPressureSwitchValue();

        if (pressureSwitchVal && !pressureSwitchPreval) {                                          //
            compressor.stop();
        } else if (!pressureSwitchVal && pressureSwitchPreval) {
            compressor.start();
        }

        pressureSwitchPreval = pressureSwitchVal;
    }
    
    public void start() {
        compressor.start();
        prevalue = true;
        pressureSwitchPreval = true;
    }
}
