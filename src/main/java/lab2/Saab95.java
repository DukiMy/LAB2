/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab2;
import static java.awt.Color.RED;

public final class Saab95 extends Vehicle implements Car, TurboChargable{

	private boolean turboOn;

	public Saab95() {
		super(
      /* Number of doors */ 2,
      /* Engine power    */ 125.0d,
      /* Vehicle Color   */ RED,
      /* Vehicle model   */ "Saab95",
      /* X position      */ 0.0d,
      /* Y position      */ 0.0d
    );

    turboOn = false;
	}

	public void setTurbo(boolean state) { turboOn = state; }

	private double speedFactor() {
		return getEnginePower() * 0.01d * (turboOn ? 1.3d : 1.0d);
	}

  @Override
	protected double increaseSpeedFactor(double speedIncrease) {
    return getCurrentSpeed() + speedFactor() * speedIncrease;
	}

	@Override
	protected double decreaseSpeedFactor(double speedDecrease) {
    return getCurrentSpeed() - speedFactor() * speedDecrease;
	}

  @Override
  protected String subToString() {
    return ", \n\tturboOn = " + turboOn;
  }
}
