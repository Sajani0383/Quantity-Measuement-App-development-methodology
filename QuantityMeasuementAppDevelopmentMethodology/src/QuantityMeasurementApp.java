/**
 * QuantityMeasurementApp.java
 *
 * UC10: Quantity Measurement Application
 *
 * This class demonstrates the generic Quantity class.
 *
 * The same methods work for both:
 * Quantity<LengthUnit>
 * Quantity<WeightUnit>
 *
 * Demonstrated operations:
 * 1. Equality comparison
 * 2. Unit conversion
 * 3. Addition
 * 4. Addition with target unit
 *
 * @author Sajani G
 * @version 10.0
 * @since UC10
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

    public static void main(String[] args) {
        Quantity<WeightUnit> weightInGrams = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> weightInKilograms = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        boolean areWeightsEqual = demonstrateEquality(weightInGrams, weightInKilograms);
        System.out.println("Are weights equal? " + areWeightsEqual);

        Quantity<WeightUnit> convertedWeight = demonstrateConversion(
                weightInGrams,
                WeightUnit.KILOGRAM
        );

        System.out.println("Converted Weight: " + convertedWeight);

        Quantity<WeightUnit> weightInPounds = new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> sumWeight = demonstrateAddition(
                weightInKilograms,
                weightInPounds
        );

        System.out.println("Sum Weight: " + sumWeight);

        Quantity<WeightUnit> sumWeightInGrams = demonstrateAddition(
                weightInKilograms,
                weightInPounds,
                WeightUnit.GRAM
        );

        System.out.println("Sum Weight in Grams: " + sumWeightInGrams);

        Quantity<LengthUnit> lengthInFeet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(12.0, LengthUnit.INCHES);

        boolean areLengthsEqual = demonstrateEquality(lengthInFeet, lengthInInches);
        System.out.println("Are lengths equal? " + areLengthsEqual);

        Quantity<LengthUnit> convertedLength = demonstrateConversion(
                lengthInFeet,
                LengthUnit.INCHES
        );

        System.out.println("Converted Length: " + convertedLength);

        Quantity<LengthUnit> sumLength = demonstrateAddition(
                lengthInFeet,
                lengthInInches,
                LengthUnit.FEET
        );

        System.out.println("Sum Length: " + sumLength);
    }
}