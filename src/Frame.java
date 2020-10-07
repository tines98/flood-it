import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Frame extends JFrame implements IGame {

    private Timer t;
    private Map map;
    private int clicks;
    private int size;
    private int screenSize;
    private int tries;

    Frame(int size, int tries) {
        super();
        this.size = size;
        clicks = 0;
        this.tries = tries;
        t = new Timer(33, actionEvent -> repaint());
        addMouseListener(new MyMouseListener());
        setLayout(new GridLayout(1, 1));
        map = new Map(size);
        add(map);
        t.setRepeats(true);
        screenSize = 500 - (500%size);
        setSize(screenSize, screenSize+30);
        setTitle("Tines's Custom Made Color Fuckery");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void run() {
        t.start();
        setVisible(true);
    }

    @Override
    public void close() {
        t.stop();
        setVisible(false);
        System.exit(1);
    }

    @Override
    public IMap getMap() {
        return map;
    }

    @Override
    public ICell getLocation(int x, int y) {
        return map.getLocation(x, y);
    }

    @Override
    public Color getColor(int x, int y) {
        return map.getColor(x, y);
    }

    @Override
    public void setColor(int x, int y, Color color) {
        map.setColor(x, y, color);
    }

    @Override
    public int[] getPosition(ICell cell) {
        return map.getPosition(cell);
    }

    @Override
    public void checkWin() {
        Color colorCheck = getColor(0, 0);
        if (clicks > tries){
            System.out.println("YOU LOSE");
            System.exit(1);
        }
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (!getColor(x, y).equals(colorCheck)) return;
            }
        }
        System.out.println("YOU WIN IN " +clicks+" CLICKS!");
        System.exit(1);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        setTitle(clicks+"/"+tries+" clicks used");
    }

    @Override
    public void colorCells(ArrayList<ICell> cells, Color color) {
        map.colorCells(cells, color);
    }

    @Override
    public void getCellsToColor() {
        map.getCellsToColor();
    }

    public class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            int x = mouseEvent.getX()/(screenSize/size);
            int y = (mouseEvent.getY()-30)/(screenSize/size);
            Color colorTo = getColor(x,y);
            if (!colorTo.equals(getColor(0,0))) {
                clicks++;
                getCellsToColor();
                getCellsToColor();
                colorCells(map.infectedCells, colorTo);
                checkWin();
            }
        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
