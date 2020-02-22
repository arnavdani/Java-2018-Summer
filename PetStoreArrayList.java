import java.util.ArrayList;
/**
 * Generate a pet store with a fixed length pet inventory.
 * Gather information about the inventory.
 * 
 * @author Susan King
 * @Arnav Dani
 * @version July 17 2018
 */
public class PetStoreArrayList
{
    // instance variables
    private ArrayList<Pet> petInventory = new ArrayList<>();

    /**
     * Constructor for objects of class PetStore.
     * 
     * @param animals   inventory of animals for the pet store
     */
    public PetStoreArrayList(Pet[] animals)
    {
        // initialize instance variables
        /* implement */
        for (int i = 0; i < animals.length; i++)
        {
            petInventory.add(animals[i]);
        }
    }

    /**
     * Returns the size of the pet inventory.
     * 
     * @return     the number of animals in the inventory
     */
    public int sizeOfInventory()
    {
        /* implement */
        return petInventory.size();
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
        for (int i = 0; i < petInventory.size(); i++)
        {
            if (breed.equalsIgnoreCase(petInventory.get(i).getBreed()))
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
        for (int i = 0; i < petInventory.size(); i++)
        {
            if (type.equalsIgnoreCase(petInventory.get(i).getType()))
            {
                System.out.println(petInventory.get(i));
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
        for (int i = 0; i < petInventory.size(); i++)
        {
            if (type.equalsIgnoreCase(petInventory.get(i).getType()))
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
        for (int i = 0; i < petInventory.size(); i++)
        {
            if (type.equalsIgnoreCase(petInventory.get(i).getType()))
            {
                totalWeight+= petInventory.get(i).getWeight();
            }
        }
        return totalWeight;
    }

    /**
     * Returns the average weight of a particular type of animal in the pet inventory.  
     * If the type is not found in the inventory, returns 0.0.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     * @return      the average weight
     */
    public double calcAverageWeightOfInventoryByType(String type)
    {
        /* implement */
        double totalWeight = 0;
        double counter = 0;
        for (int i = 0; i < petInventory.size(); i++)
        {
            if (type.equalsIgnoreCase(petInventory.get(i).getType()))
            {
                totalWeight+= petInventory.get(i).getWeight();
                counter++;
            }
        }
        if (counter != 0)
        {
            return totalWeight/counter;
        }
        return 0;
    }
}
