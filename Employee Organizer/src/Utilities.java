import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    static boolean onlyContainsNumbers(String text) {
        return (text.matches("[0-9]+"));
    }

    static String max20Chars(String string){
        return (string.length()<=20) ? string : string.substring(0,20);
    }

    static String validPPS(String string){
        return (string.length()<=9) ? string : string.substring(0,9);
    }

    static boolean validEmail(String email){
        return (email.contains("@") && email.contains("."));
    }

    static boolean validIntRange(int start, int end, int value){
        return ((value >= start) && (value <= end));
    }

    static boolean validDoubleRange(double start, double end, double value){
        return ((value >= start) && (value <= end));
    }

    static boolean validIntNonNegative(int number) { return (number >=0);}

    static boolean validIndex(int index, ArrayList list){
        return (index >= 0 && index < list.size());
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}