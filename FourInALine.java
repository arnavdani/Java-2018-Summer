import java.awt.Color;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

/**
 * FourInALine is like the game Connect 4 in which 2 players
 * are trying to be the first to have 4 Piece objects of the same 
 * color in a consecutive horizontal, vertical or diagonal pattern.
 * 
 * 
 * @author  Susan King
 * @author  Alexandra Michael modified for Checkstyle
 * @author Arnav Dani
 * @version July 26, 2018
 */
public class FourInALine extends World<Piece>
{
    // ... fill in your instance variables 
    private int rows;
    private int cols;
    private DropGame game;
    private Color currentColor;
    private boolean gameOver;

    /**
     * constructs the object
     * 
     * @param rows  the current row
     * @param cols  the column
     */
    public FourInALine(int rows, int cols)
    {
        // ... document and fill in this constructor
        super(new BoundedGrid<Piece>(rows, cols));
        game = new DropGame(getGrid());
        currentColor = Color.RED;
        flipTurn();
    }

    /**
     * changes whos turn it is w message
     */
    public void flipTurn()
    {
        if (currentColor.equals(Color.RED))
        {
            currentColor = Color.BLACK;
            setMessage("Black's turn");
        }
        else
        {
            currentColor = Color.RED;
            setMessage("Red's turn");
            
        } 
    }

    /**
     * Document me!
     * 
     * @param loc   current location
     * @return      true to keep game continuing
     */
    @Override
    public boolean locationClicked(Location loc)
    {
        // ... fill in this 
        if (gameOver) 
            return false;
        Location dropLoc = game.dropLocationForColumn(loc.getCol());
        if (dropLoc == null) {
            setMessage("Illegal drop location, try again"); 
            return false;
        }

        getGrid().put(dropLoc, new Piece(currentColor));

        if (game.checkAllDirectionsForFour(loc, currentColor))
        {
            setMessage("Congratulations--you won");
            gameOver = true;
        }

        if (!gameOver) 
            flipTurn();
        return true;

    }     

    /**
     * runs the game and creates a fourInALine object
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        FourInALine world = new FourInALine(4, 6);
        world.show();
        
    }
}
