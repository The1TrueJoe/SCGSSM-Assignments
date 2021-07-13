import java.util.HashMap;

public class Resistor {
    // Resistance Control Values;
    private int resistance; // The unmodified resistance
    private double multiplier; // Multiplier
    private double multiplied_resistance; // Modified resistance

    // Other Values
    private double tolerance; // Manufacturing tolerance
    private int temperature_coefficient; // Temperature coefficient

    // Resistance Control Bands
    private String[] resistance_color_bands; // The 2-3 Color Bands that identify the resistance
    private String multiplier_color_band; // The Color Band that identifies what value the resistance is multiplied by

    // Other Color Bands
    private String tolerance_color_band; // Color Band that identifies the manufacturing tolerance
    private String temperature_coeff_color_band; // Color Band that identifies the temperature coefficient

    // Constructors

    public Resistor(String[] band_colors) {

        mapValues();

        if (band_colors.length == 6) {
            temperature_coeff_color_band = band_colors[band_colors.length-1];
            tolerance_color_band = band_colors[band_colors.length-2];
            multiplier_color_band = band_colors[band_colors.length-3];
            resistance_color_bands = new String[band_colors.length-3];
            for (int i = 0; i < resistance_color_bands.length; i++) { resistance_color_bands[i] = band_colors[i]; }

            resistance = getResistorBandValues(resistance_color_bands);
            multiplier = getMultiplierBandValue(multiplier_color_band);
            tolerance = getToleranceBandValue(tolerance_color_band);
            temperature_coefficient = getTemperatureCoeffBandValue(temperature_coeff_color_band);

        } else if (band_colors.length <= 5) {
            temperature_coeff_color_band = "N/A";
            tolerance_color_band = band_colors[band_colors.length-1];
            multiplier_color_band = band_colors[band_colors.length-2];
            resistance_color_bands = new String[band_colors.length-2];
            for (int i = 0; i < resistance_color_bands.length; i++) { resistance_color_bands[i] = band_colors[i]; }

            resistance = getResistorBandValues(resistance_color_bands);
            multiplier = getMultiplierBandValue(multiplier_color_band);
            tolerance = getToleranceBandValue(tolerance_color_band);
            temperature_coefficient = 0;

        }

    }

    public Resistor(double multiplied_resistance) {

        mapValues();

        this.multiplied_resistance = multiplied_resistance;
        multiplier = getMultiplierValue(multiplied_resistance);
        resistance = (int) (resistance / multiplier);
        tolerance = 0;
        temperature_coefficient = 0;

        resistance_color_bands = getResistorBandColors(resistance);
        multiplier_color_band = getMultiplierBandColor(resistance);
        tolerance_color_band = "N/A";
        temperature_coeff_color_band = "N/A";

    }

    public Resistor(int resistance, double multiplier) {

        mapValues();

        this.resistance = resistance;
        this.multiplier = multiplier;
        tolerance = 0;
        temperature_coefficient = 0;

        resistance_color_bands = getResistorBandColors(resistance);
        multiplier_color_band = getMultiplierBandColor(resistance);
        multiplied_resistance = resistance * multiplier;
        tolerance_color_band = "N/A";
        temperature_coeff_color_band = "N/A";

    }

    public Resistor(String[] resistance_color_bands, String multiplier_color_band) {

        mapValues();

        this.multiplier_color_band = multiplier_color_band;
        this.resistance_color_bands = resistance_color_bands;
        tolerance_color_band = "N/A";
        temperature_coeff_color_band = "N/A";

        resistance = getResistorBandValues(resistance_color_bands);
        multiplier = getMultiplierBandValue(multiplier_color_band);
        multiplied_resistance = resistance * multiplier;
        tolerance = 0;
        temperature_coefficient = 0;

    }

    public Resistor(int resistance, double multiplier, double tolerance) {

        mapValues();

        this.resistance = resistance;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
        temperature_coefficient = 0;

        if (resistance > 1000) { resistance = (int) (resistance / multiplier); }
        multiplied_resistance = resistance * multiplier;

        resistance_color_bands = getResistorBandColors(resistance);
        multiplier_color_band = getMultiplierBandColor(multiplier);
        tolerance_color_band = getToleranceBandColor(tolerance);
        temperature_coeff_color_band = "N/A";

    }

    public Resistor(String[] resistance_color_bands, String multiplier_color_band, String tolerance_color_band) {

        mapValues();

        this.multiplier_color_band = multiplier_color_band;
        this.resistance_color_bands = resistance_color_bands;
        this.tolerance_color_band = tolerance_color_band;
        temperature_coeff_color_band = "N/A";

        resistance = getResistorBandValues(resistance_color_bands);
        multiplier = getMultiplierBandValue(multiplier_color_band);
        multiplied_resistance = resistance * multiplier;
        tolerance = getToleranceBandValue(tolerance_color_band);
        temperature_coefficient = 0;

    }

