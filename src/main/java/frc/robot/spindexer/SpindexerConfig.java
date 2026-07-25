package frc.robot.spindexer;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class SpindexerConfig {
    public static final double MOTOR_SPEED = 0.5; // TODO: untested value

    public static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();

    static {
        motorConfig.CurrentLimits.StatorCurrentLimit = 80.0;
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        // positive direction draws fuel into feeder
        motorConfig.MotorOutput.Inverted =
                InvertedValue.Clockwise_Positive; // TODO: find correct direction
    }
}
