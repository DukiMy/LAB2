/**
 *  Utfärdat av Durim Miziraj
 *  Kontakt: gusmizdu@student.gu.se
 *
 *  Gränssnittet avgränsar beteenden hos objekt med tippbara flak.
 */

package lab2;

interface Tippable extends Movable{

  void setTipBedAngle(byte angle);
  double getTipBedAngle();
}
