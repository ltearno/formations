package fr.lteconsulting.soapserver;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class CurrencyConverter
{
	private final double EXCHANGE_RATE_USD_EUR = 0.89f;

	@WebMethod
	public double usdToEur( double usd )
	{
		return usd * EXCHANGE_RATE_USD_EUR;
	}
}