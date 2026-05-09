import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

/**
 * Quantity.java
 *
 * UC13: Generic Quantity Class with Centralized Arithmetic Logic
 *
 * This class represents a quantity with a numeric value and a measurable unit.
 * The unit must implement the IMeasurable interface.
 *
 * In UC13, arithmetic logic is refactored to follow the DRY principle.
 * Addition, subtraction, and division now use a centralized helper method
 * called performArithmetic().
 *
 * The ArithmeticOperation enum represents arithmetic operations using
 * lambda expressions.
 *
 * Supported operations:
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
 * @param <U> measurable unit type
 *
 * @author Sajani G
 * @version 13.0
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

        return new Quantity<>(roundToTwoDecimals(convertedValue), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);

        double resultBaseValue = performArithmetic(other, ArithmeticOperation.ADD);
        double resultValue = targetUnit.convertFromBaseUnit(resultBaseValue);

        return new Quantity<>(roundToTwoDecimals(resultValue), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validateArithmeticOperands(other, targetUnit, true);

        double resultBaseValue = performArithmetic(other, ArithmeticOperation.SUBTRACT);
        double resultValue = targetUnit.convertFromBaseUnit(resultBaseValue);

        return new Quantity<>(roundToTwoDecimals(resultValue), targetUnit);
    }

    public double divide(Quantity<U> other) {
        validateArithmeticOperands(other, null, false);

        double result = performArithmetic(other, ArithmeticOperation.DIVIDE);

        return roundDivision(result);
    }

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired
    ) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity cannot be null");
        }

        if (this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible measurement categories");
        }

        if (Double.isNaN(this.value) || Double.isInfinite(this.value)) {
            throw new IllegalArgumentException("Invalid current quantity value");
        }

        if (Double.isNaN(other.value) || Double.isInfinite(other.value)) {
            throw new IllegalArgumentException("Invalid other quantity value");
        }

        if (targetUnitRequired) {
            validateTargetUnit(targetUnit);
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

    private double performArithmetic(Quantity<U> other, ArithmeticOperation operation) {
        double thisBaseValue = this.unit.convertToBaseUnit(this.value);
        double otherBaseValue = other.unit.convertToBaseUnit(other.value);

        return operation.compute(thisBaseValue, otherBaseValue);
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private double roundDivision(double value) {
        return Math.round(value * 1000000.0) / 1000000.0;
    }

    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {
            if (Math.abs(b) < 0.0000001) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        });

        private final DoubleBinaryOperator operation;

        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        public double compute(double a, double b) {
            return operation.applyAsDouble(a, b);
        }
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
        double roundedBaseValue = roundToTwoDecimals(convertToBaseUnit());
        return Objects.hash(roundedBaseValue, unit.getClass());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}