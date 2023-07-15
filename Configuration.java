
public class Configuration {
	public static int ROWS;
	public static int COLS;
	public static int CELL_SIZE;
	public static int MINES;
	public static String STATUS_COVERED;
	public static String STATUS_OPENED;
	public static String STATUS_MARKED;
	public static String STATUS_WRONGLY_MARKED;
	public static int BOARD_WIDTH;
	public static int BOARD_HEIGHT;
	public static int UNOPENED_INFOCELL_COUNT;
	
	public static void loadParameters(int[] parameters){
		//i could use a try catch to make sure the array only has 4 values
		ROWS = parameters[0];
		COLS = parameters[1];
		CELL_SIZE = parameters[2];
		MINES = parameters[3];
		UNOPENED_INFOCELL_COUNT = ROWS * COLS - MINES;
		BOARD_WIDTH = COLS * CELL_SIZE + 1;
		BOARD_HEIGHT = ROWS * CELL_SIZE + 1;

	}

}
