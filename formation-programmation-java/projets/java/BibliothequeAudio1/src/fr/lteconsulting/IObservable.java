package fr.lteconsulting;

public interface IObservable<T>
{
	IObservableRegistration registerObserver( IObserver<T> observer );
}
