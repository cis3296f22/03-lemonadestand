package UserInterface;

import javax.imageio.ImageIO;
import javax.management.ConstructorParameters;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.InterruptedException;
import java.text.DecimalFormat;
import java.util.Random;

public class GameView extends JFrame {
    DecimalFormat df = new DecimalFormat("0.00");

    JFrame frame = new JFrame();
    JLabel background = new JLabel();
    JLabel walker = new JLabel();
    String[] rightSideCustomers = {"girlWalkingDog3Resized.png","guyWalking2Resized.png", "guyWalkingResized.png"};
    String[] leftSideCustomers = {"girlWalking2Resized.png","girlWalkingResized.png", "guyWalkingDogResized.png"};
    JLabel gameText = new JLabel();
    JLabel weatherText = new JLabel();
    JLabel inventory = new JLabel();

    // label for in-game messages
    JLabel customerMessage = new JLabel();

    //animation Variables
    Timer timer;
    int animationX = 0;
    int animationY = 0;
    int xVelocity = 1;

    /*int money;
    int lemons;
    int sugar;
    int cups;
    int ice;*/
    int temperature = 0;
    String weather = "Sunny";
    int currentDay;
    String totalDays;

    private JPanel panel1;

    JLayeredPane layeredPane = new JLayeredPane();
    ImageIcon image = new ImageIcon("src/UserInterface/LemonIcon.png");

    public GameView(LemonadeStandModel ls) throws InterruptedException {

        // set up dummy lemonade stand
        //ls = new LemonadeStandModel();
        //ls.setInventory(100, 100, 50, 50);
        // ls.setRecipe(2, 4, 2, 1);

        customerMessage.setForeground(Color.WHITE);

        loadGameText(ls); //sets up initial game display,
        loadBackground(); //loading in background image for game
        loadWalker(); //load customer

        //using a layered pane to order z-index of components
        layeredPane.setBounds(0,0, 800,800);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(gameText, Integer.valueOf(1));
        layeredPane.add(weatherText, Integer.valueOf(1));
        layeredPane.add(inventory, Integer.valueOf(1));
        layeredPane.add(customerMessage, Integer.valueOf(1));

        //adding info to frame
        frame.setTitle("Lemonade Stand");
        frame.setIconImage(image.getImage());
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exits app on close
        frame.setSize(650,550); //setting frame size
        frame.getContentPane().setBackground(new Color(0xF1E592));
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        //frame.pack();

        System.out.println("Window size: " + frame.getWidth());

        int customers = 0;
        while(customers < 20){
            customerAnimationThread a = new customerAnimationThread(walker, 0, 200, 200, 200, ls);
            a.execute();
            int rnd = (int) ( Math.random() * 2000 + 350);

            Thread.sleep(rnd);
            customers++;
            System.out.println("num customers: " + customers);
        }

    }

    /*public static void main(String[] args) throws InterruptedException {
        new GameView();
    }*/

    public void loadBackground(){

        String path = System.getProperty("user.dir");
        System.out.println(path + File.separator + "src/UserInterface" + File.separator + "frontYardWithStand.jpg");

        //Setting image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path + File.separator + "src/UserInterface" + File.separator + "frontYardWithStand.jpg")); //Can change depending on weather
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon backgroundImage = new ImageIcon(img);
        background.setIcon(backgroundImage);


        //sets position of label
        background.setVerticalAlignment(JLabel.TOP);
        background.setBounds(15,15, 600,400);
    }

    private void loadGameText(LemonadeStandModel ls){
        //text display game information
        gameText.setText("<html>Day " + ls.getCurrentDay() + " of " + ls.getTotalDay() + "<br />Money: $" + df.format(ls.getMoney()) + "</html>"); // add variables
        gameText.setBounds(15,440,200,50); // sets text position
        gameText.setFont(new Font("Georgia", Font.BOLD, 20));

        weatherText.setText("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>"); //add variables
        weatherText.setBounds(400, 440, 200, 50);
        weatherText.setFont(new Font("Georgia", Font.BOLD, 20));

        inventory.setText("<html><pre> Cups: " + ls.getCups() + "  Ice: " + ls.getIce() + "  Lemons: " + ls.getLemons() + "  Sugar: " + ls.getSugar() + " </pre></html>");
        inventory.setBounds(75, 375, 495, 25);
        inventory.setFont(new Font("Georgia", Font.BOLD, 16));
        inventory.setBackground(new Color(0xDEE3E3));
        inventory.setOpaque(true);

        // customer message on cup sold / not sold
        //customerMessage.setText("<html>Message: </html>");
        customerMessage.setBounds(200, 225, 500, 25);
        customerMessage.setFont(new Font("Georgia", Font.BOLD, 20));


        Border invBorder = BorderFactory.createLineBorder(Color.BLACK, 2, true);
        inventory.setBorder(invBorder);
    }


