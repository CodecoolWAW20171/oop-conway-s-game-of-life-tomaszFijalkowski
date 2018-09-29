class Cell {
    private State currentState;
    private State nextState;
    private World world;
    private int x;
    private int y;

    Cell(World world, int x, int y){
        setCurrentState(State.DEAD);
        this.world = world;
        this.x = x;
        this.y = y;
    }

    void nextGeneration(){
        int neighbours = countNeighbors();
        if ((neighbours < 2 || neighbours > 3) && currentState.equals(State.ALIVE)) {
            nextState = (State.DEAD); // death
        } else if (neighbours == 3 && currentState.equals(State.DEAD)) {
            nextState = (State.ALIVE); // birth
        } else {
            nextState = (currentState); // stasis
        }
    }

    void generate(){
        setCurrentState(nextState);
    }

    void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    State getCurrentState() {
        return currentState;
    }

    private int countNeighbors(){
        int neighbours = 0;

        // checks 3x3 area around the cell
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (world.getCell(x+i, y+j).currentState.equals(State.ALIVE) && (i != 0 || j != 0)){
                    neighbours += 1;
                }
            }
        }
        return neighbours;
    }
}
