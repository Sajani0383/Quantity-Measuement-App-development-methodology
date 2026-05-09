/**
 * QuantityMeasurementApp.java
 *
 * UC8: Quantity Measurement Application
 *
 * This class demonstrates the working of the refactored Length and LengthUnit
 * classes. LengthUnit is now a standalone enum responsible for unit conversion.
 *
 * Demonstrated operations:
 * 1. Length equality
 * 2. Unit conversion
 * 3. Length addition
 * 4. Addition with target unit
 *
 * @author Sajani G
 * @version 8.0
 * @since UC8
 */
public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {
        Length oneFoot = new Length(1.0, LengthUnit.FEET);
        Length twelveInches = new Length(12.0, LengthUnit.INCHES);
        Length oneYard = new Length(1.0, LengthUnit.YARDS);
        Length thirtySixInches = new Length(36.0, LengthUnit.INCHES);
        Length threeFeet = new Length(3.0, LengthUnit.FEET);
        Length zeroInches = new Length(0.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, FEET).convertTo(INCHES)");
        System.out.println("Output: " + oneFoot.convertTo(LengthUnit.INCHES));

        System.out.println();

        System.out.println("Input: Quantity(1.0, FEET).add(Quantity(12.0, INCHES), FEET)");
        System.out.println("Output: " + oneFoot.add(twelveInches, LengthUnit.FEET));

        System.out.println();

        System.out.println("Input: Quantity(36.0, INCHES).equals(Quantity(1.0, YARDS))");
        System.out.println("Output: " + thirtySixInches.equals(oneYard));

        System.out.println();

        System.out.println("Input: Quantity(1.0, YARDS).add(Quantity(3.0, FEET), YARDS)");
        System.out.println("Output: " + oneYard.add(threeFeet, LengthUnit.YARDS));

        System.out.println();

        System.out.println("Input: Quantity(2.54, CENTIMETERS).convertTo(INCHES)");
        System.out.println("Output: " + new Length(2.54, LengthUnit.CENTIMETERS).convertTo(LengthUnit.INCHES));

        System.out.println();

        System.out.println("Input: Quantity(5.0, FEET).add(Quantity(0.0, INCHES), FEET)");
        System.out.println("Output: " + new Length(5.0, LengthUnit.FEET).add(zeroInches, LengthUnit.FEET));

        System.out.println();

        System.out.println("Input: LengthUnit.FEET.convertToBaseUnit(12.0)");
        System.out.println("Output: " + LengthUnit.FEET.convertToBaseUnit(12.0));

        System.out.println();

        System.out.println("Input: LengthUnit.INCHES.convertToBaseUnit(12.0)");
        System.out.println("Output: " + LengthUnit.INCHES.convertToBaseUnit(12.0));
    }
}