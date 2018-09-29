import javafx.scene.Group;
import javafx.scene.paint.Color;


class Grid {
    private World world;
    private Group root;
    private double gridWidth;
    private double gridHeight;
    private int verticalCells;
    private int horizontalCells;
    private int padding;
    private int zoom = 1;

    Grid(World world, Group root, double gridWidth, double gridHeight, int verticalCells, int horizontalCells, int padding){
        this.world = world;
        this.root = root;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.horizontalCells = horizontalCells + padding * 2;
        this.verticalCells = verticalCells + padding * 2;
        this.padding = padding;
    }

    void render() {
        root.getChildren().clear();
        for (int x = padding; x < verticalCells - padding; x++) {
            for (int y = padding; y < horizontalCells - padding; y++) {

                // set node's color
                Color nodeColor = world.getCell(x, y).getCurrentState().equals(State.ALIVE)? Color.BLACK : Color.WHITE;

                // create node
                Node node = new Node(zoom, x, y, gridWidth, gridHeight, padding, world, nodeColor);

                // add node to group
                root.getChildren().add(node);
            }
        }
    }

    void setZoom(int zoom) {
        this.zoom = zoom;
    }

    int getZoom() {
        return zoom;
    }
}
