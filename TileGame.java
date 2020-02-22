/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * 
 * Students:  make modifications to the code where you see ...
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;
/**
 * A memory game using tiles in the GridWorld Case Study.
 * 
 * @author Susan King -- Changed  structure a bit and added comments.
 * @author Alexandra Michael modified for Checkstyle
 * @author Arnav Dani
 * @version July 27, 2018
 */
public class TileGame extends World<Tile>
{
    // instance variables
    private Tile firstTile;     // first of a pair of tiles to be clicked on
    private Tile secondTile;    // second of a pair of tiles to be clicked on
    private boolean first;      // true if the waiting for the first tile to be clicked on

    /**
     * Creates objects of the TileGame by initializing the tiles and
     * placing them in pairs on the grid at random locations.  In addition,
     * the user is instructed to click on the first tile.  The message is
     * placed at the top banner of the grid.
     */
    public TileGame()
    {
        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, 
                           Color.PINK, Color.ORANGE, Color.GRAY, Color.MAGENTA, 
                           Color.YELLOW };

        for (int i = 0 ; i < colors.length ; i++)
        {
            Color color = colors[i];
            add(getRandomEmptyLocation(), new Tile(color));
            add(getRandomEmptyLocation(), new Tile(color));
        }
        setMessage("Click on the first tile");
        first = true;
        firstTile = null;
        secondTile = null;
    }

    /**
     * As a user clicks on tiles, the game progresses.  Specifically,
     * if the click is on the first of a pair of tiles, the first tile is turned over.
     * If the click is on the second of a pair of tiles and the colors match, the
     * tiles are left face up.
     * 
     * @param loc   the location of the tile that was clicked on
     * 
     * @return true
     */
    public boolean locationClicked(Location loc)
    {
        Grid<Tile> gr = getGrid();
        Tile t = gr.get(loc);
        if (t != null) 
        { 
            // turns over the tile clicked on
            t.flip();
            if (first)
            {
                /*
                 *  Note: the first tile of a pair has been clicked on.
                 *  Test whether the firstTile is not set to a tile.
                 */
                if (firstTile != null) 
                {
                    // turn down the previous pair of tiles 
                    // ... flip both the firstTile and secondTile
                    firstTile.flip();
                    secondTile.flip();
                }

                // set the first tile of a pair of tiles
                // ... set the firstTile to t
                firstTile = t;

                // prepare for the second tile of the pair of tiles
                setMessage("Click on the second tile");
                // ... set first to false
                first = false;
            }
            else
            {            
                /*
                 *  Note: the second tile of a pair has been clicked on.
                 *  Test whether the firstTile's Color is equal to t's color.
                 */
                if (firstTile.getColor().equals(t.getColor()))
                {               
                    /*
                     * The tiles' color match so set the tiles to null
                     * so the tiles are not turned down and are left facing up.
                     */
                    firstTile = null;
                    secondTile = null;
                    // ...set both firstTile and secondTile to null
                }
                else
                {
                    // set the second tile of a pair of tiles
                    // ... set secondTile to t
                    secondTile = t;   
                }
                // prepare for the first tile of a pair of tiles
                // ... set message to "Click on the first tile"
                // ... set first to true
                setMessage("Click on the first tile");
                
                first = true;
            }                  
        }
        return true;      
    }

    /**
     * Initializes and starts the memory game.
     * 
     * @param args arguments from the command line
     */
    public static void main(String[] args)
    {
        TileGame john = new TileGame();
        john.show();
    }
}