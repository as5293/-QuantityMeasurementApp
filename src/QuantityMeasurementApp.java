package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    // 🔹 Generic Length Class
    public static class Length {

        private double value;
        private LengthUnit unit;

        // 🔹 Enum for units
        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0);

            private final double conversionFactor;

            LengthUnit(double conversionFactor) {
                this.conversionFactor = conversionFactor;
            }

            public double getConversionFactor() {
                return conversionFactor;
            }
        }

        // 🔹 Constructor
        public Length(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // 🔹 Convert to base unit (inches)
        private double toBaseUnit() {
            return this.value * this.unit.getConversionFactor();
        }

        // 🔹 Compare method
        public boolean compare(Length other) {
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        // 🔹 equals method
        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null) return false;

            if (getClass() != obj.getClass()) return false;

            Length other = (Length) obj;

            return this.compare(other);
        }
    }

    // 🔹 Demo methods
    public static void demonstrateFeetEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Feet Equal: " + l1.equals(l2));
    }

    public static void demonstrateInchesEquality() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Inches Equal: " + l1.equals(l2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Feet vs Inches Equal: " + l1.equals(l2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}