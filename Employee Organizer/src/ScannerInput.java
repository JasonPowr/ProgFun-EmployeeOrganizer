import java.util.Scanner;

public class ScannerInput {

    public static int readNextInt(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.next());        //scanner input for ints if a int is not entered then
            }                                                   //Enter a number please. is displayed
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    public static double readNextDouble(String prompt) {
        do {
            var scanner = new Scanner(System.in);
            try{
                System.out.print(prompt);                   //scanner input for doubles if a double is not entered then
                return Double.parseDouble(scanner.next());  // Enter a number please is entered
            }
            catch (NumberFormatException e) {
                System.err.println("\tEnter a number please.");
            }
        }  while (true);
    }

    public static String validNextLine(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);                   //scanner input for Strings
        return input.nextLine();
    }

    public static char validNextChar(String prompt) {
        Scanner input = new Scanner(System.in);     //scanner input for chars
        System.out.print(prompt);
        return input.next().charAt(0);
    }

}