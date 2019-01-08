package moviegamecore;

import org.junit.*;
import java.util.*;

/**
 *
 * @author Stephen
 */
public class AddActorToMovieTest
{
    GameCoord game;
    Movie aMovie;
    Actor anActor;
    Collection<Actor> theActors;
    
    @Before
    public void setup()
    {
        game = new GameCoord();
        aMovie = game.addMovieToGame("aTitle");
        anActor = new Actor("a");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("b");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("c");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("d");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("e");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("f");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("g");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("h");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("i");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("j");
        game.addActorToMovie(anActor, aMovie);
        anActor = new Actor("k");
        game.addActorToMovie(anActor, aMovie);
        theActors = aMovie.getActors();
    }
    /**
     * test for a movie referencing 12 actor objects
     */
    @Test
    public void test1addActorToMovie()
    {
        //set up the fixtures
        
        //send the test message
        assert theActors.size() == 11;
        anActor = new Actor("l");
        game.addActorToMovie(anActor, aMovie);
        
        //check the result
        assert theActors.size() == 12;    
    }
    
    /**
     * test for a movie referencing 13 actor objects
     */
    @Test
    public void test2addActorToMovie()
    {
        //set up the fixtures
        anActor = new Actor("l");
        game.addActorToMovie(anActor, aMovie);
        
        //send the test message
        assert theActors.size() == 12;
        anActor = new Actor("m");
        game.addActorToMovie(anActor, aMovie);
        
        //check the result
        assert theActors.size() == 12;
    }
    
    /**
     * Test for a movie referencing two actors with the same name
     */
    @Test
    public void test3addActorToMovie()
    {
        //set up the fixtures
        
        //send the test message
        assert theActors.size() == 11;
        anActor = new Actor("k");
        game.addActorToMovie(anActor, aMovie);
        
        //check the result
        assert theActors.size() == 11;
    }
    
    /**
     * Test for a movie not referencing two actors with the same name
     */
    @Test
    public void test4addActorToMovie()
    {
        //set up the fixtures
    
        //send the test message
        assert theActors.size() == 11;
        anActor = new Actor("m");
        game.addActorToMovie(anActor, aMovie);
        
        //check the result
        assert theActors.size() == 12;
    }
}
