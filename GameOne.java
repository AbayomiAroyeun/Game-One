import java.time.LocalDateTime;
import java.util.Scanner;

public class GameOne {
    public static void main(String[] args) {
        LocalDateTime myTime = LocalDateTime.now();
        System.out.println(myTime);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Is the number an even number or odd number?");
        String category = scanner.next();

        while (true) {
            int secretNumber = -1;

            if (category.equals("even")) {
                try {
                    System.out.println("How many letters does it have?");
                    int lettersEven = scanner.nextInt();
                    System.out.println("Is the number less than 3?");
                    boolean isLessThan3 = parseYesNoInput(scanner.next());
                    System.out.println("Is the number more than 5?");
                    boolean isMoreThan5 = parseYesNoInput(scanner.next());
                    System.out.println("Is the number divisible by 5?");
                    boolean isDivisibleBy5 = parseYesNoInput(scanner.next());

                    if (lettersEven == 3 && isMoreThan5 && isDivisibleBy5) secretNumber = 10;
                    else if (lettersEven == 3 && !isMoreThan5 && !isDivisibleBy5) secretNumber = 2;
                    else if (lettersEven == 4) {
                        // introduce another condition to set to 0 when lettersEven = 4;
                        if (isLessThan3) secretNumber = 0;
                        else secretNumber = 4;
                    } else if (lettersEven == 5) secretNumber = 8;
                    else if (lettersEven == 3) secretNumber = 6;
                } catch (Exception e) {
                    System.out.println("Enter numbers only & not words");
                    scanner.nextLine(); // consume invalid input
                    continue;
                }
            } else if (category.equals("odd")) {
                try {
                    System.out.println("How many letters does it have?");
                    int lettersOdd = scanner.nextInt();
                    System.out.println("Is it a multiple of 3?");
                    boolean multiple3 = parseYesNoInput(scanner.next());
                    System.out.println("Is the number less than 6?");
                    boolean less6 = parseYesNoInput(scanner.next());

                    if (lettersOdd == 3) secretNumber = 1;
                    else if (lettersOdd == 4 && multiple3) secretNumber = 9;
                    else if (lettersOdd == 4) secretNumber = 5;
                    else if (lettersOdd == 5 && less6) secretNumber = 3;
                    else if (lettersOdd == 5) secretNumber = 7;
                } catch (Exception e) {
                    System.out.println("Enter numbers only & not words");
                    scanner.nextLine(); // consume invalid input
                    continue;
                }
            } else {
                System.out.println("You must write either even or odd to proceed.");
                continue;
            }

            if (secretNumber != -1) {
                System.out.println("Your secret Number is:" + secretNumber + ".");
            } else {
                System.out.println("Your Secret Number could not be revealed");
            }

            break; // Exit the loop after processing the result
        }
        scanner.close();
    }

    private static boolean parseYesNoInput(String next) {
        return next.equalsIgnoreCase("yes");
    }
}