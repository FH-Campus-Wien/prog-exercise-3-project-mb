package at.ac.fhcampuswien;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.

        oneMonthCalendar(31, 3);
    }

    public static void oneMonthCalendar(int dayCnt, int startWeekDay) {
        for (int i = 1; i < dayCnt + startWeekDay; i++) {
            if (i >= startWeekDay) {
                System.out.printf("%1$2s ", (i - startWeekDay) + 1);
                if (i % 7 == 0 && i < dayCnt + startWeekDay - 1) System.out.println();
            } else System.out.print("   ");
        }

        System.out.println();
    }
}