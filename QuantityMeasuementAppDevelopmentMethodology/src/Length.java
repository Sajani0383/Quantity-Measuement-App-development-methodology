/**
 * Length.java
 *
 * UC8: Refactored Quantity Length Class
 *
 * This class represents a length value with a specific unit.
 * The conversion responsibility is delegated to the standalone LengthUnit enum.
 *
 * Responsibilities:
 * 1. Store length value and unit.
 * 2. Compare two length objects.
 * 3. Convert one length unit to another.
 * 4. Add two length values.
 *
 * Rounding is done only after the final result is calculated.
 * This avoids precision loss during intermediate conversion.
 *
 * Example:
 * 2.54 centimeters should convert to exactly 1.0 inch approximately.
 * If rounding is done too early in the base conversion step, the result
 * becomes 0.96 inches. So intermediate values are not rounded.
 *
 * @author Sajani G
 * @version 8.0
 * @since UC8
 */
public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Length unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid length value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new Length(round(convertedValue), targetUnit);
    }

    public Length add(Length length) {
        return add(length, this.unit);
    }

    public Length add(Length length, LengthUnit targetUnit) {
        if (length == null) {
            throw new IllegalArgumentException("Length object cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double firstBaseValue = this.unit.convertToBaseUnit(this.value);
        double secondBaseValue = length.unit.convertToBaseUnit(length.value);
        double totalBaseValue = firstBaseValue + secondBaseValue;
        double resultValue = targetUnit.convertFromBaseUnit(totalBaseValue);

        return new Length(round(resultValue), targetUnit);
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Length length = (Length) object;

        return Math.abs(this.convertToBaseUnit() - length.convertToBaseUnit()) < 0.01;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}