    public Resistor(int resistance, double multiplier, double tolerance, int temperature_coefficient) {

        mapValues();

        this.resistance = resistance;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
        this.temperature_coefficient = temperature_coefficient;
        multiplied_resistance = resistance * multiplier;

        resistance_color_bands = getResistorBandColors(resistance);
        multiplier_color_band = getMultiplierBandColor(multiplier);
        multiplied_resistance = resistance * multiplier;
        tolerance_color_band = getToleranceBandColor(tolerance);
        temperature_coeff_color_band = getTemperatureCoeffBandColor(temperature_coefficient);

    }

    public Resistor(String[] resistance_color_bands, String multiplier_color_band, String tolerance_color_band, String temperature_coeff_color_band) {

        mapValues();

        this.multiplier_color_band = multiplier_color_band;
        this.resistance_color_bands = resistance_color_bands;
        this.tolerance_color_band = tolerance_color_band;
        this.temperature_coeff_color_band = temperature_coeff_color_band;

        resistance = getResistorBandValues(resistance_color_bands);
        multiplier = getMultiplierBandValue(multiplier_color_band);
        multiplied_resistance = resistance * multiplier;
        tolerance = getToleranceBandValue(tolerance_color_band);
        temperature_coefficient = getTemperatureCoeffBandValue(temperature_coeff_color_band);

    }

    public String toString() {
        String msg = "Unformatted Resistance: " + (int) multiplied_resistance + ", Formated Resistance: " + formatResistance(multiplied_resistance,multiplier) + ", Multiplier: " + (int) multiplier;

        String bnds = "{";
        for (String resistance_band : resistance_color_bands) { bnds += resistance_band + ", "; }
        bnds += multiplier_color_band + ", ";

        if (tolerance > 0) { msg += ", Tolerance: ±" + tolerance + "%"; bnds += tolerance_color_band + ", "; }
        if (temperature_coefficient > 0) { msg += ", Temperature Coeff: " + temperature_coefficient + "ppm"; bnds += temperature_coeff_color_band + ", "; }

        bnds = bnds.substring(0, bnds.length() - 2) + "}";
        return msg + " " + bnds;

    }


    public double getResistance () {  return resistance; }
    public double getMultipliedResistance () { return multiplied_resistance; }
    public double getMultiplier () { return multiplier; }
    public double getTolerance () { return tolerance; }
    public double getTemperatureCoeff () { return temperature_coefficient; }

    public String[] getResistanceBandColors () { return resistance_color_bands; }
    public String getMultiplierBandColor () { return multiplier_color_band; }
    public String getToleranceBandColor () { return tolerance_color_band; }
    public String getTemperatureCoeffBandColor () { return temperature_coeff_color_band; }

    public int getResistorBandValues(String[] colors) {
        String resistance = "";
        for (String color : colors) { resistance += getResistorBandValue(color.toUpperCase()); }
        return Integer.parseInt(resistance);

    }

