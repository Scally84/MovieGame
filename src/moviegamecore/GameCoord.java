package moviegamecore;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Stephen
 */
public class GameCoord
{
    //attributes
    private boolean initialised;
    private int numOfTurnsPerRound;
    
    //links
    Collection<Player> players;
    Collection<Movie> movies;
    ArrayList<Actor> actors;
    Collection<Round> rounds;
    
    //constructors
    public GameCoord()
    {
        initialised = false;
        numOfTurnsPerRound = 0;
        players = new HashSet<>(); // holds all player object
        movies = new HashSet<>(); // holds all movie objects
        actors = new ArrayList<>(); // holds all actor objects
        rounds = new HashSet<>(); // holds all the round objects
        readActorListDetails("listOfActors.csv"); // method to extract data
    }
    
    //protocols
    
    /**
     * method used to get the state of numOfTurnsPerRound
     * 
     * @return numOfTurnsPerRound
     */
    public int getNumOfTurnsPerRound()
    {
        return numOfTurnsPerRound;
    }
    
    /**
     * method used to get increment numOfTurnsPerRound
     * 
     */
    public void incrementNumOfTurnsPerRound()
    {
        numOfTurnsPerRound =  getNumOfTurnsPerRound() + 1;
    }
    
    /**
     * method used to get the state of initialised
     * 
     * @return initialised
     */
    public boolean getInitialised()
    {
        return initialised;
    }
    
    /**
     * method used to change readyToInit from false to true
     */
    public void setTrue()
    {
        initialised = true;
    }
    
    /**
     * method used to scan CSV file and create an Actor object with name for
     * each actor in file
     * 
     * @param setupFile 
     */
    private void readActorListDetails(String setupFile)
    {
        Scanner fileScanner = null;
        String lineDetails;
        
        try
        {
           fileScanner = new Scanner(new BufferedReader(new FileReader(setupFile)));
           
           while (fileScanner.hasNextLine())
           {
               lineDetails = fileScanner.nextLine(); // adds line details to lineDetails

               Actor anActor = new Actor(lineDetails); // create object w/lineDetails as name
               actors.add(anActor);
           }
        }
        catch (FileNotFoundException anException)
        {
            System.out.println("Error: " + anException);
        }
        finally
        {
            fileScanner.close();
        }       
    }
    
    /**
     * method used to add a new player to the game. If there are 
     * 10 players in the game, then a new player is not created
     * and null is returned.
     * 
     * @param aName
     * @return newPlayer
     */
    public Player addPlayerToGame(String aName)
    {
        Player newPlayer = null;
                
        int numOfPlayers = players.size(); //returns size of the collection 'players'
        
        if (numOfPlayers < 10) //check if there is less than 10 players in the game
        {
            newPlayer = new Player(aName); //construct new player object
            players.add(newPlayer); //new player gets added to the collection of players
            
            return newPlayer;
        }
        
        else
        {
            return newPlayer;
        }
    }
    
