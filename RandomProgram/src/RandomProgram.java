import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class RandomProgram {
	
	JLabel numberLabel = new JLabel();
	boolean isBlue=false;
	boolean isRed=false;
	boolean isGreen=false;

	JLabel resultLabel = new JLabel("Pick color or number");
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomProgram window = new RandomProgram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandomProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new CloseListener());
		file.add(exit);
		
		JMenu help = new JMenu("Help");
		menuBar.add(help);
		
		JToggleButton redButton = new JToggleButton("RED");
		redButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		redButton.setBackground(Color.RED);
		redButton.setBounds(10, 297, 89, 40);
		frame.getContentPane().add(redButton);
		
		JToggleButton blueButton = new JToggleButton("BLUE");
		blueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		blueButton.setBackground(SystemColor.textHighlight);
		blueButton.setBounds(208, 297, 89, 40);
		frame.getContentPane().add(blueButton);
		
		 JToggleButton greenButton = new JToggleButton("GREEN");
	     greenButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
	     greenButton.setEnabled(false);
	     greenButton.setBackground(new Color(154, 205, 50));
	     greenButton.setBounds(109, 297, 89, 40);
	     frame.getContentPane().add(greenButton);
		
		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(redButton);
		colorGroup.add(blueButton);
		colorGroup.add(greenButton);
		
		JSpinner numberSpinner = new JSpinner();
		numberSpinner.setBounds(125, 244, 46, 42);
		numberSpinner.setModel(new SpinnerNumberModel(0, 0, 36, 1));
		JFormattedTextField formattedField=((JSpinner.DefaultEditor)numberSpinner.getEditor()).getTextField(); formattedField.setEditable(false); 
		frame.getContentPane().add(numberSpinner);
		
		JRadioButton rdbtnColor = new JRadioButton("Color");
		rdbtnColor.setBounds(10, 254, 109, 23);
		frame.getContentPane().add(rdbtnColor);
		
		JRadioButton rdbtnNumber = new JRadioButton("Number");
		rdbtnNumber.setBounds(208, 254, 109, 23);
		frame.getContentPane().add(rdbtnNumber);
		
		ButtonGroup choiceGroup = new ButtonGroup();
		choiceGroup.add(rdbtnNumber);
		choiceGroup.add(rdbtnColor);
		
		blueButton.setEnabled(false);
        redButton.setEnabled(false);
        numberSpinner.setEnabled(false);
        
        resultLabel.setBounds(35, 409, 241, 21);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(resultLabel);
        resultLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        numberLabel.setBounds(47, 11, 217, 222);
        numberLabel.setText("?");
        numberLabel.setVerticalAlignment(SwingConstants.CENTER);
        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setOpaque(true);
        numberLabel.setBackground(Color.BLACK);
        numberLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 90));
        frame.getContentPane().add(numberLabel);
        
        
        JButton playButton = new JButton("PLAY");
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(rdbtnNumber.isSelected()) {
        			play();
        			Integer randomNumber = Integer.parseInt(numberLabel.getText());
        			if(String.valueOf(randomNumber).equals(String.valueOf(numberSpinner.getValue()))) {
        				youWon();
        			}
        			else
        				youLost();
        		} else if (rdbtnColor.isSelected()) {
        			if(redButton.isSelected() || blueButton.isSelected() || greenButton.isSelected()) {
        				play();
        				if(isBlue) {
        					if(blueButton.isSelected()) {
        						youWon();
        					}
        					else {
        						youLost();
        					}
        				} else if(isRed) {
        					if(redButton.isSelected()) {
        						youWon();
        					}
        					else {
        						youLost();
        					}
        				} else if(isGreen) {
        					if(greenButton.isSelected()) {
        						youWon();
        					}
        					else {
        						youLost();
        					}
        				} else {
        					JOptionPane.showMessageDialog(null, "Whoops, unexpected error");
        				}
        			} else {
        				JOptionPane.showMessageDialog(null, "Please choose between red and blue");
        			}
        		} else {
        			JOptionPane.showMessageDialog(null, "Please choose between colors or numbers");
        		}
        	}
        });
        playButton.setBounds(10, 348, 290, 50);
        playButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        frame.getContentPane().add(playButton);
		
		rdbtnColor.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            blueButton.setEnabled(true);
	            redButton.setEnabled(true);
	            greenButton.setEnabled(true);
	            
	            numberSpinner.setEnabled(false);
	        }
	    });
		
		rdbtnNumber.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	numberSpinner.setEnabled(true);
	        	
	        	blueButton.setEnabled(false);
	            redButton.setEnabled(false);
	            greenButton.setEnabled(false);
	        }
	    });
		
	}
	
	private void play() {
		List<Integer> blueNumbers = new ArrayList<Integer>();
			blueNumbers.add(new Integer(2));
			blueNumbers.add(new Integer(4));
			blueNumbers.add(new Integer(6));
			blueNumbers.add(new Integer(8));
			blueNumbers.add(new Integer(10));
			blueNumbers.add(new Integer(11));
			blueNumbers.add(new Integer(13));
			blueNumbers.add(new Integer(15));
			blueNumbers.add(new Integer(17));
			blueNumbers.add(new Integer(20));
			blueNumbers.add(new Integer(22));
			blueNumbers.add(new Integer(24));
			blueNumbers.add(new Integer(26));
			blueNumbers.add(new Integer(28));
			blueNumbers.add(new Integer(29));
			blueNumbers.add(new Integer(31));
			blueNumbers.add(new Integer(33));
			blueNumbers.add(new Integer(35));
		List<Integer> redNumbers = new ArrayList<Integer>();
			redNumbers.add(new Integer(1));
			redNumbers.add(new Integer(3));
			redNumbers.add(new Integer(5));
			redNumbers.add(new Integer(7));
			redNumbers.add(new Integer(9));
			redNumbers.add(new Integer(12));
			redNumbers.add(new Integer(14));
			redNumbers.add(new Integer(16));
			redNumbers.add(new Integer(18));
			redNumbers.add(new Integer(19));
			redNumbers.add(new Integer(21));
			redNumbers.add(new Integer(23));
			redNumbers.add(new Integer(25));
			redNumbers.add(new Integer(27));
			redNumbers.add(new Integer(30));
			redNumbers.add(new Integer(32));
			redNumbers.add(new Integer(34));
			redNumbers.add(new Integer(36));
		
		Integer number = randomNumber();
		
		numberLabel.setText(number.toString());
		
		if(blueNumbers.contains(number)) {
			numberLabel.setBackground(Color.BLUE);
			isBlue=true;
			isRed=false;
			isGreen=false;
		} else if(redNumbers.contains(number)) {
			numberLabel.setBackground(Color.RED);
			isBlue=false;
			isRed=true;
			isGreen=false;
		} else {
			numberLabel.setBackground(new Color(154, 205, 50));
			isBlue=false;
			isRed=false;
			isGreen=true;
		}
	}
	
	private int randomNumber() {
		Random generator = new Random();
		return generator.nextInt(37);
	}
	
	private void youWon() {
		resultLabel.setText("YOU WON!!!");
		JOptionPane.showMessageDialog(null, "YOU WON!!!");
	}
	
	private void youLost() {
		resultLabel.setText("YOU LOST :(");
	}
	
	private class CloseListener implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	    }
	}
}
