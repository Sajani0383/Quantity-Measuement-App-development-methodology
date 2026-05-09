import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * QuantityMeasurementAppTest.java
 *
 * UC8: JUnit Test Cases for Refactoring LengthUnit Enum
 *
 * This test class verifies the refactored quantity measurement design.
 * LengthUnit is now a standalone enum responsible for unit conversion logic.
 *
 * Test Coverage:
 * 1. LengthUnit enum constants
 * 2. Conversion factor validation
 * 3. Conversion to base unit
 * 4. Conversion from base unit
 * 5. Length equality
 * 6. Length conversion
 * 7. Length addition
 * 8. Exception handling
 *
 * @author Sajani G
 * @version 8.0
 * @since UC8
 */
public class QuantityMeasurementAppTest {

    @Test
    public void testLengthUnitEnumFeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 0.01);
    }

    @Test
    public void testLengthUnitEnumInchesConstant() {
        assertEquals(1.0 / 12.0, LengthUnit.INCHES.getConversionFactor(), 0.01);
    }

    @Test
    public void testLengthUnitEnumYardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 0.01);
    }

    @Test
    public void testLengthUnitEnumCentimetersConstant() {
        assertEquals(1.0 / 30.48, LengthUnit.CENTIMETERS.getConversionFactor(), 0.01);
    }

    @Test
    public void testConvertToBaseUnitFeetToFeet() {
        assertEquals(5.0, LengthUnit.FEET.convertToBaseUnit(5.0), 0.01);
    }

    @Test
    public void testConvertToBaseUnitInchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), 0.01);
    }

    @Test
    public void testConvertToBaseUnitYardsToFeet() {
        assertEquals(3.0, LengthUnit.YARDS.convertToBaseUnit(1.0), 0.01);
    }

    @Test
    public void testConvertToBaseUnitCentimetersToFeet() {
        assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(30.48), 0.01);
    }

    @Test
    public void testConvertFromBaseUnitFeetToInches() {
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 0.01);
    }

    @Test
    public void testConvertFromBaseUnitFeetToYards() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0), 0.01);
    }

    @Test
    public void testConvertFromBaseUnitFeetToCentimeters() {
        assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 0.01);
    }

    @Test
    public void testFeetEqualsFeet() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);
        assertEquals(length1, length2);
    }

    @Test
    public void testFeetEqualsTwelveInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(length1, length2);
    }

    @Test
    public void testOneYardEqualsThirtySixInches() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(36.0, LengthUnit.INCHES);
        assertEquals(length1, length2);
    }

    @Test
    public void testFeetAndInchesNotEqual() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(10.0, LengthUnit.INCHES);
        assertNotEquals(length1, length2);
    }

    @Test
    public void testConvertFeetToInches() {
        Length result = new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testConvertYardsToFeet() {
        Length result = new Length(1.0, LengthUnit.YARDS).convertTo(LengthUnit.FEET);
        assertEquals(3.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testConvertCentimetersToInches() {
        Length result = new Length(2.54, LengthUnit.CENTIMETERS).convertTo(LengthUnit.INCHES);
        assertEquals(1.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddFeetAndInches() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddYardAndFeetWithTargetUnitYards() {
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(3.0, LengthUnit.FEET);
        Length result = length1.add(length2, LengthUnit.YARDS);
        assertEquals(2.0, result.getValue(), 0.01);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddFeetAndInchesWithTargetUnitYards() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        Length result = length1.add(length2, LengthUnit.YARDS);
        assertEquals(0.67, result.getValue(), 0.01);
        assertEquals(LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testNullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
    }

    @Test
    public void testNaNValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));
    }

    @Test
    public void testInfiniteValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.POSITIVE_INFINITY, LengthUnit.FEET));
    }

    @Test
    public void testConvertToNullTargetUnitThrowsException() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length.convertTo(null));
    }

    @Test
    public void testAddNullLengthThrowsException() {
        Length length = new Length(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length.add(null));
    }

    @Test
    public void testAddWithNullTargetUnitThrowsException() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertThrows(IllegalArgumentException.class, () -> length1.add(length2, null));
    }
}