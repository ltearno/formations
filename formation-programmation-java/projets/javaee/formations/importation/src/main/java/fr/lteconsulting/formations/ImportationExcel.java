package fr.lteconsulting.formations;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import fr.lteconsulting.formations.model.Collaborateur;
import fr.lteconsulting.formations.model.DemandeFormation;
import fr.lteconsulting.formations.model.Formation;

public class ImportationExcel
{
	public static void main( String[] args )
	{
		TransactionManager tx = new TransactionManager( "formations" );
		DataAccess dao = new DataAccess( tx );

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
				collaborateur = dao.maybeAddCollaborateur( collaborateur );

				Formation formation = new Formation();
				formation.setIntitule( record.get( "Intitulé de la formation" ) );
				formation.setNbJours( parseBigDecimal( record.get( "Nb jours" ) ) );
				formation.setLieu( record.get( "Lieu de formation" ) );
				formation.setNomPrestataire( record.get( "Organisme ext / Formateur interne" ) );
				formation.setDebutAttendu( DateParser.parse( record.get( "Date attendue" ) ) );
				formation.setDebutReel( DateParser.parse( record.get( "Date réelle" ) ) );
				formation = dao.maybeAddFormation( formation );

				DemandeFormation demandeFormation = new DemandeFormation();
				demandeFormation.setCollaborateur( collaborateur );
				demandeFormation.setFormation( formation );
				demandeFormation = dao.maybeAddDemandeFormation( demandeFormation );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		tx.close();
	}

	private static BigDecimal parseBigDecimal( String text )
	{
		try
		{
			return text != null ? new BigDecimal( text.replace( ',', '.' ) ) : null;
		}
		catch( Exception e )
		{
			return null;
		}
	}
}
