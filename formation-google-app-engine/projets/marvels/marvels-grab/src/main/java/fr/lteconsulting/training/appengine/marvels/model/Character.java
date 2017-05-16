package fr.lteconsulting.training.appengine.marvels.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties( ignoreUnknown = true )
public class Character
{
	public int id;
	public String name;
	public String description;
	public Image thumbnail;
	public List<Url> urls;
}