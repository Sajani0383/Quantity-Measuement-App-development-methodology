/**
 * QuantityMeasurementApp.java
 *
 * UC12: Quantity Measurement Application
 *
 * This class demonstrates the generic Quantity class with:
 * 1. Equality comparison
 * 2. Conversion
 * 3. Addition
 * 4. Subtraction
 * 5. Division
 *
 * The same generic methods work for length, weight, and volume.
 *
 * @author Sajani G
 * @version 12.0
 * @since UC12
 */
public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit
    ) {
        return quantity.convertTo(targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit
    ) {
        return quantity1.add(quantity2, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.subtract(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit
    ) {
        return quantity1.subtract(quantity2, targetUnit);
    }

    public static <U extends IMeasurable> double demonstrateDivision(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.divide(quantity2);
    }

    public static void main(String[] args) {
        Quantity<LengthUnit> tenFeet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> sixInches = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<WeightUnit> tenKilograms = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> fiveThousandGrams = new Quantity<>(5000.0, WeightUnit.GRAM);

        Quantity<VolumeUnit> fiveLitres = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> fiveHundredMillilitres = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("Subtraction Operations");

        Quantity<LengthUnit> lengthDifference = demonstrateSubtraction(
                tenFeet,
                sixInches
        );
        System.out.println("10 FEET - 6 INCHES = " + lengthDifference);

        Quantity<LengthUnit> lengthDifferenceInInches = demonstrateSubtraction(
                tenFeet,
                sixInches,
                LengthUnit.INCHES
        );
        System.out.println("10 FEET - 6 INCHES in INCHES = " + lengthDifferenceInInches);

        Quantity<WeightUnit> weightDifference = demonstrateSubtraction(
                tenKilograms,
                fiveThousandGrams
        );
        System.out.println("10 KILOGRAM - 5000 GRAM = " + weightDifference);

        Quantity<VolumeUnit> volumeDifference = demonstrateSubtraction(
                fiveLitres,
                fiveHundredMillilitres
        );
        System.out.println("5 LITRE - 500 MILLILITRE = " + volumeDifference);

        System.out.println();

        System.out.println("Division Operations");

        double lengthRatio = demonstrateDivision(
                new Quantity<>(10.0, LengthUnit.FEET),
                new Quantity<>(2.0, LengthUnit.FEET)
        );
        System.out.println("10 FEET / 2 FEET = " + lengthRatio);

        double crossLengthRatio = demonstrateDivision(
                new Quantity<>(24.0, LengthUnit.INCHES),
                new Quantity<>(2.0, LengthUnit.FEET)
        );
        System.out.println("24 INCHES / 2 FEET = " + crossLengthRatio);

        double weightRatio = demonstrateDivision(
                new Quantity<>(10.0, WeightUnit.KILOGRAM),
                new Quantity<>(5.0, WeightUnit.KILOGRAM)
        );
        System.out.println("10 KILOGRAM / 5 KILOGRAM = " + weightRatio);

        double volumeRatio = demonstrateDivision(
                new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(10.0, VolumeUnit.LITRE)
        );
        System.out.println("5 LITRE / 10 LITRE = " + volumeRatio);
    }
}