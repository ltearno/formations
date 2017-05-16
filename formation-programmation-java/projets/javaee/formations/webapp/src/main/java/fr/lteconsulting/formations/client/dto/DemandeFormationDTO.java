package fr.lteconsulting.formations.client.dto;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( namespace = JsPackage.GLOBAL, name = "Object", isNative = true )
public class DemandeFormationDTO
{
	public Integer id;
	public CollaborateurDTO collaborateur;
	public FormationDTO formation;
}
