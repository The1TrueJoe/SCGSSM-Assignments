import java.util.HashMap;

public class ResistorInfo {
    private static HashMap<String, Integer> Resistance_Bands_Colors;
    private static HashMap<String, Double> Multiplier_Bands_Colors;
    private static HashMap<String, Double> Tolerance_Bands_Colors;
    private static HashMap<String, Integer> Temperature_Bands_Colors;

    private static HashMap<Integer, String> Resistance_Bands_Numbers;
    private static HashMap<Double, String> Multiplier_Bands_Numbers;
    private static HashMap<Double, String> Tolerance_Bands_Numbers;
    private static HashMap<Integer, String> Temperature_Bands_Numbers;

    /**
     * Adds values to the hashmaps.
     * The maps contain the values of each color band.
     * /b Should be run in the initialization step
     */

    public static void mapValues() {
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

    /**
     * Returns an array of the colors of the bands that identify the resistance.
     * @param resistance Resistance (No multipliers)
     * @param multiplier Multiplier used in that total
     * @return Array of Colors
     */

    public static String[] getResistanceBandColors(double resistance, double multiplier) {
        resistance = resistance / multiplier;

        char[] digits = (resistance + "").toCharArray();
        String[] color_bands = new String[digits.length];

        for (int i = 0; i < digits.length; i++) {
            color_bands[i] = Resistance_Bands_Numbers.get(Integer.parseInt(digits[0] + ""));
        }

        return color_bands;
    }

    /**
     * Gets the resistance given a list of color bands and the multiplier.
     * @param resistance_band_colors Array of colors of the first 2-3 bands the denote the value.
     * @param multiplier_band_color Color of the multiplier band (Turns 460 to 460k)
     * @return The resistance in xΩ
     */

    public static double getResistance(String[] resistance_band_colors, String multiplier_band_color) {
        double resistance = 0;
        String tmp = "";

        for (String band_color : resistance_band_colors) {
            tmp += Resistance_Bands_Colors.get(band_color.toUpperCase()) + "";
        }

        return (Integer.parseInt(tmp) * Multiplier_Bands_Colors.get(multiplier_band_color.toUpperCase()));
    }

    public static double getResistance(String[] band_colors) {
        String[] resistance_band_colors = new String[band_colors.length-1];
        String multiplier_band_color = band_colors[band_colors.length-1];

        for (int i = 0; i < resistance_band_colors.length; i++) { resistance_band_colors[i] = band_colors[i]; }

        return getResistance(resistance_band_colors, multiplier_band_color);
    }

    /**
     * Formats the resistance from a long hand version
     * @param resistance 460000 -> 460kΩ
     * @return Formatted resistance
     */

    public static String formatResistance(double resistance) {
        double multiplier = getMultiplier(resistance);
        resistance = resistance / multiplier;

        if (multiplier == 10000) {
            resistance *= 10;
        } else if (multiplier == 10000000) {
            resistance *= 10;
        }

        if (multiplier % 1000000 == 0) {
            return resistance + "MΩ";
        } else if (multiplier % 1000 == 0) {
            return resistance + "kΩ";
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

        multiplier = multiplier * getMultiplier(resistance);
        resistance = resistance / multiplier;
        return resistance;
    }

    /**
     * Returns the value of the multiplier band
     * @param multiplier_band_color Color of the multiplier band
     * @return The multiplier value
     */

    public static double getMultiplier(String multiplier_band_color) {
        return Multiplier_Bands_Colors.get(multiplier_band_color);
    }

    /**
     * Returns the multiplier used in the resistor
     * @param resistance Total Resistance
     * @return Multiplier Value
     */

    public static double getMultiplier (double resistance) {

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
     * Gives the color associated with the multiplier
     * @param multiplier_value Value of Multiplier
     * @return Color of Multiplier Band
     */

    public static String getMultiplierBandColor (double multiplier_value) {
        return Multiplier_Bands_Numbers.get(multiplier_value);
    }

    /**
     * Return the Color of the Tolerance Band
     * @param tolerance The Resistor Tolerance
     * @return Color of the band
     */

    public static String getToleranceBandColor(double tolerance) {
        return Tolerance_Bands_Numbers.get(tolerance);
    }

    /**
     * Returns the resistor tolerance, which is manufacturing tolerance. The actual resistance can vary by that value.
     * @param tolerance_band_color Usually the last color band if the resistor has 4-5 bands.
     * @return Tolerance in ±x%
     */

    public static double getTolerance(String tolerance_band_color) {
        return Multiplier_Bands_Colors.get(tolerance_band_color.toUpperCase());
    }

    /**
     * Return the Color of the Temperature Coefficient Band
     * @param temperature_coeff The Resistor Temperature Coefficient
     * @return Color of the band
     */

    public static String getTemperatureCoeffBandColor(int temperature_coeff) {
        return Temperature_Bands_Numbers.get(temperature_coeff);
    }

    /**
     * Returns the temperature coefficient. Shows how the value changes as the resistor heats up.
     * @param temperature_band_color Color of temperature band in resistor. Usually the last band.
     * @return Temperature Coefficient in ppm/°C
     */

    public static int getTemperatureCoeff(String temperature_band_color) {
        return Temperature_Bands_Colors.get(temperature_band_color.toUpperCase());
    }

    /**
     * Returns an array of the colors of the bands that identify the resistance.
     * @param resistance Total Resistance (Modifier Removed)
     * @return Array of Colors
     */

    public static String[] getResistanceBands(double resistance) {
        return getResistanceBands(resistance, 1);
    }

    /**
     * Returns the lower end resistance of the allowed tolerance
     * @param resistance The resistance in xΩ
     * @param tolerance Resistor Tolerance in ±x%
     * @return The maximum resistance in xΩ
     */

    public static double getMaxResistance(int resistance, double tolerance) {
        return resistance + (resistance * (tolerance/100));
    }

    /**
     * Returns the higher end resistance of the allowed tolerance
     * @param resistance The resistance in xΩ
     * @param tolerance Resistor Tolerance in ±x%
     * @return The minimum resistance in xΩ
     */

    public static double getMinResistance(int resistance, double tolerance) {
        return resistance - (resistance * (tolerance/100));
    }

    /**
     * Check if resistor is within the manufacture tolerance
     * @param resistance The resistance in xΩ
     * @param tolerance Resistor Tolerance in ±x%
     * @return Whether or not the resistor is within the specified tolerance.
     */

    public static boolean isDefective(int resistance, double tolerance) {
        return (resistance < getMinResistance(resistance, tolerance)) || (resistance > getMaxResistance(resistance, tolerance));
    }

}