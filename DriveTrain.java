package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain {

    // 4 drive motors. FL, BL, FR, BR

    CANSparkMax flMotor = new CANSparkMax(Constants.flMotorIndex, MotorType.kBrushless);
    CANSparkMax blMotor = new CANSparkMax(Constants.blMotorIndex, MotorType.kBrushless);
    CANSparkMax frMotor = new CANSparkMax(Constants.frMotorIndex, MotorType.kBrushless);
    CANSparkMax brMotor = new CANSparkMax(Constants.brMotorIndex, MotorType.kBrushless);
    
}
