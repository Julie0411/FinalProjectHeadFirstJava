package StartWithGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimpleGui {
    private JFrame frame;
    private JLabel label;
    private int xPos = 70;
    private int yPos = 70;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton colorButton = new JButton("Change colors");
        colorButton.addActionListener(event -> frame.repaint());

        MyDrawPanel drawPanel = new MyDrawPanel();
        JButton labelButton = new JButton("Change label");

        labelButton.addActionListener(event -> label.setText("Ouch!"));
        label = new JLabel("I'm a label");

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(500, 400);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            xPos++;
            yPos++;

            drawPanel.repaint();

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Random random = new Random();
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(xPos, yPos, 40, 40);
        }
    }
}