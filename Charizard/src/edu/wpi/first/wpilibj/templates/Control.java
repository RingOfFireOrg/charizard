package edu.wpi.first.wpilibj.templates;

/**
 *
 * @author PyroTech
 */
public class Control {
    public static void timedRun(Runnable r, long start, long stop, double speed) {
        long currentTime = System.currentTimeMillis();    
        if ((currentTime >= start) && (currentTime <= stop)) {
                r.start(speed);
        } else {
                r.stop();
        }
    }
}