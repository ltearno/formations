package com.sopra.rest.directions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class Leg
{
	public Duration duration;
}
