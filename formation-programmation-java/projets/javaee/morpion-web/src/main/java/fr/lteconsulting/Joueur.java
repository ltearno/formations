package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Joueur
{
	@Expose
	@Id
	@GeneratedValue( strategy = GenerationType.TABLE )
	private Integer id;

	@Expose private String pseudo;
	@Expose private String login;
	@Expose private String password;
	@Expose private char character;

	@ManyToMany( mappedBy = "joueurs" )
	private List<Partie> parties = new ArrayList<>();

	public Joueur( String pseudo, String login, String password, char character )
	{
		this.pseudo = pseudo;
		this.login = login;
		this.password = password;
		this.character = character;
	}

	public Joueur()
	{
	}

	public List<Partie> getParties()
	{
		return parties;
	}

	public Integer getId()
	{
		return id;
	}

	public String getPseudo()
	{
		return pseudo;
	}

	public String getLogin()
	{
		return login;
	}

	public String getPassword()
	{
		return password;
	}

	public char getCharacter()
	{
		return character;
	}
}
