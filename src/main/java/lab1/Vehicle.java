/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab1;

import java.awt.Color;
import java.awt.geom.Point2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

abstract class Vehicle implements Movable {

  private final Point2D pos = new Point2D.Double(0.0d, 0.0d);
	private int nrDoors;
  private double direction;
	private double enginePower;
	private double currentSpeed;
	private Color color;
	private String modelName;

	protected Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
    this.direction = 0.0d;
		this.nrDoors = nrDoors;
		this.enginePower = enginePower;
		this.color = color;
		this.modelName = modelName;
	  stopEngine();
  }

  public double getX() { return pos.getX(); }

  public double getY() { return pos.getY(); }

  public double getDirection() { return direction; }

	public int getNrDoors() { return nrDoors; }

	public double getEnginePower() { return enginePower; }

	public double getCurrentSpeed() { return currentSpeed; }

	public int getColor() { return color.getRGB(); }

  public String getModelName() { return modelName; }

  public void setColor(int c) { color = new Color(c); }

	public void startEngine() { setCurrentSpeed(0.1d); }

	public void stopEngine() { setCurrentSpeed(0.0d); }

  public void turnLeft() { direction += 0.1d; }

  public void turnRight() { direction -= 0.1d; }

  private void validateArgInterval(double arg, double lowBound, double highBound) {
    if (arg < lowBound || arg > highBound) {
      throw new IllegalArgumentException();
    }
  }

  public void brake(double speedDecrease) {
    validateArgInterval(speedDecrease, 0.0d, 1.0d);
    decreaseSpeed(speedDecrease);
	}

  public void gas(double speedIncrease) {
    validateArgInterval(speedIncrease, 0.0d, 1.0d);
    increaseSpeed(speedIncrease);
	}

  public void move() {
    pos.setLocation(
      pos.getX() + sin(direction) * getCurrentSpeed(),
      pos.getY() + cos(direction) * getCurrentSpeed()
    );
  }

  private void setCurrentSpeed(double setSpeed) {
    if (setSpeed > getEnginePower()) {
      currentSpeed = getEnginePower();
      return;

    } else if (setSpeed < 0.0d) {
      currentSpeed = 0.0d;

    } else {
      currentSpeed = setSpeed;
    }
  }

	private void increaseSpeed(double speedIncrease) {
		setCurrentSpeed(
      increaseSpeedFactor(speedIncrease)
    );
	}

	private void decreaseSpeed(double speedDecrease) {
		setCurrentSpeed(
      decreaseSpeedFactor(speedDecrease)
    );
	}

  protected abstract double increaseSpeedFactor(double speedIncrease);
  protected abstract double decreaseSpeedFactor(double speedDecrease);
  protected abstract String subToString();

  @Override
  public String toString() {
    return "Vehicle{" +
          " \n\tmodelName = \"" + modelName + '\"' +
          ", \n\trDoors = " + nrDoors +
          ", \n\tenginePower = " + enginePower +
          ", \n\tcurrentSpeed = " + currentSpeed +
          ", \n\tdirection = " + direction +
          ", \n\tpos = (" + pos.getX() + ", " + pos.getY() + ")" +
          ", \n\tcolor = #" + String.format("%06X", color.getRGB() & 0x00FFFFFF) + subToString() +
          "\n}";
  }
}
