package calendar;

import calendar.DateDistance;

class  Date
{
    protected int this_day    =  1 ;
    protected int this_month  =  1 ;
    protected int this_year   =  1970 ;

    protected char  date_print_format  =  'E' ;

    public Date() {}

    public Date( int  given_day,
                 int  given_month,
                 int  given_year,
                 char given_print_format )
    {
        this_day           =  given_day ;
        this_month         =  given_month ;
        this_year          =  given_year ;
        date_print_format  =  given_print_format ;
    }

    public Date( int  given_day,
                 int  given_month,
                 int  given_year )
    {
        this_day     =  given_day ;
        this_month   =  given_month ;
        this_year    =  given_year ;
    }

    public Date( String  date_as_string )
    {
        //  This constructor accepts date strings in two formats:
        //
        //    MM/DD/YYYY  is the American format.
        //    DD.MM.YYYY  is the format used in Europe.
        //
        //  Member variable date_print_format will be set either
        //  to value 'A' or 'E'. This value will be used to select
        //  correct print format when this date object is converted
        //  to a string with the toString() method.

        if ( date_as_string.charAt( 2 )  ==  '/' )
        {
            date_print_format  =  'A' ;  // American format
            this_day   = Integer.parseInt( date_as_string.substring( 3, 5 ) ) ;
            this_month = Integer.parseInt( date_as_string.substring( 0, 2 ) ) ;
        }
        else
        {
            date_print_format  =  'E' ;  //  European format
            this_day   = Integer.parseInt( date_as_string.substring( 0, 2 ) ) ;
            this_month = Integer.parseInt( date_as_string.substring( 3, 5 ) ) ;
        }

        this_year  = Integer.parseInt( date_as_string.substring( 6, 10 ) ) ;
    }

    public int   day()    {  return  this_day   ; }
    public int   month()  {  return  this_month ; }
    public int   year()   {  return  this_year  ; }
    public char  get_date_print_format()  { return date_print_format ; }

    public boolean is_last_day_of_month()
    {
        boolean  it_is_last_day_of_month  =  false ;

        if  (  this_day  >  27  )
        {
            if  (  this_day  ==  31 )
            {
                it_is_last_day_of_month  =  true ;
            }
            else if  ( ( this_day  ==  30 ) &&
                    ( this_month  ==  2  ||  this_month  ==  4  ||
                            this_month  ==  6  ||  this_month  ==  9  ||
                            this_month  ==  11 ) )
            {
                it_is_last_day_of_month  =  true ;
            }
            else if  ( this_day  ==  29  &&  this_month  ==  2 )
            {
                it_is_last_day_of_month  =  true ;
            }
            else if  ( this_day    ==  28  &&
                    this_month  ==   2  &&
                    ! this_is_a_leap_year() )
            {
                it_is_last_day_of_month  =  true ;
            }
        }

        return  it_is_last_day_of_month ;
    }

    public boolean this_is_a_leap_year()
    {
        boolean  return_code  =  false ;

        if  ( this_year  %  4   ==  0 )
        {
            //  Years which are equally divisible by 4 and which
            //  are not full centuries are leap years. Centuries
            //  equally divisible by 4 are, however, leap years.

            if  ( this_year  %  100  ==  0 )
            {
                int  century  =  this_year  /  100  ;

                if  ( century  %  4   ==   0 )
                {
                    return_code  =  true ;
                }
            }
            else
            {
                return_code  =  true ;
            }
        }

        return  return_code ;
    }

    public boolean is_within_dates( Date earlier_date,
                                    Date later_date   )
    {
        return (( is_equal_to( earlier_date )  )  ||
                ( is_equal_to(  later_date )   )  ||
                ( is_later_than( earlier_date ) &&
                        is_earlier_than( later_date ) ) ) ;
    }

    public int index_for_day_of_week()
    {
        //  day_index will get a value in the range from 0 to 6,
        //  0 meaning Monday and 6 meaning Sunday.

        int  day_index  =  0 ;
        Date  known_date  =  new  Date( 6, 10, 1997 ) ;
        // Oct. 6, 1997 is Monday.

        if  ( known_date.is_later_than( this ) )
        {
            while ( known_date.is_not_equal_to( this ) )
            {
                if ( day_index  >  0 )
                {
                    day_index  --  ;
                }
                else
                {
                    day_index  =  6 ;
                }

                known_date.decrement() ;
            }
        }
        else
        {
            while ( known_date.is_not_equal_to( this ) )
            {
                if ( day_index  <  6  )
                {
                    day_index  ++  ;
                }
                else
                {
                    day_index  =  0 ;
                }

                known_date.increment() ;
            }
        }

        return  day_index ;
    }

    public String get_day_of_week()
    {
        String[]  days_of_week  =  { "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday" } ;

        return  days_of_week[ index_for_day_of_week() ] ;
    }

    public void increment()
    {
        if  (  is_last_day_of_month() )
        {
            this_day   =  1 ;

            if  (  this_month  <  12  )
            {
                this_month  ++  ;
            }
            else
            {
                this_month  =  1  ;
                this_year  ++ ;
            }
        }
        else
        {
            this_day  ++  ;
        }
    }

