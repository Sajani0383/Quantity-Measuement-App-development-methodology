import java.util.Objects;

/**
 * Quantity.java
 *
 * UC10: Generic Quantity Class
 *
 * This class represents a quantity with a numeric value and a measurable unit.
 * The unit must implement the IMeasurable interface.
 *
 * This generic class replaces separate category-specific classes such as
 * Length and Weight.
 *
 * It can work with:
 * Quantity<LengthUnit>
 * Quantity<WeightUnit>
 *
 * Responsibilities:
 * 1. Store value and unit.
 * 2. Convert quantity from one unit to another.
 * 3. Add two compatible quantities.
 * 4. Compare two compatible quantities.
 *
 * @param <U> measurable unit type
 *
 * @author Sajani G
 * @version 10.0
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
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible unit category");
        }

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(round(convertedValue), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Cannot add quantities of different categories");
        }

        if (this.unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Target unit belongs to different category");
        }

        double firstBaseValue = this.unit.convertToBaseUnit(this.value);
        double secondBaseValue = other.unit.convertToBaseUnit(other.value);
        double totalBaseValue = firstBaseValue + secondBaseValue;
        double resultValue = targetUnit.convertFromBaseUnit(totalBaseValue);

        return new Quantity<>(round(resultValue), targetUnit);
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
