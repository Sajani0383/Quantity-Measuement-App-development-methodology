import java.util.Objects;

/**
 * Quantity.java
 *
 * UC12: Generic Quantity Class with Extended Arithmetic Operations
 *
 * This class represents a quantity with a numeric value and a measurable unit.
 * The unit must implement the IMeasurable interface.
 *
 * In UC12, this class supports:
 * 1. Equality comparison
 * 2. Unit conversion
 * 3. Addition
 * 4. Subtraction
 * 5. Division
 *
 * The same class works with:
 * Quantity<LengthUnit>
 * Quantity<WeightUnit>
 * Quantity<VolumeUnit>
 *
 * Subtraction returns a new Quantity object.
 * Division returns a dimensionless double value.
 *
 * @param <U> measurable unit type
 *
 * @author Sajani G
 * @version 12.0
 * @since UC10
 */
public class Quantity<U extends IMeasurable> {
    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid quantity value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public Quantity<U> convertTo(U targetUnit) {
        validateTargetUnit(targetUnit);

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(round(convertedValue), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateOtherQuantity(other);
        validateTargetUnit(targetUnit);

        double firstBaseValue = this.unit.convertToBaseUnit(this.value);
        double secondBaseValue = other.unit.convertToBaseUnit(other.value);
        double totalBaseValue = firstBaseValue + secondBaseValue;
        double resultValue = targetUnit.convertFromBaseUnit(totalBaseValue);

        return new Quantity<>(round(resultValue), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateOtherQuantity(other);
        validateTargetUnit(targetUnit);

        double firstBaseValue = this.unit.convertToBaseUnit(this.value);
        double secondBaseValue = other.unit.convertToBaseUnit(other.value);
        double resultBaseValue = firstBaseValue - secondBaseValue;
        double resultValue = targetUnit.convertFromBaseUnit(resultBaseValue);

        return new Quantity<>(round(resultValue), targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateOtherQuantity(other);

        double firstBaseValue = this.unit.convertToBaseUnit(this.value);
        double secondBaseValue = other.unit.convertToBaseUnit(other.value);

        if (Math.abs(secondBaseValue) < 0.0000001) {
            throw new ArithmeticException("Division by zero is not allowed");
        }

        return roundDivision(firstBaseValue / secondBaseValue);
    }

    private void validateOtherQuantity(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible measurement categories");
        }
    }

    private void validateTargetUnit(U targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (this.unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Target unit belongs to a different category");
        }
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private double roundDivision(double value) {
        return Math.round(value * 1000000.0) / 1000000.0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Quantity<?> quantity = (Quantity<?>) object;

        if (this.unit.getClass() != quantity.unit.getClass()) {
            return false;
        }

        return Math.abs(this.convertToBaseUnit() - quantity.convertToBaseUnit()) < 0.01;
    }

    @Override
    public int hashCode() {
        double roundedBaseValue = round(convertToBaseUnit());
        return Objects.hash(roundedBaseValue, unit.getClass());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}