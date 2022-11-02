package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
    public static void main(String[] args){
        new MainMenu();
    }

    JFrame frame = new JFrame();
    JFrame frame1 = new JFrame();
    JFrame frame2 = new JFrame();

    JButton button7 = new JButton("7 Days");
    JButton button14 = new JButton("14 Days");
    JButton button30 = new JButton("30 Days");
    JButton buttonEnd = new JButton("Endless");
    JButton buttonBack = new JButton("Back");
    JButton button = new JButton("New Game");
    JButton buttoninstruct = new JButton("Instructions");
    JButton buttonExit = new JButton("Exit");

    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public MainMenu(){
        JLabel label = new JLabel("Lemonade Stand");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));
        panel1.setBorder(BorderFactory.createEmptyBorder(100, 600, 100, 600));
        panel1.setLayout(new GridLayout(0,1));;
        panel.setBackground(new Color(0x123456));
        panel1.setBackground(new Color(0x123456));

        label.setForeground(Color.YELLOW);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.BOLD, 80));

        panel.add(label, BorderLayout.NORTH);
        panel1.add(button, BorderLayout.CENTER);
        panel1.add(buttoninstruct, BorderLayout.CENTER);
        panel1.add(buttonExit, BorderLayout.CENTER);
        
        buttonAction();
        buttoninstruction();
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

    public void buttonAction(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JLabel label = new JLabel("How Many Days?");
                JPanel panel = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(200, 600, 200, 600));
                panel.setLayout(new GridLayout(0,1));
                panel.setBackground(new Color(0x123456));

                label.setForeground(Color.YELLOW);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setFont(new Font("MV Boli", Font.BOLD, 35));

                panel.add(label);
                panel.add(button7);
                panel.add(button14);
                panel.add(button30);
                panel.add(buttonEnd);
                panel.add(buttonBack);
                backAction(frame1);

                frame1.add(panel, BorderLayout.CENTER);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setTitle("New Game");
                frame1.setIconImage(image.getImage());
                frame1.getContentPane().setBackground(new Color(0x123456));
                frame1.setUndecorated(false);
                frame1.setResizable(false);
                frame1.pack();
                frame1.setVisible(true);
                device.setFullScreenWindow(frame1);
            }
        });
    }

    public void buttoninstruction(){
        buttoninstruct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
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
                    Keep an eye on passing customers. Symbols or words appear over their heads indicating whether they like or dislike your lemonade, or if they think your prices are fair. Always try to please the customers.</html>""");
                
                label.setForeground(Color.YELLOW);
                label1.setForeground(Color.GREEN);
                label.setHorizontalTextPosition(JLabel.CENTER);
                label.setFont(new Font("MV Boli", Font.BOLD, 35));
                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel.setBackground(new Color(0x123456));
                panel1.setBackground(new Color(0x123456));

                panel.add(label, BorderLayout.PAGE_START);
                panel.add(label1, BorderLayout.CENTER);
                panel1.add(buttonBack, BorderLayout.PAGE_END);
                buttonBack.setSize(250, 100);
                backAction(frame2);

                frame2.add(panel, BorderLayout.CENTER);
                frame2.add(panel1, BorderLayout.SOUTH);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setTitle("How To Play");
                frame2.setIconImage(image.getImage());
                frame2.setUndecorated(false);
                frame2.setResizable(false);
                frame2.pack();
                frame2.setVisible(true);
                device.setFullScreenWindow(frame2);
            }
        });
    }

    public void backAction(JFrame backFrame){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backFrame.dispose();
                new MainMenu();
            }
        });  
    }

    public void exitAction(){
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.exit(1);
            }
        });  
    }
}
