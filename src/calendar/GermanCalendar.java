package calendar;

public class GermanCalendar extends EnglishCalendar {
    public GermanCalendar(int given_month, int given_year) {


        String[] german_names_of_months = {"Januar", "Februar", "Marz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
        String german_week_description = "Woche   Mon  Die  Mit  Don  Fre  Sam  Son";
        names_of_months   =  german_names_of_months;
        week_description  =  german_week_description ;

        this_month  =  given_month ;
        this_year   =  given_year  ;
    }
}
