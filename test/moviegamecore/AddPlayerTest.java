package moviegamecore;

import org.junit.*;
import java.util.*;

/**
 *
 * @author Stephen
 */

public class AddPlayerTest
{
    GameCoord game;
    Collection<Player> thePlayers;
    
    @Before
    public void setup()
    {
        game = new GameCoord();
        thePlayers = game.getPlayers();
        
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
        game.addPlayerToGame("aName");
    }
    /**
     * test that a GameCord object game references
     * a tenth player object
     */
    @Test
    public void test1addPlayerToGame()
    {
        //set up the fixtures
        
        //send the test message
        game.addPlayerToGame("player10");
        
        //check the result
        assert thePlayers.size() == 10 : "aPlayer should have been created and added to players";
    }
    
    /**
     * test that a GameCoord object game does not reference
     * an eleventh player object
     */
    @Test
    public void test2addPlayerToGame()
    {
        //set up the fixtures
        game.addPlayerToGame("player10");
 
        //send the test message
        game.addPlayerToGame("player11");
        
        //check the result
        assert thePlayers.size() == 10 : "aPlayer should not have been created and added to players";
    }
}