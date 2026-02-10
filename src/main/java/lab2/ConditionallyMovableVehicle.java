/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab2;
import java.awt.Color;

abstract class ConditionallyMovableVehicle extends Vehicle {

  public ConditionallyMovableVehicle (
      int nrDoors,
      double enginePower,
      Color color,
      String modelName,
      double x,
      double y
  ) {
    super(nrDoors, enginePower, color, modelName, x, y);
  }

  protected abstract boolean canMove();

  @Override
  public void move() { if (canMove()) super.move(); }

  @Override
  public void gas(double speedIncrease) {
    if (canMove()) super.gas(speedIncrease);
  }

  protected abstract double speedFactor();

  @Override
	protected double increaseSpeedFactor(double increase) {
    return getCurrentSpeed() + speedFactor() * increase;
  }

  @Override
  protected double decreaseSpeedFactor(double decrease) {
    return getCurrentSpeed() - speedFactor() * decrease;
  }
}
