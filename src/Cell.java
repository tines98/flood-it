import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.CollationKey;
import java.util.ArrayList;
import java.util.Random;

public class Cell extends JPanel implements ICell {

    private Color color;
    private int x, y;
    private ArrayList<Color> colorList;

    public Cell(int x, int y){
        colorList = Main.colors;
        color = initColor();
        this.x = x;
        this.y = y;
    }

    Color initColor(){
        Random r = new Random();
        return colorList.get(r.nextInt(colorList.size()));
//        return new Color(r.nextFloat(),r.nextFloat(), r.nextFloat());
    }

    @Override
    public int[] getPosition() {
        int[] position = new int[2];
        position[0] = x;
        position[1] = y;
        return position;
    }

    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public void setColor(Color color){
        this.color = color;
    }

    @Override
    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fillRect(getX(),getY(),getWidth(),getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawRect(getX(),getY(),getWidth(),getHeight());
    }
}
