/*
 * WisVictorControler
 * controls a motor and allows incrementing both a forward and reversed direction
 * chosen by two boolean values that choose which state along with an
 * incrementing will convert a -1 to 0 to 1 scale converted to a 0 to 1 scale for
 * each direction
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Kyle
 */
public class WisVictorControler {
    int pwm;
    //boolean victor, v;
    private Victor motorV;
    
    boolean nState = true, iState = false;
    boolean doubleButtonError;
    
    public WisVictorControler(int pwm) {
        motorV = new Victor(pwm);
    }
    
    public void drive(boolean nButton, boolean iButton, double value){
        value = (value-1)/2;
        if (nButton && !iButton) {
            iState = false;
            doubleButtonError = false;
        } else if (!nButton && iButton){
            iState = true;
            doubleButtonError = false;
        } else if (nButton && iButton) {
            doubleButtonError = true;
        }
        if(iState) {
            value *= -1;
            SmartDashboard.putString("WIS Direction:", " Output");
        }
        else{
            SmartDashboard.putString("WIS Direction:", " Intake");
        }
        motorV.set(value);
    }
    
    public boolean readError() {
        return doubleButtonError;
    }
    

    
}
