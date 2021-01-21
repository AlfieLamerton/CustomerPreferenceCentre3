import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekPreference implements Preference {

    DayOfWeek chosenDay;

    public DayOfWeekPreference (DayOfWeek chosenDay)
    {
        this.chosenDay = chosenDay;
    }

    public boolean givenDateSendEmail(LocalDate date)
    {
        if (date.getDayOfWeek() == chosenDay)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}