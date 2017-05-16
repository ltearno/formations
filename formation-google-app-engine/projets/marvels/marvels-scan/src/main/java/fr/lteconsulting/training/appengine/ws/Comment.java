package fr.lteconsulting.training.appengine.ws;

import java.util.Date;

/**
 * Object that is serialized to JSON and passed to the Web-UI layer
 */
public class Comment
{
	public String commentKey;
	public String userAlias;
	public Date date;
	public String content;
	public boolean isMine;
}
