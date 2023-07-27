import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;


public class Play
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					
					int[] default_configs = new int[] {16,16,15,40};
					/*
					 * 8 × 8, 9 × 9, or 10 × 10. 
					 * Intermediate has 40 mines and also varies in size between 13 × 15 and 16 × 16. 
					 * Finally, expert has 99 mines and is always 16 × 30 (or 30 × 16).
					 */
					
					Configuration.loadParameters(default_configs);
					JFrame frame = new JFrame();
					JMenuBar menubar = new JMenuBar();
					
					JMenu easy = new JMenu("Easy");
					JMenu intermediate = new JMenu("Intermediate");
					JMenu diffucult = new JMenu("Diffucult");
					
					menubar.add(easy);
					menubar.add(intermediate);
					menubar.add(diffucult);
					
					JLabel statusbar = new JLabel("select a cell");
					frame.add(statusbar, BorderLayout.SOUTH);
					frame.add(new Board(Configuration.ROWS, Configuration.COLS, Configuration.MINES, statusbar));
					//frame.setResizable(false);
					frame.pack();
					frame.setTitle("Ekrem's Minefield");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					

					//frame.setJMenuBar(menubar);
					frame.setVisible(true);
					
					
				}
			});
	}
}
