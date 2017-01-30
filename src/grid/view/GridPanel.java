package grid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import grid.controller.GridController;
import grid.view.GridFrame;

public class GridPanel extends JPanel
{
	private GridController baseController;
	private GridFrame gridFrame;
	private SpringLayout baseLayout;
	private JLabel title;
	private JLabel input;
	private JLabel row;
	private JLabel column;
	private JLabel turn;
	private JLabel playerTurn;
	private JTextField tttInput;
	private JTextField rowInput;
	private JTextField columnInput;
	private JButton submit;
	
	public GridPanel(GridController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.title = new JLabel("Tic Tac Toe");
		this.input = new JLabel("Input X or O here");
		this.row = new JLabel("Row");
		this.column = new JLabel("Column");
		this.turn = new JLabel("Turn: Player ");
		this.playerTurn = new JLabel("1");
		this.tttInput = new JTextField(25);
		this.rowInput = new JTextField(5);
		this.columnInput = new JTextField(5);
		this.submit = new JButton("Submit");		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.LIGHT_GRAY);
		
		title.setFont(new Font("Impact", Font.PLAIN, 50));
		
		this.add(title);
		this.add(input);
		this.add(row);
		this.add(column);
		this.add(turn);
		this.add(playerTurn);
		this.add(tttInput);
		this.add(rowInput);
		this.add(columnInput);
		this.add(submit);
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, submit, 396, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submit, 27, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, input, -6, SpringLayout.NORTH, tttInput);
		baseLayout.putConstraint(SpringLayout.NORTH, tttInput, 51, SpringLayout.SOUTH, title);
		baseLayout.putConstraint(SpringLayout.WEST, tttInput, 27, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, input, 105, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, title, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, title, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, columnInput, 6, SpringLayout.SOUTH, row);
		baseLayout.putConstraint(SpringLayout.WEST, columnInput, 0, SpringLayout.WEST, tttInput);
		baseLayout.putConstraint(SpringLayout.SOUTH, column, -6, SpringLayout.NORTH, rowInput);
		baseLayout.putConstraint(SpringLayout.NORTH, rowInput, 87, SpringLayout.SOUTH, row);
		baseLayout.putConstraint(SpringLayout.WEST, rowInput, 27, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, row, 48, SpringLayout.SOUTH, tttInput);
		baseLayout.putConstraint(SpringLayout.WEST, column, 0, SpringLayout.WEST, row);
		baseLayout.putConstraint(SpringLayout.WEST, row, 28, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, playerTurn, 626, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, turn, 0, SpringLayout.WEST, playerTurn);
		baseLayout.putConstraint(SpringLayout.NORTH, playerTurn, 0, SpringLayout.NORTH, title);
		baseLayout.putConstraint(SpringLayout.NORTH, turn, 0, SpringLayout.NORTH, title);
	}
	
	public void setupListeners()
	{
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				tttInput.setText("");
				rowInput.setText("");
				columnInput.setText("");
			}
		});
	}
}
