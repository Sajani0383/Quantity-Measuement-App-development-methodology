import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-2;

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
    public void testCrossUnitInequality() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET)
                .equals(new Length(10.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testYardEquals36Inches() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS)
                .equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testCentimeterEqualsInches() {
        assertTrue(new Length(100.0, Length.LengthUnit.CENTIMETERS)
                .equals(new Length(39.3701, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testReferenceEquality() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void testNullEquality() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);
        assertFalse(l.equals(null));
    }

    @Test
    public void testConvertFeetToInches() {
        double result = Length.convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void testConvertYardsToFeet() {
        double result = Length.convert(3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        assertEquals(9.0, result, EPSILON);
    }

    @Test
    public void testConvertUsingObjectMethod() {
        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        Length converted = l.convertTo(Length.LengthUnit.INCHES);

        assertTrue(converted.equals(new Length(72.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testAddSameUnit() {
        Length result = new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(2.0, Length.LengthUnit.FEET));

        assertTrue(result.equals(new Length(3.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAddDifferentUnits() {
        Length result = new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES));

        assertTrue(result.equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAddReverseUnits() {
        Length result = new Length(12.0, Length.LengthUnit.INCHES)
                .add(new Length(1.0, Length.LengthUnit.FEET));

        assertTrue(result.equals(new Length(24.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testAddWithTargetUnitFeet() {
        Length result = new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES), Length.LengthUnit.FEET);

        assertTrue(result.equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAddWithTargetUnitInches() {
        Length result = new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES), Length.LengthUnit.INCHES);

        assertTrue(result.equals(new Length(24.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testAddWithTargetUnitYards() {
        Length result = new Length(1.0, Length.LengthUnit.FEET)
                .add(new Length(12.0, Length.LengthUnit.INCHES), Length.LengthUnit.YARDS);

        assertEquals(0.67, result.getValue(), EPSILON);
    }

    @Test
    public void testAddCentimeterAndInch() {
        Length result = new Length(2.54, Length.LengthUnit.CENTIMETERS)
                .add(new Length(1.0, Length.LengthUnit.INCHES));

        assertTrue(result.equals(new Length(5.08, Length.LengthUnit.CENTIMETERS)));
    }

    @Test
    public void testAddZero() {
        Length result = new Length(5.0, Length.LengthUnit.FEET)
                .add(new Length(0.0, Length.LengthUnit.INCHES));

        assertTrue(result.equals(new Length(5.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAddNegativeValues() {
        Length result = new Length(5.0, Length.LengthUnit.FEET)
                .add(new Length(-2.0, Length.LengthUnit.FEET));

        assertTrue(result.equals(new Length(3.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAddNullThrowsException() {
        Length l = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            l.add(null);
        });
    }

    @Test
    public void testAddWithNullTargetUnitThrowsException() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(l2, null);
        });
    }
}