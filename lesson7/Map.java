
import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    private static Graphics graphics;
    private final static Color colorGrid = Color.BLACK;
    private final static Color colorBackGround = Color.CYAN;

    public static final int MODE_HUM_HUM = 0;
    public static final int MODE_AI_HUM = 1;

    Map() {
        setBackground(colorBackGround);
    }

    private void clearFiled ()
    {
        graphics.setColor(colorBackGround);
        graphics.fillRect(0,0,this.getWidth(),this.getHeight());
    }

    private void drawField(int fieldSizeX, int fieldSizeY)
    {
        graphics.setColor(colorGrid);
        graphics.drawRect(0, 0,this.getWidth()-1, this.getHeight()-1);
        int j=0;
        int step = (this.getWidth()-1) / fieldSizeX;

        for (int i=0; i<=fieldSizeX-1;i++)
        {
            graphics.drawLine(0,j,this.getWidth()-1,j);
            j +=step;
        }

        j=0;
        step = (this.getWidth()-1) / fieldSizeY;
        for (int i=0; i<=fieldSizeY-1;i++)
        {
            graphics.drawLine(j,0,j,this.getHeight()-1);
            j +=step;
        }
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        graphics = this.getGraphics();
        clearFiled();
        drawField(fieldSizeX,fieldSizeY);

    }
}
