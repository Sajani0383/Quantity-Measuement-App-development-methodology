/**
 * QuantityMeasurementAppUC3 - Unified Quantity Measurement System
 *
 * Author: Sajani G
 * Version: 3.0
 */

public class QuantityMeasurementApp {

    public static void printResult(Length l1, Length l2, String unit1, String unit2) {
        boolean result = l1.equals(l2);

        System.out.println("Input: Quantity(" + l1Value(l1) + ", \"" + unit1 + "\") and Quantity("
                + l2Value(l2) + ", \"" + unit2 + "\")");

        System.out.println("Output: Equal (" + result + ")");
        System.out.println();
    }

    private static double l1Value(Length l) {
        try {
            java.lang.reflect.Field f = Length.class.getDeclaredField("value");
            f.setAccessible(true);
            return f.getDouble(l);
        } catch (Exception e) {
            return 0;
        }
    }

    private static double l2Value(Length l) {
        try {
            java.lang.reflect.Field f = Length.class.getDeclaredField("value");
            f.setAccessible(true);
            return f.getDouble(l);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        printResult(l1, l2, "feet", "inches");

        Length l3 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l4 = new Length(1.0, Length.LengthUnit.INCHES);

        printResult(l3, l4, "inch", "inch");
    }
}