package UserInterface;

import javax.imageio.ImageIO;
import javax.management.ConstructorParameters;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.InterruptedException;

public class GameView extends JFrame {

    JFrame frame = new JFrame();
    JLabel background = new JLabel();
    JLabel gameText = new JLabel();
    JLabel weatherText = new JLabel();
    JLabel inventory = new JLabel();

    // label for in-game messages
    JLabel customerMessage = new JLabel();

    Button testButton = new Button();

    LemonadeStandModel ls = new LemonadeStandModel();
    /*int money;
    int lemons;
    int sugar;
    int cups;
    int ice;*/
    int temperature = 0;
    String weather = "Sunny";
    int currentDay = 1;
    String totalDays = "7";

    private JPanel panel1;

    JLayeredPane layeredPane = new JLayeredPane();

    public GameView() throws InterruptedException {

        // set up dummy lemonade stand
        ls = new LemonadeStandModel();
        ls.setInventory(100, 100, 50, 50);
        ls.setRecipe(2, 4, 2, 1);

        //REMOVE
        testButton.setBounds(200,440,40,25);
        testButton.addActionListener(e -> {
            ls.sellCup();
            gameText.setText("<html>Day 1 of 7<br />Money: $" + ls.getMoney() + "</html>"); // add variable
            inventory.setText("<html><pre> Cups: " + ls.getCups() + "  Ice: " + ls.getIce() + "  Lemons: " + ls.getLemons() + "  Sugar: " + ls.getSugar() + " </pre></html>");
            // System.out.println(ls.getMoney());
        });

        //WILL PASS IN PARAMS WHEN INITIALIZED
        loadGameText(); //sets up initial game display,

        loadBackground(); //loading in background image for game

        //using a layered pane to order z-index of components
        layeredPane.setBounds(0,0, 800,800);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(gameText, Integer.valueOf(1));
        layeredPane.add(weatherText, Integer.valueOf(1));
        layeredPane.add(inventory, Integer.valueOf(1));
        layeredPane.add(testButton, Integer.valueOf(1));
        layeredPane.add(customerMessage, Integer.valueOf(1));

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


        int customers = 0;
        while(customers < 20){
            int rnd = (int) ( Math.random() * 2 + 1);

            // purhcase cup
            if(rnd == 1) {
                ls.sellCup();
                gameText.setText("<html>Day 1 of 7<br />Money: $" + ls.getMoney() + "</html>"); // add variable
                inventory.setText("<html><pre> Cups: " + ls.getCups() + "  Ice: " + ls.getIce() + "  Lemons: " + ls.getLemons() + "  Sugar: " + ls.getSugar() + " </pre></html>");
                customerMessage.setText("<html>Cup Sold!</html>");
                System.out.println("Current Money: " + ls.getMoney());
            } else {
                System.out.println("Ew! I dont want that lemonade...");
                customerMessage.setText("<html>Ew! I dont want that lemonade..." + "</html>");
            }

            try {
                Thread.sleep(3000);

                // trying to get message to fade after it shows up
                /*double faded = 1.0;
                while(faded > 0.2){
                    faded = faded - 0.1;
                    customerMessage.setForeground(new Color(0, 0, 0, (float)faded));
                    Thread.sleep(100);
                    System.out.println("Fade is now " + (float)faded);
                }*/

                // for now, just set to empty message  
                customerMessage.setText("<html></html>");
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Interruption Exception thrown");
            }

            customers++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new GameView();
    }

    public void loadBackground(){

        String path = System.getProperty("user.dir");
        System.out.println(path + File.separator + "UserInterface" + File.separator + "frontYardNoStand.jpg");

        //Setting image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path + File.separator + "UserInterface" + File.separator + "frontYardNoStand.jpg")); //Can change depending on weather
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon backgroundImage = new ImageIcon(img);
        background.setIcon(backgroundImage);


        //sets position of label
        background.setVerticalAlignment(JLabel.TOP);
        background.setBounds(15,15, 600,400);
    }

    private void loadGameText(){
        //text display game information
        gameText.setText("<html>Day " + currentDay + " of " + totalDays + "7<br />Money: $" + ls.getMoney() + "</html>"); // add variables
        gameText.setBounds(15,440,200,50); // sets text position
        gameText.setFont(new Font("Georgia", Font.BOLD, 20));

        weatherText.setText("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>"); //add variables
        weatherText.setBounds(400, 440, 200, 50);
        weatherText.setFont(new Font("Georgia", Font.BOLD, 20));

        inventory.setText("<html><pre> Cups: " + ls.getCups() + "  Ice: " + ls.getIce() + "  Lemons: " + ls.getLemons() + "  Sugar: " + ls.getSugar() + " </pre></html>");
        inventory.setBounds(150, 375, 460, 25);
        inventory.setFont(new Font("Georgia", Font.BOLD, 20));
        inventory.setBackground(new Color(0xDEE3E3));
        inventory.setOpaque(true);

        // customer message on cup sold / not sold
        customerMessage.setText("<html>Message: </html>");
        customerMessage.setBounds(200, 225, 500, 25);
        customerMessage.setFont(new Font("Georgia", Font.BOLD, 20));


        Border invBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        inventory.setBorder(invBorder);
    }

    private void increaseMoney(){
        //money += 1;
        //System.out.println(money);
    }

}
