import java.time.LocalDate;
import java.util.ArrayList;

public class Report
{
    LocalDate date;
    ArrayList<String> customersForDate = new ArrayList<String>(0);

    public Report (LocalDate date) {
        this.date = date;
    }
}