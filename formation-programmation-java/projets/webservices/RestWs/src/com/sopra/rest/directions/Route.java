package com.sopra.rest.directions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class Route
{
	public Leg legs[];
}
