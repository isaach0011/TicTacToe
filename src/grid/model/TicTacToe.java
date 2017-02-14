package grid.model;

import grid.controller.*;
import grid.view.GridPanel;

public class TicTacToe
{
	private GridController baseController;
	private GridPanel basePanel;
	private String value;
	
	public TicTacToe()
	{
		value = "";
	}
	
	public String toString()
	{
		return value + "is in this spot.";
	}
}
