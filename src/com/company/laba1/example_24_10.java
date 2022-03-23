import java.util.Scanner;

public class example_24_10 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input day of week, month and day number (example - monday january 1): ");
        String dayOfWeek = consoleIn.next();
        String month = consoleIn.next();
        int dayNumber = consoleIn.nextInt();

        System.out.printf("\n%s %d %s\n", dayOfWeek, dayNumber, month);

        consoleIn.close();
    }
}
