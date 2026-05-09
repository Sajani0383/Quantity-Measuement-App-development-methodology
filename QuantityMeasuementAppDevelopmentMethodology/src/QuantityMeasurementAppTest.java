import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuantityMeasurementAppTest.java
 *
 * UC10: Test Cases for Generic Quantity Class
 *
 * This test class checks length and weight operations using the same
 * generic Quantity class.
 *
 * Test Coverage:
 * 1. Length equality
 * 2. Weight equality
 * 3. Length conversion
 * 4. Weight conversion
 * 5. Length addition
 * 6. Weight addition
 * 7. Cross-category comparison prevention
 * 8. Exception handling
 *
 * @author Sajani G
 * @version 10.0
 * @since UC10
 */
public class QuantityMeasurementAppTest {

    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> length2 = new Quantity<>(3.0, LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    public void weightPoundEqualsGrams() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> weight2 = new Quantity<>(453.592, WeightUnit.GRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = QuantityMeasurementApp.demonstrateConversion(
                length,
                LengthUnit.INCHES
        );

        assertEquals(12.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void convertLengthYardsToInches() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result = QuantityMeasurementApp.demonstrateConversion(
                length,
                LengthUnit.INCHES
        );

        assertEquals(36.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void convertWeightKilogramsToGrams() {
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = QuantityMeasurementApp.demonstrateConversion(
                weight,
                WeightUnit.GRAM
        );

        assertEquals(1000.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = QuantityMeasurementApp.demonstrateAddition(
                length1,
                length2,
                LengthUnit.FEET
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void addLengthYardsAndFeet() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> length2 = new Quantity<>(3.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = QuantityMeasurementApp.demonstrateAddition(
                length1,
                length2,
                LengthUnit.YARDS
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = QuantityMeasurementApp.demonstrateAddition(
                weight1,
                weight2,
                WeightUnit.KILOGRAM
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void addWeightKilogramsAndPounds() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(2.20462, WeightUnit.POUND);

        Quantity<WeightUnit> result = QuantityMeasurementApp.demonstrateAddition(
                weight1,
                weight2,
                WeightUnit.KILOGRAM
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void addWeightTonnesAndKilograms() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.TONNE);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = QuantityMeasurementApp.demonstrateAddition(
                weight1,
                weight2,
                WeightUnit.TONNE
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.TONNE, result.getUnit());
    }

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    @Test
    public void backwardCompatibilityAddLengthInSameUnit() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length1.add(length2);

        assertEquals(3.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void backwardCompatibilityAddWeightInSameUnit() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(2.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = weight1.add(weight2);

        assertEquals(3.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void backwardCompatibilityChainedAdditionsLength() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> length3 = new Quantity<>(1.0, LengthUnit.YARDS);

        Quantity<LengthUnit> result = length1.add(length2).add(length3);

        assertEquals(5.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void constructorRejectsNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(1.0, null));
    }

    @Test
    public void constructorRejectsNaNValue() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    @Test
    public void constructorRejectsInfiniteValue() {
        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(Double.POSITIVE_INFINITY, WeightUnit.KILOGRAM));
    }

    @Test
    public void convertRejectsNullTargetUnit() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> length.convertTo(null));
    }

    @Test
    public void addRejectsNullQuantity() {
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> weight.add(null));
    }

    @Test
    public void addRejectsNullTargetUnit() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertThrows(IllegalArgumentException.class, () -> weight1.add(weight2, null));
    }
}