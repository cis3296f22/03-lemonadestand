package UserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class pricing extends JFrame{
    int price_per_cup = 0;
    int lemons = 0;
    int sugar = 0;
    int ice = 0;

    JFrame frame = new JFrame();
    JLabel background = new JLabel();
    Button increase = new Button();
    Button decrease = new Button();

    JLabel ppc = new JLabel();
    JLabel amtlemon = new JLabel();
    JLabel amtsugar = new JLabel();
    JLabel amtice = new JLabel();

    public static void main(String[] args) {
        new pricing();
    }

    public void pricing(){
        JLabel label = new JLabel("Price/Quality Control");
        ppc.setText("Price per Cup: " + price_per_cup + "Cents");
        amtlemon.setText("Lemons per Pitcher" + lemons + "Lemons");
        amtsugar.setText("Sugar per Pitcher: " + sugar + "Cups");
        amtice.setText("Ice per Cup: " + ice + "Cubes");
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setBackground(new Color(0xF1E592));
        panel.add(label, BorderLayout.PAGE_START);
        panel.add(label1, BorderLayout.CENTER);
        
    }
}
