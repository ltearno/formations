package fr.lteconsulting.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.lteconsulting.model.Question;
import fr.lteconsulting.model.Quizz;
import fr.lteconsulting.model.Reponse;
import fr.lteconsulting.model.ReponseUtilisateur;
import fr.lteconsulting.model.Utilisateur;

@Stateless
public class BigDao
{
	@PersistenceContext
	private EntityManager em;

	public Quizz findQuizzByName( String quizzName )
	{
		Query q = em.createQuery( "from Quizz q where q.nom=:name" );
		q.setParameter( "name", quizzName );
		try
		{
			return (Quizz) q.getSingleResult();
		}
		catch( NoResultException e )
		{
			return null;
		}
	}

	public void addQuizz( Quizz quizz )
	{
		em.persist( quizz );
	}

	public Quizz findQuizzById( Integer id )
	{
		return em.find( Quizz.class, id );
	}

	public void addQuestion( Question question )
	{
		em.merge( question );
	}

	@SuppressWarnings( "unchecked" )
	public List<Quizz> getQuizzs()
	{
		return em.createQuery( "from Quizz" ).getResultList();
	}

	@SuppressWarnings( "unchecked" )
	public List<Utilisateur> getUtilisateurs()
	{
		return em.createQuery( "from Utilisateur" ).getResultList();
	}

	public List<Question> findQuestionsByQuizzId( Integer quizzId )
	{
		Quizz quizz = findQuizzById( quizzId );
		for( Question q : quizz.getQuestions() )
			q.getReponses();
		return quizz.getQuestions();
	}

	public Reponse findReponseById( int reponseId )
	{
		return em.find( Reponse.class, reponseId );
	}

	public void addReponseUtilisateur( ReponseUtilisateur reponse )
	{
		em.persist( reponse );
	}

	public List<Question> findNextQuestionsForUser( Integer quizzId, Utilisateur utilisateur )
	{
		List<Question> questions = findQuestionsByQuizzId( quizzId );
		List<Question> result = new ArrayList<>();
		for( Question question : questions )
		{
			Query q = em.createQuery( "from ReponseUtilisateur ru left join ru.reponse r where r.question=:question and ru.utilisateur=:utilisateur" );
			q.setParameter( "question", question );
			q.setParameter( "utilisateur", utilisateur );

			if( q.getResultList().isEmpty() )
				result.add( question );
		}

		return result;
	}

	public String processResultats( int quizzId, int utilisateurId )
	{
		StringBuilder sb = new StringBuilder();

		Quizz quizz = findQuizzById( quizzId );
		if( quizz == null )
			return sb.toString();

		Utilisateur utilisateur = findUtilisateurById( utilisateurId );
		if( utilisateur == null )
			return sb.toString();

		Map<Integer, ReponseUtilisateur> reponsesUtilisateur = findReponseUtilisateurByQuizzAndUtilisateur( quizz, utilisateur );

		int nbAllGood = 0;
		int nbOneBad = 0;
		int nbOneGood = 0;
		int nbBad = 0;

		for( Question question : quizz.getQuestions() )
		{
			// sb.append( "####" + question.getTexte() + "\n" );

			// toutes les réponses bonnes
			// au moins une réponse bonne
			// aucune réponse bonne
			boolean fAllGood = true;
			boolean fOneGood = false;
			boolean fOneBad = false;
			for( Reponse reponse : question.getReponses() )
			{
				boolean ru = reponsesUtilisateur.get( reponse.getId() ) != null;

				// sb.append( "[" + reponse.isValide() + "][" + ru + "]" + reponse.getTexte() + "\n\n" );

				fAllGood &= ru == reponse.isValide();
				fOneGood |= reponse.isValide() && ru; // une bonne coche
				fOneBad |= (!reponse.isValide()) && ru; // une mauvaise coche

				// sb.append( String.format( "all good : %b, one good: %b\n", fAllGood, fOneGood ) );
			}

			if( fAllGood )
				nbAllGood++;
			else if( fOneBad )
				nbOneBad++;
			else if( fOneGood )
				nbOneGood++;
			else
				nbBad++;
		}

		// sb.append( "#### Résultats " + utilisateur.getNomComplet() + "\n" );
		float score = nbAllGood + nbOneGood / 2.f;
		// sb.append( String.format( "SCORE: %.2f = bien: %d, oneBad:%d, oneGood: %d, mauvais: %d, total : %d\n", score, nbAllGood, nbOneBad, nbOneGood, nbBad,
		// quizz.getQuestions().size() ) );

		sb.append( String.format( "%s;%s;%.2f;%d;%d;%d;%d;%d\n", utilisateur.getNomComplet(), utilisateur.getEmail(), score, nbAllGood, nbOneBad, nbOneGood, nbBad, quizz.getQuestions().size() ) );

		return sb.toString();
	}

	public Utilisateur findUtilisateurById( int utilisateurId )
	{
		Utilisateur utilisateur = em.find( Utilisateur.class, utilisateurId );
		return utilisateur;
	}

	private Map<Integer, ReponseUtilisateur> findReponseUtilisateurByQuizzAndUtilisateur( Quizz quizz, Utilisateur utilisateur )
	{
		Map<Integer, ReponseUtilisateur> reponsesUtilisateur = new HashMap<>();

		Query q = em.createQuery( "from ReponseUtilisateur ru where ru.reponse.question.quizz=:quizz and ru.utilisateur=:utilisateur" );
		q.setParameter( "quizz", quizz );
		q.setParameter( "utilisateur", utilisateur );

		@SuppressWarnings( "unchecked" )
		List<ReponseUtilisateur> ru = q.getResultList();

		ru.stream().forEach( ( r ) -> {
			reponsesUtilisateur.put( r.getReponse().getId(), r );
		} );

		return reponsesUtilisateur;
	}

	public void updateReponses()
	{
		Utilisateur u = findUtilisateurById( 1 );
		Quizz quizz = findQuizzById( 8 );

		Query q = em.createQuery( "from ReponseUtilisateur ru where ru.reponse.question.quizz=:quizz and ru.utilisateur=:utilisateur" );
		q.setParameter( "quizz", quizz );
		q.setParameter( "utilisateur", u );
		List<ReponseUtilisateur> rus = q.getResultList();

		rus.stream().forEach( ( ru ) -> ru.getReponse().setValide( true ) );
	}
}
