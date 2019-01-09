package moviegamecore;

import org.junit.*;

/**
 *
 * @author Stephen
 */

public class InitialiseGameTest
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
        movie1 = game.addMovieToGame("title");
        movie2 = game.addMovieToGame("title");
        movie3 = game.addMovieToGame("title");
        movie4 = game.addMovieToGame("title");
        movie5 = game.addMovieToGame("title");
        movie6 = game.addMovieToGame("title");
        movie7 = game.addMovieToGame("title");
        movie8 = game.addMovieToGame("title");
        movie9 = game.addMovieToGame("title");
        
        actor1 = new Actor("a");
  
        game.addActorToMovie(actor1, movie1);
        game.addActorToMovie(actor1, movie2);
        game.addActorToMovie(actor1, movie3);
        game.addActorToMovie(actor1, movie4);
        game.addActorToMovie(actor1, movie5);
        game.addActorToMovie(actor1, movie6);
        game.addActorToMovie(actor1, movie7);
        game.addActorToMovie(actor1, movie8);
        game.addActorToMovie(actor1, movie9);
      
        game.addPlayerToGame("name");
        
    }
    
    /**
     * test for 10 movies, 2 players and each movie references 1 actor
     * in the game
     */
    @Test
    public void test1initialiseGame()
    {
        //set up the fixture
        movie10 = game.addMovieToGame("title");
        game.addActorToMovie(actor1, movie10);
        game.addPlayerToGame("name");
     
        //send the test message
        game.initialiseGame();

        //get the result
        assert game.getInitialised() == true;
    }
    
    /**
     * test for 9 movie objects in the game
     */
    @Test
    public void test2initialiseGame()
    {
        //set up the fixture
        game.addPlayerToGame("name");
     
        //send the test message
        game.initialiseGame();

        //get the result
        assert game.getInitialised() == false;
    }
    
    /**
     * test for 1 player object in the game
     */
    @Test
    public void test3initialiseGame()
    {
        //set up the fixture
        movie10 = game.addMovieToGame("title");
        game.addActorToMovie(actor1, movie10);
        
        //send the test message
        game.initialiseGame();

        //get the result
        assert game.getInitialised() == false;
    }
    
    /**
     * test for a movie object referencing no actor objects
     */
    @Test
    public void test4initialiseGame()
    {
        //set up the fixture
        movie10 = game.addMovieToGame("title");
        game.addPlayerToGame("name");
     
        //send the test message
        game.initialiseGame();

        //get the result
        assert game.getInitialised() == false;
    }
}
