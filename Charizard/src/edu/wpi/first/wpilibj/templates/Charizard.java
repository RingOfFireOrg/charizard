/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Charizard extends SimpleRobot {
    
    Joystick driveStick = new Joystick(2);
    Joystick twistStick = new Joystick(1);
    Joystick controlStick = new Joystick(3);
    JoystickButton wisVent = new JoystickButton(controlStick, 2);
    JoystickButton wisDown = new JoystickButton(controlStick, 3);
    JoystickButton wisUp = new JoystickButton(controlStick, 4);
    JoystickButton wisNormal = new JoystickButton(controlStick, 11);
    JoystickButton wisInvert = new JoystickButton(controlStick, 7);
    MecanumDriveTrain charizardDrive = new MecanumDriveTrain(1, 2, 3, 4, true, false, true);
    Gyro itsAGyro = new Gyro(1);
    WisVictorControler wis = new WisVictorControler(5);
    SuperCompressor compressorSystem = new SuperCompressor(1,1);
    PistonVentable wisPiston = new PistonVentable(1, 1,2,3,4);
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        compressorSystem.start();
        charizardDrive.setup();
        charizardDrive.drive(0,0,0,0);
        Timer.delay(0);
        charizardDrive.drive(0,0,0,0);
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        compressorSystem.start();
        charizardDrive.setup();
        while(isEnabled() && isOperatorControl()) {
            charizardDrive.drive(driveStick.getX(), driveStick.getY(), twistStick.getZ(), itsAGyro.getAngle());
            wis.drive(wisNormal.get(), wisInvert.get(), controlStick.getThrottle());
            wisPiston.drive(wisVent.get(), wisDown.get(), wisUp.get());
            compressorSystem.update();
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
