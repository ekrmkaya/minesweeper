# Minesweeper
Personal project with Java Swing.
This project was something I had developed to test my understanding of Object Oriented Programming principles. I have revisited the project
and added graphics.

# Contents
The project consists of 6 java files and 1 additional file for the pngs needed for graphics. 

1. Cell.java outlines the individuals cells that can be clicked and opened. 

2. Minefield.java outlines the grid of Cell objects which the game is played on. The main component is a 2D array of Cells. 

3. Board.java extends JPanel and adds the graphic and user interaction components of the program. This class deals with mouse clicks
and updates the graphics when necessary.

4 & 5. Menu.java and Configuration.java are only used in the initial set up of the game. Run Menu.java to play the game

6. MouseReader.java deals with MouseEvents. 

7. img.zip contains .png files that are used in the code. 

# Running
You can run the code simply by unzipping img and running the main method in Menu.java. 

<img width="231" alt="menu" src="https://github.com/ekrmkaya/minesweeper/assets/91214064/651a5860-6fb6-4299-b8c4-6523a6129e9a">

<img width="240" alt="gameplay" src="https://github.com/ekrmkaya/minesweeper/assets/91214064/b794465e-5ad0-4b5d-998d-08041887e5a5">
