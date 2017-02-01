package grid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JScrollPane.*;
import grid.controller.GridController;
import grid.view.GridFrame;
import grid.model.*;

public class GridPanel extends JPanel
{
	private GridController baseController;
	private GridFrame gridFrame;
	private TicTacToe ticTacToe;
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
	
	private JTable gridTable;
	private JScrollPane gridPane;
	
	public GridPanel(GridController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.title = new JLabel("5x5 Tic Tac Toe");
		this.input = new JLabel("Input X or O here");
		this.row = new JLabel("Row");
		this.column = new JLabel("Column");
		this.turn = new JLabel("Turn: Player ");
		this.playerTurn = new JLabel("1");
		this.tttInput = new JTextField(25);
		this.rowInput = new JTextField(5);
		this.columnInput = new JTextField(5);
		this.submit = new JButton("Submit");
		
		setupTable();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	public GridPanel(TicTacToe ticTacToe)
	{
		this.ticTacToe = ticTacToe;
	}
	
	public void setupTable()
	{
		DefaultTableModel data = new DefaultTableModel(baseController.getGrid(), new String []{"1", "2", "3", "4", "5"});
		gridTable = new JTable();
		gridTable.setModel(data);
		gridPane = new JScrollPane();
		gridPane.setViewportView(gridTable);
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
		this.add(gridPane);
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, submit, 396, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submit, 27, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, input, -6, SpringLayout.NORTH, tttInput);
		baseLayout.putConstraint(SpringLayout.WEST, tttInput, 27, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, input, 105, SpringLayout.WEST, this);
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
		baseLayout.putConstraint(SpringLayout.NORTH, gridPane, 54, SpringLayout.SOUTH, turn);
		baseLayout.putConstraint(SpringLayout.WEST, gridPane, 54, SpringLayout.EAST, tttInput);
		baseLayout.putConstraint(SpringLayout.NORTH, tttInput, 148, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, playerTurn, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, turn, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, title, 0, SpringLayout.WEST, row);
		baseLayout.putConstraint(SpringLayout.SOUTH, title, -29, SpringLayout.NORTH, input);
	}
	
	public void setupListeners()
	{
		submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String xo = tttInput.getText();
				int rowChoice = Integer.parseInt(rowInput.getText());
				int columnChoice = Integer.parseInt(columnInput.getText());
				
				if(isXOrO(xo) && isValidSpace(rowChoice) && isValidSpace(columnChoice))
				{
					ticTacToe.assignSpace(xo, rowChoice, columnChoice);
				}
				
				tttInput.setText("");
				rowInput.setText("");
				columnInput.setText("");
			}
		});
	}
	
	public GridController getBaseController()
	{
		return baseController;
	}
	
	public boolean isValidInteger(String input)
	{
		boolean isValid = false;
		
		try
		{
			int successful = Integer.parseInt(input);
			isValid = true;
		}
		catch (NumberFormatException userTypedSomething)
		{
			JOptionPane.showMessageDialog(this, "Type in a valid int in either row or column.");
		}
		
		return isValid;
	}
	
	public boolean isXOrO(String input)
	{
		boolean isValid = false;
		
		if (input.equalsIgnoreCase("o") || input.equalsIgnoreCase("x"))
		{
			isValid = true;
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Type in either X or O in the Input.");
		}
		
		return isValid;
	}
	
	public boolean isValidSpace(int input)
	{
		boolean isValid = false;
		
		if (input == 1 ||
				input == 2 ||
				input == 3 ||
				input == 4 ||
				input == 5)
		{
			isValid = true;
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Type in a valid space on the table.");
		}
		
		return isValid;
	}
}
