package moviegamecore;

import org.junit.*;
import java.util.*;

/**
 *
 * @author Stephen
 */

public class PlayerAnswerTest
{
    GameCoord game;
    Player player1;
    Movie movie1;
    Actor actor1;
    Actor actor2;
    Round round1;
    
    @Before
    public void setup()
    {
        game = new GameCoord();
        
        player1 = game.addPlayerToGame("name");
        movie1 = game.addMovieToGame("title");
        actor1 = new Actor("Al Pacino");
        game.addActorToMovie(actor1, movie1);
        round1 = new Round();
        round1.addMovie(movie1);
        
    }
    
    /**
     * test for player's number of turns is 0
     */
    @Test
    public void test1playerAnswer()
    {
        //set up the fixture
        List<String> checked = new ArrayList<>();
        checked.add("Al Pacino");
        
        //send the test message
        Boolean result = game.playerAnswer(player1, round1, checked);

        //get the result
        assert result;
    }
    
    /**
     * test for two names. Player's points is incremented by two
     */
    @Test
    public void test2playerAnswer()
    {
        //set up the fixture
        actor2 = new Actor("Woody Allen");
        game.addActorToMovie(actor2, movie1);
        List<String> checked = new ArrayList<>();
        checked.add("Al Pacino");
        checked.add("Woody Allen");
        
        //send the test message
        assert player1.getPoints() == 0;
        Boolean result = game.playerAnswer(player1, round1, checked);

        //get the result
        assert result;
        assert player1.getPoints() == 2;
    }
    
    /**
     * test for one name not in list. Player's points not incremented
     */
    @Test
    public void test3playerAnswer()
    {
        //set up the fixture
        actor2 = new Actor("Woody Allen");
        game.addActorToMovie(actor2, movie1);
        List<String> checked = new ArrayList<>();
        checked.add("Al Pacino");
        checked.add("Woody Allen");
        checked.add("not in list");
        
        //send the test message
        assert player1.getPoints() == 0;
        Boolean result = game.playerAnswer(player1, round1, checked);

        //get the result
        assert result;
        assert player1.getPoints() == 0;
    }
    
    /**
     * test for one name. Player's points is incremented by one
     */
    @Test
    public void test4playerAnswer()
    {
        //set up the fixture
        actor2 = new Actor("Woody Allen");
        game.addActorToMovie(actor2, movie1);
        List<String> checked = new ArrayList<>();
        checked.add("Al Pacino");
        
        //send the test message
        assert player1.getPoints() == 0;
        Boolean result = game.playerAnswer(player1, round1, checked);

        //get the result
        assert result;
        assert player1.getPoints() == 1;
    }
    
    /**
     * test for player's number of turns is 1
     */
    @Test
    public void test5playerAnswer()
    {
        //set up the fixture
        actor2 = new Actor("Woody Allen");
        game.addActorToMovie(actor2, movie1);
        List<String> checked = new ArrayList<>();
        checked.add("Al Pacino");
        checked.add("Woody Allen");
        game.playerAnswer(player1, round1, checked);
        
        //send the test message
        Boolean result = game.playerAnswer(player1, round1, checked);

        //get the result
        assert !result;
        assert player1.getNumOfTurns() == 1;
    }
    
}
