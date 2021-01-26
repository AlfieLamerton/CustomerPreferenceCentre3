import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("How many customers are there?");
        int numberOfCustomers = input.nextInt();

        ArrayList<Customer> customerList = new ArrayList<Customer>(0);

        /* Data collection (console input) */

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

            else if (customerOption == 2) // Days of week
            {
                System.out.println("How many days of the week would you like to receive marketing info? (1-7)");
                int numberOfDays = input.nextInt();


                System.out.println("Enter which days of the week you would like to recive marketing info:\n 1) Monday\n 2) Tuesday\n 3) Wednesday\n 4) Thursday\n 5) Friday\n 6) Saturday\n 7) Sunday\n");

                for (int j = 0; j < numberOfDays; j++)
                {
                    // I've left the code in from when I was trying to take String values as input:
                    // String dayAsString = input.nextLine();
                    // int dayAsInteger = getIntegerValue(dayAsString);
                    customerList.get(i).addDayOfWeekPreference(input.nextInt());
                }
            }

            else if (customerOption == 3) // Every day
            {
                for (int j = 1; j < 8; j++)
                {
                    customerList.get(i).addDayOfWeekPreference(j);
                }
            }
        }

        input.close();

        Report [] prefCentreReport = new Report[90]; // Create an array which will contain our dates and the customers who selected them

        // This gives us the 1st of April 2018 when passed to the LocalDate ofYearDay() method with the year 2018. We can change this variable to start at any point in
        // calendar time, and change the size of the prefCentreReport array to cover different ranges of time.
        int dayOfYearCounter = 91;

        for (int i = 0; i < prefCentreReport.length; i++) // For each date
        {
            /* Compare customer preferences with dates */
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

            /* Produce report */
            // System.out.print(prefCentreReport[i].date.getDayOfWeek()+ " " + prefCentreReport[i].date + "  "); // Output the current date (with days)
            System.out.print(prefCentreReport[i].date + "  "); // Output the current date (without days)


            for (int j = 0; j < prefCentreReport[i].customersForDate.size(); j++) // For each customer signed up for that date
            {
                System.out.print(prefCentreReport[i].customersForDate.get(j) + " "); // Output the customer names for this date
            }
            System.out.print("\n");

            dayOfYearCounter++;
        }
    }

    // This exists from when I was trying to take a String input for the day of week option
    // public static int getIntegerValue(String dayAsString)
    // {
    //     if (dayAsString == "mon") return 1;
    //     if (dayAsString == "tue") return 2;
    //     if (dayAsString == "wed") return 3;
    //     if (dayAsString == "thu") return 4;
    //     if (dayAsString == "fri") return 5;
    //     if (dayAsString == "sat") return 6;
    //     if (dayAsString == "sun") return 7;
    //     else return 0;
    // }
}