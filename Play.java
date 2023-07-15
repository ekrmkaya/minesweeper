import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Play
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					
					int[] default_configs = {30,16,15,99};
					
					
					Configuration.loadParameters(default_configs);
					JFrame frame = new JFrame();
					JLabel statusbar = new JLabel("select a cell");
					frame.add(statusbar, BorderLayout.SOUTH);
					frame.add(new Board(Configuration.ROWS, Configuration.COLS, Configuration.MINES, statusbar));
					frame.setResizable(false);
					frame.pack();
					frame.setTitle("Ekrem's Minefield");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					
				}
			});
	}
}
