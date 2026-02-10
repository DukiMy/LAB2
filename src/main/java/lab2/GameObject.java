/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 */

package lab2;

import java.util.Set;
import java.util.HashSet;
import java.awt.geom.Point2D;
import java.util.function.Predicate;


abstract class GameObject {
  private static final Set<GameObject> gameObjects = new HashSet<>();
  private final Point2D pos = new Point2D.Double(0.0d, 0.0d);

  protected GameObject(double x, double y) {
    pos.setLocation(x, y);
    gameObjects.add(this);
  }

  public double getX() { return pos.getX(); }

  public double getY() { return pos.getY(); }

  public Point2D getPoint() {
    return new Point2D.Double( pos.getX(), pos.getY() );
  }

  public void mutatePoint(double x, double y) {

    pos.setLocation(x, y);
  }

  public <T extends Vehicle> T getClosestInRange(
    Class<T> type,
    double loadRadius,
    Predicate<? super T> allowed
  ) {
    if (loadRadius < 0) {
      throw new IllegalArgumentException(
        String.format("Parameter 'loadRadius' = %.2f is negative.", loadRadius)
      );
    }

    double maxDistSq = loadRadius * loadRadius;

    T best = null;
    double bestD2 = Double.POSITIVE_INFINITY;

    for (GameObject other : gameObjects) {
      if (other == this) continue;
      if (!type.isInstance(other)) continue;

      T candidate = type.cast(other);
      if (!allowed.test(candidate)) continue;

      double d2 = pos.distanceSq(other.pos);
      if (d2 <= maxDistSq && d2 < bestD2) {
        bestD2 = d2;
        best = candidate;
      }
    }

    return best;
  }

  public <T extends Vehicle> T getClosestInRange(Class<T> type, double loadRadius) {
    return getClosestInRange(type, loadRadius, x -> true);
  }

  public void destroy() { gameObjects.remove(this); }
}
