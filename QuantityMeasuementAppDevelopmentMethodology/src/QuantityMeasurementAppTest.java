import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuantityMeasurementAppTest.java
 *
 * UC13: Test Cases for Centralized Arithmetic Logic
 *
 * This test class validates that addition, subtraction, and division
 * still work correctly after refactoring arithmetic logic into a
 * centralized helper method.
 *
 * @author Sajani G
 * @version 13.0
 * @since UC13
 */
public class QuantityMeasurementAppTest {

    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(length1, length2);
    }

    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(weight1, weight2);
    }

    @Test
    public void volumeLitreEqualsMillilitres() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(volume1, volume2);
    }

    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = length.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void convertWeightKilogramsToGrams() {
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = weight.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void convertVolumeLitresToMillilitres() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = volume.convertTo(VolumeUnit.MILLILITRE);

        assertEquals(1000.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = length1.add(length2);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = weight1.add(weight2);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void addVolumeLitresAndMillilitres() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = volume1.add(volume2);

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

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
    public void testSubtractionVolumeLitreMinusMillilitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = volume1.subtract(volume2);

        assertEquals(4.5, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void testSubtractionNonCommutative() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        Quantity<LengthUnit> result1 = length1.subtract(length2);
        Quantity<LengthUnit> result2 = length2.subtract(length1);

        assertEquals(5.0, result1.getValue(), 0.01);
        assertEquals(-5.0, result2.getValue(), 0.01);
        assertNotEquals(result1, result2);
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
    public void testDivisionWeightKilogramDividedByGram() {
        Quantity<WeightUnit> weight1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(2000.0, WeightUnit.GRAM);

        double result = weight1.divide(weight2);

        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testDivisionVolumeMillilitreDividedByLitre() {
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
    public void testDivisionNonCommutative() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        double result1 = length1.divide(length2);
        double result2 = length2.divide(length1);

        assertEquals(2.0, result1, 0.01);
        assertEquals(0.5, result2, 0.01);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testDivisionByZero() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(0.0, LengthUnit.FEET);

        assertThrows(ArithmeticException.class, () -> length1.divide(length2));
    }

    @Test
    public void testNullOperandConsistentAcrossOperations() {
        Quantity<LengthUnit> length = new Quantity<>(10.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> length.add(null));
        assertThrows(IllegalArgumentException.class, () -> length.subtract(null));
        assertThrows(IllegalArgumentException.class, () -> length.divide(null));
    }

    @Test
    public void testNullTargetUnitAddSubtractReject() {
        Quantity<LengthUnit> length1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(5.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> length1.add(length2, null));
        assertThrows(IllegalArgumentException.class, () -> length1.subtract(length2, null));
    }

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
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

    @Test
    public void testAllOperationsAcrossVolumeCategory() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> added = volume1.add(volume2);
        Quantity<VolumeUnit> subtracted = volume1.subtract(volume2);
        double divided = volume1.divide(volume2);

        assertEquals(6.0, added.getValue(), 0.01);
        assertEquals(4.0, subtracted.getValue(), 0.01);
        assertEquals(5.0, divided, 0.01);
    }
}