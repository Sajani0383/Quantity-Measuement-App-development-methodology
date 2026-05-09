/**
 * LengthUnit.java
 *
 * UC8: Refactoring Unit Enum to Standalone Class
 *
 * This enum represents different length units used in the Quantity
 * Measurement application. In UC8, LengthUnit is extracted as a standalone
 * enum instead of being placed inside the Length class.
 *
 * The main responsibility of this enum is to store the conversion factor
 * of each unit and perform conversion to and from the base unit.
 *
 * Base unit: Feet
 *
 * Supported units:
 * FEET, INCHES, YARDS, CENTIMETERS
 *
 * Important:
 * Rounding is not done inside this enum because these methods are used
 * for intermediate calculations. Rounding is done only in the Length class
 * after the final conversion or addition result is calculated.
 *
 * @author Sajani G
 * @version 8.0
 * @since UC8
 */
public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}