package fr.lteconsulting.training.marvels.ws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class MarvelCharactersResult
{
	public int code;
	public String status;
	public MarvelData data;
}
