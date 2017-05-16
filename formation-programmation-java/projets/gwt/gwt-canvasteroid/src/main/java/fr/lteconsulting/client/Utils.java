package fr.lteconsulting.client;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;

public class Utils
{
	@JsFunction
	@FunctionalInterface
	public interface JsCallback
	{
		void execute();
	}

	@JsMethod( namespace = JsPackage.GLOBAL )
	public static native void requestAnimationFrame( JsCallback callback );

	@JsMethod( namespace = "performance", name = "now" )
	public static native double now();
}
