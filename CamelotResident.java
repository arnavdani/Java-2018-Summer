import java.util.Scanner;

/**
 * Creates a resident of Camelot then maintains and prints 
 * his or her information.
 * 
 * @author Susan King
 * @author Arnav Dani
 * @version July 16, 2018
 */
public class CamelotResident
{
    // constant
    private static final String DOMAIN = "@Camelot.com";

    // instance variables
    private String lastName;
    private String firstName;
    private int age;
    private String city;
    private String state;
    private String zip;

    /**
     * Constructor for objects of class CamelotResident.
     * 
     * @param fName   first name of resident
     * @param lName   last name of resident
     * @param years   age of resident
     * @param town    city of resident
     * @param st      state of resident
     * @param zipCode zip code of resident
     */
    public CamelotResident(String fName, String lName, int years, 
    String town, String st, String zipCode)
    {
        firstName = fName;
        lastName = lName;
        age = years;
        city = town;
        state = st;
        zip = zipCode;
    }

    /**
     * Constructor for objects of class CamelotResident.
     */
    public CamelotResident()
    {
        askForName();
        askForAge();
        askForAddress();
    }

    /**
     * Asks user for resident's name and stores the first and last names.
     */
    public void askForName( )
    {
        System.out.println("\n\n\nType in the resident's name in the format" +
            "\n\tLastname, Firstname or enter 99 to quit.");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine( );
        lastName = name.substring(0, name.indexOf(","));
        firstName = name.substring(name.indexOf(",") + 2);
    }

    /**
     * Asks user for resident's age and stores it.
     */
    public void askForAge( )
    {
        System.out.println("\nType in the resident's age");
        Scanner in = new Scanner(System.in);
        age = in.nextInt();

        in.nextLine( );
    }

    /**
     * Asks user for resident's address and stores the information.
     */
    public void askForAddress( )
    {
        System.out.println("\nType in the resident's address in the format" 
            + "\n\tCity, State /n Zip");
        Scanner in = new Scanner(System.in);
        String address = in.nextLine( );
        city = address.substring(0, address.indexOf(","));
        state = address.substring(address.indexOf(",") + 1, 
            address.lastIndexOf(" "));

        zip = address.substring(address.lastIndexOf(" "));
        in.nextLine();
    }

    /**
     * Takes a string of characters and returns only the characters 
     * from the alphabet as well as numbers.
     * 
     * @param  str  non-null string of charaters
     * @return the alphanumberic characters from the parameter str
     */
    public String stripPunctuation(String str)
    {
        String stripped = "";  // empty string
        for (int index = 0 ; index < str.length( ) ; index++)
        {
            String c = str.substring(index, index + 1);
            if ( (0 <= c.compareTo("0") && c.compareTo("9") <= 0) )
                stripped += c;
            else if (0 <= c.compareTo("a") && c.compareTo("z") <= 0)
                stripped += c;
            else if (0 <= c.compareTo("A") && c.compareTo("Z") <= 0)
                stripped += c;    

        }
        return stripped; 
    }

    /**
     * Generates the resident's E-mail account.
     * 
     * @return E-mail account
     */
    public String generateEmailAccount( )
    {
        String email = "";
        email = getFirstName().substring(0, 1) + getLastName();
        email = email.toLowerCase();
        email = stripPunctuation(email);
        email += DOMAIN;
        return email;
    }

    /**
     * Retrieves the first name.
     * 
     * @return the resident's first name
     */
    public String getFirstName( )
    {
        return firstName;
    }

    /**
     * Sets the first name to a new first name.
     * 
     * @param fName the resident's new first name
     */
    public void setFirstName(String fName)
    {
        firstName = fName;
    }

    /**
     * Retrieves the last name.
     * 
     * @return the resident's last name
     */
    public String getLastName( )
    {
        return lastName;
    }

    /**
     * Sets the last name to a new last name.
     * 
     * @param lName the resident's new last name
     */
    public void setLastName(String lName)
    {
        lastName = lName;
    }

    /**
     * Retrieves the city. 
     * 
     * @return the resident's city
     */
    public String getCity( )
    {
        return city;
    }

    /**
     * Sets the city to a new city name.
     * 
     * @param town the resident's new city
     */
    public void setCity(String town)
    {
        city = town;
    }

    /**
     * Retrieves the state. 
     * 
     * @return the resident's state
     */
    public String getState( )
    {
        return state;
    }

    /**
     * Sets the state to a new state name.
     * 
     * @param st the resident's new state
     */
    public void setState(String st)
    {
        state = st;
    }

    /**
     * Retrieves the zip code. 
     * 
     * @return the resident's zip
     */
    public String getZip( )
    {
        return zip;
    }

    /**
     * Sets the zip to a new zip code.
     * 
     * @param zippy the resident's new zip code
     */
    public void setZip(String zippy)
    {
        zip = zippy;
    }

    /**
     * Retrieves the age.
     * 
     * @return the resident's age
     */
    public int getAge( )
    {
        return age;
    }

    /**
     * Sets the age to a new age.
     * 
     * @param oldness the resident's new age
     */
    public void setAge(int oldness)
    {
        age = oldness;
    }

    /**
     * Displays information about the resident.
     */
    public void printInformation( )
    {
        System.out.print ("\n\n\n" + firstName + " " + lastName);
        System.out.println ("\t Age: " + age);
        System.out.println ("\t" + generateEmailAccount( ));
        System.out.println ("\t\t " + city);
        System.out.println ("\t\t\t" + state + " " + zip);
    }

    /**
     * while statement to keep it going
     * 
     * /
    public void 
     */
    public void doWhile()
    {
        while (firstName.equals("stop") == false)
        {
            askForName();
            if (firstName.equals("stop") == true)
            {
                return;
            }
            askForAge();
            askForAddress();
            printInformation();
        }
    }
}
