import java.util.ArrayList;
import java.time.DayOfWeek;

public class Customer {
    
    public  String name;
    ArrayList<Preference> customerPreferences = new ArrayList<Preference>(0); // Initialises customerPreferences as an empty ArrayList in case it's never used

    public void addDayOfMonthPreference(int newPreferenceForMonth)
    {
        this.customerPreferences.add(new DayOfMonthPreference(newPreferenceForMonth));
    }

    public void addDayOfWeekPreference(int newPreferenceForWeek)
    {
        this.customerPreferences.add(new DayOfWeekPreference(DayOfWeek.of(newPreferenceForWeek)));
    }

    public void setAlwaysOrNeverPreference(int customerOption)
    {
        this.customerPreferences.add(new AlwaysOrNeverPreference(customerOption));
    }
}