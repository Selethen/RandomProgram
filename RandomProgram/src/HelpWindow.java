import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWindow window = new HelpWindow();
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
	public HelpWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 445, 323);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		ImageIcon board = new ImageIcon(getClass().getResource("/resources/ruletka.jpg"));
		
		JLabel panel = new JLabel(board);
		panel.setBounds(226, 11, 193, 261);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("<html>The key to win the game is to select the right color/number. Firstly, you have to pick the right button (color/number). Then, depending on the button you've selected, you need to pick number/color that you want. Next you have to click play, and then program will randomly pick a number. If you pick the right color/number, then you win. You can see board with possible numbers on the right side.</html>");
		lblNewLabel.setBounds(10, 11, 194, 206);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Author: \u0141ukasz Parulski");
		lblNewLabel_1.setBounds(9, 259, 207, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
