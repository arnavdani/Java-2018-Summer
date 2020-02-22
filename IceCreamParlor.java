
/**
 * Provides a tester for IceCream
 * 
 * @author Susan King 
 * @author Alexandra Michael modified for Checkstyle
 * @author Arnav Dani
 * 
 * @version July 26, 2018
 */
public class IceCreamParlor
{
    // instance variables
    private String parlorName;
    private IceCream[] inventory;

    /**
     * Constructor for objects of class IceCreamParlor
     */
    public IceCreamParlor()
    {
        parlorName = "BICP -- Best Ice Cream Parlor";
        inventory = new IceCream[ ] {
            new IceCream(),
            new IceCream("Skinny Butter Pecan", 
                new String[] {"milk","cream","sugar","pecans","butter" }, 
                120),
            new IceCream("Chocolate Double Fudge", 
                new String[] {"chocolate","milk", "vanilla extract", 
                    "condensed milk", "salt", "heavy cream"},
                180),
            new IceCream("Strawberry Cheesecake", 
                new String[]{"milk","cream","sugar","cheesecake","strawberries" },
                150),
            new IceCream("Moose Track", 
                new String[]{"milk","cream","sugar","peanut butter",
                    "chocolate fudge","caramel"}, 
                175),
            new IceCream("Lite Mint Chocolate Chip", 
                new String[] {"milk","cream","sugar","chocolate chips" ,"mint"}, 
                120),
            new IceCream("Java Chip", 
                new String[] {"milk","cream","sugar","chocolate chips" ,"coffee base"}, 
                150),
            new IceCream("Madagascar Vanilla Bean", 
                new String[] {"milk","cream","sugar","vanilla bean"}, 
                160),
            new IceCream("Chocolate Chip Cookie Dough", 
                new String[] {"milk","cream","sugar","chocolate chips" ,"cookie dough"}, 
                170)
        };

    }

    /**
     * Retrieve the parlor's name.
     * 
     * @return     the name of the parlor
     */
    public String getParlorName( )
    {

        return parlorName;
    }

    /**
     * Change the parlor's name.  New owners!
     * 
     * @param nam    the new name of the parlor
     */
    public void setParlorName(String nam)
    {
        parlorName = nam;
    }

    /**
     * Retrieve the inventory of ice cream in the parlor's
     * pantry.
     * 
     * @return     the parlor's inventory of ice cream
     */
    public IceCream[] getInventory( )
    {
        return inventory;
    }

    /**
     * Change the list of ice cream in the inventory.
     * 
     * @param invent    the new list of ice cream
     */
    public void setInventory(IceCream[] invent)
    {
        inventory = invent;
    }

    /**
     * Get average calories of the ice cream in the parlor.
     * 
     * @return average calories
     */
    public double getAverageCaloriesInInventory()
    {
        if (inventory.length == 0)
        {
            return 0;
        }
        double sum = 0.0;
        for (int i = 0; i < inventory.length; i++)
        {
            sum += inventory[i].getCalories();
        }
        return sum/inventory.length;
    }

    /**
     * Get minimum calories of the ice cream inventory in the parlor.
     * 
     * @return minimum calories
     */
    public int getMinimumCaloriesInInventory()
    {
        if (inventory.length == 0)
        {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < inventory.length; i++)
        {
            if (inventory[i].getCalories() <  min)
            {
                min = inventory[i].getCalories();
            }
        }
        return min;
    }

    /**
     * Count ice creams with the least calories.
     * 
     * @precondition  at least one ice cream in the inventory
     * 
     * @return the number of ice creams with the fewest calories
     */
    public int countLowCalIceCreams()
    {
        int minCal= getMinimumCaloriesInInventory();
        int counter = 0;
        for (int i= 0; i < inventory.length; i++)
        {
            if (inventory[i].getCalories() <= minCal)
            {
                counter++;
            }
        }

        return counter;
    }

