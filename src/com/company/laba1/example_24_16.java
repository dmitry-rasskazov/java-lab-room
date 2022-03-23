import java.util.Scanner;

public class example_24_16 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input number: ");
        int currentNumber = consoleIn.nextInt();
        int preNumber = currentNumber - 1;
        int nextNumber = currentNumber + 1;
        int sum = currentNumber + preNumber + nextNumber;
        int sqrOfSum = sum * sum;

        System.out.printf("\n%d %d %d %d\n", preNumber, currentNumber, nextNumber, sqrOfSum);

        consoleIn.close();
    }
}
