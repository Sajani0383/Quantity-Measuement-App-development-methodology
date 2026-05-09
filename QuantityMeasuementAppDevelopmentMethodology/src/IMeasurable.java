/**
 * IMeasurable.java
 *
 * UC13: Common Unit Interface
 *
 * This interface defines a common contract for all measurable units.
 * LengthUnit, WeightUnit, and VolumeUnit implement this interface.
 *
 * It allows the generic Quantity class to work with different
 * measurement categories such as length, weight, and volume.
 *
 * @author Sajani G
 * @version 13.0
 * @since UC10
 */
public interface IMeasurable {
    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();
}