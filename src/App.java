import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("How many customers are there?");
        int numberOfCustomers = input.nextInt();
        input.nextLine();

        ArrayList<Customer> customerList = new ArrayList<Customer>(0);

        /* Data collection (console input) */

        for (int i = 0; i < numberOfCustomers; i++)
        {
            customerList.add(new Customer());

            // Set customer's name to the name entered by user
            System.out.println("Enter customer name");
            customerList.get(i).name = input.nextLine();

            System.out.println("How would you like to set your preferences?\n 1) On a specific day of the month\n 2) On each specified day of the week\n 3) Every day\n 4) Never\n");

            int customerOption = input.nextInt();
            input.nextLine();

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

            else if (customerOption == 2) // Days of week
            {
                System.out.println("How many days of the week would you like to receive marketing info? (1-7)");

                int numberOfDays = input.nextInt();
                input.nextLine();

                System.out.println("Enter which day(s) of the week you would like to recive marketing info: ");

                for (int j = 0; j < numberOfDays; j++)
                {
                    customerList.get(i).addDayOfWeekPreference(getIntegerValue(input.nextLine()));
                }
            }

            else if ((customerOption == 3) || (customerOption == 4)) // Every day or never
            {
                customerList.get(i).setAlwaysOrNeverPreference(customerOption);
            }
        }

        input.close();

        Report [] prefCentreReport = new Report[90]; // Create an array which will contain our dates and the customers who selected them

        // This gives us the 1st of April 2018 when passed to the LocalDate ofYearDay() method with the year 2018. We can change this variable to start at any point in
        // calendar time, and change the size of the prefCentreReport array to cover different ranges of time.
        int dayOfYearCounter = 91;

        /* Compare preferences and produce report */

        for (int i = 0; i < prefCentreReport.length; i++) // For each date
        {
            /* Compare customer preferences with current date */
            LocalDate dateToCompare = LocalDate.ofYearDay(2018, dayOfYearCounter); // Creates a LocalDate for the date on each iteration
            prefCentreReport[i] = new Report(dateToCompare);

            for (int j = 0; j < numberOfCustomers; j++) // For each customer
            {
                for (int k = 0; k < customerList.get(j).customerPreferences.size(); k++) // For each of a given customer's preferences
                {
                    boolean isPreferenceSet = customerList.get(j).customerPreferences.get(k).givenDateSendEmail(dateToCompare); // returns true or false
                    if (isPreferenceSet == true) prefCentreReport[i].customersForDate.add(customerList.get(j).name); // If true, adds the customer's name to the report
                }
            }

            /* Output report for current date */
            System.out.print(prefCentreReport[i].date + "  "); // Output the current date (without days)
            // System.out.print(prefCentreReport[i].date.getDayOfWeek()+ " " + prefCentreReport[i].date + "  "); // Alternative wich outputs days too

            for (int j = 0; j < prefCentreReport[i].customersForDate.size(); j++) // For each customer signed up for that date
            {
                System.out.print(prefCentreReport[i].customersForDate.get(j) + " "); // Output the customer names for this date
            }

            System.out.print("\n");
            dayOfYearCounter++;
        }
    }

    // Convert the string day value to an integer that refers to the LocalDate.dayOfWeek ENUM for that day
    public static int getIntegerValue(String dayAsString)
    {
        switch (dayAsString)
        {
            case "mon": return 1;
            case "tue": return 2;
            case "wed": return 3;
            case "thu": return 4;
            case "fri": return 5;
            case "sat": return 6;
            case "sun": return 7;
            default: return 1;
        }
    }
}