import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


public class Game extends Application {
    static boolean gamePaused = true;

    private int verticalCells = 64;
    private int horizontalCells = 64;

    private double sceneWidth = 800;
    private double sceneHeight = 800;

    private double gridWidth = sceneWidth / verticalCells;
    private double gridHeight = sceneHeight / horizontalCells;

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

        int padding = 10;
        World world = new World(verticalCells, horizontalCells, padding);
        Grid grid = new Grid(world, root, gridWidth, gridHeight, verticalCells, horizontalCells, padding);
        grid.render();

        GameLoop gameLoop = new GameLoop(world, grid);
        Controls(scene, grid, gameLoop);
    }

    private void Controls(Scene scene, Grid grid, GameLoop gameLoop) {
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE || e.getCode() == KeyCode.ENTER) {
                if (gamePaused) {
                    gameLoop.start();
                    gamePaused = false;
                } else {
                    gameLoop.stop();
                    gamePaused = true;
                }
            }

            if (e.getCode() == KeyCode.UP && grid.getZoom() < 32) { // 32 is max zoom value
                grid.setZoom(grid.getZoom()*2);
            }

            if (e.getCode() == KeyCode.DOWN && grid.getZoom() > 1) { // 1 is min zoom value
                grid.setZoom(grid.getZoom()/2);
            }

            if (e.getCode() == KeyCode.RIGHT && gameLoop.getTempo() < 64) { // is max tempo value
                gameLoop.setTempo(gameLoop.getTempo()*2);
            }

            if (e.getCode() == KeyCode.LEFT && gameLoop.getTempo() > 1) { // 1 is min tempo value
                gameLoop.setTempo(gameLoop.getTempo()/2);
            }

            grid.render();
        });
    }
}
