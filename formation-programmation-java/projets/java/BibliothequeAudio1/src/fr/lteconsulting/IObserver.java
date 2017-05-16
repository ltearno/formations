package fr.lteconsulting;

public interface IObserver<T>
{
	void onChange( T object );
}
