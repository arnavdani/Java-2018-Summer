
/**
 * Creates a specific pet that includes an id number, type, breed and weight.
 * 
 * @author Susan King
 * @author Arnav Dani
 * @version July 17 2018
 */
public class Pet
{
    // instance variables 
    private String type;  // cat, dog, fish, etc.  Stored all lower case
    private String breed; // Siamese, German Shepard, Zebra Fish
    private String id;    // id of the animal
    private double weight;

    /**
     * Constructor for objects of class Pet.
     * 
     * @param t     type of pet     (e.g., "dog")
     * @param b     breed of pet    (e.g., "German Shepard")
     * @param ident identification of the pet
     * @param w     current weight of pet
     */
    public Pet(String t, String b, String ident, double w)
    {
        // initialise instance variables
        /* implement */
        type = t;
        breed = b;
        id = ident;
        weight = w;
    }

    /**
     * Retrieves the type of this pet.
     * 
     * @return     the type of this animal 
     */
    public String getType()
    {
        /* implement */
        return type;
    }
    
    /**
     * Retrieves the breed of this pet.
     * 
     * @return     the breed of this animal 
     */
    public String getBreed()
    {
        /* implement */
        return breed;
    }
    
    /**
     * Retrieves the identification number/character sequence of this pet.
     * 
     * @return     the id of this animal 
     */
    public String getId()
    {
        /* implement */
        return id;
    }
    
    /**
     * Retrieves the weight of this pet.
     * 
     * @return     the weight of this animal 
     */
    public double getWeight()
    {
        /* implement */
        return weight;
    }
    
    /**
     * Sets the new weight of this pet.
     * 
     * @param w     the new weight of animal 
     */
    public void setWeight(double w)
    {
        /* implement */
        weight = w;
    }
    
    /**
     * Returns information about this pet.
     * 
     * @return type, breed, id information and weight
     */
    public String toString()
    {
        return type.toUpperCase() + "\t" + breed + "\t" + id + "\t" + weight;
    }
}
