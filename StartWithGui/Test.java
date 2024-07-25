package StartWithGui;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {

    private static JButton button;
    public Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
    }

    public static void main(String[] args) {
        Test frame = new Test();

        button = new JButton("Huhuhu");

        frame.getContentPane().add(button, BorderLayout.CENTER);

        button.addActionListener(e -> {
            if (button.getText().equalsIgnoreCase("Huhuhu")) {
                button.setText("hahaha");
            } else {
                button.setText("Huhuhu");
            }
            System.out.println("Brurumarmato");
        });

        frame.setVisible(true);
    }
}
