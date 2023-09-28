package advJavaTask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    enum GameType {
        SOCCER,
        HOCKEY,
        RUGBY
    }

    public static void writeNumOfPlayersPerTeam(GameType game) {
        File file = new File(game + ".txt");
        try (FileWriter writer = new FileWriter(file)) {
            switch (game) {
                case SOCCER -> writer.write("11");
                case HOCKEY -> writer.write("6");
                case RUGBY -> writer.write("15");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeNumOfPlayersPerTeam(GameType.SOCCER);
        writeNumOfPlayersPerTeam(GameType.HOCKEY);
        writeNumOfPlayersPerTeam(GameType.RUGBY);
        Scanner sc = new Scanner(System.in);
        runSelfTrainingTasks(sc);
    }

    private static void runSelfTrainingTasks(Scanner sc) {
        compareListsOfStrings(sc);
        nameShuffle(sc);
        doubleLetters(sc);
        calculateScores(sc);
    }

    private static void calculateScores(Scanner sc) {
        System.out.println("\nThe program calculates the numbers of entered A,B,C letters in the string");
        System.out.println("Please enter the sequence of A,B,Cs:");
        String enter = sc.nextLine().trim();
        int[] result = new int[3];
        try {
            for (int i = 0; i < enter.length(); i++) {
                switch (enter.charAt(i)) {
                    case 'A' -> result[0]++;
                    case 'B' -> result[1]++;
                    case 'C' -> result[2]++;
                    default -> throw new RuntimeException("Wrong symbols");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Arrays.toString(result));
    }

    private static void doubleLetters(Scanner sc) {
        System.out.println("\nThe program takes a word and returns true if the word has two consecutive identical letters");
        System.out.println("Please enter the word:");
        String word = sc.nextLine().trim();
        boolean result = false;
        for (int i = 0; i < word.length() - 2; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }

    private static void nameShuffle(Scanner sc) {
        System.out.println("\nThe program accepts a person's first and last name and returns a string with the first and last name swapped");
        System.out.println("Please enter first and last names");
        String name = sc.nextLine();
        String[] names = name.trim().split("\\s");
        System.out.println(names[1] + " " + names[0]);
    }

    private static void compareListsOfStrings(Scanner sc) {
        System.out.println("The program will compare elements in 2 arrays");
        System.out.println("Please enter string elements of the first array separated by space");
        String userArray = sc.nextLine();
        List<String> userInput = List.of(userArray.trim().split("\\s"));
        System.out.println("Please enter string elements of the second array separated by space");
        String correctArray = sc.nextLine();
        List<String> correctWords = List.of(correctArray.trim().split("\\s"));
        System.out.println(correctStream(userInput, correctWords));
    }

    private static List<Integer> correctStream(List<String> userInput, List<String> correctWords) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(correctWords.get(i))) {
                result.add(1);
            } else {
                result.add(-1);
            }
        }
        return result;
    }
}
