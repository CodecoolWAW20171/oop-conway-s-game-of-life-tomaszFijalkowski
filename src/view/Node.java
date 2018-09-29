import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class Node extends StackPane {

    Node(int zoom, int x, int y, double width, double height, int padding, World world, Color color) {
        Cell cell = world.getCell(x, y);
        width *= zoom;
        height *= zoom;

        // create rectangle
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setStroke(Game.gamePaused ? Color.GRAY : Color.LIGHTGREY);
        rectangle.setFill(color);

        // set position
        setTranslateX(x * width - (padding * width));
        setTranslateY(y * height - (padding * height));

        // make rectangle clickable
        rectangle.setOnMouseClicked(lambda -> {
            if (Game.gamePaused) {
                if (cell.getCurrentState().equals(State.DEAD)){
                    cell.setCurrentState(State.ALIVE);
                    rectangle.setFill(Color.BLACK);
                } else {
                    cell.setCurrentState(State.DEAD);
                    rectangle.setFill(Color.WHITE);
                }
            }
        });
        getChildren().addAll(rectangle);
    }
}