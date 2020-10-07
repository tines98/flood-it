import javax.swing.*;
import java.awt.*;

public interface ICell{
    Color getColor();

    void setColor(Color color);

    void draw(Graphics graphics);

    int[] getPosition();
}
