import javax.swing.plaf.synth.SynthStyle;
import java.util.Random;
import java.util.Scanner;

public class ResistorChat {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random rng = new Random();
        String input = "";

        ResistorInfo.mapValues();

        System.out.println(new Resistor(450000, 0.5, 25));

        /**
        System.out.println("\n\n\n");
        System.out.println("Hello! I am here to help you identify your resistors!");

        while (true) {
            System.out.println(">");
            input = keyboard.nextLine();
            input = input.toLowerCase();

            if (input.contains("exit") || input.contains("bye") || input.contains("close")) {
                System.out.println("Bye!");
                keyboard.close();
                System.exit(0);

            } else if (input.contains("hi") || input.contains("hello")) {
                switch (rng.nextInt(3)) {
                    case 1:
                        System.out.println("Hello!");
                        break;
                    case 2:
                        System.out.println("Howdy!");
                        break;
                    default:
                        System.out.println("Hi!");
                        break;
                }

            } else if (input.contains("Ω") || input.contains("k") || input.contains("m")) {
                int index_end;
                int index_beginning;
                char[] input_characters;
                double resistance, tolerance = 0;
                int temperature_coeff = 0;

                // Resistance

                // Gets last index of resistance
                if (input.contains("Ω")) {
                    index_end = input.lastIndexOf("Ω");
                } else { // Added to make make sure this works if the user doesn't use Ω
                    index_end = Math.max(input.lastIndexOf('k'), input.lastIndexOf('m'));
                }

                index_beginning = 0;

                input_characters = input.substring(index_beginning, index_end+1).toCharArray();
                for (; index_beginning < index_end; index_beginning++) {
                    System.out.println("// " + input.substring(index_beginning, index_end+1));
                    if (!Character.isDigit(input_characters[index_beginning])) {
                        System.out.println(input_characters[index_beginning] + " is a digit");
                        break;
                    }
                }

                String formatted_resistance = input.substring(index_beginning, index_end+1);
                resistance = ResistorInfo.deformatResistance(formatted_resistance);

                if (input.contains("%")) {
                    index_beginning = index_end;
                    index_end = input.lastIndexOf("%");

                    input_characters = input.substring(index_beginning, index_end+1).toCharArray();
                    for (; index_beginning < index_end; index_beginning++) {
                        System.out.println("// " + input.substring(index_beginning, index_end+1));
                        if (Character.isDigit(input_characters[index_beginning])) {
                            System.out.println(input_characters[index_beginning] + " is a digit");
                            break;
                        }
                    }

                    if (input.substring(index_beginning, index_end+1).contains("±")) { index_end--; }

                    tolerance = Double.parseDouble(input.substring(index_beginning, index_end+1));
                }

                if (input.contains("ppm")) {
                    index_beginning = index_end;
                    index_end = input.lastIndexOf("ppm");

                    input_characters = input.substring(index_beginning, index_end+1).toCharArray();
                    for (; index_beginning < index_end; index_beginning++) {
                        System.out.println("// " + input.substring(index_beginning, index_end+1));
                        if (Character.isDigit(input_characters[index_beginning])) {
                            System.out.println(input_characters[index_beginning] + " is a digit");
                            break;
                        }
                    }

                    temperature_coeff = Integer.parseInt(input.substring(index_beginning, index_end+1));
                }

                Resistor resistor = new Resistor(resistance, tolerance, temperature_coeff);
                System.out.println("Your resistor is: " + resistor.toString());
            }

        }
        */
    }

    public static class ResistorSolver {

        /**
         * Sees if a resistance can be calculated using two separate resistors placed in series
         * @param values Resistors that are available to be used
         * @param target_value Target Resistance
         * @return Message with the resistors that can be used
         */

        public static String seriesSolver(Resistor[] values, double target_value) {
            for (int i = 0; i < values.length; i++) {
                for (int x = 0; x < values.length; i++) {
                    if (values[i].getResistance() + values[x].getResistance() == target_value) {
                        return "Add " + ResistorInfo.formatResistance(values[i].getResistance()) + " & " + ResistorInfo.formatResistance(values[x].getResistance()) + " in series";
                    }
                }
            }

            return "N";
        }

        /**
         * Sees if a resistance can be calculated using two separate resistors placed in parallel
         * @param values Resistors that are available to be used
         * @param target_value Target Resistance
         * @return Message with the resistors that can be used
         */

        public static String parallelSolver(Resistor[] values, double target_value) {
            for (int i = 0; i < values.length; i++) {
                for (int x = 0; x < values.length; i++) {
                    if (1/(values[i].getResistance() + values[x].getResistance()) == target_value) {
                        return "Add " + ResistorInfo.formatResistance(values[i].getResistance()) + " & " + ResistorInfo.formatResistance(values[x].getResistance()) + " in parallel";
                    }
                }
            }

            return "N";
        }

        /**
         * Sees if a resistance can be calculated using separate resistors
         * @param values Resistors that are available to be used
         * @param target_value Target Resistance
         * @return Message with the resistors that can be used
         */

        public static String solver(Resistor[] values, double target_value) {
            for (int i = 0; i < values.length; i++) {
                if (values[i].getResistance() == target_value) {
                    return "There is already a " + target_value + " resistor in the inventory";

                } else if (target_value % values[i].getResistance() == 0) {
                    return "Add " + (target_value / values[i].getResistance()) + " " + (ResistorInfo.formatResistance(values[i].getResistance())) + " resistors";

                }
            }

            String tmp;

            tmp = seriesSolver(values, target_value);
            if (!(tmp.equals("N"))) { return tmp; }

            tmp = parallelSolver(values, target_value);
            if (!(tmp.equals("N"))) { return tmp; }

            return "A simple solution is not able to be calculated";
        }
    }

    public class InvalidResistorException extends Exception {
        public InvalidResistorException(String message) {
            super(message);
        }
    }

    public class InvalidColorException extends Exception {
        public InvalidColorException(String message) {
            super(message);
        }
    }

    public class InvalidResistanceException extends Exception {
        public InvalidResistanceException(String message) {
            super(message);
        }
    }

}

