/**
 * UC3: Generic Quantity Length Class
 *
 * Description:
 * Unified class to handle multiple length units using DRY principle.
 * Converts values to base unit (inches) for comparison.
 *
 * Author: Sajani G
 * Version: 3.0
 */

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    public boolean compare(Length thatLength) {
        if (thatLength == null) return false;
        return this.convertToBaseUnit() == thatLength.convertToBaseUnit();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Length)) return false;
        Length that = (Length) obj;
        return this.convertToBaseUnit() == that.convertToBaseUnit();
    }

    public static void main(String[] args) {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Are lengths equal? " + length1.equals(length2));
    }
}