package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
    JFrame mainFrame = new JFrame();
    JFrame gameFrame = new JFrame();
    JFrame instructFrame = new JFrame();

    JButton button7 = new JButton("7 Days");
    JButton button14 = new JButton("14 Days");
    JButton button30 = new JButton("30 Days");
    JButton buttonEnd = new JButton("Endless");
    JButton buttonBack = new JButton("Back");
    JButton buttonGame = new JButton("New Game");
    JButton buttonInstruct = new JButton("Instructions");
    JButton buttonExit = new JButton("Quit");

    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public MainMenu(){
        JLabel headLabel = new JLabel("Lemonade Stand");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(100, 25, 75, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(75, 650, 150, 650));
        panel1.setLayout(new GridLayout(0,1, 0, 30));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));

        headLabel.setFont(new Font("MV Boli", Font.BOLD, 80));
        headLabel.setForeground(Color.black);

        customButton(buttonGame, 25, new Color(0,204,0), Color.white);
        customButton(buttonInstruct, 25, Color.orange, Color.white);
        customButton(buttonExit, 25, Color.red, Color.white);

        panel.add(headLabel);
        panel1.add(buttonGame);
        panel1.add(buttonInstruct);
        panel1.add(buttonExit);
        
        newGameAction();
        instructAction();
        quitAction();

        mainFrame.add(panel, BorderLayout.NORTH);
        mainFrame.add(panel1, BorderLayout.CENTER);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Lemonade Stand");
        mainFrame.setIconImage(image.getImage());
        mainFrame.setUndecorated(false);
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
        device.setFullScreenWindow(mainFrame);
    }

    public void newGameAction(){
        buttonGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JLabel headLabel = new JLabel("Lemonade Stand");
                JLabel playLabel = new JLabel("How long would you like to play?");
                JPanel panel = new JPanel();
                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(75, 30, 30, 30));
                panel.setBackground(new Color(0xF1E592));

                panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 0, 100));
                panel1.setBackground(new Color(0xF1E592));

                panel2.setBorder(BorderFactory.createEmptyBorder(0, 675, 75, 675));
                panel2.setLayout(new GridLayout(0,1, 0, 20));
                panel2.setBackground(new Color(0xF1E592));

                headLabel.setFont(new Font("Comic Sans", Font.BOLD, 55));
                headLabel.setForeground(Color.black);
                headLabel.setHorizontalTextPosition(JLabel.CENTER);

                playLabel.setFont(new Font("MV Boli", Font.BOLD, 35));
                playLabel.setForeground(Color.black);
                playLabel.setHorizontalTextPosition(JLabel.CENTER);

                customButton(button7, 35, new Color(0,204,0), Color.white);
                customButton(button14, 35, Color.orange, Color.white);
                customButton(button30, 35, Color.red, Color.white);
                customButton(buttonEnd, 35, Color.black, Color.white);
                customButton(buttonBack, 35, Color.darkGray, Color.white);
                
                panel.add(headLabel);
                panel1.add(playLabel);
                panel2.add(button7);
                panel2.add(button14);
                panel2.add(button30);
                panel2.add(buttonEnd);
                panel2.add(buttonBack);
                
                gameAction(button7);
                gameAction(button14);
                gameAction(button30);
                gameAction(buttonEnd);
                backAction(gameFrame);
                
                gameFrame.add(panel, BorderLayout.NORTH);
                gameFrame.add(panel1, BorderLayout.CENTER);
                gameFrame.add(panel2, BorderLayout.SOUTH);
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setTitle("Lemonade Stand");
                gameFrame.setIconImage(image.getImage());
                gameFrame.setUndecorated(false);
                gameFrame.setResizable(false);
                gameFrame.pack();
                gameFrame.setVisible(true);
                device.setFullScreenWindow(gameFrame);
                mainFrame.dispose();
            }
        });
    }

    public void instructAction(){
        buttonInstruct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JLabel headLabel = new JLabel("How to play");
                JLabel instructLabel = new JLabel("""
                    <html>Weather:<br/>
                    Keep an eye on the forecast. This will help you estimate supplies you will need, how to formulate your lemonade and how much to charge.<br/>
                    <br/>
                    Pricing:<br/>
                    On hotter days, customers will pay more. On colder days, lower your prices to attract customers. You can adjust your price at any time during the day.<br/>
                    <br/>
                    Inventory:<br/>
                    Stock up on cups when the price is low. Keep lemons and sugar stocks fairly low as they can go bad. Ice melts at the end of every day, so buy ice only according to your daily needs.<br/>
                    <br/>
                    Quality:<br/>
                    On colder days, add additional lemons and sugar to your pitchers to entice customers, and reduce ice to save money. On hot days, decrease your lemons and sugar to the default, and increase ice cubes.<br/>
                    <br/>
                    Customers:<br/>
                    Keep an eye on passing customers. Symbols or words appear over their heads indicating whether they like or dislike your lemonade, or if they think your prices are fair. Always try to please the customers.</html>"""
                );
                
                headLabel.setFont(new Font("MV Boli", Font.BOLD, 35));
                instructLabel.setFont(new Font("Consolas", Font.BOLD, 16));
                headLabel.setForeground(Color.red);
                instructLabel.setForeground(Color.black);
                headLabel.setHorizontalTextPosition(JLabel.CENTER);

                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));
                customButton(buttonBack, 20, Color.white, Color.black);

                panel.add(headLabel, BorderLayout.PAGE_START);
                panel.add(instructLabel);
                panel1.add(buttonBack);
                backAction(instructFrame);

                instructFrame.add(panel, BorderLayout.CENTER);
                instructFrame.add(panel1, BorderLayout.SOUTH);
                instructFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                instructFrame.setTitle("Lemonade Stand");
                instructFrame.setIconImage(image.getImage());
                instructFrame.setUndecorated(false);
                instructFrame.setResizable(false);
                instructFrame.pack();
                instructFrame.setVisible(true);
                device.setFullScreenWindow(instructFrame);
                mainFrame.dispose();
            }
        });
    }

    public void gameAction(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase();
                gameFrame.dispose();
            }
        });  
    }

    public void backAction(JFrame backFrame){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new MainMenu();
                backFrame.dispose();
            }
        });  
    }

    public void quitAction(){
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainFrame.dispose();
                System.exit(1);
            }
        });  
    }

    public void customButton(JButton button, int size, Color color, Color color1){
        button.setFont(new Font("Comic Sans", Font.BOLD, size));
        button.setBackground(color);
        button.setForeground(color1);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
    }
}