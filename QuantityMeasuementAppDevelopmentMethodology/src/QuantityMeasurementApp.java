/**
 * QuantityMeasurementApp.java
 *
 * UC9: Quantity Measurement Application
 *
 * This application demonstrates measurement operations for both length
 * and weight categories.
 *
 * Existing length functionality from UC8 is preserved.
 * UC9 introduces weight functionality using Weight and WeightUnit.
 *
 * Weight operations supported:
 * 1. Weight equality
 * 2. Weight comparison across different units
 * 3. Weight conversion
 * 4. Weight addition
 * 5. Weight addition with target unit
 *
 * Length and weight are treated as separate measurement categories.
 *
 * @author Sajani G
 * @version 9.0
 * @since UC9
 */
public class QuantityMeasurementApp {

    public static boolean demonstrateWeightEquality(Weight weight1, Weight weight2) {
        return weight1.equals(weight2);
    }

    public static boolean demonstrateWeightComparison(double value1, WeightUnit unit1, double value2, WeightUnit unit2) {
        Weight weight1 = new Weight(value1, unit1);
        Weight weight2 = new Weight(value2, unit2);
        return weight1.equals(weight2);
    }

    public static Weight demonstrateWeightConversion(double value, WeightUnit fromUnit, WeightUnit toUnit) {
        Weight weight = new Weight(value, fromUnit);
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightConversion(Weight weight, WeightUnit toUnit) {
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2) {
        return weight1.add(weight2);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2, WeightUnit targetUnit) {
        return weight1.add(weight2, targetUnit);
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);
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
        Weight oneKilogram = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight thousandGrams = new Weight(1000.0, WeightUnit.GRAM);
        Weight onePound = new Weight(1.0, WeightUnit.POUND);
        Weight fourFiftyThreePointFiveNineTwoGrams = new Weight(453.592, WeightUnit.GRAM);
        Weight twoKilograms = new Weight(2.0, WeightUnit.KILOGRAM);
        Weight zeroGrams = new Weight(0.0, WeightUnit.GRAM);

        System.out.println("Weight Equality Comparisons");
        System.out.println("Input: Quantity(1.0, KILOGRAM).equals(Quantity(1000.0, GRAM))");
        System.out.println("Output: " + oneKilogram.equals(thousandGrams));

        System.out.println();

        System.out.println("Input: Quantity(1.0, POUND).equals(Quantity(453.592, GRAM))");
        System.out.println("Output: " + onePound.equals(fourFiftyThreePointFiveNineTwoGrams));

        System.out.println();

        System.out.println("Weight Unit Conversions");
        System.out.println("Input: Quantity(1.0, KILOGRAM).convertTo(GRAM)");
        System.out.println("Output: " + oneKilogram.convertTo(WeightUnit.GRAM));

        System.out.println();

        System.out.println("Input: Quantity(2.0, POUND).convertTo(KILOGRAM)");
        System.out.println("Output: " + new Weight(2.0, WeightUnit.POUND).convertTo(WeightUnit.KILOGRAM));

        System.out.println();

        System.out.println("Input: Quantity(500.0, GRAM).convertTo(POUND)");
        System.out.println("Output: " + new Weight(500.0, WeightUnit.GRAM).convertTo(WeightUnit.POUND));

        System.out.println();

        System.out.println("Weight Addition Operations");
        System.out.println("Input: Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM))");
        System.out.println("Output: " + oneKilogram.add(thousandGrams));

        System.out.println();

        System.out.println("Input: Quantity(1.0, KILOGRAM).add(Quantity(1000.0, GRAM), GRAM)");
        System.out.println("Output: " + oneKilogram.add(thousandGrams, WeightUnit.GRAM));

        System.out.println();

        System.out.println("Input: Quantity(2.0, KILOGRAM).add(Quantity(0.0, GRAM), KILOGRAM)");
        System.out.println("Output: " + twoKilograms.add(zeroGrams, WeightUnit.KILOGRAM));

        System.out.println();

        System.out.println("Length Functionality Still Works");
        Length oneFoot = new Length(1.0, LengthUnit.FEET);
        Length twelveInches = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: Quantity(1.0, FEET).equals(Quantity(12.0, INCHES))");
        System.out.println("Output: " + oneFoot.equals(twelveInches));

        System.out.println();

        System.out.println("Input: Quantity(1.0, FEET).convertTo(INCHES)");
        System.out.println("Output: " + oneFoot.convertTo(LengthUnit.INCHES));
    }
}