/**
 * WeightUnit.java
 *
 * UC10 and UC11: Weight Unit Enum Implementing IMeasurable
 *
 * This enum defines weight units and their conversion factors.
 * It implements IMeasurable so that it can be used with the
 * generic Quantity class.
 *
 * Base unit for weight: Grams
 *
 * Conversion factors:
 * 1 milligram = 0.001 grams
 * 1 gram = 1 gram
 * 1 kilogram = 1000 grams
 * 1 pound = 453.592 grams
 * 1 tonne = 1000000 grams
 *
 * @author Sajani G
 * @version 11.0
 * @since UC10
 */
public enum WeightUnit implements IMeasurable {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1000000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
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