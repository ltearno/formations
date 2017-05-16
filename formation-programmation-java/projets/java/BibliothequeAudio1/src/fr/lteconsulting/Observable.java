package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> implements IObservable<T>
{
	private T observedObject;
	private List<Registration> registrations = new ArrayList<>();

	private class Registration implements IObservableRegistration
	{
		private IObserver<T> observer;

		Registration( IObserver<T> observer )
		{
			this.observer = observer;
		}

		@Override
		public void unregister()
		{
			registrations.remove( this );
		}
	}

	public Observable( T observedObject )
	{
		this.observedObject = observedObject;
	}

	@Override
	public IObservableRegistration registerObserver( IObserver<T> observer )
	{
		Registration registration = new Registration( observer );

		registrations.add( registration );

		return registration;
	}

	public void notifyObservers()
	{
		for( Registration registration : registrations )
		{
			try
			{
				registration.observer.onChange( observedObject );
			}
			catch( Exception e )
			{
				System.out.println( "UNE EXCEPTION EST SURVENUE PENDANT LA NOTIFICATION AUX OBSERVERS" );
				e.printStackTrace();
			}
		}
	}
}