    public void decrement()
    {
        if ( this_day  >  1  )
        {
            this_day  --  ;
        }
        else
        {
            if ( this_month  ==   5  ||  this_month  ==   7  ||
                    this_month  ==  10  ||  this_month  ==  12  )
            {
                this_day    =  30 ;
                this_month  -- ;
            }
            else if ( this_month  ==   2  ||  this_month  ==   4  ||
                    this_month  ==   6  ||  this_month  ==   8  ||
                    this_month  ==   9  ||  this_month  ==  11  )
            {
                this_day    =  31 ;
                this_month  -- ;
            }
            else if (  this_month  ==  1  )
            {
                this_day    =  31  ;
                this_month  =  12  ;
                this_year   -- ;
            }
            else if (  this_month  ==  3  )
            {
                this_month  =  2  ;

                if ( this_is_a_leap_year() )
                {
                    this_day  =  29  ;
                }
                else
                {
                    this_day  =  28  ;
                }
            }
        }
    }


    public DateDistance get_distance_to(Date  another_date )
    {
        DateDistance  distance_to_return  =  new DateDistance() ;
        Date  start_date, end_date ;
        int   start_day, end_day ;

        if ( this.is_earlier_than( another_date ) )
        {
            start_date  =  this ;
            end_date    =  another_date ;
        }
        else
        {
            start_date  =  another_date ;
            end_date    =  this ;
        }

        //  We will suppose that day 30 is the last day of every
        //  month. This way we minimize calculation errors.

        if ( start_date.is_last_day_of_month() ||
                ( start_date.day()    ==  28  &&
                        start_date.month()  ==  2  )    )
        {
            start_day   =  30  ;
        }
        else
        {
            start_day   =  start_date.day() ;
        }

        if ( end_date.is_last_day_of_month() ||
                ( end_date.day()    ==  28  &&
                        end_date.month()  ==  2  )    )
        {
            end_day   =  30  ;
        }
        else
        {
            end_day   =  end_date.day() ;
        }

        distance_to_return.years  =  end_date.year()  - start_date.year() ;
        distance_to_return.months =  end_date.month() - start_date.month() ;
        distance_to_return.days   =  end_day  -  start_day ;

        if ( distance_to_return.days  <  0 )
        {
            distance_to_return.months  --  ;
            distance_to_return.days  =  distance_to_return.days  +  30 ;
        }

        if ( distance_to_return.months  <  0 )
        {
            distance_to_return.years   --  ;
            distance_to_return.months  =  distance_to_return.months +  12 ;
        }

        return  distance_to_return ;
    }


    public int get_week_number()
    {
        // January 1, 1883 was a Monday with week number 1.
        // January 1, 1990 was a Monday with week number 1.

        Date  date_to_increment  =  new  Date( 1, 1, 1883 ) ;
        int    week_number  =  1 ;
        int    local_index_for_day_of_week  =  0 ; // 0 means Monday

        while ( date_to_increment.is_earlier_than( this ) )
        {
            date_to_increment.increment() ;

            if ( local_index_for_day_of_week  ==  6  ) // 6 means Sunday
            {
                local_index_for_day_of_week  =  0 ; // back to Monday

                if  ( week_number  <   52 )
                {
                    week_number  ++  ;
                }
                else  if  ( week_number  ==  52 )
                {
                    if ( date_to_increment.day()    <=  28  &&
                            date_to_increment.month()  ==  12  )
                    {
                        week_number  =  53 ;
                    }
                    else
                    {
                        week_number  =  1  ;
                    }
                }
                else  // must be week_number  53
                {
                    week_number  =  1 ;
                }
            }
            else
            {
                local_index_for_day_of_week  ++  ;
            }
        }

        return  week_number  ;
    }


    public boolean is_equal_to( Date another_date )
    {
        return ( this_day    ==  another_date.day()    &&
                this_month  ==  another_date.month()  &&
                this_year   ==  another_date.year()  ) ;
    }

    public boolean is_not_equal_to( Date another_date )
    {
        return ( this_day    !=  another_date.day()    ||
                this_month  !=  another_date.month()  ||
                this_year   !=  another_date.year()  ) ;
    }

    public boolean is_earlier_than( Date another_date )
    {
        return ( (   this_year  <   another_date.year()     )  ||
                ( ( this_year  ==  another_date.year() )  &&
                        ( this_month <   another_date.month() )  )  ||
                ( ( this_year  ==  another_date.year() )  &&
                        ( this_month ==  another_date.month() ) &&
                        ( this_day   <   another_date.day() )   )    ) ;
    }

    public boolean is_later_than( Date another_date )
    {
        return ( (   this_year  >   another_date.year()     )  ||
                ( ( this_year  ==  another_date.year() )  &&
                        ( this_month >   another_date.month() )  )  ||
                ( ( this_year  ==  another_date.year() )  &&
                        ( this_month ==  another_date.month() ) &&
                        ( this_day   >   another_date.day() )   )    ) ;
    }

    public String toString()
    {
        String day_as_string    =  String.format( "%02d", this_day ) ;

        String month_as_string  =  String.format( "%02d", this_month ) ;

        String year_as_string   =  ""  +  this_year ;

        String string_to_caller ;

        if ( date_print_format  ==  'A' )
        {
            string_to_caller  =  month_as_string + "/" + day_as_string
                    + "/"  +  year_as_string  ;
        }
        else
        {
            string_to_caller  =  day_as_string + "." + month_as_string
                    + "."  +  year_as_string  ;
        }

        return  string_to_caller ;
    }
}
