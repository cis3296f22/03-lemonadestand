package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class gameover extends JFrame{
    double expenses = 0.00;
    double invalue = 0.00;
    double net = 0.00;

    //values for the bottom items
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");
    //buttons to go back
    JFrame gameOverFrame = new JFrame();
    JButton buttonBack = new JButton("Play Again?");
    //label for items
    JLabel headLabel = new JLabel("End of Season Report", SwingConstants.CENTER);
    JLabel inco = new JLabel("Total Income: ");
    JLabel exp = new JLabel("Total Expenses: ");
    JLabel liq = new JLabel("Liquidated Inventory Value: ");
    JLabel line = new JLabel("---------------------------------------------------------");
    JLabel prof = new JLabel("Net Profit/Loss: ");
    //bottom items
    JLabel dayLabel = new JLabel(" ", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    //makes it look good
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");

    public gameover(LemonadeStandModel ls){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel income = new JLabel(" " + df.format(ls.getMoney()));
        JLabel expense = new JLabel(" " + df.format(expenses));
        JLabel liquid = new JLabel(" " + df.format(invalue));
        dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");

        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        panel2.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        panel.setLayout(new GridLayout(0,1, 0, 20));
        panel1.setLayout(new GridBagLayout());
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));
        
        net = ((ls.getMoney() + invalue) - expenses);
        JLabel nets = new JLabel(" " + df.format(net));
        if(net > 0){
            customLabel(nets, "Comic Sans", new Color(0, 204, 0), 15);
        }
        else if(net < 0){
            customLabel(nets, "Comic Sans", new Color(204, 0, 0), 15);
        }
        else{
            customLabel(nets, "Comic Sans", Color.black, 15);
        }

        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 40, 5, 5);
        grid.ipadx = 60;
        grid.ipady = 30;

        customLabel(headLabel, "Comic Sans", new Color(204, 0, 0), 30);
        customLabel(inco, "Comic Sans", Color.black, 15);
        customLabel(exp, "Comic Sans", Color.black, 15);
        customLabel(liq, "Comic Sans", Color.black, 15);
        customLabel(line, "Comic Sans", Color.black, 15);
        customLabel(prof, "Comic Sans", Color.black, 15);
        customLabel(income, "Comic Sans", new Color(0, 204, 0), 15);
        customLabel(expense, "Comic Sans", new Color(204, 0, 0), 15);
        customLabel(liquid, "Comic Sans", new Color(0, 204, 0), 15);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        customButton(buttonBack, 20, Color.white, Color.black);

        panel.add(headLabel);

        grid.gridx = 0;
        grid.gridy = 0;
        panel1.add(inco, grid);

        grid.gridx = 2;
        panel1.add(income, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        panel1.add(exp, grid);

        grid.gridx = 2;
        panel1.add(expense, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        panel1.add(liq, grid);

        grid.gridx = 2;
        panel1.add(liquid, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        panel1.add(line, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        panel1.add(prof, grid);

        grid.gridx = 2;
        panel1.add(nets, grid);

        grid.gridx = 0;
        grid.gridy = 5;
        grid.insets = new Insets(5, 100, 5, 5);
        panel1.add(buttonBack, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        backAction();

        gameOverFrame.add(panel, BorderLayout.NORTH);
        gameOverFrame.add(panel1, BorderLayout.CENTER);
        gameOverFrame.add(panel2, BorderLayout.SOUTH);
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setTitle("Lemonade Stand");
        gameOverFrame.setIconImage(image.getImage());
        gameOverFrame.setPreferredSize(new Dimension(650, 550));
        gameOverFrame.setUndecorated(false);
        gameOverFrame.setResizable(false);
        gameOverFrame.pack();
        gameOverFrame.setVisible(true);
    }


    public void backAction(){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new MainMenu();
                gameOverFrame.dispose();
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
