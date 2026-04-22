package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // 🔹 Overloaded method 1
    public static double demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {
        return Length.convert(value, from, to);
    }

    // 🔹 Overloaded method 2
    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit to) {
        return length.convertTo(to);
    }

    public static void main(String[] args) {

        System.out.println(convertExample());

        Length l = new Length(2.0, Length.LengthUnit.YARDS);
        System.out.println(demonstrateLengthConversion(l, Length.LengthUnit.INCHES));
    }

    static double convertExample() {
        return demonstrateLengthConversion(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);
    }
}