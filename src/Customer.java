import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Customer {
    
    public  String name;
    ArrayList<Preference> customerPreferences = new ArrayList<Preference>(0); // Initialises customerPreferences as an empty ArrayList

    public void addDayOfMonthPreference(int newPreferenceMonth)
    {
        this.customerPreferences.add(new DayOfMonthPreference(newPreferenceMonth));
    }

    public void addDayOfWeekPreference(int newPreferenceWeek)
    {
        this.customerPreferences.add(new DayOfWeekPreference(DayOfWeek.of(newPreferenceWeek)));
        System.out.println(DayOfWeek.of(newPreferenceWeek));
    }
}