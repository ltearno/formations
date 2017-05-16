package fr.lteconsulting.formations.client.dto;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( namespace = JsPackage.GLOBAL, name = "Object", isNative = true )
public class FormationDTO
{
	public Integer id;
	public String intitule;
	public String lieu;
	public int debutAttendu;
	public int debutReel;
	public float nbJours;
	public String nomPrestataire;
}
