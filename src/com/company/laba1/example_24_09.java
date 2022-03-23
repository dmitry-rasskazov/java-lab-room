import java.util.Scanner;

public class example_24_09 {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.println("Input name: ");
        String name = consoleIn.nextLine();

        System.out.println("Input age: ");
        int ages = consoleIn.nextInt();

        System.out.printf("\nYou name is %s and your ages %d\n", name, ages);

        consoleIn.close();
    }
}
