package frc.robot.spindexer;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpindexerSubsystem extends SubsystemBase {
    private final TalonFX motor = new TalonFX(SpindexerConst.MOTOR_ID);

    public SpindexerSubsystem() {
        motor.getConfigurator().apply(SpindexerConfig.motorConfig);
    }

    /**
     * Set the motor speed to a given value
     *
     * @param speed
     */
    public void moveMotorSpeed(double speed) {
        motor.set(speed);
    }

    /** Start running the motor */
    public void start() {
        moveMotorSpeed(SpindexerConfig.MOTOR_SPEED);
    }

    /** Stop the motor */
    public void stop() {
        moveMotorSpeed(0.0);
    }

    /**
     * Gets the current spindexer motor speed
     *
     * @return the current motor speed
     */
    public double getMotorSpeed() {
        return motor.get();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // TODO Auto-generated method stub
        builder.addDoubleProperty("motor speed (frac)", this::getMotorSpeed, this::moveMotorSpeed);
        builder.addDoubleProperty(
                "angular velocity (rps)", () -> motor.getVelocity().getValueAsDouble(), null);
    }
}
