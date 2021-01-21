import java.time.LocalDate;

public class DayOfMonthPreference implements Preference {
    
    int chosenDay;

    public DayOfMonthPreference (int chosenDay)
    {
        this.chosenDay = chosenDay;
    }

    public boolean givenDateSendEmail(LocalDate date)
    {
        if (date.getDayOfMonth() == chosenDay)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}