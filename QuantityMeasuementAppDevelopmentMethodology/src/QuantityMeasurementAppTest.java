import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuantityMeasurementAppTest.java
 *
 * UC12: Test Cases for Subtraction and Division Operations
 *
 * This test class validates subtraction and division operations
 * for length, weight, and volume measurements using the same
 * generic Quantity class.
 *
 * @author Sajani G
 * @version 12.0
 * @since UC12
 */
public class QuantityMeasurementAppTest {

    @Test
    public void testSubtractionSameUnitFeetMinusFeet() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(5.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionCrossUnitFeetMinusInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(9.5, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionExplicitTargetUnitInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = length1.subtract(length2, LengthUnit.INCHES);

        assertEquals(114.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testSubtractionWeightKilogramMinusGram() {
        Quantity<WeightUnit> weight1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = weight1.subtract(weight2);

        assertEquals(5.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testSubtractionWeightInGramTargetUnit() {
        Quantity<WeightUnit> weight1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = weight1.subtract(weight2, WeightUnit.GRAM);

        assertEquals(5000.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testSubtractionVolumeLitreMinusMillilitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = volume1.subtract(volume2);

        assertEquals(4.5, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void testSubtractionVolumeTargetMillilitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = volume1.subtract(volume2, VolumeUnit.MILLILITRE);

        assertEquals(3000.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void testSubtractionResultingInNegative() {
        Quantity<LengthUnit> length1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(-5.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionResultingInZero() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(120.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(0.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionWithZeroOperand() {
        Quantity<LengthUnit> length1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(0.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(5.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionWithNegativeValues() {
        Quantity<LengthUnit> length1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(-2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length1.subtract(length2);

        assertEquals(7.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionNonCommutative() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result1 = length1.subtract(length2);
        Quantity<LengthUnit> result2 = length2.subtract(length1);

        assertNotEquals(result1, result2);
        assertEquals(5.0, result1.getValue(), 0.01);
        assertEquals(-5.0, result2.getValue(), 0.01);
    }

    @Test
    public void testSubtractionChainedOperations() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> length3 = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length1.subtract(length2).subtract(length3);

        assertEquals(7.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testSubtractionNullOperand() {
        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> length.subtract(null));
    }

    @Test
    public void testSubtractionNullTargetUnit() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> length1.subtract(length2, null));
    }

    @Test
    public void testDivisionSameUnitFeetDividedByFeet() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = length1.divide(length2);

        assertEquals(5.0, result, 0.01);
    }

    @Test
    public void testDivisionCrossUnitInchesDividedByFeet() {
        Quantity<LengthUnit> length1 = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> length2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = length1.divide(length2);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testDivisionKilogramDividedByGram() {
        Quantity<WeightUnit> weight1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(2000.0, WeightUnit.GRAM);

        double result = weight1.divide(weight2);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testDivisionLitreDividedByLitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(5.0, VolumeUnit.LITRE);

        double result = volume1.divide(volume2);

        assertEquals(2.0, result, 0.01);
    }

    @Test
    public void testDivisionMillilitreDividedByLitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1.0, VolumeUnit.LITRE);

        double result = volume1.divide(volume2);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testDivisionRatioGreaterThanOne() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(2.0, LengthUnit.FEET);

        assertEquals(5.0, length1.divide(length2), 0.01);
    }

    @Test
    public void testDivisionRatioLessThanOne() {
        Quantity<LengthUnit> length1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(10.0, LengthUnit.FEET);

        assertEquals(0.5, length1.divide(length2), 0.01);
    }

    @Test
    public void testDivisionRatioEqualToOne() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(10.0, LengthUnit.FEET);

        assertEquals(1.0, length1.divide(length2), 0.01);
    }

    @Test
    public void testDivisionNonCommutative() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        double result1 = length1.divide(length2);
        double result2 = length2.divide(length1);

        assertNotEquals(result1, result2);
        assertEquals(2.0, result1, 0.01);
        assertEquals(0.5, result2, 0.01);
    }

    @Test
    public void testDivisionByZero() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> length1.divide(length2));
    }

    @Test
    public void testDivisionNullOperand() {
        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> length.divide(null));
    }

    @Test
    public void testAdditionSubtractionInverse() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length1.add(length2).subtract(length2);

        assertEquals(length1, result);
    }

    @Test
    public void testSubtractionImmutability() {
        Quantity<LengthUnit> original = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtractValue = new Quantity<>(2.0, LengthUnit.FEET);

        original.subtract(subtractValue);

        assertEquals(10.0, original.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, original.getUnit());
    }

    @Test
    public void testDivisionImmutability() {
        Quantity<WeightUnit> original = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> divisor = new Quantity<>(2.0, WeightUnit.KILOGRAM);

        original.divide(divisor);

        assertEquals(10.0, original.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, original.getUnit());
    }
}