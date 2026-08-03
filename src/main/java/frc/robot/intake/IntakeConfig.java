package frc.robot.intake;

import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class IntakeConfig {
    public static final double ROLLER_SPEED = 0.5;
    public static final double REVERSE_ROLLER_SPEED = -0.5;

    public static final TalonFXConfiguration deployConfig = new TalonFXConfiguration();

    static {
        deployConfig.CurrentLimits.StatorCurrentLimit = 80.0;
        deployConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        // positive direction raises intake
        deployConfig.MotorOutput.Inverted =
                InvertedValue.Clockwise_Positive; // TODO: test inverted value

        deployConfig.Feedback.SensorToMechanismRatio = 96.0;

        deployConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        deployConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold =
                IntakeConst.MAX_ANGLE.in(Rotations);

        deployConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
        deployConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold =
                IntakeConst.MIN_ANGLE.in(Rotations);
    }

    public static final TalonFXConfiguration rollerConfig = new TalonFXConfiguration();

    static {
        rollerConfig.CurrentLimits.StatorCurrentLimit = 80.0;
        rollerConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        // positive direction intakes fuel
        rollerConfig.MotorOutput.Inverted =
                InvertedValue.Clockwise_Positive; // TODO: test inverted value
    }
}
