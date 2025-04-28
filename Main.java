import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        String numberStr = "123";

        // Method 1: Using Integer.parseInt()
        int number1 = Integer.parseInt(numberStr);
        System.out.println("Using parseInt: " + number1);

        // Method 2: Using Integer.valueOf()
        int number2 = Integer.valueOf(numberStr);
        System.out.println("Using valueOf: " + number2);

        // Method 3: Using new Integer() (deprecated since Java 9)
        // int number3 = new Integer(numberStr);

        // Handling potential NumberFormatException
        try {
            String invalidNumber = "123abc";
            int number4 = Integer.parseInt(invalidNumber);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to integer: " + e.getMessage());
        }

        // Converting with different radix (base)
        String binaryString = "1010";
        int binaryToDecimal = Integer.parseInt(binaryString, 2);
        System.out.println("Binary 1010 to decimal: " + binaryToDecimal); // 10

        String hexString = "1A";
        int hexToDecimal = Integer.parseInt(hexString, 16);
        System.out.println("Hex 1A to decimal: " + hexToDecimal); // 26
    }
}