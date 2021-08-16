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


    public static double getResistorBandValue(String color) { return Resistance_Bands_Colors.get(color); }
    public static double getMultiplierBandValue(String color) { return Multiplier_Bands_Colors.get(color); }
    public static double getToleranceBandValue(String color) { return Tolerance_Bands_Colors.get(color); }
    public static double getTemperatureCoeffBandValue(String color) { return Temperature_Bands_Colors.get(color); }

    public static String getResistorBandColor(double value) { return Resistance_Bands_Numbers.get(value); }
    public static String getMultiplierBandColor(double value) { return Multiplier_Bands_Numbers.get(value); }
    public static String getToleranceBandColor(double value) { return Tolerance_Bands_Numbers.get(value); }
    public static String getTemperatureCoeffBandColor(double value) { return Temperature_Bands_Numbers.get(value); }


}
