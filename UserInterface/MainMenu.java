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

    public MainMenu(){
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        button.setBounds(200, 100, 100, 50);
        buttonAction();

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
}
