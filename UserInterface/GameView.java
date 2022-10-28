package UserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameView extends JFrame {


    JFrame frame = new JFrame();
    JLabel background = new JLabel();

    private ImageIcon backgroundImage;

    public GameView() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("UserInterface/sunnyNeighborhood.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //setting image
        backgroundImage = new ImageIcon(img);
        background.setIcon(backgroundImage);


        //adding label with image to frame
        frame.add(background);

        frame.setTitle("Lemonade Stand");
        frame.setSize(600,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GameView();
    }



}
