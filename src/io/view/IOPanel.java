package io.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import io.controller.IOController;
import io.model.Game;

import javax.swing.*;

public class IOPanel extends JPanel
{

	private IOController baseController;
	private JButton saveButton;
	private JButton loadButton;
	private JTextField titleField;
	private JTextField rankingField;
	private JTextArea rulesArea;
	private JLabel rulesLabel;
	private JLabel rankingLabel;
	private JLabel titleLabel;
	private SpringLayout baseLayout;
	private JLabel gameCountLabel;

	public IOPanel(IOController baseController)
	{
		this.baseController = baseController;

		saveButton = new JButton("save the game stuff");
		loadButton = new JButton("load the game stuff");
		titleField = new JTextField(15);
		titleLabel = new JLabel("Game Title:");
		rankingField = new JTextField(5);
		rankingLabel = new JLabel("Game Ranking:");
		rulesArea = new JTextArea(5, 20);
		rulesLabel = new JLabel("Game Rules:");
		gameCountLabel = new JLabel("Current game count:");
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(rankingField);
		this.add(rankingLabel);
		this.add(rulesArea);
		this.add(rulesLabel);
		this.add(saveButton);
		this.add(titleField);
		this.add(titleLabel);
		this.add(loadButton);
		this.add(gameCountLabel);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 6, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, gameCountLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, gameCountLabel, -16, SpringLayout.NORTH, titleField);
		baseLayout.putConstraint(SpringLayout.WEST, titleField, 6, SpringLayout.EAST, titleLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 6, SpringLayout.NORTH, titleField);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, titleField, 59, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingField, 92, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rankingField, 9, SpringLayout.EAST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingLabel, 6, SpringLayout.NORTH, rankingField);
		baseLayout.putConstraint(SpringLayout.WEST, rankingLabel, 0, SpringLayout.WEST, rulesLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesLabel, 126, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, rulesLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 18, SpringLayout.SOUTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.WEST, rulesArea, 34, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rulesArea, -68, SpringLayout.SOUTH, this);

	}

	



	private void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.makeGameFromInput(titleField.getText(), rankingField.getText(), rulesArea.getText());
				if (tempGame != null)
				{
					baseController.saveGameInformation(tempGame);
					gameCountLabel.setText("Current game count: " + baseController.getProjectGames().size());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Try again with a valid number");
				}
			}
		});
		
		loadButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.readGameInformation();
				if( tempGame != null)
				{
					titleField.setText(tempGame.getGameTitle());
					rankingField.setText(Integer.toString(tempGame.getFunRanking()));
					String tempRules = "";
					for(String currentRule : tempGame.getGameRules() )
					{
						tempRules += currentRule + "\n";
					}
					rulesArea.setText(tempRules);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Check the save file make sure it is in order.");
				}
			}
		});
	}
}
