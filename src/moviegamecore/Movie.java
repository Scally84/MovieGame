package moviegamecore;

import java.util.*;

/**
 *
 * @author Stephen
 */
public class Movie
{
    //attributes
    private String title;
    //private int numOfActors;
    
    //links
    private Round round; 
    private Collection<Actor> actors;
    
    //constructors
    Movie(String aTitle)
    {
        title = aTitle;
        //numOfActors = 0;
        actors = new HashSet<>();
        round = new Round();
    }
    
    //protocols
    
    /**
     * method used to get the title of the movie object
     * 
     * @return title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * method used to get all the actor objects linked to the movie object
     * 
     * @return Collection actors
     */
    public Collection getActors()
    {
        return actors;
    }
    
    /**
     * method used to return the round object linked to movie
     * 
     * @return round
     */
    public Round getRound()
    {
        return round;
    }
    
    /**
     * method used to add anActor to the collection of actor objects linked
     * to the movie object
     * 
     * @param anActor 
     */
    public void addActor(Actor anActor)
    {
        actors.add(anActor);
    }
    
    @Override
    public String toString()
    {
        return title; 
               
    }

}
