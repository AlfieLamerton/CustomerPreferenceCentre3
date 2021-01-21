import java.time.LocalDate;
import java.time.DayOfWeek;
// import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        /* Unit testing */

        // Arbitrary date to test (1st April 2018)
        LocalDate dateToTest = LocalDate.of(2018, 4, 1);

        //  Test for DayOfMonthPreference

        int correctDayOfMonth = 1;
        int incorrectDayOfMonth = 4;

        // Should return true
        DayOfMonthPreference DOMpreference1 = new DayOfMonthPreference(correctDayOfMonth);
        System.out.println(DOMpreference1.givenDateSendEmail(dateToTest));

        // Should return false
        DayOfMonthPreference DOMpreference2 = new DayOfMonthPreference(incorrectDayOfMonth);
        System.out.println(DOMpreference2.givenDateSendEmail(dateToTest));


        //  Test for DayOfWeekPreference

        DayOfWeek correctDayOfWeek = DayOfWeek.SUNDAY;
        DayOfWeek incorrectDayOfWeek = DayOfWeek.MONDAY;

        // Should return true
        DayOfWeekPreference DOWpreference1 = new DayOfWeekPreference(correctDayOfWeek);
        System.out.println(DOWpreference1.givenDateSendEmail(dateToTest));

        // Should return false
        DayOfWeekPreference DOWpreference2 = new DayOfWeekPreference(incorrectDayOfWeek);
        System.out.println(DOWpreference2.givenDateSendEmail(dateToTest));
    }
}
