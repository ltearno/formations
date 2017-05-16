package fr.lteconsulting.formations;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateParser
{
	private final static Map<String, Integer> months = new HashMap<>();

	static
	{
		months.put( "janv.", 1 );
		months.put( "févr.", 2 );
		months.put( "mars", 3 );
		months.put( "avr.", 4 );
		months.put( "mai", 5 );
		months.put( "juin", 6 );
		months.put( "juil.", 7 );
		months.put( "août", 8 );
		months.put( "sept.", 9 );
		months.put( "oct.", 10 );
		months.put( "nov.", 11 );
		months.put( "déc.", 12 );
	}

	public static Date parse( String text )
	{
		try
		{
			String dayNumber = text.substring( 0, 2 );
			String monthName = text.substring( 3 );

			Calendar calendar = new GregorianCalendar();
			calendar.setTimeInMillis( 0 ); // raz de tous les champs
			calendar.set( Calendar.YEAR, Calendar.getInstance().get( Calendar.YEAR ) );
			calendar.set( Calendar.HOUR, 0 );
			calendar.set( Calendar.MINUTE, 0 );
			calendar.set( Calendar.SECOND, 0 );
			calendar.set( Calendar.DAY_OF_MONTH, Integer.parseInt( dayNumber ) );
			calendar.set( Calendar.MONTH, months.get( monthName ) - 1 );

			return calendar.getTime();
		}
		catch( Exception e )
		{
			return null;
		}
	}
}
