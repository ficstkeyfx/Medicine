package view.custom;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Button extends JButton {
    private Animator animator;
    private int targetSize;
    private float animatSize;
    private Point pressedPoint;
    private float alpha;
    private Color effectColor = new Color(32, 136, 203);
    private Color overColor = new Color(255, 218, 0);

    private float ovalH = 1;

    public void setOverColor(Color overColor) {
        this.overColor = overColor;
    }
    public Color getOverColor() {
        return overColor;
    }
    public Color getEffectColor() {
    return effectColor;
}
    public void setEffectColor(Color effectColor) {
    this.effectColor = effectColor;
}
    public void setOvalH(float ovalH) {
        this.ovalH = ovalH;
    }

    public void setEnabled(boolean x){
        super.setEnabled(x);
        if(x==false) {
            setBackground(effectColor);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(effectColor);
                    targetSize = Math.max(getWidth(), getHeight()) * 2;
                    animatSize = 0;
                    pressedPoint = e.getPoint();
                    alpha = 0.5f;
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    animator.start();
                }
                public void mouseEntered(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(effectColor);
                }
                public void mouseExited(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(effectColor);
                }
            });
        }else{
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    targetSize = Math.max(getWidth(), getHeight()) * 2;
                    animatSize = 0;
                    pressedPoint = me.getPoint();
                    alpha = 0.5f;
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    animator.start();
                }
                public void mouseEntered(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(overColor);
                }
                public void mouseExited(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(effectColor);
                }
            });
        }
    }
    
    public Button() {
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(5, 0, 5, 0));
            setBackground(effectColor);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    targetSize = Math.max(getWidth(), getHeight()) * 2;
                    animatSize = 0;
                    pressedPoint = me.getPoint();
                    alpha = 0.5f;
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    animator.start();
                }
                public void mouseEntered(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(overColor);
                }
                public void mouseExited(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(effectColor);
                }
            });
            TimingTarget target = new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    if (fraction > 0.5f) {
                        alpha = 1 - fraction;
                    }
                    animatSize = fraction * targetSize;
                    repaint();
                }
            };
            animator = new Animator(700, target);
            animator.setAcceleration(0.5f);
            animator.setDeceleration(0.5f);
            animator.setResolution(0);
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            int width = getWidth();
            int height = getHeight();
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            if(ovalH == 0)
                g2.fillRoundRect(0, 0, width, height, 0,0);
            else
                g2.fillRoundRect(0, 0, width, height, height/2, height/2);
            if (pressedPoint != null) {
                g2.setColor(effectColor);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
                g2.fillOval((int) (pressedPoint.x - animatSize / 2), (int) (pressedPoint.y - animatSize / 2), (int) animatSize, (int) animatSize);
            }
            g2.dispose();
            grphcs.drawImage(img, 0, 0, null);
            super.paintComponent(grphcs);
    }

}
