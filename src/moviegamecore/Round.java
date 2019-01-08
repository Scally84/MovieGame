package moviegamecore;

import java.util.*;

/**
 *
 * @author Stephen
 */
public class Round
{
    //attributes
    private static int number = 0;
    private int counter = 0;
    private int roundNumber;
  
    //links
    private Movie movie;
    private Collection<Actor> fifteenActors;
    
    //constructors
    Round()
    {
        fifteenActors = new HashSet<>();
        number++;
        roundNumber = number;
    }
    
    //protocols
    
    /**
     * method used to return the roundNumber attribute
     * 
     * @return roundNumber
     */
    public int getRoundNumber()
    {
        return roundNumber;
    }
    
    /**
     * method used to return the linked movie
     * 
     * @return Movie
     */
    public Movie getMovie()
    {
        return movie;
    }
    
    /**
     * method used to return the collection of linked actors
     * 
     * @return Collection of actors
     */
    public Collection<Actor> get15Actors()
    {
        return fifteenActors;
    }
    
    /**
     * method used to add movie object to movie
     * 
     * @param aMovie
     */
    public void addMovie(Movie aMovie)
    {
        movie = aMovie;
    }
    
    /**
     * method used to add an actor object to fifteenActors
     * 
     * @param anActor
     */
    public void addActor(Actor anActor)
    {
        fifteenActors.add(anActor);
    }
    
}
