package calendar;

class  SpanishCalendar  extends  EnglishCalendar
{
    public SpanishCalendar( int given_month, int given_year )
    {
        String[]  spanish_names_of_months  =


                { "Enero", "Febrero", "Marzo", "Abril",
                        "Mayo", "Junio", "Julio", "Agosto",
                        "Septiembre", "Octubre", "Noviembre", "Diciembre" } ;

        String   spanish_week_description  =

                "Semana  Lun  Mar  Mie  Jue  Vie  Sab  Dom" ;

        names_of_months   =  spanish_names_of_months ;
        week_description  =  spanish_week_description ;

        this_month  =  given_month ;
        this_year   =  given_year  ;
    }
}