package fr.lteconsulting.server;

import java.util.Random;

public class Mots
{
	public static String mot()
	{
		return mots[new Random().nextInt( mots.length )];
	}

	public static String nom()
	{
		String mot = mot();
		return mot.substring( 0, 1 ).toUpperCase() + mot.substring( 1 ).toLowerCase();
	}

	public static String phrase()
	{
		int nbMots = 3 + new Random().nextInt( 3 );
		return phrase( nbMots );
	}

	public static String phrase( int nbMots )
	{
		String phrase = "";
		
		for( int i = 0; i < nbMots; i++ )
		{
			if( i > 0 )
				phrase += " ";

			phrase += mot();
		}

		phrase = phrase.substring( 0, 1 ).toUpperCase() + phrase.substring( 1 );

		return phrase;
	}

	private static final String[] mots = {
			"mythe",
			"Apollon",
			"Titan",
			"centaure",
			"grec",
			"mythologique",
			"Éole",
			"Styx",
			"Téthys",
			"Héra",
			"Vénus",
			"Éos",
			"Osiris",
			"Thésée",
			"religion",
			"Pâris",
			"indo-européen",
			"Héraclès",
			"Gaïa",
			"Agamemnon",
			"Cronos",
			"thétis",
			"troyen",
			"Deucalion",
			"Olympe",
			"Dieu",
			"nymphe",
			"Héphaïstos",
			"Saturne",
			"Hermès",
			"Éros",
			"Poséidon",
			"Léda",
			"Aphrodite",
			"perséphone",
			"Ymir",
			"symbolisme",
			"personnification",
			"Rhéa",
			"Neptune",
			"Loki",
			"Hercule",
			"Arès",
			"Diane",
			"Dioné",
			"Vulcain",
			"Ulysse",
			"Cécrops",
			"enfer",
			"Odin",
			"pégase",
			"Zeus",
			"Néréide",
			"divinité",
			"scandinave",
			"Protée",
			"grecque",
			"Artémis",
			"Ovide",
			"Isis",
			"Tartare",
			"Pluton",
			"Ouranos",
			"Nérée",
			"Ménélas",
			"Énée",
			"Argonaute",
			"Déméter",
			"Dionysos",
			"Yggdrasil",
			"Edda",
			"Charon",
			"Hadès",
			"Troie",
			"satyre",
			"Jupiter",
			"mino",
			"déesse",
			"sphinx",
			"Persée",
			"folklore",
			"Athéna",
			"géant",
			"Junon",
			"Prométhée",
			"Ptah",
			"Panthéon",
			"Orphée",
			"héros",
			"Hélio",
			"Achille",
			"créature",
			"elfe",
			"Tithon",
			"dryade",
			"chimère" };
}
