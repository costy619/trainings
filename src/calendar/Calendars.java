package calendar;

public class Calendars {
    public static void main( String[] not_in_use )
    {
        EnglishCalendar  an_english_calendar  =
                new  EnglishCalendar( 12, 2019 ) ;

        an_english_calendar.print() ;

        SpanishCalendar  a_spanish_calendar  =
                new  SpanishCalendar( 5, 2011 ) ;

        a_spanish_calendar.print() ;
    }
}
