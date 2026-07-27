package frc.robot.intake;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public class IntakeConst {
    public static final int DEPLOY_ID = -1; // TODO: intake motor id
    public static final int ROLLER_ID = -1; // TODO: roller motor id

    public static final Angle MIN_ANGLE = Degrees.of(0.0);
    public static final Angle MAX_ANGLE = Degrees.of(128.26);

    public static final double ROLLER_SPEED = 0.5;
}
