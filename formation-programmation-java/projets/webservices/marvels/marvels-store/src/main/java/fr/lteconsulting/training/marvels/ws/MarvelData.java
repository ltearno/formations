package fr.lteconsulting.training.marvels.ws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelData
{
	public int offset;
	public int total;
	public List<MarvelCharacter> results;
}
