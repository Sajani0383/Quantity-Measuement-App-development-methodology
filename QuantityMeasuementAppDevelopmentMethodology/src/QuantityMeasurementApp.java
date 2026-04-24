/**
 * QuantityMeasurementApp UC7
 *
 * Author: Sajani G
 * Version: 7.0
 */

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length demonstrateLengthConversion(Length l, Length.LengthUnit toUnit) {
        return l.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2, Length.LengthUnit targetUnit) {
        return l1.add(l2, targetUnit);
    }

    public static void printAdd(Length l1, Length l2, Length.LengthUnit target) {
        System.out.println("Input: add(" + l1 + ", " + l2 + ", " + target + ")");
        System.out.println("Output: " + l1.add(l2, target));
        System.out.println();
    }

    public static void main(String[] args) {

        printAdd(new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.FEET);

        printAdd(new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.INCHES);

        printAdd(new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS);

        printAdd(new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET),
                Length.LengthUnit.YARDS);

        printAdd(new Length(36.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.YARDS),
                Length.LengthUnit.FEET);

        printAdd(new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.CENTIMETERS);

        printAdd(new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS);

        printAdd(new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET),
                Length.LengthUnit.INCHES);
    }
}