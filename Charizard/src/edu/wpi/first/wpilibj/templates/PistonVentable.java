/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;


/**
 *
 * @author Kyle
 */
public class PistonVentable {
    int slot, sol1, sol2, sol3, sol4;
    //sol 1 is the solenoid that when true vents the solenoid
    //sol 2 is the solenoid that when true connects the solenoid to pressure
    
    private MySolenoid wisExtend;
    private MySolenoid wisRetract;
    boolean ventState, upState, downState;
    boolean a0a = false, a1a = true;
    boolean multiButtonError = false;
    
    public PistonVentable(int slot, int sol1, int sol2, int sol3, int sol4) {                               
        wisExtend = new MySolenoid(slot, sol1, sol2);
        wisRetract = new MySolenoid(slot, sol3, sol4);
        //wisRetractA = new Solenoid(slot, sol3);
        //wisRetractB = new Solenoid(slot, sol4);
    }
    
    public void drive(boolean ventButton, boolean upButton, boolean downButton) {
        if (ventButton && (!upButton && !downButton)) {
            ventState = true;
            upState = false;
            downState = false;
            multiButtonError = false;
        } else if ((!ventButton && upButton) && !downButton) {
            ventState = false;
            upState = true;
            downState = false;
            multiButtonError = false;
        } else if ((!ventButton && !upButton) && downButton) {
            ventState = false;
            upState = false;
            downState = true;
            multiButtonError = false;
        } else if (!(!ventButton && !upButton) && !downButton){
            ventState = true;
            upState = false;
            downState = false;
            multiButtonError = false;
        } else {
            multiButtonError = true;
        }
        
        if(ventState) {
            this.vent();
        }
        if (upState) {
            this.up();
        }
        if (downState) {
            this.down();
        }
    }
    private void vent() {
        wisExtend.extend();
        wisRetract.extend();
    }
    private void up() {
        wisExtend.extend();
        wisRetract.retract();
    }
    private void down() {
        wisExtend.retract();
        wisRetract.extend();
    }
    public boolean buttonError(){
        return multiButtonError;
    }
    
}
