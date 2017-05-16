package fr.lteconsulting.training.marvels.ws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class MarvelCharacter
{
	public int id;
	public String name;
}
