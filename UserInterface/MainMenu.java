package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu {
    public static void main(String [] args){
        new MainMenu();
    }

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button = new JButton("New Game");
    JButton buttoninstruct = new JButton("Instructions");

    public MainMenu(){
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(buttoninstruct);
        button.setBounds(200, 100, 100, 50);
        buttonAction();
        buttoninstruction();

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setTitle("Lemonade Stand Game");
        frame.pack();
        frame.setVisible(true);
    }

    public void buttonAction(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JLabel label = new JLabel("How many days?");
                JFrame frame = new JFrame();
                JPanel panel = new JPanel();
                JButton button7 = new JButton("7 Days");
                JButton button14 = new JButton("14 Days");
                JButton button30 = new JButton("30 Days");
                
                panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
                panel.setLayout(new GridLayout(0, 1));
                panel.add(label);
                panel.add(button7);
                panel.add(button14);
                panel.add(button30);

                frame.add(panel, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setTitle("New Game");
                frame.pack();
                frame.setVisible(true);
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
                JFrame frame = new JFrame();
                JPanel panel = new JPanel(new BorderLayout());

                panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
                panel.setLayout(new GridLayout(0, 1));
                panel.add(label, BorderLayout.PAGE_START);
                panel.add(label1, BorderLayout.CENTER);

                frame.add(panel, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.setTitle("How To Play");
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