    private void loadWalker(){
        String path = System.getProperty("user.dir");
        System.out.println(path + File.separator + "src/UserInterface" + File.separator + "stickFigAnimTest.png");

        //Setting image
        BufferedImage walkerImg = null;
        try {
            walkerImg = ImageIO.read(new File(path + File.separator + "src/UserInterface" + File.separator + "smallStickFig.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon walkerIcon = new ImageIcon(walkerImg);
        walker.setIcon(walkerIcon);
        walker.setBounds(0,200,walker.getIcon().getIconWidth(),walker.getIcon().getIconHeight());

    }


    private void increaseMoney(){
        //money += 1;
        //System.out.println(money);
    }

    private class customerAnimationThread extends SwingWorker{

        private JLabel customer;
        LemonadeStandModel ls;
        String path;
        private int xPos, yPos, customerWidth, customerHeight;
        public customerAnimationThread(JLabel j, int xPosition, int yPosition, int width, int height, LemonadeStandModel temp){
            path = System.getProperty("user.dir");
            customer = new JLabel();
            xPos = xPosition;
            yPos = yPosition;
            customerWidth = width;
            customerHeight = height;
            ls = temp;
        }

        @Override
        protected Object doInBackground() throws Exception {

            int rnd = (int) ( Math.random() * 2 + 1);
            int rndSide = (int) ( Math.random() * 2 + 1);

            try {
                Thread.sleep(100);

                // trying to get message to fade after it shows up
                /*double faded = 1.0;
                while(faded > 0.2){
                    faded = faded - 0.1;
                    customerMessage.setForeground(new Color(0, 0, 0, (float)faded));
                    Thread.sleep(100);
                    System.out.println("Fade is now " + (float)faded);
                }*/

                if (rndSide == 1) {
                    loadLeftWalker();
                    customer.setBounds(0, yPos, customerWidth, customerHeight);
                    layeredPane.add(customer, Integer.valueOf(2));
                    while(xPos<650){

                        if(xPos == 275){ //if walker is at lemonade stand
                            // purhcase cup
                            if(rnd == 1) {
                                Thread.sleep(100);
                                ls.sellCup();
                                gameText.setText("<html>Day 1 of 7<br />Money: $" + df.format(ls.getMoney()) + "</html>"); // add variable
                                inventory.setText("<html><pre> Cups: " + ls.getCups() + "  Ice: " + ls.getIce() + "  Lemons: " + ls.getLemons() + "  Sugar: " + ls.getSugar() + " </pre></html>");
                                customerMessage.setForeground(Color.GREEN);
                                customerMessage.setText("<html>Cup Sold!</html>");
                                System.out.printf("Current Money: %.2f", ls.getMoney());
                            } else {
                                System.out.println("Ew! I dont want that lemonade...");
//                                customerMessage.setForeground(Color.RED);
//                                customerMessage.setText("<html>Ew! I don't want that lemonade..." + "</html>");
                            }

                        }
                        else if(xPos == 515){
                            customer.setVisible(false);
                        }
                        xPos += 1;
                        Thread.sleep(2);
                        customer.setBounds(xPos, yPos, customerWidth, customerHeight);
                    }
                }else{ //Customers moving from right to left
                    xPos = 525;
                    loadRightWalker();
                    customer.setBounds(xPos, yPos, customerWidth, customerHeight);
                    layeredPane.add(customer, Integer.valueOf(2));
                    while(xPos>-100){
                        if(xPos == 275){ //if walker is at lemonade stand
                            // purhcase cup
                            if(rnd == 1) {
                                Thread.sleep(100);
                                ls.sellCup();
                                gameText.setText("<html>Day 1 of 7<br />Money: $" + df.format(ls.getMoney()) + "</html>"); // add variable
                                inventory.setText("<html><pre> Cups: " + ls.getCups() + "  Ice: " + ls.getIce() + "  Lemons: " + ls.getLemons() + "  Sugar: " + ls.getSugar() + " </pre></html>");
                                customerMessage.setForeground(Color.GREEN);
                                customerMessage.setText("<html>Cup Sold!</html>");
                                System.out.println("Current Money: " + ls.getMoney());
                            } else {
                                System.out.println("Ew! I dont want that lemonade...");
//                                customerMessage.setForeground(Color.RED);
//                                customerMessage.setText("<html>Ew! I don't want that lemonade..." + "</html>");
                            }

                        }else if(xPos == 0){
                            customer.setVisible(false);
                        }

                        xPos -= 1;
                        Thread.sleep(2);
                        customer.setBounds(xPos, yPos, customerWidth, customerHeight);
                    }
                }

                // for now, just set to empty message
                customerMessage.setText("<html></html>");
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Interruption Exception thrown");
            }

            return null;
        }

        private void loadLeftWalker(){
            int rndIndex = new Random().nextInt(leftSideCustomers.length);
            String pic = leftSideCustomers[rndIndex];

            String path = System.getProperty("user.dir");
            //Setting image
            BufferedImage walkerImg = null;
            try {
                walkerImg = ImageIO.read(new File(path + File.separator + "src/UserInterface" + File.separator + pic));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon walkerIcon = new ImageIcon(walkerImg);
            customer.setIcon(walkerIcon);
            customer.setBounds(0,200,customer.getIcon().getIconWidth(),customer.getIcon().getIconHeight());

        }

        private void loadRightWalker(){
            int rndIndex = new Random().nextInt(rightSideCustomers.length);
            String pic = rightSideCustomers[rndIndex];

            String path = System.getProperty("user.dir");
            //Setting image
            BufferedImage walkerImg = null;
            try {
                walkerImg = ImageIO.read(new File(path + File.separator + "src/UserInterface" + File.separator + pic));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon walkerIcon = new ImageIcon(walkerImg);
            customer.setIcon(walkerIcon);
            customer.setBounds(0,200,customer.getIcon().getIconWidth(),customer.getIcon().getIconHeight());

        }

    }

}