    /**
     * Retrieve ice creams with the least calories.
     * 
     * @precondition  at least one ice cream in the inventory
     * 
     * @return the array of ice cream objects with the fewest
     *         number of calories
     */
    public IceCream[] locateLowCalIceCreams()
    {
        IceCream[] lowCalVarieties = new IceCream[countLowCalIceCreams()];
        int index = 0;
        int minCal= getMinimumCaloriesInInventory();
        while (index < countLowCalIceCreams())
        {
            for (int i = 0; i < inventory.length; i++)
            {
                if (inventory[i].getCalories() <= minCal)
                {
                    lowCalVarieties[index] = inventory[i];
                    index++; 
                }
            }
        }

        return lowCalVarieties;
    }

    /**
     * Retrieve ice creams with a specific ingredient listed as
     * part of the ingredient's string.  This
     * method includes both counting and retrieving into one
     * method for demonstration purpose.
     * 
     * @param ingredient    the word being searched for in the 
     *                      ice creams' ingredients
     * @return a list of ice creams that are made with "ingredient"
     */
    public IceCream[] locateIngredientMatches(String ingredient)
    {
        int counter = 0;
        int index = 0;
        int ind = 0;
        for (int i = 0; i < inventory.length; i++)
        {
            if (inventory[i].getIngredients()[index].equalsIgnoreCase(ingredient))
            {
                counter++;
                index++;
            }
        }

        IceCream[] match = new IceCream[counter];
        while (ind < match.length)
        {
            for (int i = 0; i < inventory.length; i++)
            {
                if (inventory[i].getIngredients()[ind].equalsIgnoreCase(ingredient))
                {
                    match[ind] = inventory[i];
                    ind++;
                }
            }
        }


        return match;
    }

    /**
     * Retrieve ice creams with a specific word within its name.
     *  
     * @param word  the word that is being search in the ice creams' names
     * @return the array of ice cream objects with the fewest
     *         number of calories
     */
    public IceCream[] locateNameAndWordMatches(String word)
    {
        int counter = 0;
        for (int i = 0; i < inventory.length; i++)
        {
            if (inventory[i].isNameFound(word))
            {
                counter++;
            }
        }

        IceCream[] match = new IceCream[counter];
        int index = 0;
        while (index < counter)
        {
            for (int i = 0; i < inventory.length; i++)
            {
                if (inventory[i].isNameFound(word))
                {
                    match[index] = inventory[i];
                    index++;
                }
            }
        }
        return match;
    }

    /**
     * Print out the inventory for the parlor.
     */
    public void printInventory( )
    {
        System.out.println(parlorName + "'s Inventory");
        printIceCreams(inventory);
    }

    /**
     * Print out an array of ice creams.
     * 
     * @param creams  the list of all the ice creams to be printed
     */
    public void printIceCreams(IceCream[] creams)
    {
        for (int i = 0 ; i < creams.length ; i++)
        {
            creams[i].printIceCream();
        }
    }

    /**
     * This method tests many of the programming
     * skills associated with arrays of objects that 
     * are not String objects.
     * 
     * @param args  the information being input from the command line
     */
    public static void main(String[] args)
    {
        IceCreamParlor iScream = new IceCreamParlor();
        iScream.printInventory();

        System.out.println("\n\nAVERAGE CALORIES = " +
            iScream.getAverageCaloriesInInventory());

        System.out.println("\n\nMATCH FOR CHOCOLATE IN NAME");
        iScream.printIceCreams(iScream.locateNameAndWordMatches("chocolate"));

        System.out.println("\n\nMATCH FOR SUGAR");
        iScream.printIceCreams(iScream.locateIngredientMatches("sugar"));

        System.out.println("\n\nMATCH FOR CHOCOLATE IN INGREDIENTS");
        iScream.printIceCreams(iScream.locateIngredientMatches("chocolate"));

        System.out.println("\n\nLOW CALORIES");
        iScream.printIceCreams(iScream.locateLowCalIceCreams());        

    }
}
