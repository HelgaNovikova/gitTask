package conditionsAndLoops;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        task1(scan);
        task2(scan);
        task3(scan);
        System.out.println("Do you want to execute extra tasks? Y/N");
        String extraTasks = scan.next();
        if (extraTasks.equalsIgnoreCase("y")) {
            nearHundred(scan);
            lastDigit(scan);
            maxInt(scan);
            love7(scan);
            System.out.println(answerCell(scan));
            equalSlices(scan);

        }
    }

    private static void equalSlices(Scanner scan) {
        System.out.println("The program determines whether or not it's possible to split a pie fairly");
        System.out.println("Please enter the total number of slices:");
        int totalSlices = scan.nextInt();
        System.out.println("Please enter the number of recipients");
        int recipients = scan.nextInt();
        System.out.println("Please enter how many slices each person gets");
        int slicesForEach = scan.nextInt();
        System.out.println(slicesForEach * recipients <= totalSlices ? "true" : "false");
    }

    private static boolean answerCell(Scanner scan) {
        System.out.println("\nThe program determines if you should answer the phone");
        System.out.println("Is it a morning? Y/N");
        String morning = scan.next();
        boolean isMorning = (morning.toLowerCase().charAt(0) == 'y');
        System.out.println("Is it your mom calling? Y/N");
        String mom = scan.next();
        boolean isMom = (mom.toLowerCase().charAt(0) == 'y');
        System.out.println("Are you asleep? Y/N");
        String asleep = scan.next();
        boolean isAsleep = (asleep.toLowerCase().charAt(0) == 'y');
        if (isAsleep) {
            return false;
        }
        if (isMorning) {
            return isMom;
        }
        return true;
    }

    private static void love7(Scanner scan) {
        System.out.println("\nThe program prints true if either one of 2 digits is 7 or if their sum is 7");
        System.out.println("Please enter 2 int numbers");
        int a = scan.nextInt();
        int b = scan.nextInt();
        if ((a == 7) || (b == 7) || (a + b == 7)) {
            System.out.println("true");
        } else {
            System.out.println(false);
        }
    }

    private static void maxInt(Scanner scan) {
        System.out.println("\nThe program finds and prints the max of 3 numbers");
        System.out.println("Please enter 3 int numbers");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        System.out.println(Math.max(Math.max(a, b), Math.max(b, c)));
    }

    private static void lastDigit(Scanner scan) {
        System.out.println("\nThe program will determine if 2 digits have the same last digit");
        System.out.println("Please enter two non-negative int values");
        int firstNumber = scan.nextInt();
        int secondNumber = scan.nextInt();
        int lastDigit = firstNumber % 10;
        if (secondNumber % 10 == lastDigit) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static void nearHundred(Scanner scan) {
        System.out.println("\nThe program will determine weather the number is within 10 of 100\n" +
                "Please enter the number");
        int number = scan.nextInt();
        if ((number >= 90) && (number <= 110)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static void task3(Scanner scan) {
        System.out.println("Please enter the size of the half-pyramid: ");
        int pyramidSize = scan.nextInt();
        for (int i = 0; i < pyramidSize; i++) {
            for (int j = pyramidSize; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void task1(Scanner scan) {
        System.out.println("Please enter the maximum number :");
        int number = scan.nextInt();
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0) {
                System.out.println("The number ‘" + i + "’ is divisible by three");
            } else if (i % 2 == 0) {
                System.out.println("The number ‘" + i + "’ is even.");
            } else {
                System.out.println("The number ‘" + i + "’ is odd.");
            }
        }
    }

    private static void task2(Scanner scan) {
        System.out.println("Please enter 2 integer numbers, first number have to be smaller then the second:");
        int first = scan.nextInt();
        int second = scan.nextInt();
        if (first <= second) {
            int sum = 0;
            for (int i = first; i <= second; i++) {
                sum += i;
            }
            System.out.println("The sum of the numbers between first and second numbers: " + sum);
        } else {
            System.out.println("Error: First number should have been smaller then the second");
        }
    }
}
