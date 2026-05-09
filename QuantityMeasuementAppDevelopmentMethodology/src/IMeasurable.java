/**
 * IMeasurable.java
 *
 * UC10: Common Unit Interface
 *
 * This interface defines a common contract for all measurable unit enums.
 * LengthUnit and WeightUnit both implement this interface.
 *
 * The purpose of this interface is to allow the generic Quantity class
 * to work with multiple measurement categories such as length and weight.
 *
 * Methods:
 * 1. getConversionFactor() - returns conversion factor to base unit
 * 2. convertToBaseUnit() - converts value to base unit
 * 3. convertFromBaseUnit() - converts base value to target unit
 * 4. getUnitName() - returns unit name
 *
 * @author Sajani G
 * @version 10.0
 * @since UC10
 */
public interface IMeasurable {
    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();
}