package UI.layout.swing;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class GradientBackgroundPanel extends JPanel {
    Color startColor;
    Color endColor;
    public GradientBackgroundPanel(){
        startColor = new Color(154, 125, 243);
        endColor = new Color(236, 225, 152);
    }

    public GradientBackgroundPanel(Color st, Color end){
        setLayout(new GridLayout(1, 1));
        this.startColor = st;
        this.endColor = end;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        float frac = 0.8f;
        GradientPaint paint = new GradientPaint(0, 0, startColor,
                width*frac, height*frac, endColor);
        g2d.setPaint(paint);
        g2d.fillRect(0, 0, width, height);
    }

}

