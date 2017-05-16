package fr.lteconsulting.training.struts.model;

import java.util.List;

public class CountriesResponse
{
	public static class RestResponse
	{
		List<String> messages;

		@Override public String toString()
		{
			return "RestResponse{" +
					"messages=" + messages +
					'}';
		}
	}

	public RestResponse RestResponse;

	@Override public String toString()
	{
		return "CountriesResponse{" +
				"RestResponse=" + RestResponse +
				'}';
	}
}
