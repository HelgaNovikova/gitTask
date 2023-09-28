package strings;

import java.util.Scanner;


public class Tasks {

    private static final String ENTER_STRING = "Please enter the string";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(compareStrings(scan));
        System.out.println(isPalindrome(scan));
        System.out.println(addChars(scan));
        System.out.println(maxStart(scan));
        System.out.println(fizzString(scan));
        System.out.println(bibThere(scan));
        stringTimes(scan);
        System.out.println(isPlural(scan));
    }

    private static boolean isPlural(Scanner scan) {
        System.out.println("\nThe program  takes in a word and determines whether or not it is plural");
        System.out.println(ENTER_STRING);
        String enterdString = scan.next().trim();
        return enterdString.charAt(enterdString.length() - 1) == 's';
    }

    private static void stringTimes(Scanner scan) {
        System.out.println("\nThe program returns a larger string that is n copies of the original string");
        System.out.println(ENTER_STRING);
        String enteredString = scan.nextLine();
        System.out.println("Enter integer number > 0");
        int copies = scan.nextInt();
        if (copies > 0) {
            for (int i = 1; i <= copies; i++) {
                System.out.print(enteredString);
            }
            System.out.println();
        }
    }

    private static boolean bibThere(Scanner scan) {
        System.out.println("\nThe program return true if the given string contains a 'bib' string," +
                " but where the middle 'i' char can be any char");
        System.out.println(ENTER_STRING);
        String enteredString = scan.nextLine().trim();
        return enteredString.matches(".*b.b.*");
    }

    private static String fizzString(Scanner scan) {
        System.out.println("\nThe program returns 'Fizz' if the string starts with 'f', 'Buzz' - if it ends with 'b'" +
                ", or returns the string in other cases");
        System.out.println(ENTER_STRING);
        String enteredString = scan.nextLine().trim().toLowerCase();
        String result = "";
        if (enteredString.charAt(0) == 'f') {
            result = "Fizz";
        }
        if (enteredString.charAt(enteredString.length() - 1) == 'b') {
            result += "Buzz";
        }
        if (result.isEmpty()) {
            result = enteredString;
        }
        return result;
    }

    private static boolean maxStart(Scanner scan) {
        System.out.println("\nThe program return true if the given string begins with 'max', except the 'm' can be anything");
        System.out.println(ENTER_STRING);
        String enteredString = scan.nextLine().trim();
        return enteredString.matches(".ax.*");
    }

    private static String addChars(Scanner scan) {
        System.out.println("\nThe program takes the last char of the string and returns" +
                " a new string with the last char added at the beginning and the end");
        System.out.println(ENTER_STRING);
        String enteredString = scan.nextLine().trim();
        if (enteredString.isEmpty()) {
            return "Entered string was either empty, or contained only spaces";
        }
        int lastSymbolIndex = enteredString.length() - 1;
        return enteredString.charAt(lastSymbolIndex) + enteredString + enteredString.charAt(lastSymbolIndex);
    }

    private static String compareStrings(Scanner scan) {
        System.out.println("\nThe program will compare strings");
        System.out.println("Please enter 2 strings, each string on each line");
        String first = scan.nextLine().trim();
        String second = scan.nextLine().trim();
        if (first.isEmpty() || second.isEmpty()) {
            return "Cannot compare Strings";
        }
        if (first.equals(second)) {
            return "The Strings are the same";
        }
        String partOf = "%s is a part of %s";
        if (first.contains(second)) {
            return String.format(partOf, second, first);
        }
        if (second.contains(first)) {
            return String.format(partOf, first, second);
        }
        return "Strings are different";
    }

    private static boolean isPalindrome(Scanner scan) {
        System.out.println("\nThe program checks if the entered string is palindrome or not");
        System.out.println(ENTER_STRING);
        String enteredString = scan.nextLine();
        enteredString = enteredString.replaceAll("[\\s?!,.']", "").toLowerCase();
        int stringLength = enteredString.length();
        for (int i = 0; i < stringLength / 2; i++) {
            if (enteredString.charAt(i) != enteredString.charAt(stringLength - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
