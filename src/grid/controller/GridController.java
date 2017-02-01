package grid.controller;

import javax.swing.JOptionPane;
import grid.model.TicTacToe;
import grid.view.GridFrame;

public class GridController
{
	private GridFrame gridFrame;
	private TicTacToe ticTacToe;
	private TicTacToe [][] grid;
	private String value;
	
	public GridController()
	{
		gridFrame = new GridFrame(this);
		ticTacToe = new TicTacToe();
		grid = new TicTacToe[5][5];
		value = "";
		fillGrid();
	}
	
	private void fillGrid()
	{
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				grid[row][col] = new TicTacToe();
			}
		}
	}
	
	public void assignSpace(String xOrO, int row, int col)
	{
		value = xOrO;
		grid[row][col] = value;
	}
	
	public void start()
	{
		JOptionPane.showMessageDialog(gridFrame, "Look at me");
	}
	
	public TicTacToe[][] getGrid()
	{
		return grid;
	}

	
	public GridFrame getFrame()
	{
		return gridFrame;
	}
	
	public TicTacToe getTicTacToe()
	{
		return ticTacToe;
	}	
}
