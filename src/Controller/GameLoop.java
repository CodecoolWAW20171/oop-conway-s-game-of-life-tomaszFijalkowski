import javafx.animation.AnimationTimer;


public class GameLoop extends AnimationTimer {
    private int generation = 0;
    private int tempo = 1;
    private int frame = 0;
    private World world;
    private Grid grid;

    GameLoop(World world, Grid grid){
        this.world = world;
        this.grid = grid;
    }

    // gets called every frame
    @Override
    public void handle(long now) {
        frame++;
        if (frame % (1.0 / tempo * 64) == 0) {
            world.nextGeneration();
            grid.render();
            System.out.println("Generation: " + ++generation + " | Zoom: " + grid.getZoom() + " | Tempo: " + tempo);
        }
    }

    void setTempo(int tempo) {
        this.tempo = tempo;
    }

    int getTempo() {
        return tempo;
    }
}