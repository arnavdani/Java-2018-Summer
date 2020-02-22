import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Supports games in which a checker-like piece is dropped into
 * one of the slots at a top, and the piece dropped as low as
 * it can.  It cannot move to a location in which another piece
 * already occupies.  It is used by games like FourNeighbors and
 * FourInALine.
 * 
 * @author  Susan King
 * @author  Alexandra Michael modified for Checkstyle
 * @author Arnav Dani
 * @version July 26, 2018
 */
public class DropGame
{
    private Grid<Piece> theGrid;

    /**
     * Creates a grid in which to play the game.
     * 
     * @param gr    the grid in which to play this game
     */
    public DropGame(Grid<Piece> gr)
    {
        theGrid = gr;
    }

    /** 
     * Retrieves the location a Piece object can drop to
     * at the bottom of a column.
     * 
     * Precondition: 0 <= column < theGrid.getNumCols()
     * 
     * @param column the column position the user is trying to drop
     *               a Piece object
     * 
     * @return       null if no empty locations exist in the column;
     *               otherwise, the empty location with the
     *               largest row index within the specified column;
     */
    public Location dropLocationForColumn(int column)
    {
        for (int r = theGrid.getNumRows() - 1; r >= 0; r--)
        {
            Location nextLoc = new Location(r, column);
            if (theGrid.get(nextLoc) == null)
            {
                return nextLoc;
            }
        }
        return null;
    }

    /**
     * Tests if new piece has four or more surrounding
     * neighbors of the same color.
     *
     * Precondition:     0 <= column < theGrid.getNumCols()
     * 
     * @param column      the column position the user is trying to drop
     *                    a Piece object
     * @param pieceColor  the color being matched
     * 
     * @return <code>true</code> if dropping a Piece object of the given
     *                   color into the specified column matches color with 
     *                   four neighbors;
     *         <code>false</code> otherwise
     */
    public boolean countNeighbors(int column, Color pieceColor)
    {
        Location loc = dropLocationForColumn(column);
        if (loc == null)
        {
            return false;
        }

        // ArrayList<Piece> neighbors = ...;
        int colorCount = 0;
        // loop to determine if neighbors have the same color
        return (colorCount >= 4);
    }

    /**
     * Tests whether there are four or more of the same color
     * in a row based upon a location.
     * 
     * Precondition:     0 <= column < theGrid.getNumCols()
     * 
     * @param loc       the location based upon which to check for four
     * @param pieceColor    the color of the piece being dropped
     * 
     * @return <code>true</code> if dropping a Piece object of the 
     *                   given color into the specified column 
     *                   matches color with four in a line;
     *         <code>false</code> otherwise
     */
    public boolean checkAllDirectionsForFour(Location loc, Color pieceColor)
    {
        /* ... write code to count how many Piece objects are in a row:
         * ... horizontally, vertically, or diagonal (both directions).
         * 
         * You will want to write support method(s) to do this, so plan
         * this well.  This structure might help you.  It includes useful
         * debug statements.

        // Check the vertical, horizontal, and both diagonals.  
        // Pick the maximum.
        int backDiagonal = ...
        int diagonal     = ...
        int vertical     = ...
        int horizontal   = ...
        int count        = Math.max (Math.max(backDiagonal,diagonal),
        Math.max(vertical,horizontal) );
        System.out.println("\nPiece Color "    + pieceColor   + 
        "\n\tVertical   = " + vertical     +
        "\n\tHorizontal = " + horizontal   +
        "\n\tBack Diagon= " + backDiagonal +
        "\n\tDiagonal   = " + diagonal);             
         */
        for (int dir = 0; dir < 180; dir += 45)
        {
            if (fourInRow(dir, pieceColor, loc))
            {
                return true;
            }
        }

        return false;
        

        // remove this when you write this method
    }

    /**
     * check if there are 4 in a pattern
     * @param dir where it is facing
     * @param c color
     * @param myLoc location to work off of
     * @return if all four are conseq in that direction
     * 
     */
    public boolean fourInRow(int dir, Color c, Location myLoc)
    {
        int counter = 1;
        Location next = myLoc.getAdjacentLocation(dir);
        while (theGrid.isValid(next) && theGrid.get(next) != null && theGrid.get(next).getColor().equals(c))
        {
            counter++;
            next = next.getAdjacentLocation(dir);
        }
        next = myLoc.getAdjacentLocation(dir + Location.HALF_CIRCLE);
        while (theGrid.isValid(next) && theGrid.get(next) != null && theGrid.get(next).getColor().equals(c))
        {
            counter++;
            next = next.getAdjacentLocation(dir + Location.HALF_CIRCLE);
        }
        System.out.println(counter);
        return counter >= 4;
    }
        
}
