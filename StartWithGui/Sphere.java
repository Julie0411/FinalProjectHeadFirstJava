package StartWithGui;

import javax.swing.*;
import java.awt.*;

public class Sphere extends JPanel {
    private JButton button;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }

    private static void sphere() {
        JFrame frame = new JFrame("Sphere with Gradient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sphere spherePanel = new Sphere();
        frame.add(spherePanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> sphere());
    }
}
