package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;`+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public Length(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

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

    private double toBase() {
        return value * unit.getFactor();
    }

    public Length add(Length other) {
        if (other == null) {
            throw new IllegalArgumentException("Other length cannot be null");
        }

        double sumInBase = this.toBase() + other.toBase();
        double result = sumInBase / this.unit.getFactor();

        return new Length(result, this.unit);
    }

    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double base = value * from.getFactor();
        return base / to.getFactor();
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }
}