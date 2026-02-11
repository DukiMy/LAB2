/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab2;

import java.util.ArrayDeque;
import java.util.Deque;
import static java.awt.Color.YELLOW;
import static java.lang.System.out;

public final class VolvoFH16 extends ConditionallyMovableVehicle implements RampOperated {

  private static final double LOAD_RADIUS = 5.0d;
  private static final byte MAX_CAPACITY = 6;
  private final Deque<Vehicle> cargo = new ArrayDeque<>();
  private boolean isRampLowered;

  public VolvoFH16() {
    super(
      /* Number of doors */ 2,
      /* Engine power    */ 200.0d,
      /* Vehicle color   */ YELLOW,
      /* Vehicle model   */ "VolvoFH16",
      /* X position      */ 0.0d,
      /* Y position      */ 0.0d
    );

    raiseRamp();
  }

  public void lowerRamp() {
    if (getCurrentSpeed() > 0) return;
    isRampLowered = true;
  }

  public void raiseRamp() {
    isRampLowered = false;
  }

  public boolean isRampLowered() {
    return isRampLowered;
  }

  public boolean canLoad() {
    return (getCurrentSpeed() == 0 && isRampLowered);
  }

  public void load() {
    Vehicle v;

    if (!canLoad()) {
      out.println("Can not load, ramp is not lowered!");
      return;
    }

    if (cargo.size() >= MAX_CAPACITY) {
      out.println("Can not load, " + getModelName() +" is full!");
      return;
    }

    v = getClosestInRange(
      Vehicle.class,
      LOAD_RADIUS,
      car -> (car instanceof Car) && !cargo.contains(car)
    );

    if (v == null) return;

    cargo.push(v);
    v.mutatePoint(getX(), getY());
  }

  public void unLoad() {
    if (!canLoad()) {
      out.println("Can not unload, ramp is not lowered!");
      return;
    }

    if (cargo.isEmpty()) {
      out.println("There is nothing to unload!");
      return;
    }

    Vehicle v = cargo.pop();
    v.mutatePoint(getX() - 1.0, getY());
  }

  private StringBuilder loadToString() {
    StringBuilder sb = new StringBuilder();

    if (cargo.isEmpty()) return sb.append("Cargohold is empty.");

    for (Vehicle v : cargo) sb.append(v).append('\n');

    return sb;
  }

  public void printLoad() { out.println(loadToString()); }

	protected double speedFactor() { return getEnginePower() * 0.01d; }

  @Override
  public void move() {
    super.move();
    for (Vehicle v : cargo) {
      v.mutatePoint(getX(), getY());
    }
  }

  @Override
  protected boolean canMove() { return !isRampLowered; }

  @Override
  protected String subToString() {
    StringBuilder sb = new StringBuilder();

    sb.append(", \n\tisRampLowered = " + isRampLowered)
      .append("\n\t" + loadToString());

    return sb.toString();
  }
}
