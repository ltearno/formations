package fr.lteconsulting.training.appengine.marvels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDataContainer
{
	public int offset;
	public int total;
	public List<Character> results;
}
