package calendar;

class  EnglishCalendar
{
    protected  int  this_month ;
    protected  int  this_year ;

    protected  String[]  names_of_months ;
    protected  String    week_description ;

    public EnglishCalendar() {}

    public EnglishCalendar( int given_month, int given_year )
    {
        String[]  english_names_of_months  =

                { "January", "February", "March", "April",
                        "May", "June", "July", "August",
                        "September", "October", "November", "December" } ;

        String  english_week_description  =

                " Week   Mon  Tue  Wed  Thu  Fri  Sat  Sun" ;

        names_of_months   =  english_names_of_months ;

        week_description  =  english_week_description ;

        this_month  =  given_month ;
        this_year   =  given_year  ;
    }


    public void print()
    {
        Date a_day_in_this_month  =  new Date( 1, this_month, this_year ) ;

        int day_of_week_index   =  0 ;

        int day_of_week_of_first_day  =
                a_day_in_this_month.index_for_day_of_week() ;

        System.out.print(
                "\n\n   "  +  names_of_months[ this_month - 1 ]
                        +  "  "  +  this_year  +  "\n\n"  +  week_description   +  "\n\n" );

        System.out.printf( "%4d  ",  a_day_in_this_month.get_week_number() ) ;

        // The first week of a month is often an incomplete week,
        // i.e., the first part of week belongs to the previous
        // month. In place of the days that belong to the previous
        // month we print just spaces.

        while ( day_of_week_index != day_of_week_of_first_day )
        {
            System.out.print( "     " )  ;
            day_of_week_index  ++ ;
        }

        while ( this_month  ==  a_day_in_this_month.month() )
        {
            if ( day_of_week_index  >=  7 )
            {
                System.out.printf( "\n%4d  ",
                        a_day_in_this_month.get_week_number() ) ;

                day_of_week_index  =  0 ;
            }

            System.out.printf( "%5d", a_day_in_this_month.day() ) ;

            a_day_in_this_month.increment() ;

            day_of_week_index  ++  ;
        }

        System.out.print( "\n" ) ;
    }
}
