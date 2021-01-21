import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Scanner;

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

        /*

        Scanner input = new Scanner(System.in);

        System.out.println("How many customers are there?");
        int numOfCustomers = input.nextInt();

        Customer [] customerList = new Customer[numOfCustomers];
        
        for (int i = 0; i < numOfCustomers; i++)
        {
            // This creates a new customer object for each customer for whom the system will be processing data
            customerList[i] = new Customer();

            input.nextLine();

            // Set customer's name to the name entered by user
            System.out.println("Enter customer name");
            String name = input.nextLine();
            customerList[i].name = name;

            System.out.println("How would you like to set your preferences?\n 1) On a specific day of the month\n 2) On each specified day of the week\n 3) Every day\n 4) Never\n");
            
            int customerPreferenceType = input.nextInt();

            if (customerPreferenceType == 1)
            {
                System.out.println("How many days of the month would you like to receive marketing info? (1-28)");
                int numberOfDays = input.nextInt();
                customerList[i].customerPreferences = new DayOfMonthPreference[numberOfDays];
            }

            else if (customerPreferenceType == 2)
            {

            }

            else if (customerPreferenceType == 3)
            {

            }

            else if (customerPreferenceType == 4)
            {

            }
        }
        
        input.close();

        */
        
    }
}
