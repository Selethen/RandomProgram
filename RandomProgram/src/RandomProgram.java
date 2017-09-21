import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JSpinner;

public class RandomProgram {

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
		frame.setBounds(100, 100, 277, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToggleButton redButton = new JToggleButton("RED");
		redButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		redButton.setBackground(Color.RED);
		redButton.setBounds(10, 293, 89, 40);
		frame.getContentPane().add(redButton);
		
		JToggleButton blueButton = new JToggleButton("BLUE");
		blueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		blueButton.setBackground(SystemColor.textHighlight);
		blueButton.setBounds(165, 293, 89, 40);
		frame.getContentPane().add(blueButton);
		
		ButtonGroup colorGroup = new ButtonGroup();
		colorGroup.add(redButton);
		colorGroup.add(blueButton);
		
		JSpinner numberSpinner = new JSpinner();
		numberSpinner.setBounds(109, 294, 46, 42);
		numberSpinner.setModel(new SpinnerNumberModel(0, 0, 36, 1));
		JFormattedTextField formattedField=((JSpinner.DefaultEditor)numberSpinner.getEditor()).getTextField(); formattedField.setEditable(false); 
		frame.getContentPane().add(numberSpinner);
	}
}
