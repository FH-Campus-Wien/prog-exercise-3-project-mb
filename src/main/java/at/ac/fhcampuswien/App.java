package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    // global vars

    // final vars
    static final long m = (long) ((int) 2e31) + 1;
    static final int a = 1103515245;
    static final short c = 12345;
    static final char[] filter = {'.', ',', '\'', '?', '!'};

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        // Task 1
        oneMonthCalendar(31, 3);

        // Task 2
        long[] ranNums = lcg(0);
        for (long r : ranNums) {
            System.out.println(r);
        }

        // Task 3
        //guessingGame(randomNumberBetweenOneAndHundred());

        // Task 4
        System.out.println(swapArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{100, 202, 30, 14, 15, 16}));
        System.out.println(swapArrays(new int[]{100, 202, 30, 14, 15, 16}, new int[]{1, 2, 3, 4, 5, 6, 7}));

        // Task 5
        System.out.println(camelCase("my name isn't Alice!"));
    }

    // TODO: Task 1
    public static void oneMonthCalendar(int dayCnt, int startWeekDay) {
        for (int i = 1; i < dayCnt + startWeekDay; i++) {
            if (i >= startWeekDay) {
                System.out.printf("%1$2s ", (i - startWeekDay) + 1);
                if (i % 7 == 0 && i < dayCnt + startWeekDay - 1) System.out.println();
            } else System.out.print("   ");
        }

        System.out.println();
    }

    // TODO: Task 2
    public static long[] lcg(long seed) {
        long[] ranNums = new long[10];

        ranNums[0] = (a * seed + c) % m;

        for (int i = 1; i < ranNums.length; i++) {
            ranNums[i] = (a * ranNums[i - 1] + c) % m;
        }

        return ranNums;
    }

    // TODO: Task 3
    public static void guessingGame(int numberToGuess) {
        int playerGuess;
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            do {
                System.out.printf("Guess number %d: ", i);
                playerGuess = sc.nextInt();
            } while (playerGuess < 1 || playerGuess > 100);

            if (playerGuess < numberToGuess && i < 10)
                System.out.println("The number AI picked is higher than your guess.");
            else if (playerGuess > numberToGuess && i < 10)
                System.out.println("The number AI picked is lower than your guess.");
            else if (playerGuess == numberToGuess) {
                System.out.println("You won wisenheimer!");
                return;
            }
        }

        System.out.println("You lost! Have you ever heard of divide & conquer?");
    }

    public static int randomNumberBetweenOneAndHundred() {
        return new Random().nextInt(1, 101);
    }

    // TODO: Task 4
    public static boolean swapArrays(int[] arr0, int[] arr1) {
        int buffer;

        if (arr0.length == arr1.length) {
            for (int i = 0; i < arr0.length; i++) {
                buffer = arr1[i];
                arr1[i] = arr0[i];
                arr0[i] = buffer;
            }
            return true;
        } else return false;
    }

    // TODO: Task 5
    public static String camelCase(String input) {
        char[] inputArr = input.toCharArray();
        boolean isFirstChar = true;
        StringBuilder outputStr = new StringBuilder();

        for (char c : inputArr) {
            if (!hasSpecialChar(c)) {
                if (c != ' ') {
                    if (isFirstChar && c >= 97) c -= 32;
                    else if (!isFirstChar && c <= 90) c += 32;

                    outputStr.append(c);
                    isFirstChar = false;
                } else isFirstChar = true;
            }
        }

        return outputStr.toString();
    }

    public static boolean hasSpecialChar(char _char) {
        for (char c : filter) if (_char == c) return true;
        return false;
    }
}