/**
 * Weight.java
 *
 * UC9: Weight Measurement Class
 *
 * This class represents a weight quantity with its value and unit.
 * It supports equality comparison, unit conversion, and addition.
 *
 * The conversion responsibility is delegated to the standalone WeightUnit enum.
 * WeightUnit converts all values through the common base unit, grams.
 *
 * Responsibilities:
 * 1. Store weight value and weight unit.
 * 2. Compare two weight measurements.
 * 3. Convert weight from one unit to another.
 * 4. Add two weight measurements.
 *
 * Example:
 * new Weight(1.0, WeightUnit.KILOGRAM)
 * is equal to
 * new Weight(1000.0, WeightUnit.GRAM)
 *
 * @author Sajani G
 * @version 9.0
 * @since UC9
 */
public class Weight {
    private double value;
    private WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Weight unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid weight value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double weightInGrams = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(weightInGrams);

        return new Weight(round(convertedValue), targetUnit);
    }

    public Weight add(Weight weight) {
        return add(weight, this.unit);
    }

    public Weight add(Weight weight, WeightUnit targetUnit) {
        if (weight == null) {
            throw new IllegalArgumentException("Weight object cannot be null");
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double firstWeightInGrams = this.unit.convertToBaseUnit(this.value);
        double secondWeightInGrams = weight.unit.convertToBaseUnit(weight.value);
        double totalWeightInGrams = firstWeightInGrams + secondWeightInGrams;
        double resultValue = targetUnit.convertFromBaseUnit(totalWeightInGrams);

        return new Weight(round(resultValue), targetUnit);
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private boolean compare(Weight thatWeight) {
        return Math.abs(this.convertToBaseUnit() - thatWeight.convertToBaseUnit()) < 0.01;
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

        Weight thatWeight = (Weight) object;
        return compare(thatWeight);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }

    public static void main(String[] args) {
        Weight oneKilogram = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight thousandGrams = new Weight(1000.0, WeightUnit.GRAM);

        System.out.println(oneKilogram.equals(thousandGrams));
        System.out.println(oneKilogram.convertTo(WeightUnit.GRAM));
        System.out.println(oneKilogram.add(thousandGrams, WeightUnit.KILOGRAM));
    }
}