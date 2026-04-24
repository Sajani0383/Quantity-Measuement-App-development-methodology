/**
 * UC6 Test Class - Addition Operations Between Length Measurements
 *
 * Author: Sajani G
 * Version: 6.0
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.FEET)));
    }
    @Test
    public void testInchesEquality() {
        assertTrue(new Length(1.0, Length.LengthUnit.INCHES)
                .equals(new Length(1.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testInchesInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.INCHES)
                .equals(new Length(2.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testCrossUnitInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(10.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testMultipleFeetComparison() {
        assertTrue(new Length(3.0, Length.LengthUnit.FEET)
                .equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void yardEquals36Inches() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        assertTrue(new Length(100.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(39.3701, Length.LengthUnit.INCHES)));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertTrue(new Length(3.0, Length.LengthUnit.FEET)
                .equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void yardNotEqualToInches() {
        assertFalse(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(10.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length a = new Length(1.0, Length.LengthUnit.YARDS);
        Length b = new Length(3.0, Length.LengthUnit.FEET);
        Length c = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void convertFeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        Length converted = QuantityMeasurementApp
                .demonstrateLengthConversion(l, Length.LengthUnit.INCHES);

        Length expected = new Length(72.0, Length.LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(converted, expected));
    }

    @Test
    public void addFeetAndFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addFeetAndInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addInchesAndFeet() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(24.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addYardAndFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(2.0, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addCmAndInch() {
        Length l1 = new Length(2.54, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(5.08, Length.LengthUnit.CENTIMETERS);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addWithZero() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(5.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addNegativeValues() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    public void addNullShouldThrow() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(null);
        });
    }
}