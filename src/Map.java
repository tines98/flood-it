import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Map extends JPanel implements IMap{
    int x, y;
    int size;
    Color color;
    Cell[][] map;
    ArrayList<ICell> infectedCells;


    public Map(int size){
        this.size = size;
        map = new Cell[size][size];
        infectedCells = new ArrayList<>();
        setLayout(new GridLayout(size,size));
        createMap();
        infectedCells.add(getLocation(0,0));
    }

    void createMap(){
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Cell temp = new Cell(x,y);
                map[y][x] = temp;
                add(temp);
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (Cell[] row: map) {
            for (Cell cell: row) {
                cell.draw(graphics);
            }
        }
//        graphics.drawRect(450,450,50,50);
    }

    @Override
    public Color getColor(int x, int y) {
        return map[y][x].getColor();
    }

    @Override
    public void setColor(int x, int y, Color color) {
        map[y][x].setColor(color);
    }

    public void addToInfected(ICell cell){
        if (!infectedCells.contains(cell)){
            infectedCells.add(cell);
        }
    }

    @Override
    public ICell getLocation(int x, int y) {
        return map[y][x];
    }

    @Override
    public int[] getPosition(ICell cell) {
        return cell.getPosition();
    }

    @Override
    public void colorCells(ArrayList<ICell> cells, Color color) {
        for (ICell cell: cells) {
            cell.setColor(color);
        }
    }

    public void getSameColoredNeighbours(int x, int y) {
        ArrayList<ICell> cells = new ArrayList<>();
        Color color = getColor(x,y);
        if (x != 0){
            if (getColor(x-1,y).equals(color)){
                addToInfected(getLocation(x-1,y));
            }
        }
        if (x != size-1){
            if (getColor(x+1,y).equals(color)){
                addToInfected(getLocation(x+1,y));
            }
        }
        if (y != 0){
            if (getColor(x,y-1).equals(color)){
                addToInfected(getLocation(x,y-1));
            }
        }
        if (y != size-1){
            if (getColor(x,y+1).equals(color)){
                addToInfected(getLocation(x,y+1));
            }
        }
    }

    @Override
    public void getCellsToColor() {
        for (int i = 0; i < infectedCells.size(); i++) {
            int x = infectedCells.get(i).getPosition()[0];
            int y = infectedCells.get(i).getPosition()[1];
            getSameColoredNeighbours(x,y);
        }
    }
}
