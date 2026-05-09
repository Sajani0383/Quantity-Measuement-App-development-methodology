/**
 * VolumeUnit.java
 *
 * UC11: Volume Unit Enum Implementing IMeasurable
 *
 * This enum defines volume units and their conversion factors.
 * It implements IMeasurable so that it can be used with the
 * generic Quantity class.
 *
 * Base unit for volume: Litre
 *
 * Conversion factors:
 * 1 litre = 1 litre
 * 1 millilitre = 0.001 litre
 * 1 gallon = 3.78541 litres
 *
 * This class proves that the UC10 generic design can be extended
 * to a new measurement category without creating a separate Volume class.
 *
 * @author Sajani G
 * @version 11.0
 * @since UC11
 */
public enum VolumeUnit implements IMeasurable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
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