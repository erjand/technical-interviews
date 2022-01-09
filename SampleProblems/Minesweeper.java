/*
Minesweeper is a game played on an X-by-Y board of covered tiles. Hidden among the tiles
are M mines. We will be working towards a command-line version of Minesweeper where the game flow
is as follows:

1. User is the shown the current state of the board, and selects a tile to reveal.
    a. If it is a mine, the game ends and the player loses.
    b. If it is not a mine, a number indicating how many neighboring tiles contain mines is shown.
2. The player continues selecting tiles to reveal.
    a. If they successfully reveal all non-mine tiles, the player wins.

You can see an example of the game at https://minesweeperonline.com/#

For this interview, we want to build as much functionality of the game as we can.

Starter tasks:
1. Define a data structure to represent the game board.
2. Construct a new board with randomly placed mines.
3. Write a method to display which tiles contain mines.
*/