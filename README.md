# minesweeper
Personal project with Java Swing.
This project was something I had developed to test my understanding of Object Oriented Programming principles. I have revisited the project
and added graphics. My next steps for this project are to add a diffuculty selection page and a play again button. 

# contents
The project consists of 6 java files and 1 additional file for the pngs needed for graphics. 

1. Cell.java outlines the individuals cells that can be clicked and opened. 

2. Minefield.java outlines the grid of Cell objects which the game is played on. The main component is a 2D array of Cells. 

3. Board.java extends JPanel and adds the graphic and user interaction components of the program. This class deals with mouse clicks
and updates the graphics when necessary.

4 & 5. Play.java and Configuration.java are only used in the initial set up of the game and contain the main method.

6. MouseReader.java deals with MouseEvents. 

7. img.zip contains .png files that are used in the code. 

# running
You can run the code simply by unzipping img and running the main method in Play.java. 

