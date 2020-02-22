
/**
 * Generate a pet store with a fixed length pet inventory.
 * Gather information about the inventory.
 * 
 * @author Susan King
 * @author Arnav Dani
 * @version July 17 2018
 */
public class PetStore
{
    // instance variables
    private Pet[] petInventory;

    /**
     * Constructor for objects of class PetStore.
     * 
     * @param animals   inventory of animals for the pet store
     */
    public PetStore(Pet[]animals)
    {
        // initialize instance variables
        /* implement */
        petInventory = animals;
    }

    /**
     * Returns the size of the pet inventory.
     * 
     * @return     the number of animals in the inventory
     */
    public int sizeOfInventory()
    {
        /* implement */
        return petInventory.length;
    }

    /**
     * Returns whether a particular breed is found in the inventory
     * The comparison is done all in lower case letters.
     * 
     * @param   breed  the breed being searched for
     * @return  true if the breed is in the inventory; otherwise,
     *          false 
     */
    public boolean isBreedInInventory(String breed)
    {
        /* implement */
        for (int i = 0; i < petInventory.length; i++)
        {
            if (breed.equalsIgnoreCase(petInventory[i].getBreed()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints a list of animal in the pet inventory of a particular type.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     */
    public void printInventoryOfAType(String type)
    {
        /* implement */
        for (int i = 0; i < petInventory.length; i++)
        {
            if (type.equalsIgnoreCase(petInventory[i].getType()))
            {
                System.out.println(petInventory[i]);
            }
        }

    }

    /**
     * Returns the number of occurrences of a type in the pet inventory.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     * @return     the number of occurrences of a type in the inventory
     */
    public int countInventoryByType(String type)
    {
        /* implement */
        int counter = 0;
        for (int i = 0; i < petInventory.length; i++)
        {
            if (type.equalsIgnoreCase(petInventory[i].getType()))
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns the weight of all the animals of a certain type
     * 
     * @return     the weight of all the animals of a certain type
     */
    private double calcTotalWeightOfInventoryByType(String type)
    {
        /* implement */
        double totalWeight = 0;
        for (int i = 0; i < petInventory.length; i++)
        {
            if (type.equalsIgnoreCase(petInventory[i].getType()))
            {
                totalWeight += petInventory[i].getWeight();
            }
        }
        return totalWeight;
    }

    /**
     * Returns the average weight of a particular type 
     * of animal in the pet inventory.  
     * If the type is not found in the inventory, returns 0.0.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     * @return      the average weight
     */
    public double calcAverageWeightOfInventoryByType(String type)
    {
        /* implement */
        if (countInventoryByType("type") != 0)
        {
            return calcTotalWeightOfInventoryByType("type") / countInventoryByType("type");
        }
        return 0;
    }
}
