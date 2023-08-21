import java.util.Objects;
import java.util.Random;
import java.awt.Graphics;
/**
 * 
 * @author ekaya
 *
 */
public class Minefield {
/**
 * 	the only attribute of Minefield is a 2D array of Cells
 */
	private Cell[][] field;
	private int infoCellCount;
	private Cell[] mineCells;
	private boolean gameLost;
	

/**
 * This is a non-parametric constructor
 */
	public Minefield() {
		this(10,10,10);
	}
/**
 * 
 * @param numRows rows in 2D array
 * @param numColumns columns in 2D array
 * @param numMines number of mines to disperse through the 2D array
 */
	public Minefield(int numRows, int numColumns, int numMines) {
		this.field = new Cell[numRows][numColumns];
		mineCells = new Cell[numMines];
		//makeAllInfo();
		this.mineLaying(numMines);
		this.addInfoCells();
		this.infoCellCount = numRows * numColumns - numMines;
		
	}
	
	public Cell[][] getField(){
		return this.field;
	}
	
	public int getInfoCellCount() {
		return this.infoCellCount;
	}
	
	public boolean gameLost() {
		return this.gameLost;
	}
	
	public void gameLost(boolean a) {
		this.gameLost = a;
	}
/**
 * 
 * @param numOfMines the number of mines that should be randomly spread throughout the 2D array of Objects
 */
	public void mineLaying(int numOfMines) {	
		//makeAllInfo();
		Random r = new Random();
		//r.setSeed(11);
		
		int laid_mines = 0;
		while(laid_mines != numOfMines) {
			int row = r.nextInt(field.length);
			int col = r.nextInt(field[0].length);
			
			if (field[row][col] == null) {
				Cell newMine = new Cell(row, col, 0, true);
				field[row][col] = newMine;
				mineCells[laid_mines] = newMine;
				laid_mines += 1;
				
			}
			else continue;
		}
		
	}
/**
 * this method adds InfoCells to the slots that are not MineCells
 */
	public void addInfoCells() {
		//int nearbyMines = 0;
		for (int i = 0; i<field.length; i++) {
			for (int k = 0; k<field[i].length; k++) {
				if (field[i][k] == null) {
					Cell currentCell = new Cell(i,k,0, false);
					field[i][k] = currentCell;
					currentCell.setMines(this.getNearbyMines(currentCell));
				}
			}
		}
		
	}
	
	public void openAllMines() {
		for(Cell mine : this.mineCells) {
			mine.setStatus("opnd");
		}
	}
/**
 * 
 * @param g the Graphics object that is passed to Minefield by Class Board
 */
	public void draw(Graphics g) {
		for (int i = 0; i<field.length; i++) {
			for (int k = 0; k<field[i].length; k++) {
				field[i][k].draw(g);
				
			}
		}
	}
/**
 * 
 * @param x pixel coordinates right-to-left
 * @param y pixel coordinates up-to-down
 * @return this method returns the Object located at pixel x,y
 */
	public Cell getCellByScreenCoordinates(int x, int y) {
		int col = (int)(Math.ceil( ((double)(x)) / (double)(Configuration.CELL_SIZE) - 1));
		int row = (int)(Math.ceil( ((double)(y)) / (double)(Configuration.CELL_SIZE) - 1));
		
		return field[row][col];
	}
	
	public void openCells(Cell cell) {
		cell.setStatus("opnd");
		this.infoCellCount--;
		//Configuration.UNOPENED_INFOCELL_COUNT -=1;
		
		if(cell.getNumOfAdjacentMines() == 0) {
			for (int i = cell.getRow()-1; i<=cell.getRow()+1; i++) {
				if (i<0) continue;
				else if(i>field.length-1) break;

				for (int k = cell.getCol()-1; k<=cell.getCol()+1; k++) {
					if (k<0) continue;
					else if (k>field[i].length-1) break;
					
					if (!field[i][k].isMine()) {
						if ((field[i][k].getStatus().equals("cvrd"))) {
							openCells((field[i][k]));
						}
						
					}
				}
			}
		}
		
		
	}
/**
 * This method sets the status of incorrectly marked cells to STATUS_WRONGLY_MARKED
 */
	public void revealIncorrectMarkedCells() {
		for (int i = 0; i<field.length; i++) {
			for (int k = 0; k<field[i].length; k++) {
				if (!field[i][k].isMine()
					&& (field[i][k]).getStatus() == "mrkd") {
					(field[i][k]).setStatus("wmrkd");
				}
			}
		}
	}

	/**
	 * 
	 * @param cell InfoCell Object
	 * @return this method returns an int that is the number of neighboring cells that hold a MineCell Object
	 */
	public int getNearbyMines(Cell cell) {
		// go through field to find row and column where object == cell
		int nearbyMines = 0;
			
		for (int i = cell.getRow()-1; i<=cell.getRow()+1; i++) {
			if (i<0) continue;
			else if(i>field.length-1) break;

			for (int k = cell.getCol()-1; k<=cell.getCol()+1; k++) {
				if (k<0) continue;
				else if (k>field[i].length-1) break;
					
				if (field[i][k] != null && field[i][k].isMine()) {
						nearbyMines++;
				}
			}
		}
			
		cell.setMines(nearbyMines);
		return nearbyMines;
	}
	
}
