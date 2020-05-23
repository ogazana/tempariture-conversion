package com.assessment.odwaassessment.enums;


public enum ScaleEnum {

    CELSIUS_SCALE(273.15),

    POUND_SCALE(0.4536),

    KILOMETERS_SCALE(1.60934),

    DEFAULT(0);

    public static ScaleEnum findByScale(double scale) {
        for (ScaleEnum calc : ScaleEnum.values()) {
            if (calc.scale == scale) {
                return calc;
            }
        }
        return DEFAULT;
    }

    ScaleEnum(double scale) {
        this.scale = scale;
    }

    public double getScale() {
        return scale;
    }

    private double scale;
}
