package grid.view;

import java.awt.Dimension;
import javax.swing.JFrame;
import grid.controller.GridController;
import grid.view.GridPanel;

public class GridFrame extends JFrame
{
	private GridController baseController;
	private GridPanel gridPanel;
	
	public GridFrame(GridController baseController)
	{
		super();
		this.baseController = baseController;
		gridPanel = new GridPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(gridPanel);
		this.setTitle("Tic Tac Toe");
		this.setSize(new Dimension(900,600));
		this.setResizable(false);
		this.setVisible(true);	
	}
}
