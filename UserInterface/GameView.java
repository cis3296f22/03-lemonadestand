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

public class GameView extends JFrame {

    JFrame frame = new JFrame();
    JLabel background = new JLabel();
    JLabel gameText = new JLabel();
    JLabel weatherText = new JLabel();
    JLabel inventory = new JLabel();
    Button testButton = new Button();
    int money = 0;

    private JPanel panel1;

    JLayeredPane layeredPane = new JLayeredPane();

    public GameView() {

        //REMOVE
        testButton.setBounds(200,440,40,25);
        testButton.addActionListener(e -> {
            money += 1;
            gameText.setText("<html>Day 1 of 7<br />Money: $" + money + "</html>"); // add variable
            System.out.println(money);
        });

        //text display game information
        gameText.setText("<html>Day 1 of 7<br />Money: $" + money + "</html>"); // add variable
        gameText.setBounds(15,440,200,50); // sets text position
        gameText.setFont(new Font("Georgia", Font.BOLD, 20));

        weatherText.setText("<html>Temperature: 80&#8457<br />Weather: Sunny</html>"); //add variables
        weatherText.setBounds(400, 440, 200, 50);
        weatherText.setFont(new Font("Georgia", Font.BOLD, 20));

        inventory.setText("<html><pre> Cups: 0  Ice: 0  Lemons: 0  Sugar: 0 </pre></html>");
        inventory.setBounds(150, 375, 460, 25);
        inventory.setFont(new Font("Georgia", Font.BOLD, 20));
        inventory.setBackground(new Color(0xDEE3E3));
        inventory.setOpaque(true);
        Border invBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        inventory.setBorder(invBorder);


        //Setting image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("UserInterface/frontYardNoStand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon backgroundImage = new ImageIcon(img);
        background.setIcon(backgroundImage);


        //sets position of label
        background.setVerticalAlignment(JLabel.TOP);
        background.setBounds(15,15, 600,400);

        //using a layered pane to order z-index of components
        layeredPane.setBounds(0,0, 800,800);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(gameText, Integer.valueOf(1));
        layeredPane.add(weatherText, Integer.valueOf(1));
        layeredPane.add(inventory, Integer.valueOf(1));
        layeredPane.add(testButton, Integer.valueOf(1));

        //adding info to frame
        frame.setTitle("Lemonade Stand");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits app on close
        frame.setSize(650,550); //setting frame size
        frame.getContentPane().setBackground(new Color(0xF1E592));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        //frame.pack();


    }

    public static void main(String[] args) {
        new GameView();
    }

    private void increaseMoney(){
        money += 1;
        System.out.println(money);
    }

}
