import java.time.LocalDate;
import java.time.DayOfWeek;
// import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        

        /* Unit testing

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

        */

        // Test for Customer.java and using methods

        Customer customer = new Customer();

        customer.name = "Joe";
        customer.customerPreferences = new DayOfMonthPreference[5];

        // create 5 dates that will return true for our customer's preferences
        LocalDate [] correctDates = new LocalDate[5];

        // create 5 dates that will return false for our customer's preferences
        LocalDate [] incorrectDates = new LocalDate[5];

        for (int i = 0; i < 5; i++) // this sets his preferred days of the month to the 1st-5th of the month
        {
            customer.customerPreferences[i] = new DayOfMonthPreference(i+1);
            correctDates[i] = LocalDate.of(2018, 4, i + 1);
            incorrectDates[i] = LocalDate.of(2018, 4, i + 5);
            System.out.println(customer.customerPreferences[i].givenDateSendEmail(correctDates[i]));
            System.out.println(customer.customerPreferences[i].givenDateSendEmail(incorrectDates[i]));
        }
        
    }
}
