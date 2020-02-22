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

import java.awt.Color;

/**
 * A Tile has a color and is either "turned up" or "turned down".
 * When used in combination of the GridWorld Case Study it can
 * be used to play such games as "Memory."
 * 
 * @author Susan King  -- Added comments
 * @author Alexandra Michael modified for Checkstyle
 * @author Arnav Dani
 * 
 * @version July 27, 2018
 */
public class Tile
{
    // instance variables
    private Color color;
    private boolean up;

    /**
     * Constructs a Tile object with a color and is
     * faced down.
     * 
     * @param color   the color assigned to the tile which
     *                is shown when the tile is face up.
     */
    public Tile(Color color)
    {
        up = false;
        this.color = color;
    }

    /**
     * Retrieves the tile's color.
     * 
     * @return the color of the tile if the tile is face up; 
     *         otherwise, the color is black
     */
    public Color getColor()
    {
        if (up)
            return color;
        else 
            return Color.BLACK;
    }

    /**
     * Assigns a color value to the tile.
     * 
     * @param color  the new color for the tile
     */
    public void setColor(Color color)
    {
        // ... set the color
        this.color = color;
    }

    /**
     * Retrieves the text that is on the tile.  The objects of
     * this class do not have a text associated with it.
     * 
     * @return a empty String
     */
    public String getText() 
    { 
        return ""; 
    } 

    /**
     * Reverses the state of whether the tile is face up or
     * face down.
     */
    public void flip()
    {
        // ... flip the value of up
        up = !up;
    }
}
