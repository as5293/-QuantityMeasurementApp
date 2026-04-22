package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;


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


    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    // 🔹 Convert to base (inches)
    private double toBase() {
        return value * unit.getFactor();
    }

    // 🔹 Instance conversion (returns new object)
    public Length convertTo(LengthUnit target) {
        if (target == null) throw new IllegalArgumentException("Target unit null");

        double base = toBase();
        double converted = base / target.getFactor();

        return new Length(converted, target);
    }

    // 🔹 STATIC conversion (IMPORTANT API)
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        double base = value * source.getFactor();
        return base / target.getFactor();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }


    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}