package at.ac.fhcampuswien;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class App {
    // final vars
    static final int m = (int) 2e31;
    static final int a = 1103515245;
    static final int c = 12345;

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        oneMonthCalendar(31, 3);

        long[] ranNums = lcg(12345);
        for (long r : ranNums) {
            System.out.println(r);
        }
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

        ranNums[0] = seed;

        for (int i = 1; i < ranNums.length; i++) {
            ranNums[i] = (a * ranNums[i - 1] + c) % m;
        }

        return ranNums;
    }
}