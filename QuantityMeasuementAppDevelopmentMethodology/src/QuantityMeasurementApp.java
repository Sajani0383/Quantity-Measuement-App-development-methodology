/**
 * QuantityMeasurementAppUC4
 *
 * Author: Sajani G
 * Version: 4.0
 */

public class QuantityMeasurementApp {

    public static void printResult(Length l1, Length l2) {
        System.out.println("Input: Quantity(" + l1.getValue() + ", " + l1Unit(l1) +
                ") and Quantity(" + l2.getValue() + ", " + l2Unit(l2) + ")");
        System.out.println("Output: Equal (" + l1.equals(l2) + ")");
        System.out.println();
    }

    private static String l1Unit(Length l) {
        return l.getClass().getDeclaredFields()[1].getType().getSimpleName();
    }

    private static String l2Unit(Length l) {
        return l.getClass().getDeclaredFields()[1].getType().getSimpleName();
    }

    public static void main(String[] args) {

        printResult(new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES));

        printResult(new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET));

        printResult(new Length(1.0, Length.LengthUnit.YARDS),
                new Length(36.0, Length.LengthUnit.INCHES));

        printResult(new Length(2.0, Length.LengthUnit.YARDS),
                new Length(2.0, Length.LengthUnit.YARDS));

        printResult(new Length(1.0, Length.LengthUnit.CENTIMETERS),
                new Length(0.393701, Length.LengthUnit.INCHES));
    }
}