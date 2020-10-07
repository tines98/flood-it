import java.awt.*;
import java.util.ArrayList;

public interface IGame {

    void run();

    void close();

    IMap getMap();

    ICell getLocation(int x, int y);

    Color getColor(int x, int y);

    void setColor(int x, int y, Color color);

    int[] getPosition(ICell cell);

    void checkWin();

    void colorCells(ArrayList<ICell> cells, Color color);

    void getCellsToColor();

}
