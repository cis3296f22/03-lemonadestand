package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class melt {
    double ice = 0;
    // creation of LemonadeStand
    LemonadeStandModel ls = new LemonadeStandModel();
    WeatherForecast wf = new WeatherForecast();
    //values for the bottom items
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");

    JFrame priceFrame = new JFrame();
    //button to continue
    JButton buttonStart = new JButton("OK");
    //Labels
    JLabel headLabel = new JLabel("Inventory Loss", SwingConstants.CENTER);
    JLabel melt = new JLabel("Your remaining ice has melted.");
    //bottom items
    JLabel dayLabel = new JLabel("", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    //makes it look good
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");

    public static void main(String[] args){
        new melt();
    }

    public melt(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");

        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        panel.setLayout(new GridLayout(0,1, 0, 20));
        panel1.setLayout(new GridBagLayout());
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 40;
        grid.ipady = 30;

        customLabel(headLabel, "Comic Sans", new Color(204, 0, 0), 25);
        customLabel(melt, "Comic Sans", Color.black, 15);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        customButton(buttonStart, 16, new Color(0, 204, 0), Color.white);

        panel.add(headLabel);

        
        grid.gridx = 0;
        grid.gridy = 1;
        panel1.add(melt, SwingConstants.CENTER);

        grid.insets = new Insets(5, 100, 5, 100);
        grid.gridx = 0;
        grid.gridy = 3;
        panel1.add(buttonStart, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        startAction(ls, wf);

        priceFrame.add(panel, BorderLayout.NORTH);
        priceFrame.add(panel1, BorderLayout.CENTER);
        priceFrame.add(panel2, BorderLayout.SOUTH);
        priceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        priceFrame.setTitle("Lemonade Stand");
        priceFrame.setIconImage(image.getImage());
        priceFrame.setPreferredSize(new Dimension(650, 550));
        priceFrame.setUndecorated(false);
        priceFrame.setResizable(false);
        priceFrame.pack();
        priceFrame.setVisible(true);
    }

    public void startAction(LemonadeStandModel temp, WeatherForecast wfTemp){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(ls, wfTemp);
                priceFrame.dispose();
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
