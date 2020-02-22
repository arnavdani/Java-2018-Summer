/**
 * Tests the CamelotResident class:
 *      Creates a few instances and 
 *      Calls CamelotResident methods:
 *           printInformation() 
 *           getName()  
 * 
 * @author Susan King
 * @author Marina Peregrino 
 * @author Arnav Dani
 * @version July 16 201
 */
public class CamelotResidentTester
{
    /**
     * Tests the Camelot Resident class.
     * 
     * @param args   information from the command line
     */
    public static void main (String [ ] args)
    {
        CamelotResident arthur = new CamelotResident("Arthur", "Pendragon", 
                25, "Camelot", "Britain", "12345" );
        CamelotResident lancelot = new CamelotResident("Lancelot", "du Lac", 
                22, "Camelot", "Britain", "12345" );
        CamelotResident guinevere = new CamelotResident
        ("Guinevere", "Pendragon", 
                24, "Camelot", "Britain", "12345" );

        CamelotResident arnav = new CamelotResident
        ("Arnav", "Dani", 14, "Cupertino", "California", "95014");
        CamelotResident merlin = new CamelotResident
        ("Merlin", "Blahname", 21, "Camelot", "Britain", "12345");
        CamelotResident flexible = new CamelotResident
        ("Merlin", "Blahname", 21, "Camelot", "Britain", "12345");

        /* Print out the 4 residents */

        /* Create an array of five Camelot residents */
        CamelotResident [] names = new CamelotResident[5];

        /* Add the 4 residents to an array and print their information */
        names[0] = arthur;
        names[1] = lancelot;
        names[2] = guinevere;
        names[3] = merlin;
        names[4] = arnav;
        for (int i = 0; i < names.length; i++)
        {

            if (names[i] != null)
                names[i].printInformation();

        }
        /* Caution!  Beware of null pointers. */ 
        flexible.doWhile();

    }
}