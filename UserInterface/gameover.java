package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class gameover extends JFrame{
    double money = 20.00;
    double expenses = 0.00;
    double invalue = 0.00;
    double net = 0.00;
    int lemons = 0;
    int cups = 0;
    int sugar = 0;

    //values for the bottom itesm
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");
    //buttons to go back
    JFrame inventoryFrame = new JFrame();
    JButton buttonBack = new JButton("Play Again?");
    //label for items
    JLabel headLabel = new JLabel("End of Season Report", SwingConstants.CENTER);
    JLabel inco = new JLabel("Total Income: ");
    JLabel exp = new JLabel("Total Expenses: ");
    JLabel liq = new JLabel("Liquidated Inventory Value: ");
    JLabel line = new JLabel("---------------------------------------------------------");
    JLabel prof = new JLabel("Net Profit/Loss: ");
    //bottom items
    JLabel dayLabel = new JLabel("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(money) + "</html>", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    //makes it look good
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public static void main(String[] args) {
        new gameover();
    }

    public gameover(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 0, 75));
        panel1.setBorder(BorderFactory.createEmptyBorder(25, 450, 25, 450));
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 200, 75, 200));
        panel.setLayout(new GridLayout(0,1, 100, 100));
        panel1.setLayout(new GridBagLayout());
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 60;
        grid.ipady = 30;

        customLabel(headLabel, "Comic Sans", Color.red, 35);
        customLabel(inco, "Comic Sans", Color.black, 20);
        customLabel(exp, "Comic Sans", Color.black, 20);
        customLabel(liq, "Comic Sans", Color.black, 20);
        customLabel(line, "Comic Sans", Color.black, 20);
        customLabel(prof, "Comic Sans", Color.black, 20);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        customButton(buttonBack, 25, Color.white, Color.black);

        panel.add(headLabel);

        grid.gridx = 0;
        grid.gridy = 0;
        panel1.add(inco, grid);

        //grid.gridx = 2;
        //panel1.add(money, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        panel1.add(exp, grid);

        //grid.gridx = 2;
        //panel1.add(expenses, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        panel1.add(liq, grid);

        //grid.gridx = 2;
        //panel1.add(invalue, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        panel1.add(line, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        panel1.add(prof, grid);

        //grid.gridx = 2;
        //panel1.add(net, grid);

        grid.gridx = 0;
        grid.gridy = 5;
        panel1.add(buttonBack, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        backAction();

        inventoryFrame.add(panel, BorderLayout.NORTH);
        inventoryFrame.add(panel1, BorderLayout.CENTER);
        inventoryFrame.add(panel2, BorderLayout.SOUTH);
        inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryFrame.setTitle("Lemonade Stand");
        inventoryFrame.setIconImage(image.getImage());
        inventoryFrame.setUndecorated(false);
        inventoryFrame.setResizable(false);
        inventoryFrame.pack();
        inventoryFrame.setVisible(true);
        device.setFullScreenWindow(inventoryFrame);
    }


    public void backAction(){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new MainMenu();
                inventoryFrame.dispose();
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
