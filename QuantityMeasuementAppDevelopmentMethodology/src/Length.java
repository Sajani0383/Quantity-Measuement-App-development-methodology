/**
 * UC6: Quantity Length with Addition Support
 *
 * Author: Sajani G
 * Version: 6.0
 */

public class Length {

    private double value;
    private LengthUnit unit;
    private static final double EPSILON = 1e-6;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);
        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException();
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

    private double toBase() {
        return value * unit.getFactor();
    }

    private static double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    public Length convertTo(LengthUnit target) {
        if (target == null) throw new IllegalArgumentException();

        double base = toBase();
        double converted = base / target.getFactor();

        return new Length(round(converted), target);
    }

    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (from == null || to == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }
        double base = value * from.getFactor();
        return base / to.getFactor();
    }

    public Length add(Length other) {
        if (other == null) throw new IllegalArgumentException();

        double sumBase = this.toBase() + other.toBase();
        double result = sumBase / this.unit.getFactor();

        return new Length(round(result), this.unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Length)) return false;
        Length other = (Length) obj;
        return Math.abs(this.toBase() - other.toBase()) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}