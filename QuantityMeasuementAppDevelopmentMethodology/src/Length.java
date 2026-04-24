/**
 * UC4: Generic Quantity Length Class with Extended Units
 *
 * Description:
 * Supports FEET, INCHES, YARDS, CENTIMETERS.
 * Uses base unit (inches) and precision-safe comparison.
 *
 * Author: Sajani G
 * Version: 4.0
 */

public class Length {

    private double value;
    private LengthUnit unit;
    private static final double EPSILON = 0.0001;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length other) {
        if (other == null) return false;
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Length)) return false;
        Length other = (Length) obj;
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPSILON;
    }
}