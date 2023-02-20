package baiTapGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooser {
    public static void main(String[] args) {
        JFrame f = new JFrame("Color");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton button = new JButton("Select Background Color");
        
        ActionListener actionListener = (ActionEvent e) -> {
            Color initBackground = button.getBackground();
            Color background = JColorChooser.showDialog(null, "Color", initBackground);
            if(background != null) {
                button.setBackground(background);
            }
        };
        button.addActionListener(actionListener);
        f.add(button, BorderLayout.CENTER);
        f.setSize(720, 480);
        f.setVisible(true);
    }
}
