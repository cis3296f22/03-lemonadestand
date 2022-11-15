package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
    // creation of LemonadeStand
    LemonadeStandModel ls = new LemonadeStandModel();

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

    public MainMenu(){
        ls.setMoney(20.0);
        System.out.println("Money in main menu:" + ls.getMoney());

        JLabel headLabel = new JLabel("Lemonade Stand");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(60, 25, 50, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 225, 50, 225));
        panel1.setLayout(new GridLayout(0,1, 0, 20));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));

        customLabel(headLabel, "MV Boli", Color.black, 45);
        
        customButton(buttonGame, 25, new Color(0,204,0), Color.white);
        customButton(buttonInstruct, 25, new Color(255,153,0), Color.white);
        customButton(buttonExit, 25, new Color(204, 0, 0), Color.white);

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
        mainFrame.setPreferredSize(new Dimension(650, 550));
        mainFrame.setUndecorated(false);
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setVisible(true);
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

                panel.setBorder(BorderFactory.createEmptyBorder(50, 30, 25, 30));
                panel1.setBorder(BorderFactory.createEmptyBorder(25, 100, 10, 100));
                panel2.setBorder(BorderFactory.createEmptyBorder(10, 250, 30, 250));
                panel2.setLayout(new GridLayout(0,1, 0, 15));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));
                panel2.setBackground(new Color(0xF1E592));

                customLabel(headLabel, "Comic Sans", new Color(204, 0, 0), 35);
                customLabel(playLabel, "MV Boli", Color.black, 25);

                customButton(button7, 25, new Color(0,204,0), Color.white);
                customButton(button14, 25, new Color(255,153,0), Color.white);
                customButton(button30, 25, new Color(204, 0, 0), Color.white);
                customButton(buttonEnd, 25, Color.black, Color.white);
                customButton(buttonBack, 25, Color.darkGray, Color.white);
                
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
                gameFrame.setPreferredSize(new Dimension(650, 550));
                gameFrame.setUndecorated(false);
                gameFrame.setResizable(false);
                gameFrame.pack();
                gameFrame.setVisible(true);
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

                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(50, 25, 10, 25));
                panel1.setBorder(BorderFactory.createEmptyBorder(10, 25, 25, 25));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));

                customLabel(headLabel, "MV Boli", new Color(204, 0, 0), 30);
                customLabel(instructLabel, "Consolas", Color.black, 12);

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
                instructFrame.setPreferredSize(new Dimension(650, 550));
                instructFrame.setUndecorated(false);
                instructFrame.setResizable(false);
                instructFrame.pack();
                instructFrame.setVisible(true);
                mainFrame.dispose();
            }
        });
    }

    public void gameAction(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(ls);
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

    public void customLabel(JLabel label, String font, Color color, int size){
        label.setFont(new Font(font, Font.BOLD, size));
        label.setForeground(color);
    }

    public void customButton(JButton button, int size, Color color, Color color1){
        button.setFont(new Font("Comic Sans", Font.BOLD, size));
        button.setBackground(color);
        button.setForeground(color1);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
    }
}