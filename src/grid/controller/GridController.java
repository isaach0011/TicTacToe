package grid.controller;

import grid.model.TicTacToe;
import grid.view.GridFrame;

public class GridController
{
	private GridFrame gridFrame;
	private TicTacToe ticTacToe;
	
	public GridController()
	{
		gridFrame = new GridFrame(this);
		ticTacToe = new TicTacToe();
	}
	
	public void start()
	{
		
	}
	
	public GridFrame getGridFrame()
	{
		return gridFrame;
	}
	
	public TicTacToe getTicTacToe()
	{
		return ticTacToe;
	}
}
