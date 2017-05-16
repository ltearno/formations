package fr.lteconsulting.formations;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;
import org.junit.Test;

import fr.lteconsulting.formations.model.Collaborateur;

public class CSVReaderTest
{
	@Test
	public void test()
	{
		try
		{
			CSVParser parser = CSVParser.parse( new File( "sopra-modified.csv" ),
					StandardCharsets.UTF_8,
					CSVFormat.RFC4180
							.withDelimiter( ';' )
							.withQuote( '"' )
							.withFirstRecordAsHeader() );

			for( CSVRecord record : parser )
			{
				Collaborateur collaborateur = new Collaborateur();
				collaborateur.setCodeAgence( record.get( "Agence" ) );
				collaborateur.setNom( record.get( "Nom du collaborateur" ) );
				collaborateur.setPrenom( record.get( "Prénom du collaborateur" ) );

				record.get( "Nb jours" );
				record.get( "Date attendue" );
				record.get( "Date réelle" );
				record.get( "Intitulé de la formation" );
				record.get( "Lieu de formation" );
				record.get( "Organisme ext / Formateur interne" );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
			Assert.fail();
		}
	}
}
