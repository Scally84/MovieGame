package moviegamecore;

import org.junit.*;
import java.util.*;

/**
 *
 * @author Stephen
 */
public class PlayRoundTest
{
    GameCoord game;
    Movie movie1;
    Movie movie2;
    Movie movie3;
    Movie movie4;
    Movie movie5;
    Movie movie6;
    Movie movie7;
    Movie movie8;
    Movie movie9;
    Movie movie10;
    Actor actor1;
    
    @Before
    public void setup()
    {
        game = new GameCoord();
        
        movie1 = game.addMovieToGame("test");
        movie2 = game.addMovieToGame("title");
        movie3 = game.addMovieToGame("title");
        movie4 = game.addMovieToGame("title");
        movie5 = game.addMovieToGame("title");
        movie6 = game.addMovieToGame("title");
        movie7 = game.addMovieToGame("title");
        movie8 = game.addMovieToGame("title");
        movie9 = game.addMovieToGame("title");
        movie10 = game.addMovieToGame("title");
        
        actor1 = new Actor("Al Pacino");
        
        game.addActorToMovie(actor1, movie1);
        game.addActorToMovie(actor1, movie2);
        game.addActorToMovie(actor1, movie3);
        game.addActorToMovie(actor1, movie4);
        game.addActorToMovie(actor1, movie5);
        game.addActorToMovie(actor1, movie6);
        game.addActorToMovie(actor1, movie7);
        game.addActorToMovie(actor1, movie8);
        game.addActorToMovie(actor1, movie9);
        game.addActorToMovie(actor1, movie10);
      
        game.addPlayerToGame("name");
        game.addPlayerToGame("name");
    }
    
    /**
     * test for initialised: true
     * numOfTurnsPerRound : 2
     */
    @Test
    public void test1playRound()
    {
         //set up the fixture
        game.setTrue();
        game.incrementNumOfTurnsPerRound();
        game.incrementNumOfTurnsPerRound();
 
        //send the test message
        Round aRound = game.playRound();

        //get the result
        assert aRound != null;
 
    }
    
    /**
     * test for initialised: false
     * numOfTurnsPerRound : 2
     */
    @Test
    public void test2playRound()
    {
         //set up the fixture
        game.incrementNumOfTurnsPerRound();
        game.incrementNumOfTurnsPerRound();
 
        //send the test message
        Round aRound = game.playRound();

        //get the result
        assert aRound == null;
    }
    
     /**
     * test for initialised: true
     * numOfTurnsPerRound : 1
     */
    @Test
    public void test3playRound()
    {
         //set up the fixture
        game.setTrue();
        game.incrementNumOfTurnsPerRound();
 
        //send the test message
        Round aRound = game.playRound();

        //get the result
        assert aRound != null;
    }
    
    /**
     * test that chosen random actors are not already in movie
     */
    @Test
    public void test4playRound()
    {
         //set up the fixture
        game.setTrue();
        game.incrementNumOfTurnsPerRound();
        game.incrementNumOfTurnsPerRound();
        
        //send the test message
        Round aRound = game.playRound();

        int count = 0;
        Movie theMovie = aRound.getMovie();
        Collection<Actor> actorsInMovie = theMovie.getActors();
        Collection<Actor> fifteenActors = aRound.get15Actors();
        
        for (Actor eachActor : actorsInMovie)
        {
            if (fifteenActors.contains(eachActor))
            {
                count ++;
            }
        }

        //get the result
        assert (count == actorsInMovie.size());
    }
    
    @Test
    public void test5playRound()
    {
         //set up the fixture
        game.setTrue();
 
        //send the test message
        Round aRound = game.playRound();
        int roundNo = aRound.getRoundNumber();
        String movieTitle = aRound.getMovie().getTitle();
        Collection<Actor> actors = aRound.get15Actors();
        int size = aRound.get15Actors().size();
        
        System.out.println(roundNo + movieTitle + size);
        
        for (Actor eachActor : actors)
        {
            System.out.print(eachActor.getName() + "\n");
        }
        

        //get the result
        assert aRound != null;
    }
    
}
