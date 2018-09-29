class World {
    private Cell[][] board;

    World(int width, int height, int padding){
        // create a board with given size and added padding
        board = new Cell[width + padding * 2][height + padding * 2];
        initializeBoard();
    }

    Cell getCell(int x, int y) {
        return board[x][y];
    }

    void nextGeneration(){
        // check next state for all cells
        for (int x = 1; x < board.length - 1; x++) {
            for (int y = 1; y < board[x].length - 1; y++) {
                board[x][y].nextGeneration();
            }
        }
        // execute next generation for all cells
        for (int x = 1; x < board.length - 1; x++) {
            for (int y = 1; y < board[x].length - 1; y++) {
                board[x][y].generate();
            }
        }
    }

    private void initializeBoard(){
        // fill initial board with dead cells
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = new Cell(this, x, y);
            }
        }
    }
}
