/**
 * QuantityMeasurementApp UC5
 *
 * Author: Sajani G
 * Version: 5.0
 */

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                      double v2, Length.LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {
        Length l = new Length(value, from);
        return l.convertTo(to);
    }

    public static Length demonstrateLengthConversion(Length l,
                                                     Length.LengthUnit to) {
        return l.convertTo(to);
    }

    public static void main(String[] args) {

        System.out.println("Input: convert(1.0, FEET, INCHES) -> Output: " +
                Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES));

        System.out.println("Input: convert(3.0, YARDS, FEET) -> Output: " +
                Length.convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET));

        System.out.println("Input: convert(36.0, INCHES, YARDS) -> Output: " +
                Length.convert(36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS));
    }
}