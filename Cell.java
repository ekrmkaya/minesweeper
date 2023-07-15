import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Cell {
	private int row;
	private int column;
	private int numOfAdjacentMines;
	private boolean isMine;
	private String status = "cvrd";
	

	public Cell(int row, int column, int numOfAdjacentMines, boolean isMine) {
		this.row = row;
		this.column = column;
		this.numOfAdjacentMines = numOfAdjacentMines;
		this.isMine = isMine;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.column;
	}
	
	public void setMines(int mineCount) {
		this.numOfAdjacentMines = mineCount;
	}
	
	public int getNumOfAdjacentMines() {
		return this.numOfAdjacentMines;
	}
	
	public boolean isMine() {
		return this.isMine;
	}

	public void draw(Graphics g) {
		g.drawImage(this.getImage(), this.getHorizontalPosition(), this.getVerticalPosition(), null);
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {

		this.status = status;
	}

	public Image getImage() {
		Image image;
		if(this.isMine) {
			if(this.status.equals("mrkd")) {
				ImageIcon a = new ImageIcon("img/marked_cell.png");
				image = a.getImage();
			}
			else if(this.status.equals("opnd")) {
				ImageIcon a = new ImageIcon("img/mine_cell.png");
				image = a.getImage();
			}
			else /*(status.equals(Configuration.STATUS_COVERED))*/ {
				ImageIcon a = new ImageIcon("img/covered_cell.png");
				image = a.getImage();
			}
			return image;
		}
		else {
			if (status.equals("cvrd")) {
				ImageIcon a = new ImageIcon("img/covered_cell.png");
				image = a.getImage();
			}
			else if(status.equals("mrkd")) {
				ImageIcon a = new ImageIcon("img/marked_cell.png");
				image = a.getImage();
			}
			else if(status.equals("wmrkd")){
				ImageIcon a = new ImageIcon("img/wrong_mark.png");
				image = a.getImage();
			}
			else /*(status.equals(Configuration.STATUS_OPENED))*/ {
				ImageIcon a = new ImageIcon("img/info_" + this.numOfAdjacentMines + ".png");
				image = a.getImage();
			}
			return image; 
		}
			
	}
	
	private int getHorizontalPosition() {
		return (column) * Configuration.CELL_SIZE;
		//Calculates and returns the pixel-level horizontal position of the top-left corner of the cell
	}
	
	private int getVerticalPosition() {
		return (row) * Configuration.CELL_SIZE;
		//Calculates and returns the pixel-level vertical position of the top-left corner of the cell
	}

}
