package fr.lteconsulting.formations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class DateParsingTest
{
	@Test
	public void test()
	{
		// 01-janv.
		SimpleDateFormat format = new SimpleDateFormat( "dd M", Locale.FRENCH );

		// Date today = new Date();
		// System.out.println( format.format( today ) );

		try
		{
			Calendar.getInstance().set( 2016, 0, 1 );
			Date date = Calendar.getInstance().getTime();

			System.out.println( DateParser.parse( "01-janv." ) );

			// Assert.assertSame( date, format.parse( "01 janv" ) );
		}
		catch( Exception e )
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}
