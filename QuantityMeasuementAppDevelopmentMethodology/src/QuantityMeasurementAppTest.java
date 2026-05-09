import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuantityMeasurementAppTest.java
 *
 * UC9: Test Cases for Weight Measurement Support
 *
 * This test class verifies weight equality, conversion, and addition.
 * It also verifies that existing length functionality is still working.
 *
 * Test Coverage:
 * 1. Weight unit constants
 * 2. Weight equality
 * 3. Cross-unit weight equality
 * 4. Weight conversion
 * 5. Weight addition
 * 6. Weight addition with target unit
 * 7. Exception handling
 * 8. Existing length functionality
 *
 * @author Sajani G
 * @version 9.0
 * @since UC9
 */
public class QuantityMeasurementAppTest {

    @Test
    public void kilogramEquals1000Grams() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);
        assertEquals(weight1, weight2);
    }

    @Test
    public void poundEquals453Point592Grams() {
        Weight weight1 = new Weight(1.0, WeightUnit.POUND);
        Weight weight2 = new Weight(453.592, WeightUnit.GRAM);
        assertEquals(weight1, weight2);
    }

    @Test
    public void tonneEquals1000000Grams() {
        Weight weight1 = new Weight(1.0, WeightUnit.TONNE);
        Weight weight2 = new Weight(1000000.0, WeightUnit.GRAM);
        assertEquals(weight1, weight2);
    }

    @Test
    public void kilogramNotEqualToPound() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1.0, WeightUnit.POUND);
        assertNotEquals(weight1, weight2);
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);
        Weight result = weight1.add(weight2, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testWeightUnitEnumMilligramConstant() {
        assertEquals(0.001, WeightUnit.MILLIGRAM.getConversionFactor(), 0.001);
    }

    @Test
    public void testWeightUnitEnumGramConstant() {
        assertEquals(1.0, WeightUnit.GRAM.getConversionFactor(), 0.001);
    }

    @Test
    public void testWeightUnitEnumKilogramConstant() {
        assertEquals(1000.0, WeightUnit.KILOGRAM.getConversionFactor(), 0.001);
    }

    @Test
    public void testWeightUnitEnumPoundConstant() {
        assertEquals(453.592, WeightUnit.POUND.getConversionFactor(), 0.001);
    }

    @Test
    public void testWeightUnitEnumOunceConstant() {
        assertEquals(28.3495, WeightUnit.OUNCE.getConversionFactor(), 0.001);
    }

    @Test
    public void testWeightUnitEnumTonneConstant() {
        assertEquals(1000000.0, WeightUnit.TONNE.getConversionFactor(), 0.001);
    }

    @Test
    public void testConvertKilogramToGram() {
        Weight result = new Weight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testConvertGramToKilogram() {
        Weight result = new Weight(1000.0, WeightUnit.GRAM).convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testConvertPoundToGram() {
        Weight result = new Weight(1.0, WeightUnit.POUND).convertTo(WeightUnit.GRAM);

        assertEquals(453.59, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testConvertGramToPound() {
        Weight result = new Weight(453.592, WeightUnit.GRAM).convertTo(WeightUnit.POUND);

        assertEquals(1.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    @Test
    public void testConvertKilogramToPound() {
        Weight result = new Weight(1.0, WeightUnit.KILOGRAM).convertTo(WeightUnit.POUND);

        assertEquals(2.2, result.getValue(), 0.01);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    @Test
    public void testConvertOunceToGram() {
        Weight result = new Weight(1.0, WeightUnit.OUNCE).convertTo(WeightUnit.GRAM);

        assertEquals(28.35, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testConvertTonneToKilogram() {
        Weight result = new Weight(1.0, WeightUnit.TONNE).convertTo(WeightUnit.KILOGRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testAddKilogramAndGram() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight result = weight1.add(weight2);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testAddKilogramAndGramWithTargetUnitGram() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);

        Weight result = weight1.add(weight2, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testAddPoundAndGramWithTargetUnitPound() {
        Weight weight1 = new Weight(1.0, WeightUnit.POUND);
        Weight weight2 = new Weight(453.592, WeightUnit.GRAM);

        Weight result = weight1.add(weight2, WeightUnit.POUND);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    @Test
    public void testAddWithZeroWeight() {
        Weight weight1 = new Weight(5.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(0.0, WeightUnit.GRAM);

        Weight result = weight1.add(weight2, WeightUnit.KILOGRAM);

        assertEquals(5.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testNegativeWeightEquality() {
        Weight weight1 = new Weight(-1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(-1000.0, WeightUnit.GRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    public void testLargeWeightEquality() {
        Weight weight1 = new Weight(1000000.0, WeightUnit.GRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.KILOGRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    public void testSmallWeightEquality() {
        Weight weight1 = new Weight(0.001, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1.0, WeightUnit.GRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    public void testReferenceEqualitySameObject() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);

        assertEquals(weight, weight);
    }

    @Test
    public void testEqualsReturnsFalseForNull() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(null, weight);
    }

    @Test
    public void testWeightAndLengthAreNotEqual() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);
        Length length = new Length(1.0, LengthUnit.FEET);

        assertNotEquals(weight, length);
    }

    @Test
    public void testTransitiveProperty() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);
        Weight weight3 = new Weight(2.20462, WeightUnit.POUND);

        assertEquals(weight1, weight2);
        assertEquals(weight2, weight3);
        assertEquals(weight1, weight3);
    }

    @Test
    public void testRoundTripConversion() {
        Weight original = new Weight(1.5, WeightUnit.KILOGRAM);
        Weight converted = original.convertTo(WeightUnit.GRAM);
        Weight roundTrip = converted.convertTo(WeightUnit.KILOGRAM);

        assertEquals(original, roundTrip);
    }

    @Test
    public void testNullWeightUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(1.0, null));
    }

    @Test
    public void testNaNWeightValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(Double.NaN, WeightUnit.KILOGRAM));
    }

    @Test
    public void testInfiniteWeightValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(Double.POSITIVE_INFINITY, WeightUnit.KILOGRAM));
    }

    @Test
    public void testConvertToNullWeightTargetUnitThrowsException() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> weight.convertTo(null));
    }

    @Test
    public void testAddNullWeightThrowsException() {
        Weight weight = new Weight(1.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> weight.add(null));
    }

    @Test
    public void testAddWithNullWeightTargetUnitThrowsException() {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000.0, WeightUnit.GRAM);

        assertThrows(IllegalArgumentException.class, () -> weight1.add(weight2, null));
    }

    @Test
    public void testFeetEquality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    @Test
    public void testInchesEquality() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void testFeetInchesComparison() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void testFeetInequality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);

        assertNotEquals(length1, length2);
    }

    @Test
    public void testInchesInequality() {
        Length length1 = new Length(10.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertNotEquals(length1, length2);
    }

    @Test
    public void testCrossUnitInequality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(10.0, LengthUnit.INCHES);

        assertNotEquals(length1, length2);
    }

    @Test
    public void testMultipleFeetComparison() {
        Length length1 = new Length(3.0, LengthUnit.FEET);
        Length length2 = new Length(36.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void yardEquals36Inches() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(36.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length length1 = new Length(100.0, LengthUnit.CENTIMETERS);
        Length length2 = new Length(39.3701, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length length1 = new Length(3.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.YARDS);

        assertEquals(length1, length2);
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length length1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        assertEquals(length1, length2);
    }

    @Test
    public void yardNotEqualToInches() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        assertNotEquals(length1, length2);
    }

    @Test
    public void referenceEqualitySameObjectLength() {
        Length length = new Length(1.0, LengthUnit.FEET);

        assertEquals(length, length);
    }

    @Test
    public void equalsReturnsFalseForNullLength() {
        Length length = new Length(1.0, LengthUnit.FEET);

        assertNotEquals(null, length);
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length length3 = new Length(0.333333, LengthUnit.YARDS);

        assertEquals(length1, length1);
        assertEquals(length1, length2);
        assertEquals(length2, length1);
        assertEquals(length1, length3);
        assertEquals(length2, length3);
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);

        assertNotEquals(length1, length2);
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        boolean result = QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES
        );

        assertTrue(result);
    }

    @Test
    public void convertFeetToInches() {
        Length result = new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void convertYardsToInchesUsingOverLoadedMethod() {
        Length length = new Length(1.0, LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(length, LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void addFeetAndInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length result = length1.add(length2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }
}