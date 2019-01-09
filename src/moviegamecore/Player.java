package moviegamecore;

/**
 *
 * @author Stephen
 */

public class Player
{
    //attributes
    private String name;
    private int points;
    private int numOfTurns;
    private int previousScore;
    
    //links
    
    //constructors
    Player(String aName)
    {
        name = aName;
        points = 0;
        numOfTurns = 0;
        previousScore = 0;
    }
    
    //protocols
    
    /**
     * method used to get player's name
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * method used to get player's number of turns
     * 
     * @return number of turns
     */
    public int getNumOfTurns()
    {
        return numOfTurns;
    }
    
    /**
     * method used to reset player's number of turns to 0
     * 
     */
    public void resetNumOfTurns()
    {
        numOfTurns = 0;
    }
    
    /**
     * method used to get player's points
     * 
     * @return points
     */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * method used to increment player's points by argument
     * 
     * @param aNumber
     */
    public void incrementPoints(int aNumber)
    {
        points = getPoints() + aNumber;
    }
    
    /**
     * method used to increment player's number of turns
     * 
     */
    public void incrementNumOfTurns()
    {
        numOfTurns = getNumOfTurns() + 1;
    }
    
    public int getPreviousScore()
    {
        return previousScore;
    }
    
    public void setPreviousScore(int aNewScore)
    {
        previousScore = aNewScore;
    }
    
    @Override
    public String toString()
    {
        return name; 
               
    }
}
