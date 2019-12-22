package calendar;

import java.time.LocalDate;
import java.util.Scanner;

public class Calendars {
    public static void main( String[] not_in_use ) {

        Scanner keyboard = new Scanner(System.in);
        String j = keyboard.nextLine();
        String b=j;
        System.out.println("English calendar is:");
        LocalDate current_system_date = LocalDate.now() ;
        int current_year = current_system_date.getYear() ;
        int current_month = current_system_date.getMonthValue();
        EnglishCalendar an_english_calendar2 = new EnglishCalendar(current_month, current_year);
        an_english_calendar2.print();
        while (j != "k") {
            switch (j) {
                case ("E"):
                    EnglishCalendar an_english_calendar = new EnglishCalendar(12, 2019);
                    an_english_calendar.print();
                    b=j;
                    j = keyboard.nextLine();
                    break;
                case ("ES"):
                    SpanishCalendar a_spanish_calendar = new SpanishCalendar(5, 2011);
                    a_spanish_calendar.print();
                    b=j;
                    j = keyboard.nextLine();
                    break;
                case ("G"):
                    GermanCalendar germanCalendar = new GermanCalendar(6, 2109);
                    germanCalendar.print();
                    b=j;
                    j = keyboard.nextLine();
                    break;
                case ("Y"):
                    switch (b){
                        case ("E"):
                            an_english_calendar = new EnglishCalendar(1, 2020);
                            an_english_calendar.print();
                            b=j;
                            break;
                            case ("ES"):
                            a_spanish_calendar = new SpanishCalendar(1, 2012);
                            a_spanish_calendar.print();
                            break;
                        case ("G"):
                            germanCalendar = new GermanCalendar(1, 2110);
                            germanCalendar.print();
                            break;
                    }
                    j = keyboard.nextLine();
                    break;
            }
        }
    }

}
