/**
 * QuantityMeasurementApp.java
 *
 * UC13: Quantity Measurement Application
 *
 * This class demonstrates the generic Quantity class with:
 * 1. Equality comparison
 * 2. Conversion
 * 3. Addition
 * 4. Subtraction
 * 5. Division
 *
 * The same generic methods work for length, weight, and volume.
 *
 * @author Sajani G
 * @version 13.0
 * @since UC13
 */
public class QuantityMeasurementApp {

    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.equals(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> quantity,
            U targetUnit
    ) {
        return quantity.convertTo(targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.add(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit
    ) {
        return quantity1.add(quantity2, targetUnit);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.subtract(quantity2);
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit
    ) {
        return quantity1.subtract(quantity2, targetUnit);
    }

    public static <U extends IMeasurable> double demonstrateDivision(
            Quantity<U> quantity1,
            Quantity<U> quantity2
    ) {
        return quantity1.divide(quantity2);
    }

    public static void main(String[] args) {
        Quantity<LengthUnit> oneFoot = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> twelveInches = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<WeightUnit> oneKilogram = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> thousandGrams = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<VolumeUnit> oneLitre = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> thousandMillilitres = new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println("Equality Operations");
        System.out.println("1 FEET equals 12 INCHES: " + demonstrateEquality(oneFoot, twelveInches));
        System.out.println("1 KILOGRAM equals 1000 GRAM: " + demonstrateEquality(oneKilogram, thousandGrams));
        System.out.println("1 LITRE equals 1000 MILLILITRE: " + demonstrateEquality(oneLitre, thousandMillilitres));

        System.out.println();

        System.out.println("Conversion Operations");
        System.out.println("1 FEET to INCHES: " + demonstrateConversion(oneFoot, LengthUnit.INCHES));
        System.out.println("1 KILOGRAM to GRAM: " + demonstrateConversion(oneKilogram, WeightUnit.GRAM));
        System.out.println("1 LITRE to MILLILITRE: " + demonstrateConversion(oneLitre, VolumeUnit.MILLILITRE));

        System.out.println();

        System.out.println("Addition Operations");
        System.out.println("1 FEET + 12 INCHES = " + demonstrateAddition(oneFoot, twelveInches));
        System.out.println("1 KILOGRAM + 1000 GRAM = " + demonstrateAddition(oneKilogram, thousandGrams));
        System.out.println("1 LITRE + 1000 MILLILITRE = " + demonstrateAddition(oneLitre, thousandMillilitres));

        System.out.println();

        System.out.println("Subtraction Operations");

        Quantity<LengthUnit> tenFeet = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> sixInches = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<WeightUnit> tenKilograms = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> fiveThousandGrams = new Quantity<>(5000.0, WeightUnit.GRAM);

        Quantity<VolumeUnit> fiveLitres = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> fiveHundredMillilitres = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("10 FEET - 6 INCHES = " + demonstrateSubtraction(tenFeet, sixInches));
        System.out.println("10 FEET - 6 INCHES in INCHES = " + demonstrateSubtraction(
                tenFeet,
                sixInches,
                LengthUnit.INCHES
        ));
        System.out.println("10 KILOGRAM - 5000 GRAM = " + demonstrateSubtraction(
                tenKilograms,
                fiveThousandGrams
        ));
        System.out.println("5 LITRE - 500 MILLILITRE = " + demonstrateSubtraction(
                fiveLitres,
                fiveHundredMillilitres
        ));

        System.out.println();

        System.out.println("Division Operations");
        System.out.println("10 FEET / 2 FEET = " + demonstrateDivision(
                new Quantity<>(10.0, LengthUnit.FEET),
                new Quantity<>(2.0, LengthUnit.FEET)
        ));
        System.out.println("24 INCHES / 2 FEET = " + demonstrateDivision(
                new Quantity<>(24.0, LengthUnit.INCHES),
                new Quantity<>(2.0, LengthUnit.FEET)
        ));
        System.out.println("10 KILOGRAM / 5 KILOGRAM = " + demonstrateDivision(
                new Quantity<>(10.0, WeightUnit.KILOGRAM),
                new Quantity<>(5.0, WeightUnit.KILOGRAM)
        ));
        System.out.println("5 LITRE / 10 LITRE = " + demonstrateDivision(
                new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(10.0, VolumeUnit.LITRE)
        ));
    }
}