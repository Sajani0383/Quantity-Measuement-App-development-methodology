/**
 * LengthUnit.java
 *
 * UC12: Length Unit Enum Implementing IMeasurable
 *
 * This enum defines length units and their conversion factors.
 * It implements IMeasurable so that it can be used with the
 * generic Quantity class.
 *
 * Base unit for length: Inches
 *
 * Conversion factors:
 * 1 foot = 12 inches
 * 1 inch = 1 inch
 * 1 yard = 36 inches
 * 1 centimeter = 0.393701 inches
 *
 * @author Sajani G
 * @version 12.0
 * @since UC10
 */
public enum LengthUnit implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}