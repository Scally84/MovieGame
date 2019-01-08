package moviegamecore;

/**
 *
 * @author Stephen
 */
public class Actor
{
    //attributes
    private String name;
    
    //links
    
    //constructors
    Actor(String aName)
    {
        name = aName;
    }
    
    //protocols
    public String getName()
    {
        return name;
    }
    
    @Override
    public String toString()
    {
        return name; 
               
    }
}
