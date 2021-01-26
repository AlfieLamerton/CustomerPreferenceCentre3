import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.Scanner;


import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("How many customers are there?");
        int numberOfCustomers = input.nextInt();

        ArrayList<Customer> customerList = new ArrayList<Customer>(numberOfCustomers);

        for (int i = 0; i < numberOfCustomers; i++)
        {
            customerList.add(new Customer());

            input.nextLine();

            // Set customer's name to the name entered by user
            System.out.println("Enter customer name");
            customerList.get(i).name = input.nextLine();

            System.out.println("How would you like to set your preferences?\n 1) On a specific day of the month\n 2) On each specified day of the week\n 3) Every day\n 4) Never\n");

            int customerOption = input.nextInt();

            if (customerOption == 1) // Days of month
            {
                System.out.println("How many days of the month would you like to receive marketing info? (1-28)");
                int numberOfDays = input.nextInt();

                System.out.println("Enter which days of the month you would like to receive marketing info: ");
                for (int j = 0; j < numberOfDays; j++)
                {
                    customerList.get(i).addDayOfMonthPreference(input.nextInt());
                }
            }

            // else if (customerOption == 2)
            // {
            //     System.out.println("How many days of the week would you like to receive marketing info? (1-7)");
            //     int numberOfDays = input.nextInt();

            //     System.out.println("Enter which days of the week you would like to receive marketing info: e.g. MONDAY");
            //     for (int j = 0; j < numberOfDays; j++) // Getting an array out of bounds exception when this tries to run
            //     {
            //         String dayAsString = input.nextLine();
            //         int dayAsInteger = getIntegerValue(dayAsString);

            //         if (dayAsInteger != 0)
            //         {
            //             customerList.get(i).addDayOfWeekPreference(dayAsInteger);
            //         }
            //     }
            // }
        }

        input.close();

        // Make comparisons

        Report [] cpcReport = new Report[90];

        int dayOfYearCounter = 91;

        for (int i = 0; i < cpcReport.length; i++) // For each date
        {
            /* Compare customer preferences with dates */
            LocalDate dateToCompare = LocalDate.ofYearDay(2018, dayOfYearCounter); // Creates a LocalDate for the date on each iteration
            cpcReport[i] = new Report(dateToCompare);

            for (int j = 0; j < numberOfCustomers; j++) // For each customer
            {
                for (int k = 0; k < customerList.get(j).customerPreferences.size(); k++) // For each of a given customer's preferences
                {
                    boolean isPreferenceSet = customerList.get(j).customerPreferences.get(k).givenDateSendEmail(dateToCompare); // returns true or false
                    if (isPreferenceSet == true) cpcReport[i].customersForDate.add(customerList.get(j).name); // If true, adds the customer's name to the report
                }
            }

            /* Produce report */
            System.out.print(cpcReport[i].date + "  "); // Output the current date

            for (int j = 0; j < cpcReport[i].customersForDate.size(); j++)
            {
                System.out.print(cpcReport[i].customersForDate.get(j) + " "); // Output the customers for this date
            }
            System.out.print("\n");

            dayOfYearCounter++;
        }
    }

    // public static int getIntegerValue(String dayAsString)
    // {
    //     switch (dayAsString)
    //     {
    //         case "mon":
    //         return 1;
            
    //         case "tue":
    //         return 2;

    //         case "wed":
    //         return 3;

    //         case "thu":
    //         return 4;

    //         case "fri":
    //         return 5;

    //         case "sat":
    //         return 6;

    //         case "sun":
    //         return 7;

    //         default:
    //         return 0;
    //     }
    // }
}