    public String[] getResistorBandColors(int value) {
        String digits = ((int) value) + "";
        String[] colors = new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '.') { break; }
            colors[i] = getResistorBandColor(Integer.parseInt(digits.charAt(i) + ""));
        }

        return colors;
    }

    /**
     * Returns the multiplier used in the resistor
     * @param resistance Total Resistance
     * @return Multiplier Value
     */

    public static double getMultiplierValue (double resistance) {

        if (resistance % 10000000 == 0) { // 10M
            return 10000000;

        } else if (resistance % 1000000 == 0) { // 1M
            return 1000000;

        } else if (resistance % 100000 == 0) { // 100K
            return 100000;

        } else if (resistance % 10000 == 0) { // 10K
            return 10000;

        } else if (resistance % 1000 == 0) { // 1K
            return 1000;

        } else if (resistance % 100 == 0) { // 100
            return 100;

        } else if (resistance % 10 == 0) { // 10
            return 10;

        } else if (resistance % 0.01 == 0) { // 0.01
            return 0.01;

        } else if (resistance % 0.1 == 0) { // 0.1
            return 0.1;

        } else {
            return 1;
        }
    }

    /**
     * Calculates a resistor's estimated tolerance given a measured value
     * @param measured_resistance The resistance manually measured
     * @return Tolerance
     */

    public double findTolerance(double measured_resistance) {
        double tolerance = Math.abs((measured_resistance - measured_resistance) / multiplied_resistance) * 100;

        this.tolerance = tolerance;
        tolerance_color_band = getToleranceBandColor(tolerance);

        return tolerance;
    }

    /**
     * Returns the lower end resistance of the allowed tolerance
     * @return The maximum resistance in xΩ
     */

    public double getMaxResistance() {
        return multiplied_resistance + (multiplied_resistance * (tolerance/100));
    }

    /**
     * Returns the higher end resistance of the allowed tolerance
     * @return The minimum resistance in xΩ
     */

    public double getMinResistance() {
        return multiplied_resistance - (multiplied_resistance * (tolerance/100));
    }

    /**
     * Check if resistor is within the manufacture tolerance
     * @param measured_resistance The resistance manually measured
     * @return Whether or not the resistor is within the specified tolerance.
     */

    public boolean isDefective(double measured_resistance) {
        return (measured_resistance < getMinResistance()) || (measured_resistance > getMaxResistance());
    }

    /**
     * Formats the resistance from a long hand version
     * @param multiplied_resistance Adjusted Resistance 460000 -> 460kΩ
     * @param multiplier Multiplier Used
     * @return Formatted resistance
     */

    public String formatResistance(double multiplied_resistance, double multiplier) {
        int resistance = (int) (multiplied_resistance / multiplier);

        /*
        if (multiplier == 10000 || multiplier == 10000000) {
            resistance = resistance / 10;

        } else if (multiplier == 100000 || multiplier == 100000000) {
            resistance = resistance / 100;

        }
        */

        if (multiplier >= 1000 && multiplier < 1000000) {
            return resistance + "kΩ";

        } else if (multiplier >= 1000000 && multiplier < 1000000000) {
            return resistance + "MΩ";

        } else {
            return resistance + "Ω";
        }

    }

    /**
     * Turns a formatted resistance into a a long hand version
     * @param formatted_resistance Example: 460kΩ -> 460000
     * @return Deformatted resistance value
     */

    public static double deformatResistance(String formatted_resistance) {
        if (formatted_resistance.contains("Ω")) {
            formatted_resistance = formatted_resistance.substring(0, formatted_resistance.indexOf("Ω")-1);
        }

        double resistance = 0, multiplier = 1;

        resistance = Double.parseDouble(formatted_resistance.substring(0, formatted_resistance.length()-1));

        switch ((formatted_resistance.charAt(formatted_resistance.length()) + "").toUpperCase()) {
            case "K":
                multiplier = 1000;
                resistance = resistance / multiplier;
                break;
            case "M":
                multiplier = 1000000;
                resistance = resistance / multiplier;
                break;
        }

        multiplier = multiplier * getMultiplierValue(resistance);
        resistance = resistance / multiplier;
        return resistance;
    }


    private HashMap<String, Integer> Resistance_Bands_Colors;
    private HashMap<String, Double> Multiplier_Bands_Colors;
    private HashMap<String, Double> Tolerance_Bands_Colors;
    private HashMap<String, Integer> Temperature_Bands_Colors;

    private HashMap<Integer, String> Resistance_Bands_Numbers;
    private HashMap<Double, String> Multiplier_Bands_Numbers;
    private HashMap<Double, String> Tolerance_Bands_Numbers;
    private HashMap<Integer, String> Temperature_Bands_Numbers;

    /**
     * Adds values to the hashmaps.
     * The maps contain the values of each color band.
     * /b Should be run in the initialization step
     */

    private void mapValues() {
        Resistance_Bands_Colors = new HashMap<>();
        Multiplier_Bands_Colors = new HashMap<>();
        Tolerance_Bands_Colors = new HashMap<>();
        Temperature_Bands_Colors = new HashMap<>();

        Resistance_Bands_Numbers = new HashMap<>();
        Multiplier_Bands_Numbers = new HashMap<>();
        Tolerance_Bands_Numbers = new HashMap<>();
        Temperature_Bands_Numbers = new HashMap<>();

        // Resistor bands 1-2 or 1-3 (Color to Number)
        Resistance_Bands_Colors.put("BLACK",   0);
        Resistance_Bands_Colors.put("BROWN",   1);
        Resistance_Bands_Colors.put("RED",     2);
        Resistance_Bands_Colors.put("ORANGE",  3);
        Resistance_Bands_Colors.put("YELLOW",  4);
        Resistance_Bands_Colors.put("GREEN",   5);
        Resistance_Bands_Colors.put("BLUE",    6);
        Resistance_Bands_Colors.put("PURPLE",  7);
        Resistance_Bands_Colors.put("GREY",    8);
        Resistance_Bands_Colors.put("GRAY",    8);
        Resistance_Bands_Colors.put("WHITE",   9);

        // Resistor bands 1-2 or 1-3 (Number to Color)
        Resistance_Bands_Numbers.put(0, "BLACK");
        Resistance_Bands_Numbers.put(1, "BROWN");
        Resistance_Bands_Numbers.put(2, "RED");
        Resistance_Bands_Numbers.put(3, "ORANGE");
        Resistance_Bands_Numbers.put(4, "YELLOW");
        Resistance_Bands_Numbers.put(5, "GREEN");
        Resistance_Bands_Numbers.put(6, "BLUE");
        Resistance_Bands_Numbers.put(7, "PURPLE");
        Resistance_Bands_Numbers.put(8, "GREY");
        Resistance_Bands_Numbers.put(8, "GRAY");
        Resistance_Bands_Numbers.put(9, "WHITE");

        // Multiplier bands 3 or 4 (Color to Number)
        Multiplier_Bands_Colors.put("SILVER",  0.01);
        Multiplier_Bands_Colors.put("GOLD",    0.1);
        Multiplier_Bands_Colors.put("BLACK",   1.0);
        Multiplier_Bands_Colors.put("BROWN",   10.0);
        Multiplier_Bands_Colors.put("RED",     100.0);
        Multiplier_Bands_Colors.put("ORANGE",  1000.0);
        Multiplier_Bands_Colors.put("YELLOW",  10000.0);
        Multiplier_Bands_Colors.put("GREEN",  100000.0);
        Multiplier_Bands_Colors.put("BLUE",    1000000.0);
        Multiplier_Bands_Colors.put("PURPLE",  10000000.0);

        // Multiplier bands 3 or 4 (Number to Color)
        Multiplier_Bands_Numbers.put(0.01, "SILVER");
        Multiplier_Bands_Numbers.put(0.1, "GOLD");
        Multiplier_Bands_Numbers.put(1.0, "BLACK");
        Multiplier_Bands_Numbers.put(10.0, "BROWN");
        Multiplier_Bands_Numbers.put(100.0, "RED");
        Multiplier_Bands_Numbers.put(1000.0, "ORANGE");
        Multiplier_Bands_Numbers.put(10000.0, "YELLOW");
        Multiplier_Bands_Numbers.put(100000.0, "GREEN");
        Multiplier_Bands_Numbers.put(1000000.0, "BLUE");
        Multiplier_Bands_Numbers.put(10000000.0, "PURPLE");

        // Tolerance bands 4 or 5 (Color to Number)
        Tolerance_Bands_Colors.put("SILVER",  10.0);
        Tolerance_Bands_Colors.put("GOLD",    5.0);
        Tolerance_Bands_Colors.put("BROWN",   1.0);
        Tolerance_Bands_Colors.put("RED",     2.0);
        Tolerance_Bands_Colors.put("GREEN",  0.5);
        Tolerance_Bands_Colors.put("BLUE",    0.25);
        Tolerance_Bands_Colors.put("PURPLE",  0.1);

        // Tolerance bands 4 or 5 (Number to Color)
        Tolerance_Bands_Numbers.put(10.0, "SILVER");
        Tolerance_Bands_Numbers.put(5.0, "GOLD");
        Tolerance_Bands_Numbers.put(1.0, "BROWN");
        Tolerance_Bands_Numbers.put(2.0, "RED");
        Tolerance_Bands_Numbers.put(0.5, "GREEN");
        Tolerance_Bands_Numbers.put(0.25, "BLUE");
        Tolerance_Bands_Numbers.put(0.1, "PURPLE");

        // Temperature coefficient band 6 (Color to Number)
        Temperature_Bands_Colors.put("BROWN",   100);
        Temperature_Bands_Colors.put("RED",     500);
        Temperature_Bands_Colors.put("ORANGE",  15);
        Temperature_Bands_Colors.put("YELLOW",  25);

        // Temperature coefficient band 6 (Number to Color)
        Temperature_Bands_Numbers.put(100, "BROWN");
        Temperature_Bands_Numbers.put(500, "RED");
        Temperature_Bands_Numbers.put(15, "ORANGE");
        Temperature_Bands_Numbers.put(25, "YELLOW");

    }


    public int getResistorBandValue(String color) { return Resistance_Bands_Colors.get(color); }
    public double getMultiplierBandValue(String color) { return Multiplier_Bands_Colors.get(color); }
    public double getToleranceBandValue(String color) { return Tolerance_Bands_Colors.get(color); }
    public int getTemperatureCoeffBandValue(String color) { return Temperature_Bands_Colors.get(color); }

    public String getResistorBandColor(int value) { return Resistance_Bands_Numbers.get(value); }
    public String getMultiplierBandColor(double value) { return Multiplier_Bands_Numbers.get(value); }
    public String getToleranceBandColor(double value) { return Tolerance_Bands_Numbers.get(value); }
    public String getTemperatureCoeffBandColor(int value) { return Temperature_Bands_Numbers.get(value); }

}
