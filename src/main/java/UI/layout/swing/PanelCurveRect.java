package UI.layout.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PanelCurveRect extends JComponent{
    public PanelCurveRect(){

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        g2d.dispose();
    }

}
