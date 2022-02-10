package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter {

    // two talons. 1 master, 1 slave
    // 2 spark maxes. 1 for turret. 1 for hood

    WPI_TalonFX masterShooterMotor = new WPI_TalonFX(Constants.masterShooterMotorIndex);
    WPI_TalonFX slaveShooterMotor = new WPI_TalonFX(Constants.slaveShooterMotorIndex);

    CANSparkMax turretMotor = new CANSparkMax(Constants.turretMotorIndex, MotorType.kBrushless);
    CANSparkMax hoodMotor = new CANSparkMax(Constants.hoodMotorIndex, MotorType.kBrushless);

    public double shooterIndexerEncoderCount = 200; // encoder count to go from under shooter to shooter.

    public void shooterInit(){
        slaveShooterMotor.follow(masterShooterMotor);
    }

    public void shooterTeleop(){

        if(Robot.intake.colorSensor2Activated && Constants.xbox.getRawButton(2)){ // needs to change to x button
            //masterShooterMotor.set(calculated speed based on distance); // should activate slave also
            masterShooterMotor.set(0.5);
            if(masterShooterMotor.get() >= 0.5){
                Robot.intake.indexerMotor.set(Constants.quadraticPositionAndSpeed(0.05, 0.4, shooterIndexerEncoderCount, Robot.intake.indexerMotor.getEncoder().getPosition()));
                if(Robot.intake.indexerMotor.getEncoder().getPosition() > shooterIndexerEncoderCount){
                    Robot.intake.indexerMotor.set(0.0);
                    Robot.intake.indexerMotor.getEncoder().setPosition(0.0);
                    
                }
            }
            // here I have two options: 
            // 1: use a timer and wait a certain amount of time (could be constant or based on wanted motor speed)
            // 2: use an if statement and verify the speed is what we want. Contact with the ball will slow down the motors. Does that matter?
            
            // if(timer is past certain point or motor is up to speed){
                //Robot.intake.indexerMotor.set(quadraticController(0.05, Robot.intake.indexerMotorSpeed, Robot.intake.indexerMotor.getEncoder().getPosition(), encoderCount));
                //if(Robot.intake.indexerMotor.getEncoder().getPosition() > encoderCount){
                    // Robot.intake.indexerMotor.set(0.0);
                    // Robot.intake.indexerMotor.getEncoder().setPosition(0.0);
                    // Robot.intake.colorSensor2Activated = false;
                //}
            //}
        }
    }
    




}