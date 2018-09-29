import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CellTests {

    @Test
    void checkAliveCellInUnderpopulatedArea(){
        // create objects to test on
        World underPopulatedArea = new World(3, 3, 10);
        Cell aliveCellInUnderpopulatedArea = underPopulatedArea.getCell(1,1);

        // prepare world for current test
        underPopulatedArea.getCell(1,2).setCurrentState(State.ALIVE);

        // execute test
        aliveCellInUnderpopulatedArea.setCurrentState(State.ALIVE);
        aliveCellInUnderpopulatedArea.nextGeneration();
        aliveCellInUnderpopulatedArea.generate();
        assertEquals(State.DEAD, aliveCellInUnderpopulatedArea.getCurrentState());
    }

    @Test
    void checkAliveCellInRightlyPopulatedArea(){
        // create objects to test on
        World rightlyPopulatedArea = new World(3, 3, 10);
        Cell aliveCellInRightlyPopulatedArea = rightlyPopulatedArea.getCell(1,1);

        // prepare world for current test
        rightlyPopulatedArea.getCell(0,1).setCurrentState(State.ALIVE);
        rightlyPopulatedArea.getCell(1,2).setCurrentState(State.ALIVE);
        rightlyPopulatedArea.getCell(2,1).setCurrentState(State.ALIVE);

        // execute test
        aliveCellInRightlyPopulatedArea.setCurrentState(State.ALIVE);
        aliveCellInRightlyPopulatedArea.nextGeneration();
        aliveCellInRightlyPopulatedArea.generate();
        assertEquals(State.ALIVE, aliveCellInRightlyPopulatedArea.getCurrentState());
    }

    @Test
    void checkDeadCellInRightlyPopulatedArea(){
        // create objects to test on
        World rightlyPopulatedArea = new World(3, 3, 10);
        Cell deadCellInRightlyPopulatedArea = rightlyPopulatedArea.getCell(1,1);

        // prepare world for current test
        rightlyPopulatedArea.getCell(0,1).setCurrentState(State.ALIVE);
        rightlyPopulatedArea.getCell(1,2).setCurrentState(State.ALIVE);
        rightlyPopulatedArea.getCell(2,1).setCurrentState(State.ALIVE);

        // execute test
        deadCellInRightlyPopulatedArea.setCurrentState(State.DEAD);
        deadCellInRightlyPopulatedArea.nextGeneration();
        deadCellInRightlyPopulatedArea.generate();
        assertEquals(State.ALIVE, deadCellInRightlyPopulatedArea.getCurrentState());
    }

    @Test
    void checkAliveCellInOverpopulatedArea(){
        // create objects to test on
        World overPopulatedArea = new World(3, 3, 10);
        Cell aliveCellInOverpopulatedArea = overPopulatedArea.getCell(1,1);

        // prepare world for current test
        overPopulatedArea.getCell(2,1).setCurrentState(State.ALIVE);
        overPopulatedArea.getCell(2,2).setCurrentState(State.ALIVE);
        overPopulatedArea.getCell(1,2).setCurrentState(State.ALIVE);
        overPopulatedArea.getCell(0,1).setCurrentState(State.ALIVE);
        overPopulatedArea.getCell(0,2).setCurrentState(State.ALIVE);

        // execute test
        aliveCellInOverpopulatedArea.setCurrentState(State.ALIVE);
        aliveCellInOverpopulatedArea.nextGeneration();
        aliveCellInOverpopulatedArea.generate();
        assertEquals(State.DEAD, aliveCellInOverpopulatedArea.getCurrentState());
    }
}
