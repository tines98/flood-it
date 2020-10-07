import java.awt.*;
import java.util.ArrayList;

public interface IMap {

    Color getColor(int x, int y);

    void setColor(int x, int y, Color color);

    ICell getLocation(int x, int y);

    int[] getPosition(ICell cell);

    void colorCells(ArrayList<ICell> cells, Color color);

    void getCellsToColor();

}
