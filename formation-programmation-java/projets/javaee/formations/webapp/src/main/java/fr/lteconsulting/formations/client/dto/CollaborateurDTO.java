package fr.lteconsulting.formations.client.dto;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( namespace = JsPackage.GLOBAL, name = "Object", isNative = true )
public class CollaborateurDTO
{
	public Integer id;
	public String nom;
	public String prenom;
	public String codeAgence;
}
