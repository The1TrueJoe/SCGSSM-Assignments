public class Resistor_OLD {
    private double resistance;
    private double multiplier;
    private double tolerance;
    private int temperature_coeff;

    private String[] resistance_band_colors;
    private String multiplier_band_color;
    private String tolerance_band_color;
    private String temperature_coeff_band_color;

    public Resistor(double resistance, double tolerance) {
        this.resistance = resistance;
        this.tolerance = tolerance;
        multiplier = ResistorInfo.getMultiplier(resistance);

        resistance_band_colors = ResistorInfo.getResistanceBands(resistance);
        multiplier_band_color = ResistorInfo.getMultiplierBandColor(ResistorInfo.getMultiplier(resistance));
        tolerance_band_color = ResistorInfo.getToleranceBandColor(tolerance);
        temperature_coeff_band_color = "N/A";
    }

    public Resistor(double resistance) {
        this.resistance = resistance;
        multiplier = ResistorInfo.getMultiplier(resistance);

        resistance_band_colors = ResistorInfo.getResistanceBands(resistance);
        multiplier_band_color = ResistorInfo.getMultiplierBandColor(ResistorInfo.getMultiplier(resistance));
        tolerance_band_color = "N/A";
        temperature_coeff_band_color = "N/A";
    }

    public Resistor(double resistance, double tolerance, int temperature_coeff) {
        this.resistance = resistance;
        this.tolerance = tolerance;
        this.temperature_coeff = temperature_coeff;
        multiplier = ResistorInfo.getMultiplier(resistance);

        resistance_band_colors = ResistorInfo.getResistanceBands(resistance);
        multiplier_band_color = ResistorInfo.getMultiplierBandColor(ResistorInfo.getMultiplier(resistance));
        tolerance_band_color = ResistorInfo.getToleranceBandColor(tolerance);
        temperature_coeff_band_color = ResistorInfo.getTemperatureCoeffBandColor(temperature_coeff);

    }

    public Resistor(String[] band_colors) throws ResistorChat.InvalidResistorException {
        if (band_colors.length == 6) {
            String[] resistance_band_colors = new String[3];
            for (int i = 0; i < 3; i++) {
                resistance_band_colors[i] = band_colors[i];
            }

            multiplier = ResistorInfo.getMultiplier(band_colors[3]);
            resistance = ResistorInfo.getResistance(resistance_band_colors, band_colors[3]);
            tolerance = ResistorInfo.getTolerance(band_colors[4]);
            temperature_coeff = ResistorInfo.getTemperatureCoeff(band_colors[5]);

        } else if (band_colors.length == 5) {
            String[] resistance_band_colors = new String[3];
            for (int i = 0; i < 3; i++) {
                resistance_band_colors[i] = band_colors[i];
            }

            multiplier = ResistorInfo.getMultiplier(band_colors[3]);
            resistance = ResistorInfo.getResistance(resistance_band_colors, band_colors[3]);
            tolerance = ResistorInfo.getTolerance(band_colors[4]);

        } else if (band_colors.length == 4) {
            String[] resistance_band_colors = new String[2];
            for (int i = 0; i < 2; i++) {
                resistance_band_colors[i] = band_colors[i];
            }

            multiplier = ResistorInfo.getMultiplier(band_colors[2]);
            resistance = ResistorInfo.getResistance(resistance_band_colors, band_colors[2]);
            tolerance = ResistorInfo.getTolerance(band_colors[3]);

        } else {
            //throw new ResistorChat.InvalidResistorException("The resistor with length " + band_colors.length + " is invalid");

        }
    }

    public Resistor(String[] resistance_band_colors, String multiplier_band_color, String tolerance_band_color) {
        this.resistance_band_colors = resistance_band_colors;
        this.multiplier_band_color = multiplier_band_color;
        this.tolerance_band_color = tolerance_band_color;

        multiplier = ResistorInfo.getMultiplier(resistance);
        resistance = ResistorInfo.getResistance(resistance_band_colors, multiplier_band_color);
        tolerance = ResistorInfo.getTolerance(tolerance_band_color);

    }

    public Resistor(String[] resistance_band_colors, String multiplier_band_color, String tolerance_band_color, String temperature_coeff_band_color) {
        this.resistance_band_colors = resistance_band_colors;
        this.multiplier_band_color = multiplier_band_color;
        this.tolerance_band_color = tolerance_band_color;
        this.temperature_coeff_band_color = temperature_coeff_band_color;

        multiplier = ResistorInfo.getMultiplier(resistance);
        resistance = ResistorInfo.getResistance(resistance_band_colors, multiplier_band_color);
        tolerance = ResistorInfo.getTolerance(tolerance_band_color);
        temperature_coeff = ResistorInfo.getTemperatureCoeff(temperature_coeff_band_color);

    }

    public String toString() {
        String msg = "Resistance: " + ResistorInfo.formatResistance(resistance) + ", Multiplier: " + multiplier;

        String bnds = "{";
        for (String resistance_band : resistance_band_colors) { bnds += resistance_band + ", "; }

        if (tolerance > 0) { msg += ", Tolerance: " + tolerance; bnds += tolerance_band_color + ", "; }
        if (temperature_coeff > 0) { msg += ", Temperature Coeff: " + temperature_coeff; bnds += temperature_coeff_band_color + ", "; }

        bnds = bnds.substring(0, bnds.length() - 2) + "}";
        return msg + " " + bnds;

    }

    public double getResistance () {  return resistance; }
    public double getMultiplier () { return multiplier; }
    public double getTolerance () { return tolerance; }
    public int getTemperatureCoeff () { return temperature_coeff; }

    public String[] getResistanceBandColors () { return resistance_band_colors; }
    public String getMultiplierBandColor () { return multiplier_band_color; }
    public String getToleranceBandColor () { return tolerance_band_color; }
    public String getTemperatureCoeffBandColor () { return temperature_coeff_band_color; }

}
