package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Length {

        private double value;
        private LengthUnit unit;

        // 🔹 ENUM with all units (base = inches)
        public enum LengthUnit {
            FEET(12.0),
            INCHES(1.0),
            YARDS(36.0),          // 1 yard = 36 inches
            CENTIMETERS(0.393701); // 1 cm = 0.393701 inches

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

        // 🔹 Compare
        public boolean compare(Length other) {
            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        // 🔹 equals()
        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null) return false;

            if (getClass() != obj.getClass()) return false;

            Length other = (Length) obj;

            return this.compare(other);
        }
    }

    // 🔹 Demo method
    public static void demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                   double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        System.out.println("Equal (" + l1.equals(l2) + ")");
    }

    public static void main(String[] args) {

        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                3.0, Length.LengthUnit.FEET);

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                0.393701, Length.LengthUnit.INCHES);
    }
}