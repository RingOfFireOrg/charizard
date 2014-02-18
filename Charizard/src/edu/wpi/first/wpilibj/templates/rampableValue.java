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
public class rampableValue {
    double req, cur = 0.0, error, output;
    

    public double set(double req) {
        output = 0.0;
        error = Math.abs(req - cur);                                        //sets variable error to Requested speed minus Current speed
        
        if(error >= 0.1){
            output = ((0.1)*(req-cur)+ cur);                                //increments the current speed up by
        } else {                                                            //one tenth the distance to the req
            output = req;
        }  
        cur = output;
        return output;
    }
}
