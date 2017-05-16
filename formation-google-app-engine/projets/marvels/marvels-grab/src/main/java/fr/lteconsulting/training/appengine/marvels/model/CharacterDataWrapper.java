package fr.lteconsulting.training.appengine.marvels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class CharacterDataWrapper
{
	public int code;
	public String status;
	public CharacterDataContainer data;
}
