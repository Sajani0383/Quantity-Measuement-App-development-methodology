import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuantityMeasurementAppTest.java
 *
 * UC11: Test Cases for Generic Quantity Class with Volume Support
 *
 * This test class checks length, weight, and volume operations using
 * the same generic Quantity class.
 *
 * Test Coverage:
 * 1. Length equality, conversion, and addition
 * 2. Weight equality, conversion, and addition
 * 3. Volume equality, conversion, and addition
 * 4. Cross-category comparison prevention
 * 5. Exception handling
 *
 * @author Sajani G
 * @version 11.0
 * @since UC11
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
    public void volumeLitreEqualsMillilitres() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertEquals(volume1, volume2);
    }

    @Test
    public void volumeGallonEqualsLitres() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> volume2 = new Quantity<>(3.78541, VolumeUnit.LITRE);

        assertEquals(volume1, volume2);
    }

    @Test
    public void volumeLitreEqualsGallonEquivalent() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertEquals(volume1, volume2);
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
    public void convertVolumeLitreToMillilitre() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateConversion(
                volume,
                VolumeUnit.MILLILITRE
        );

        assertEquals(1000.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void convertVolumeMillilitreToLitre() {
        Quantity<VolumeUnit> volume = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateConversion(
                volume,
                VolumeUnit.LITRE
        );

        assertEquals(1.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void convertVolumeGallonToLitre() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.GALLON);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateConversion(
                volume,
                VolumeUnit.LITRE
        );

        assertEquals(3.79, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void convertVolumeLitreToGallon() {
        Quantity<VolumeUnit> volume = new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateConversion(
                volume,
                VolumeUnit.GALLON
        );

        assertEquals(1.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.GALLON, result.getUnit());
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
    public void addVolumeLitreAndMillilitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateAddition(
                volume1,
                volume2,
                VolumeUnit.LITRE
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
    }

    @Test
    public void addVolumeLitreAndMillilitreInMillilitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateAddition(
                volume1,
                volume2,
                VolumeUnit.MILLILITRE
        );

        assertEquals(2000.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.MILLILITRE, result.getUnit());
    }

    @Test
    public void addVolumeGallonAndLitre() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> volume2 = new Quantity<>(3.78541, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = QuantityMeasurementApp.demonstrateAddition(
                volume1,
                volume2,
                VolumeUnit.GALLON
        );

        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.GALLON, result.getUnit());
    }

    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    @Test
    public void preventCrossTypeComparisonVolumeVsLength() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        assertNotEquals(volume, length);
    }

    @Test
    public void preventCrossTypeComparisonVolumeVsWeight() {
        Quantity<VolumeUnit> volume = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(volume, weight);
    }

    @Test
    public void testGenericTypeSafetyWithWeight() {
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertEquals(1.0, weight.getValue(), 0.01);
        assertEquals(WeightUnit.KILOGRAM, weight.getUnit());
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
    public void backwardCompatibilityAddVolumeInSameUnit() {
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(2.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> result = volume1.add(volume2);

        assertEquals(3.0, result.getValue(), 0.01);
        assertEquals(VolumeUnit.LITRE, result.getUnit());
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
        Quantity<VolumeUnit> volume1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volume2 = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        assertThrows(IllegalArgumentException.class, () -> volume1.add(volume2, null));
    }
}