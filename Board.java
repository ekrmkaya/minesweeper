import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 * @author ekaya
 */
public class Board extends JPanel
{

	private Minefield minefield;
	private JLabel status;
	private int height;
	private int width;
	private int mines;
/**
 *  Constructor that creates a minefield, initializes values, activates mouse, and sets up size of the board
 */
	public Board(int height, int width, int mines, JLabel statusbar)
	{
		this.height = height;
		this.width = width;
		this.mines = mines;
		this.minefield = new Minefield(height, width, mines);
		status = statusbar;
		setPreferredSize(new Dimension(Configuration.BOARD_WIDTH, Configuration.BOARD_HEIGHT));
		addMouseListener(new MouseReader(this));
	}
/**
 * @param Graphics object
 */
	@Override
	public void paintComponent(Graphics g)
	{
		minefield.draw(g);
	}
/**
 * this method adjusts the statuses of cells based on user interaction through a mouse
 */
	public void mouseClickOnLocation(int x, int y, String button)
	{	
		
		if(isGameOver()) {
			setStatusbar("YOU WIN!");
			repaint();
			return;
		}
		if(minefield.gameLost()) {
			return;
		}
		Cell clickedCell = minefield.getCellByScreenCoordinates(x,y);
		if (clickedCell.isMine()) {
			if (button == "right") {
				if(clickedCell.getStatus().equals("cvrd")) {
					clickedCell.setStatus("mrkd");
					this.removeMine();
				}
				else if(clickedCell.getStatus().equals("mrkd")){
					clickedCell.setStatus("cvrd");
					this.addMine();
				}
				else {
					return;
				}

			}
			else if (button == "left") {
				if(clickedCell.getStatus().equals("mrkd")) {
					setStatusbar("Invalid Action, Unflag the Cell First");
					repaint();
					return;
				}
				clickedCell.setStatus("opnd");
				minefield.openAllMines();
				minefield.gameLost(true);
				setStatusbar("YOU LOSE!");
				repaint();
				return;
				
			}
		}
		
		if (!clickedCell.isMine()) {
			if (button == "right") {
				if (clickedCell.getStatus().equals("opnd")) {
					setStatusbar("Invalid action");
					repaint();
					return;
				}
				else if (clickedCell.getStatus().equals("mrkd")) {
					this.addMine();
					clickedCell.setStatus("cvrd");
				}
				else {
					clickedCell.setStatus("mrkd");
					this.removeMine();
				}
				
			}
			else if (button == "left") {
				if(clickedCell.getStatus().equals("mrkd")) {
					setStatusbar("Invalid Action, Unflag the Cell First");
					repaint();
					return;
				}
				if(!clickedCell.getStatus().equals("opnd")) {
					minefield.openCells((clickedCell));
				}
				
				
			}
		}
		if(isGameOver()) {
			setStatusbar("YOU WIN!");
		}
		repaint();
		
	}
	
	public void setStatusbar(String text) {
		//A setter method for the text that is displayed in the statusbar. You should use the setText
		//method of the JLabel class.
		status.setText(text);
	}
	public String getStatusbar() {
		//A getter method that returns the text of the statusbar. You should use the getText method of
		//the JLabel class.
		return status.getText();
	}
	
	public Minefield getMinefield() {
		return this.minefield;
	}
/**
 * @return This method returns true if game is over
 */
	public boolean isGameOver() {
		if(minefield.getInfoCellCount() == 0) {
			return true;
		}
		else return false;
	}
/**
 * This method adjusts the statusbar as the user flags for mines
 */
	public boolean removeMine() {
		boolean value = true;
		if (mines > 0) {
			mines -=1;
			setStatusbar(mines + "Mines remaining");
		}
		else {
			value = false;
			setStatusbar("Invalid action");
		}
		return value;
		
	}
	/**
	 * This method adjusts the statusbar as the user unflags for mines
	 */
	public boolean addMine() {
		boolean value = true;
		if (mines < Configuration.MINES) {
			mines +=1;
			setStatusbar(mines + "Mines remaining");
		}
		else {
			value = false;
			setStatusbar("Invalid action");
		}
		return value;
	}
	
}
