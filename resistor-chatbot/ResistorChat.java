import java.util.Scanner;

public class ResistorChat {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String line = "-------";
        int keyboard_result = -99;

        //while (!line.equals("Exit") && !line.equals("exit")) {
            System.out.println("What would you like to do: \n" +
                            "1) Resistor Values -> Colors\n" +
                            "2) Colors -> Resistor Values\n" +
                            "3) Tolerance Calculations\n");
            line = keyboard.next();
            keyboard_result = Integer.parseInt(line);

            if (keyboard_result == 1) {
                System.out.println("Enter resistor values: (Res, Mult, Tol, Temp)");
                line = keyboard.next();
                String[] bands = line.split(",");
                double[] band_values = new double[bands.length];

                for (int i = 0; i < bands.length; i++) { band_values[i] = Double.parseDouble(bands[i]); }

                if (band_values.length == 2) {
                    System.out.println(new Resistor((int) band_values[0], band_values[1]));
                } else if (band_values.length == 3) {
                    System.out.println(new Resistor((int) band_values[0], band_values[1], band_values[2]));
                } else if (band_values.length == 4) {
                    System.out.println(new Resistor((int) band_values[0], band_values[1], band_values[2], (int) band_values[3]));
                }


            } else if (keyboard_result == 2) {
                System.out.println("Enter colors of the resistor");
                line = keyboard.next();
                String[] bands = line.split(",");

                for (String tmp : bands) { System.out.println(tmp); }

                System.out.println(new Resistor(bands));

            } else if (keyboard_result == 3) {
                line = "-------";
                keyboard_result = -99;

                System.out.println("Tolerance Calculations:\n" +
                        "1) Calculate Unknown Tolerance\n" +
                        "2) Check if Tolerence is Exceeded\n" +
                        "3) Get Resistance Range");
                line = keyboard.next();
                keyboard_result = Integer.parseInt(line);

                if (keyboard_result == 1) {
                    System.out.println("Enter Resistor Parameters: (RatedRes, Mult, MeasuredRes)");
                    line = keyboard.next();

                    String[] bands = line.split(",");
                    double[] band_values = new double[bands.length];

                    if (band_values.length != 4) {
                        System.out.println("Invalid Input!");
                        //continue;
                    }

                    for (int i = 0; i < bands.length; i++) {
                        band_values[i] = Double.parseDouble(bands[i]);
                    }

                    Resistor res = new Resistor((int) band_values[0], band_values[1]);

                    System.out.println("The resistor's estimated tolerance is ±" + res.findTolerance(band_values[2]) + "%, Color: " + res.getToleranceBandColor());

                } else if (keyboard_result == 2) {
                    System.out.println("Enter Resistor Parameters: (RatedRes, Mult, Tol, MeasuredRes)");
                    line = keyboard.next();

                    String[] bands = line.split(",");
                    double[] band_values = new double[bands.length];

                    if (band_values.length != 4) {
                        System.out.println("Invalid Input!");
                        //continue;
                    }

                    for (int i = 0; i < bands.length; i++) {
                        band_values[i] = Double.parseDouble(bands[i]);
                    }

                    Resistor res = new Resistor((int) band_values[0], band_values[1], band_values[2]);

                    if (res.isDefective(band_values[3])) {
                        System.out.println("The resistor is outside of ±" + band_values[3] + "%, it should be ±" + res.findTolerance(band_values[3]) + "%");
                    } else {
                        System.out.println("The resistor is within the specified tolerance");
                    }

                } else if (keyboard_result == 3) {

                    System.out.println("Enter Resistor Parameters: (Res, Mult, Tol)");
                    line = keyboard.next();

                    String[] bands = line.split(",");
                    double[] band_values = new double[bands.length];

                    if (band_values.length != 3) {
                        System.out.println("Invalid Input!");
                        //continue;
                    }

                    for (int i = 0; i < bands.length; i++) {
                        band_values[i] = Double.parseDouble(bands[i]);
                    }

                    Resistor res = new Resistor((int) band_values[0], band_values[1], band_values[2]);

                    System.out.println("Max Resistance: " + res.formatResistance(res.getMaxResistance(), band_values[1]) +
                            ", Min Resistance: " + res.formatResistance(res.getMinResistance(), band_values[1]));

                }

                line = "-------";
                keyboard_result = -99;

            }

            line = "-------";
            keyboard_result = -99;

        //}
    }
}
