package lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class LoadableVehicleTests {

  @Test
  void rampStateChanges() {
    ArrayList<RampOperated> vehicleRamps = new ArrayList<>();
    vehicleRamps.add(new VolvoFH16());

    for (RampOperated vehicleRamp : vehicleRamps) {
      vehicleRamp.raiseRamp();
      assertTrue(!vehicleRamp.canLoad());

      vehicleRamp.lowerRamp();
      assertTrue(vehicleRamp.canLoad());
    }
  }

  @Test
  void canNotMoveWhileRampLowered() {
    ArrayList<RampOperated> vehicleRamps = new ArrayList<>();
    vehicleRamps.add(new VolvoFH16());

    for (RampOperated vehicleRamp : vehicleRamps) {
      vehicleRamp.lowerRamp();
      ConditionallyMovableVehicle movingWhileLowered = (ConditionallyMovableVehicle) vehicleRamp;
      movingWhileLowered.move();
    }
  }
}
