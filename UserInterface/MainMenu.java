package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {

    JFrame frame = new JFrame();
    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();

    JButton button7 = new JButton("7 Days");
    JButton button14 = new JButton("14 Days");
    JButton button30 = new JButton("30 Days");
    JButton buttonEnd = new JButton("Endless");
    JButton buttonBack = new JButton("Back");
    JButton buttonGame = new JButton("New Game");
    JButton buttonInstruct = new JButton("Instructions");
    JButton buttonExit = new JButton("Exit");

    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public MainMenu(){
        JLabel label = new JLabel("Lemonade Stand");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(75, 25, 75, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(120, 600, 120, 600));
        panel1.setLayout(new GridLayout(0,1, 20, 20));;
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));

        label.setFont(new Font("MV Boli", Font.BOLD, 80));
        label.setForeground(new Color(0x123456));
        label.setHorizontalTextPosition(JLabel.CENTER);

        customButton(buttonGame, 25, Color.darkGray);
        customButton(buttonInstruct, 25, Color.darkGray);
        customButton(buttonExit, 25, Color.darkGray);

        panel.add(label, BorderLayout.NORTH);
        panel1.add(buttonGame, BorderLayout.CENTER);
        panel1.add(buttonInstruct, BorderLayout.CENTER);
        panel1.add(buttonExit, BorderLayout.CENTER);
        
        newGameAction();
        instructAction();
        exitAction();

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lemonade Stand");
        frame.setIconImage(image.getImage());
        frame.setUndecorated(false);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        device.setFullScreenWindow(frame);
    }

    public void newGameAction(){
        buttonGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JLabel label = new JLabel("Lemonade Stand");
                JLabel label1 = new JLabel("How long would you like to play?");
                JPanel panel = new JPanel();
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
                panel.setBackground(new Color(0xF1E592));

                panel1.setBorder(BorderFactory.createEmptyBorder(100, 600, 100, 600));
                panel1.setLayout(new GridLayout(0,1, 10, 10));
                panel1.setBackground(new Color(0xF1E592));

                label.setFont(new Font("Comic Sans", Font.BOLD, 55));
                label.setForeground(Color.red);
                label.setHorizontalTextPosition(JLabel.CENTER);

                label1.setFont(new Font("MV Boli", Font.BOLD, 19));
                label1.setForeground(new Color(0x123456));
                label1.setHorizontalTextPosition(JLabel.CENTER);

                customButton(button7, 25, Color.green);
                customButton(button14, 25, Color.orange);
                customButton(button30, 25, Color.red);
                customButton(buttonEnd, 25, Color.black);
                customButton(buttonBack, 25, Color.darkGray);
                
                panel.add(label);
                panel1.add(label1);
                panel1.add(button7);
                panel1.add(button14);
                panel1.add(button30);
                panel1.add(buttonEnd);
                panel1.add(buttonBack);
                
                gameAction(button7);
                gameAction(button14);
                gameAction(button30);
                gameAction(buttonEnd);
                backAction(frame1);
                
                frame1.add(panel, BorderLayout.NORTH);
                frame1.add(panel1, BorderLayout.CENTER);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setTitle("Lemonade Stand");
                frame1.setIconImage(image.getImage());
                frame1.setUndecorated(false);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setVisible(true);
                device.setFullScreenWindow(frame1);
                frame.dispose();
            }
        });
    }

    public void instructAction(){
        buttonInstruct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JLabel label = new JLabel("How to play");
                JLabel label1 = new JLabel("""
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
                
                label.setFont(new Font("MV Boli", Font.BOLD, 35));
                label1.setFont(new Font("Consolas", Font.BOLD, 16));
                label.setForeground(Color.red);
                label1.setForeground(new Color(0x123456));
                label.setHorizontalTextPosition(JLabel.CENTER);

                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));
                customButton(buttonBack, 20, Color.darkGray);

                panel.add(label, BorderLayout.PAGE_START);
                panel.add(label1, BorderLayout.CENTER);
                panel1.add(buttonBack, BorderLayout.PAGE_END);
                backAction(frame2);

                frame2.add(panel, BorderLayout.CENTER);
                frame2.add(panel1, BorderLayout.SOUTH);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setTitle("Lemonade Stand");
                frame2.setIconImage(image.getImage());
                frame2.setUndecorated(false);
                frame2.setResizable(false);
                frame2.pack();
                frame2.setVisible(true);
                device.setFullScreenWindow(frame2);
                frame.dispose();
            }
        });
    }

    public void gameAction(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new GameView();
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

    public void exitAction(){
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                System.exit(1);
            }
        });  
    }

    public void customButton(JButton button, int size, Color color){
        button.setFont(new Font("Comic Sans", Font.BOLD, size));
        button.setForeground(Color.white);
        button.setBackground(color);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
    }
}