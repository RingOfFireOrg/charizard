package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author PyroTech
 */
public class Control {
    Runnable r;
    long start, stop;
    
    public Control(Runnable runnable) {
        r = runnable;
    }
    public void setTime(long sta, long sto) {
        start = sta;
        stop = sto;
    }
    
    public void timedRun(double speed) {   
        if (isInTime()) {
            r.start(speed);
        } else {
            r.stop();
        }
    }
    
    public void timedDrive(double x, double y, double z) {
        if(isInTime()) {
            r.drive(x,y,z,0);
        } else {
            r.stop();
        }  
    }
    
    public boolean isInTime(){
        long currentTime = System.currentTimeMillis(); 
        return ((currentTime >= start) && (currentTime <= stop));
    }
    

    
    public void start(double s) {
        r.start(s);
    } 
    
    public void drive(double x, double y, double z, double gyro) {
        r.drive(x,y,z,0);
    }
    
    public void stop() {
        r.stop();
    }
}