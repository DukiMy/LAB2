/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab2;
import static java.awt.Color.BLUE;

public final class Scania extends ConditionallyMovableVehicle implements Tippable {
  private byte tipBedAngle = 0;

  public Scania() {
    super(
      /* Number of doors */ 2,
      /* Engine power    */ 200.0d,
      /* Vehicle color   */ BLUE,
      /* Vehicle model   */ "Scania",
      /* X position      */ 0.0d,
      /* Y position      */ 0.0d
     );

    tipBedAngle = 0;
  }

  public void setTipBedAngle(byte angle) {
    double speed = getCurrentSpeed();

    if (speed > 0) {
      throw new IllegalStateException("Vehicle tried to move while tipbed angle > 0");
    }

    if (70 < angle || angle < 0) {
      throw new IllegalArgumentException(
        String.format("Argument 'angle' == %d, is out of range.", angle)
      );
    }

    tipBedAngle = angle;
  }

  public double getTipBedAngle() {
    return tipBedAngle;
  }

  @Override
  public boolean canMove() {
    return tipBedAngle == 0;
  }

  @Override
  protected double speedFactor() { return getEnginePower() * 0.01d; }

  @Override
  protected String subToString() {
    StringBuilder sb = new StringBuilder();
    sb.append(", \n\ttipBedAngle = " + tipBedAngle + '°')
      .append(", \n\tcanMove = " + canMove());

    return sb.toString();
  }
}