    /**
     * method used to add a new movie to the game. If there are already
     * 10 movies in the game, then null is returned. 
     * Otherwise, a new movie is created with title. 
     * The round object that gets constructed within the new movie object 
     * references the new movie object.
     * Both movie and round objects get added to the collection of
     * movies and rounds respectively
     * 
     * @param aTitle
     * @return newMovie
     */
    public Movie addMovieToGame(String aTitle)
    {
        int numOfMovies = movies.size(); //returns size of the collection 'movies'
        
        if (numOfMovies < 10) // check if there is less than 10 movies in the game
        {
            Movie newMovie = new Movie(aTitle); //construct a new movie object
            movies.add(newMovie); //new movie gets added to the collection of 'movies'
            
            Round theRound = newMovie.getRound(); //returns the round object that's created when a new movie object is constructed
            rounds.add(theRound); //the round object gets added to the collection of 'rounds'
            theRound.addMovie(newMovie); //the round object references the new movie object

            return newMovie;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * method used to return the Collection of player objects linked to a GameCoord object
     * 
     * @return Collection players
     */
    public Collection<Player> getPlayers()
    {
        return players;
    }
    
    /**
     * method used to return the Collection of movie objects linked to a GameCoord object
     * 
     * @return Collection movies
     */
    public Collection<Movie> getMovies()
    {
        return movies;
    }
    
    /**
     * method used to return the Collection of actor objects linked to a GameCoord object
     * 
     * @return Collection actors
     */
    public Collection<Actor> getActors()
    {
        return actors;
    }
    
    /**
     * method used to return the Collection of round objects linked to a GameCoord object
     * 
     * @return Collection actors
     */
    public Collection<Round> getRounds()
    {
        return rounds;
    }
    
    /**
     * method used to link an anActor object to aMovie object. If anActor is
     * already linked to aMovie or there are 12 actor objects linked to aMovie,
     * then null is returned
     * 
     * @param anActor
     * @param aMovie
     * @return anActor
     */
    public Actor addActorToMovie(Actor anActor, Movie aMovie)
    {
        Collection<Actor> actorsInMovie = aMovie.getActors(); //returns all the actor objects linked to aMovie
        String name;
        
        if (actorsInMovie.size() < 12) //checking there is less than 12 actors in aMovie
        {   
            boolean equal = false; //set false to signify there is no match yet
      
            for (Actor eachActor : actorsInMovie)
            {
                name = eachActor.getName(); //returns the name of the actor
                if (name.equals(anActor.getName())) //checking if anActor name matches any already linked actors names
                {
                    equal = true; //set to true because there is a match
                    break;
                }
            }
            if (equal) //If true it means there was a match
            {
                return null;
            }
            else
            {
                aMovie.addActor(anActor); //no match found
                return anActor;
            }
        }
        else
        {
            return null; //12 actors are already linked to aMovie
        }
    }
    
    /**
     * method used to return a collection of actor objects linked to aMovie
     * 
     * @param aMovie
     * @return Collection of Actor objects
     */
    public Collection<Actor> showActorsInMovie(Movie aMovie)
    {
        Collection<Actor> actorsInMovie = aMovie.getActors();
        
        if (!actorsInMovie.isEmpty())
        {
            return actorsInMovie;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * method used to initialise the game if there are between two and 
     * ten players, there are ten movies, and each movie object references 
     * at least one actor object in the game
     * 
     * @return initialised
     */
    public boolean initialiseGame()
    {
        int numOfMovies = movies.size(); //returns size of movie collection
        int numOfPlayers = players.size(); //returns size of player collection
        
        boolean atLeastOne = true; //set to true speculating there is at least one actor in each movie
        
        for (Movie eachMovie : movies)
        {
            Collection<Actor> actorsInMovie = eachMovie.getActors(); //returns a collection of actors linked to eachMovie
            if (actorsInMovie.isEmpty())
            {
                atLeastOne = false; //set to false because eachMovie does not reference any actor objects
                break;
            }
        }
         
        if ((atLeastOne) && (numOfMovies == 10) && (numOfPlayers > 1)) //check if the three conditions are true
        {
            this.setTrue(); //changes the state of initialised to true
            return initialised; // returns true
        }
        else
        {
            return initialised; // returns false
        }
    }
    
    /**
     * method used to choose a round and set it up if initialised is true and
     * the number of players in the game matches the number of turns per round 
     * 
     * @return aRound
     */
    public Round playRound()
    {
        Round aRound = null;
        boolean stateOfInitialised = this.initialised; //returns initialised value
        int turns = this.numOfTurnsPerRound; //the number of turns per round
        
        if ((stateOfInitialised) && (turns == 0))
        {
            Round chosenRound = this.chooseRound(); //see method below
            if (chosenRound != null)
            {
                aRound = this.setUpRound(chosenRound); //see method below
                return aRound;
            }
            else
            {
                return aRound;
            }
            
        }
        else
        {
            return aRound;
        }
    }
    
    /**
     * method used to return the round with the lowest round number
     *  
     * @return aRound
     */
    public Round chooseRound()
    {
        Boolean success = false;
        Round aRound = null;
        Integer lowestRoundNumber = null;
        int[] array = new int[rounds.size()]; //create array with the number of positions according to however many rounds are in the game
        int count = 0; //set to zero
        
        for (Round eachRound : rounds) 
        {
            int rn = eachRound.getRoundNumber(); //returns the round number
            array[count] = rn; //round number is placed in the position according to count
            count ++; 
        }
        
        Arrays.sort(array); //sorts the array in numerical order 
        try
        {
            lowestRoundNumber = array[0]; //selects the lowest number
            success = true;
        }
        catch(ArrayIndexOutOfBoundsException exception)
        {
            JOptionPane.showMessageDialog(null, "End of the Game", "",
                JOptionPane.INFORMATION_MESSAGE);
        }
        if (success)
        {
            for (Round eachRound : rounds)
            {
                Integer num = eachRound.getRoundNumber();

                if (num.equals(lowestRoundNumber)) //check if the round's roundNumber attribute matches the lowest number
                {
                    aRound = eachRound; //the appropriate round is selected
                    break;
                }
            }
        }
        
        return aRound; 
    }
    
    /**
     * method used to add the actors that are linked to the movie that is
     * linked to aRound to fifteenActors. However many randomly selected actors
     * are needed to make the total number of actors in fifteenActors 15, are 
     * then selected. An actor can not be picked more than once
     * 
     * @param aRound
     * @return aRound
     */
    public Round setUpRound(Round aRound)
    {
        Movie theLinkedMovie = aRound.getMovie(); //returns the linked movie object
        Collection<Actor> theActorsInMovie = theLinkedMovie.getActors(); //returns the actors linked to the movie object
        
        for (Actor eachActor : theActorsInMovie)
        {
            aRound.addActor(eachActor); //add each of the actors in the movie to aRounds fifteenActor collection
        }
        
        int count = theActorsInMovie.size();
        
        while (count < 15)
        {
            Collections.shuffle((List<?>) actors); //shuffles the list of 300+ actors
            Actor anActor = actors.get(0); //selects actor at index 0
            
            String nameOfRandomActor = anActor.getName(); 
            
            boolean isActorAlreadyInMovie = false;
           
            for (Actor eachActor : aRound.get15Actors())
            {
                String eachActorName = eachActor.getName();
                
                if (eachActorName.equals(nameOfRandomActor))
                {
                    isActorAlreadyInMovie = true;
                    break;
                }
            }
            
            if (!(isActorAlreadyInMovie))
            {
                aRound.addActor(anActor);
                count ++;
            }
        }
        
        return aRound;
    }
    
    /**
     * method used to check the player's answer against the actors in the movie.
     * If player's number of turns is 1 then nothing is changed. Otherwise, if 
     * all player's answers are in the movie then increment points accordingly.
     * If player's answer contains an actor not in the movie then 0 points are
     * rewarded
     * 
     * @param aPlayer
     * @param aRound
     * @param checked
     * @return true or false
     */
    public boolean playerAnswer(Player aPlayer, Round aRound, Collection<String> checked)
    {
        Boolean success = false;
        Movie linkedMovie = null;
        int turns = aPlayer.getNumOfTurns();
        
        if (turns == 0)
        {
            try
            {
                linkedMovie = aRound.getMovie();
                success = true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Thank you for playing", "",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
            if (success)
            {
                Collection<Actor> actorsInMovie = linkedMovie.getActors();
            
                Collection<String> actorsInMovieName = new HashSet<>();
                for (Actor eachActor : actorsInMovie)
                {
                    String name = eachActor.getName();
                    actorsInMovieName.add(name);
                }

                if (actorsInMovieName.containsAll(checked))
                {
                    aPlayer.incrementPoints(checked.size());
                    aPlayer.incrementNumOfTurns();
                    this.incrementNumOfTurnsPerRound();
                    aPlayer.setPreviousScore(checked.size());
                    return true;
                }
                else
                {
                    aPlayer.incrementNumOfTurns();
                    this.incrementNumOfTurnsPerRound();
                    aPlayer.setPreviousScore(0);
                    return true;
                } 
            }
            else
            {
                return false;
            }
            
        }
        else
        {
            return false;
        }
    }
    
    public Integer[] updateTable(Round aRound)
    {
        this.numOfTurnsPerRound = 0;
        
        for (Player eachPlayer : this.getPlayers())
        {
            eachPlayer.resetNumOfTurns();
        }
        
        this.getRounds().remove(aRound);
        
        Integer[] array =  new Integer[players.size()];
        Integer count = 0;
        
        
        for (Player eachPlayer : this.getPlayers())
        {
            array[count] = eachPlayer.getPoints();
            count ++;
        }
        
        Arrays.sort(array, Collections.reverseOrder());
        return array;
    }

}
