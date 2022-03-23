import java.util.Scanner;

public class example_24_17 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input first number: ");
        int firstNumber = consoleIn.nextInt();

        System.out.println("Input second number: ");
        int secondNumber = consoleIn.nextInt();

        System.out.printf(
                "\nSum of this numbers: %d, diff of this numbers %d\n",
                firstNumber + secondNumber,
                firstNumber - secondNumber
        );

        consoleIn.close();
    }
}
