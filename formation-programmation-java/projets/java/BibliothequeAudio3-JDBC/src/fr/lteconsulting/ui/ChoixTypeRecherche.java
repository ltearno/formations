package fr.lteconsulting.ui;

public class ChoixTypeRecherche
{
	private TypeRecherche typeRecherche = TypeRecherche.PAR_NOM;

	public void setTypeRecherche( TypeRecherche typeRecherche )
	{
		this.typeRecherche = typeRecherche;
	}

	public TypeRecherche getTypeRecherche()
	{
		return typeRecherche;
	}
}