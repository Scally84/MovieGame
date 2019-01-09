package moviegamecore;

import org.junit.*;
import java.util.*;

/**
 *
 * @author Stephen
 */

public class AddMovieTest
{
    GameCoord game;
    Collection<Movie> theMovies;
    
    @Before
    public void setup()
    {
        game = new GameCoord();
        theMovies = game.getMovies();
        
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
        game.addMovieToGame("aName");
    }
    
    /**
     * test that a GameCoord object game references
     * a tenth movie object
     */
    @Test
    public void test1addMovieToGame()
    {
        //set up the fixtures

        //send the test message
        game.addMovieToGame("Movie10");
        
        //check the result
        assert theMovies.size() == 10 : "aMovie should have been created and added to movies";
    }
    
    /**
     * test that a GameCoord object game does not reference
     * an eleventh movie object
     */
    @Test
    public void test2addMovieToGame()
    {
        //set up the fixtures
        game.addMovieToGame("Movie10");
        
        //send the test message
        game.addMovieToGame("Movie11");
        
        //check the result
        assert theMovies.size() == 10 : "Movie11 should not have been created and added to movies";
    }
    
    /**
     * test that movies references movie10
     */
    @Test
    public void test3addMovieToGame()
    {
        //set up the fixtures

        //send the test message
        Movie movie10 = game.addMovieToGame("Movie10");
        
        //check the result
        assert theMovies.contains(movie10) == true;
    }
    
    /**
     * test that rounds references round10
     */
    @Test
    public void test4addMovieToGame()
    {
        //set up the fixtures
        Collection<Round> theRounds = game.getRounds();
        
        //send the test message
        assert theRounds.size() == 9;
        game.addMovieToGame("Movie10");
        
        //check the result
        assert theRounds.size() == 10;
    }
   
}
