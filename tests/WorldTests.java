import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class WorldTests {
    @Test
    void checkRandomPattern(){
        World worldWithBlock = new World(4, 4, 10);

        // create initial pattern
        worldWithBlock.getCell(1,1).setCurrentState(State.ALIVE);
        worldWithBlock.getCell(2,2).setCurrentState(State.ALIVE);

        // perform next generation
        worldWithBlock.nextGeneration();

        // check if pattern is correct
        assertEquals(State.DEAD, worldWithBlock.getCell(1,1).getCurrentState());
        assertEquals(State.DEAD, worldWithBlock.getCell(1,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBlock.getCell(2,1).getCurrentState());
        assertEquals(State.DEAD, worldWithBlock.getCell(2,2).getCurrentState());
    }

    @Test
    void checkBlockPattern(){
        World worldWithBlock = new World(4, 4, 10);

        // create initial pattern
        worldWithBlock.getCell(1,1).setCurrentState(State.ALIVE);
        worldWithBlock.getCell(1,2).setCurrentState(State.ALIVE);
        worldWithBlock.getCell(2,1).setCurrentState(State.ALIVE);
        worldWithBlock.getCell(2,2).setCurrentState(State.ALIVE);

        // perform next generation
        worldWithBlock.nextGeneration();

        // check if pattern is correct
        assertEquals(State.ALIVE, worldWithBlock.getCell(1,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlock.getCell(1,2).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlock.getCell(2,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlock.getCell(2,2).getCurrentState());
    }

    @Test
    void checkBeehivePattern(){
        World worldWithBeehive = new World(6, 5, 10);

        // create initial pattern
        worldWithBeehive.getCell(1,2).setCurrentState(State.ALIVE);
        worldWithBeehive.getCell(2,1).setCurrentState(State.ALIVE);
        worldWithBeehive.getCell(2,3).setCurrentState(State.ALIVE);
        worldWithBeehive.getCell(3,1).setCurrentState(State.ALIVE);
        worldWithBeehive.getCell(3,3).setCurrentState(State.ALIVE);
        worldWithBeehive.getCell(4,2).setCurrentState(State.ALIVE);

        // perform next generation
        worldWithBeehive.nextGeneration();

        // check if pattern and area around is correct
        assertEquals(State.DEAD, worldWithBeehive.getCell(1,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBeehive.getCell(1,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBeehive.getCell(1,3).getCurrentState());
        assertEquals(State.ALIVE, worldWithBeehive.getCell(2,1).getCurrentState());
        assertEquals(State.DEAD, worldWithBeehive.getCell(2,2).getCurrentState());
        assertEquals(State.ALIVE, worldWithBeehive.getCell(2,3).getCurrentState());
        assertEquals(State.ALIVE, worldWithBeehive.getCell(3,1).getCurrentState());
        assertEquals(State.DEAD, worldWithBeehive.getCell(3,2).getCurrentState());
        assertEquals(State.ALIVE, worldWithBeehive.getCell(3,3).getCurrentState());
        assertEquals(State.DEAD, worldWithBeehive.getCell(4,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBeehive.getCell(4,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBeehive.getCell(4,3).getCurrentState());
    }

    @Test
    void checkBlinkerPattern(){
        World worldWithBlinker = new World(5, 5, 10);

        // create initial pattern
        worldWithBlinker.getCell(2,1).setCurrentState(State.ALIVE);
        worldWithBlinker.getCell(2,2).setCurrentState(State.ALIVE);
        worldWithBlinker.getCell(2,3).setCurrentState(State.ALIVE);

        // perform next generation
        worldWithBlinker.nextGeneration();

        // check if pattern and area around is correct
        assertEquals(State.DEAD, worldWithBlinker.getCell(1,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlinker.getCell(1,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(1,3).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(2,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlinker.getCell(2,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(2,3).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(3,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlinker.getCell(3,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(3,3).getCurrentState());

        // perform another generation
        worldWithBlinker.nextGeneration();

        // check if pattern and area around is still correct
        assertEquals(State.DEAD, worldWithBlinker.getCell(1,1).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(1,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(1,3).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlinker.getCell(2,1).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlinker.getCell(2,2).getCurrentState());
        assertEquals(State.ALIVE, worldWithBlinker.getCell(2,3).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(3,1).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(3,2).getCurrentState());
        assertEquals(State.DEAD, worldWithBlinker.getCell(3,3).getCurrentState());
    }
}
