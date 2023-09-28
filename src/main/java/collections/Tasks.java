package collections;

import java.util.*;

public class Tasks {

    public static final String ENTER_INTEGER_NUMBERS = "Please enter integer numbers separated by space in one string";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(getDay(scan));
        System.out.println(getToy(scan));
        getListWithoutDuplicates(scan);
        System.out.println(has22(scan));
        System.out.println(lucky13(scan));
        System.out.println(maxTriple(scan));
        System.out.println(arrayFront9(scan));
        System.out.println(square(scan));
    }

    private static List<Integer> square(Scanner scan) {
        System.out.println("\nThe method returns a list where each integer is multiplied with itself");
        System.out.println(ENTER_INTEGER_NUMBERS);
        String input = scan.nextLine();
        List<Integer> inputList = parseStringIntoListOfIntegers(input);
        return inputList.stream().map(x -> x * x).toList();
    }

    private static boolean arrayFront9(Scanner scan) {
        System.out.println("\nThe method returns true if one of the first 4 elements in the array is a 9");
        System.out.println(ENTER_INTEGER_NUMBERS);
        String input = scan.nextLine();
        List<Integer> inputList = parseStringIntoListOfIntegers(input);
        if (inputList.size() >= 4) {
            return inputList.contains(9) && (inputList.indexOf(9) < 4);
        }
        return false;
    }

    private static int maxTriple(Scanner scan) {
        System.out.println("\nThe method looks at the first, last, and middle values in the array and return the largest");
        System.out.println(ENTER_INTEGER_NUMBERS);
        String input = scan.nextLine();
        List<Integer> inputList = parseStringIntoListOfIntegers(input);
        int result = 0;
        if (inputList.size() % 2 == 0) {
            System.out.println("Error: you should have entered odd amount of numbers");
        } else {
            int first = inputList.get(0);
            int second = inputList.get(inputList.size() / 2);
            int third = inputList.get(inputList.size() - 1);
            result = Math.max(Math.max(first, second), Math.max(second, third));
        }
        return result;
    }

    private static boolean lucky13(Scanner scan) {
        System.out.println("\nThe program returns true if the array contains no 1's and no 3's");
        System.out.println(ENTER_INTEGER_NUMBERS);
        String input = scan.nextLine();
        List<Integer> inputNumbers = parseStringIntoListOfIntegers(input);
        return !inputNumbers.contains(1) && !inputNumbers.contains(3);
    }

    private static List<Integer> parseStringIntoListOfIntegers(String input) {
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split("\\s+")));
        return inputList.stream().map(Integer::parseInt).toList();
    }

    private static boolean has22(Scanner scan) {
        System.out.println("\nThe program returns true if the array of ints contains a 2 next to a 2 somewhere.");
        System.out.println(ENTER_INTEGER_NUMBERS);
        String input = scan.nextLine();
        List<Integer> inputNumbers = parseStringIntoListOfIntegers(input);
        for (int i = 0; i < inputNumbers.size() - 2; i++) {
            if (inputNumbers.get(i) == 2 && inputNumbers.get(i + 1) == 2) {
                return true;
            }
        }
        return false;
    }

    private static void getListWithoutDuplicates(Scanner scan) {
        System.out.println("\nThe program receives a list of words and prints all the words with no duplicates");
        System.out.println("Please enter a list of words separated by space");
        scan.nextLine();
        String input = scan.nextLine();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(input.split(" ")));
        HashSet<String> uniqueWordsSet = new HashSet<>(words);
        ArrayList<String> result = new ArrayList<>();
        for (String item : words) {
            if (uniqueWordsSet.contains(item)) {
                result.add(item);
                uniqueWordsSet.remove(item);
            }
        }
        System.out.println(result);
    }

    private static String getDay(Scanner scan) {
        System.out.println("The program receive a number and return/print the day of the week");
        System.out.println("Please enter the int number");
        int dayOfWeek = scan.nextInt();
        String result = "";
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            result = "Incorrect number, number has to be between 1 and 7";
        } else {
            ArrayList<String> daysNames =
                    new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
            result = daysNames.get(dayOfWeek - 1);
        }
        return result;
    }

    private static String getToy(Scanner scan) {
        System.out.println("\nThe program returns the name of the toy by ID");
        System.out.println("Please enter id");
        int id = scan.nextInt();
        return new ToyStore().getToyNameById(id);
    }
}

class ToyStore {
    private final HashMap<Integer, String> toyStore = new HashMap<>();

    public ToyStore() {
        toyStore.put(12, "Batmobile");
        toyStore.put(45, "Light Saber");
        toyStore.put(6, "Wonder Woman");
        toyStore.put(201, "Hello Kitty Bag");
        toyStore.put(56, "Junior QA Analyst Doll");
    }

    public String getToyNameById(int id) {
        if (toyStore.containsKey(id)) {
            return toyStore.get(id);
        }
        return "No such Toy";
    }
}

