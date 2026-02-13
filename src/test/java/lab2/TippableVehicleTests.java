package lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TippableVehiclesTest {

  @Test
  void tipBedChangesAngle() {
    ArrayList<Tippable> tippableVehicles = new ArrayList<>();
    tippableVehicles.add(new Scania());

    for (Tippable tippableVehicle : tippableVehicles) {
      byte angle = 70;

      double before = tippableVehicle.getTipBedAngle();
      double after;

      tippableVehicle.setTipBedAngle(angle);
      after = tippableVehicle.getTipBedAngle();

      assertTrue(
        before != after,
        "Flaket borde byta vinkel."
      );
    }
  }

  @Test
  void outsideTipBedAngleBoundsThrowsException() {
    ArrayList<Tippable> tippableVehicles = new ArrayList<>();
    tippableVehicles.add(new Scania());

    byte lowerExceedingAngle = -1;
    byte upperExceedingAngle = 71;

    for (Tippable tippableVehicle : tippableVehicles) {
      assertThrows(
        IllegalArgumentException.class,
         () -> tippableVehicle.setTipBedAngle(lowerExceedingAngle),
         "IllegalArgumentException borde kastas."
      );

      assertThrows(
        IllegalArgumentException.class,
         () -> tippableVehicle.setTipBedAngle(upperExceedingAngle),
         "IllegalArgumentException borde kastas."
      );
    }
  }

  @Test
  void cantMoveWhileTipped() {
    ArrayList<Tippable> tippableVehicles = new ArrayList<>();
    tippableVehicles.add(new Scania());

    byte lowestTipAngle = 1;
    byte highestTipAngle = 70;
    Point2D beforeMoveAttempt;
    Point2D afterMoveAttempt;

    for (Tippable tippableVehicle : tippableVehicles) {
      ConditionallyMovableVehicle tipped =  (ConditionallyMovableVehicle) tippableVehicle;

      tippableVehicle.setTipBedAngle(lowestTipAngle);
      beforeMoveAttempt = tipped.getPoint();

      tipped.startEngine();
      tipped.gas(0.5d);
      tipped.move();
      afterMoveAttempt = tipped.getPoint();

      assertEquals(
        beforeMoveAttempt,
        afterMoveAttempt,
        "Bilen borde inte röra sig när flaket är tippat till 1 vinkelgrad"
      );

      tipped.stopEngine();
      tippableVehicle.setTipBedAngle(highestTipAngle);
      beforeMoveAttempt = tipped.getPoint();

      tipped.move();
      afterMoveAttempt = tipped.getPoint();
      assertEquals(
        beforeMoveAttempt,
        afterMoveAttempt,
        "Bilen borde inte röra sig när flaket är tippat till max vinkelgrad."
      );
    }
  }

  @Test
  void cantTipWhileMoving() {
    ArrayList<Tippable> tippableVehicles = new ArrayList<>();
    tippableVehicles.add(new Scania());

    byte lowestTipAngle = 1;
    byte highestTipAngle = 70;

    for (Tippable tippableVehicle : tippableVehicles) {
      ConditionallyMovableVehicle movingVehicle = (ConditionallyMovableVehicle) tippableVehicle;

      movingVehicle.startEngine();
      movingVehicle.gas(0.5d);
      movingVehicle.move();

      assertThrows(
        IllegalStateException.class,
        () -> tippableVehicle.setTipBedAngle(lowestTipAngle),
        "IllegalStateException bör kastas."
      );

      assertThrows(
        IllegalStateException.class,
        () -> tippableVehicle.setTipBedAngle(highestTipAngle),
        "IllegalStateException bör kastas."
      );
    }
  }
}
