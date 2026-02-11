package lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static java.lang.System.out;

class VehicleTest {

  @Test
  void vehicleMovesForward() {
    double startX;
    double startY;

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    for (Vehicle v : vehicles) {
      startX = v.getX();
      startY = v.getY();

      v.startEngine();
      v.gas(0.3);
      v.move();

      assertTrue(
        v.getX() != startX || v.getY() != startY,
        String.format(
          "%s flyttade inte när 'move()' anropades.",
          v.getModelName()
        )
      );
    }
  }

  @Test
  void turningChangesDirection() {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());

    double dirBeforeTurn;
    double dirAfterTurn;
    boolean hasLeftTurn;
    boolean hasRightTurn;

    for (Vehicle v : vehicles) {

      dirBeforeTurn = v.getDirection();
      v.turnLeft();
      dirAfterTurn = v.getDirection();
      hasLeftTurn = (dirBeforeTurn != dirAfterTurn);

      dirBeforeTurn = v.getDirection();
      v.turnRight();
      dirAfterTurn = v.getDirection();
      hasRightTurn = (dirBeforeTurn != dirAfterTurn);

      assertTrue(
        hasLeftTurn && hasRightTurn,
        String.format(
          "%s ändrade inte riktning.",
          v.getModelName()
        )
      );
    }
  }

  @Test
  void brakeReducesSpeed() {
    double speedBeforeBraking;
    double speedAfterBreaking;

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      v.startEngine();
      v.gas(0.5);
      speedBeforeBraking = v.getCurrentSpeed();

      v.brake(0.5);
      speedAfterBreaking = v.getCurrentSpeed();

      assertTrue(
        speedAfterBreaking < speedBeforeBraking,
        String.format(
          "Farten sänktes inte när %s bromsade in.",
          v.getModelName()
        )
      );
    }
  }

  @Test
  void gasRejectsOutOfRange() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      assertThrows(IllegalArgumentException.class, () -> v.gas(-0.0001));
      assertThrows(IllegalArgumentException.class, () -> v.gas( 1.0001));
    }
  }

  @Test
  void brakeRejectsOutOfRange() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      assertThrows(IllegalArgumentException.class, () -> v.brake(-0.0001d));
      assertThrows(IllegalArgumentException.class, () -> v.brake( 1.0001d));
    }
  }

  @Test
  void turboIncreasesSpeed() {
    Vehicle movableVehicle;
    TurboChargable turboVehicle;
    double speedIncrease = 0.3d;
    double speedBefore;
    double speedAfter;

    movableVehicle = new Saab95();
    movableVehicle.startEngine();
    movableVehicle.gas(speedIncrease);
    speedBefore = movableVehicle.getCurrentSpeed();
    movableVehicle.stopEngine();

    turboVehicle = (TurboChargable)movableVehicle;
    turboVehicle.setTurbo(true);
    movableVehicle = (Saab95)turboVehicle;
    movableVehicle.startEngine();
    movableVehicle.gas(speedIncrease);
    speedAfter = movableVehicle.getCurrentSpeed();
    movableVehicle.stopEngine();

    assertTrue(
      speedBefore < speedAfter,
      "Turbo did not increase speed"
    );
  }

  @Test
  void setCurrentSpeedBoundsWork() {

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      v.startEngine();
      for (int i = 0; i < 150; i++) {
        v.gas(1.0d);
      }

      assertTrue(
        v.getCurrentSpeed() == v.getEnginePower(),
         "'setCurrentSpeed' håller inte övre fartgräns"
      );

      v.stopEngine();

      for (int i = 0; i < 100; i++) {
        v.brake(1.0d);
      }

      assertTrue(
        v.getCurrentSpeed() == 0.0d,
      "'setCurrentSpeed' håller inte nedre fartgräns"
      );
    }
  }

  @Test
  void toStringIsOverridden() throws NoSuchMethodException {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      String toString = v.toString();
      assertNotNull(toString);
      assertFalse(toString.isBlank());
      assertEquals(
        v.getClass(),
        v.getClass()
          .getMethod("toString")
          .getDeclaringClass()
      );

      out.println(v.toString());
    }
  }

  @Test
  void colorIsMutatedAndAccessed() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      Color c = new Color(0);
      v.setColor(c.getRGB());

      assertTrue(
        v.getColor() == c.getRGB(),
        "Färg kunnde inte muteras eller hämtas"
      );
    }
  }

  @Test
  void vehicleHasDoors() {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Volvo240());
    vehicles.add(new Saab95());
    vehicles.add(new VolvoFH16());
    vehicles.add(new Scania());

    for (Vehicle v : vehicles) {
      assertTrue(
        0 < v.getNrDoors(),
        "Vehicle " + v.getModelName() + " har inga dörrar."
      );
    }
  }
}
