package io.model;

import java.util.ArrayList;

/**
 * The Game superclass for the IO project.
 * @author Cody H
 * @version 1.0 13/12/2013 Added data members, constructors and default play method.
 */
public class Game
{

	/**
	 * Resizeable data structure for rules of the game.
	 */
	private ArrayList<String> gameRules;
	/**
	 * The ranking of the game's fun level.  Should be between 1-10.
	 */
	private int funRanking;
	/**
	 * The title of the game.
	 */
	private String gameTitle;
	
	/**
	 * Default Game constructor.  Initializes to zero or empty values.
	 */
	public Game()
	{
		gameRules = new ArrayList<String>();
		funRanking = 0;
		gameTitle = "";
	}
	
	/**
	 * Game Constructor with specific information.
	 * @param gameRules The ArrayList<String> for this Game's rules.
	 * @param funRanking The int value of the Game's fun ranking.
	 * @param gameTitle The String value for the Game's title.
	 */
	public Game(ArrayList<String> gameRules, int funRanking, String gameTitle)
	{
		this.gameRules = gameRules;
		this.funRanking = funRanking;
		this.gameTitle = gameTitle;
	}
	
	public ArrayList<String> getGameRules()
	{
		return gameRules;
	}

	
	public int getFunRanking()
	{
		return funRanking;
	}

	
	public String getGameTitle()
	{
		return gameTitle;
	}

	
	public void setGameRules(ArrayList<String> gameRules)
	{
		this.gameRules = gameRules;
	}

	
	public void setFunRanking(int funRanking)
	{
		this.funRanking = funRanking;
	}

	
	public void setGameTitle(String gameTitle)
	{
		this.gameTitle = gameTitle;
	}

	/**
	 * Default play method for all games.  Must be overridden in subclasses.
	 */
	public void play()
	{
		
	}
}
