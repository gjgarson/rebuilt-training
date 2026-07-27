package frc.robot.intake;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX deployMotor = new TalonFX(IntakeConst.DEPLOY_ID);
    private final TalonFX rollerMotor = new TalonFX(IntakeConst.ROLLER_ID);

    public IntakeSubsystem() {
        deployMotor.getConfigurator().apply(IntakeConfig.deployConfig);
        rollerMotor.getConfigurator().apply(IntakeConfig.rollerConfig);

        deployMotor.setPosition(IntakeConst.MAX_ANGLE);
    }

    private void moveRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }

    private void rollersOn() {
        moveRollerSpeed(IntakeConst.ROLLER_SPEED);
    }

    private void rollersOff() {
        moveRollerSpeed(0);
    }

    private void rollersReverse() {
        moveRollerSpeed(-IntakeConst.ROLLER_SPEED);
    }

    private void moveAngle(Angle angle) {
        Angle targetAngle =
                Rotations.of(
                        MathUtil.clamp(
                                angle.in(Rotations),
                                IntakeConst.MIN_ANGLE.in(Rotations),
                                IntakeConst.MAX_ANGLE.in(Rotations)));
        deployMotor.setControl(new MotionMagicVoltage(targetAngle));
    }

    private void moveDown() {
        moveAngle(IntakeConst.MIN_ANGLE);
    }

    private void moveUp() {
        moveAngle(IntakeConst.MAX_ANGLE);
    }

    public void deploy() {
        rollersOn();
        moveDown();
    }

    public void stow() {
        rollersOff();
        moveUp();
    }

    public double getAngle() {
        return deployMotor.getPosition().getValue().in(Degrees);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        // TODO Auto-generated method stub
        builder.addDoubleProperty(
                "angle (deg)", this::getAngle, (angle) -> moveAngle(Degrees.of(angle)));
    }
}
