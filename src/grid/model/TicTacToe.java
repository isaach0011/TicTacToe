package grid.model;

import grid.controller.*;
import grid.view.GridPanel;

public class TicTacToe
{
	private GridController baseController;
	private GridPanel basePanel;
	
	public TicTacToe(GridController baseController)
	{
		this.baseController = baseController;
		baseController.getGrid();
	}
	
	public void assignSpace(String xOrO, int row, int col)
	{
		baseController.getGrid()[row][col] = xOrO;
	}
	
	public String toString()
	{
		return "TicTacToe is fun.";
	}
}
