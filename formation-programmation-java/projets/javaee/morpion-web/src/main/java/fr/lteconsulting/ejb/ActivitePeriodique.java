package fr.lteconsulting.ejb;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import fr.lteconsulting.dao.PartieDao;

@Singleton
public class ActivitePeriodique
{
	@EJB
	PartieDao partieDao;

	@Schedule( second = "0", minute = "*", hour = "*", persistent = false )
	public void faireUnTruc()
	{
		System.out.println( "timer: j'efface les vieilles parties" );

		partieDao.removeVieilleParties();
	}
}
