/*
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab2;
import static java.awt.Color.BLACK;

public final class Volvo240 extends Vehicle implements Car{

	private static final double TRIM_FACTOR = 1.25d;

	public Volvo240() {
		super(
      /* Number of doors */ 4,
      /* Engine power    */ 100.0d,
      /* Vehicle color   */ BLACK,
      /* vehicle model   */ "Volvo240",
      /* X position      */ 0.0d,
      /* Y position      */ 0.0d
     );
	}

	private double speedFactor() {
		return getEnginePower() * 0.01d * TRIM_FACTOR;
	}

  @Override
	protected double increaseSpeedFactor(double speedIncrease) {
    return Math.min(getCurrentSpeed() + speedFactor() * speedIncrease, getEnginePower());
	}

	@Override
	protected double decreaseSpeedFactor(double speedDecrease) {
    return Math.max(getCurrentSpeed() - speedFactor() * speedDecrease, 0.0d);
	}

  @Override
  protected String subToString() { return ", \n\tTRIM_FACTOR = " + TRIM_FACTOR; }
}
