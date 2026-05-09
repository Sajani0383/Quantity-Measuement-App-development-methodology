/**
 * WeightUnit.java
 *
 * UC9: Weight Unit Enum with Base Unit Conversion
 *
 * The WeightUnit enum defines different units of weight measurement.
 * Each unit stores a conversion factor relative to the base unit.
 *
 * Base unit: Gram
 *
 * Supported units:
 * MILLIGRAM
 * GRAM
 * KILOGRAM
 * POUND
 * OUNCE
 * TONNE
 *
 * This enum is responsible for:
 * 1. Storing conversion factors.
 * 2. Converting a value from a specific unit to grams.
 * 3. Converting a value from grams to a specific unit.
 *
 * Example:
 * 1 kilogram = 1000 grams
 * 1 pound = 453.592 grams
 * 1 ounce = 28.3495 grams
 *
 * @author Sajani G
 * @version 9.0
 * @since UC9
 */
public enum WeightUnit {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    OUNCE(28.3495),
    TONNE(1000000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
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

    public static void main(String[] args) {
        double kilograms = 10.0;
        double grams = WeightUnit.KILOGRAM.convertToBaseUnit(kilograms);
        System.out.println(kilograms + " kilograms is " + grams + " grams.");

        double milligrams = WeightUnit.MILLIGRAM.convertFromBaseUnit(grams);
        System.out.println(grams + " grams is " + milligrams + " milligrams.");
    }
}