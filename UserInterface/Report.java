package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Report {
    public static void main(String[] args){
        new Report();
    }

    LemonadeStandModel ls = new LemonadeStandModel();
    double money = 20;
    double gross = 0;
    double soldCups = 100;
    double customer = 100;
    double pricePerCup = .25;
    int lemon = 3;
    int sugar = 1;
    int ice = 1;
    int l = 0;
    int s = 0;
    int i = 0;
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    int counter = 0;
    String weather = "Sunny";
    String reaction;
    DecimalFormat df = new DecimalFormat("0.00");

    JFrame reportFrame = new JFrame();
    JFrame lossFrame = new JFrame();

    JButton buttonOK1 = new JButton("OK");
    JButton buttonOK2 = new JButton("OK");
    JProgressBar popularBar = new JProgressBar(0, 100);

    JLabel reportLabel = new JLabel("End of Day Report", SwingConstants.CENTER);
    JLabel lossLabel = new JLabel("Inventory Loss", SwingConstants.CENTER);
    JLabel popularLabel = new JLabel("Your Popularity:", SwingConstants.CENTER);
    JLabel lemonLabel = new JLabel((lemon / 3) + " of your remaining lemons spoiled.", SwingConstants.CENTER);
    JLabel sugarLabel = new JLabel("Bugs in the sugar! All remaining sugar needs discarding.", SwingConstants.CENTER);
    JLabel iceLabel = new JLabel("Your remaining ice has melted.", SwingConstants.CENTER);
    JLabel blankLabel1 = new JLabel(" ", SwingConstants.CENTER);
    JLabel blankLabel2 = new JLabel(" ", SwingConstants.CENTER);
    JLabel blankLabel3 = new JLabel(" ", SwingConstants.CENTER);
    JLabel dayLabel = new JLabel("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(money) + "</html>", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");

    public Report(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        if((soldCups / customer) == 1){
            reaction = "AMAZING!";
            counter += (100 / totalDay) + 1;
        }

        else if((soldCups / customer) >= .8 && (soldCups / customer) < 1){
            if(weather.equals("Rain") || weather.equals("Snow")){
                reaction = "AMAZING!";
                counter += (100 / totalDay) + 1;
            }
            else{
                reaction = "Great!";
                counter += (80 / totalDay);
            }
        }

        else if((soldCups / customer) >= .5 && (soldCups / customer) < .8){
            if(weather.equals("Rain") || weather.equals("Snow")){
                reaction = "Great!";
                counter += (80 / totalDay);
            }
            else{
                reaction = "Decent.";
                counter += (60 / totalDay);
            }
        }

        else if((soldCups / customer) < .5 && (soldCups / customer) >= .3){
            if((weather.equals("Rain") || weather.equals("Snow"))){
                reaction = "Decent.";
                counter += (60 / totalDay);
            }
            else{
                reaction = "Pitiful.";
                counter += (40 / totalDay);
            }
        }

        else{
            reaction = "Pitiful.";
            counter = 0;
        }
        JLabel soldLabel = new JLabel("<html>You managed to sell " + (int)soldCups + " cups to " + (int)customer + " potential customers." + "<br />&emsp;&emsp;Considering the weather, I'd say this is " + reaction + "</html>", SwingConstants.CENTER);

        gross = soldCups * pricePerCup;
        JLabel grossLabel = new JLabel("Money generated from Day " + currentDay + ": $" + df.format(gross), SwingConstants.CENTER);
        
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 15, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(15, 250, 30, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        panel.setLayout(new GridLayout(0,1, 0, 10));
        panel1.setLayout(new GridLayout(0,1, 0, 10));
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        customLabel(reportLabel, "Comic Sans", new Color(153, 0, 0), 30);
        customLabel(soldLabel, "Comic Sans", Color.black, 20);
        customLabel(popularLabel, "Comic Sans", Color.black, 20);
        customLabel(grossLabel, "Comic Sans", Color.black, 20);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);
        customProgressBar(popularBar, "Comic Sans", new Color(255, 153, 0), new Color(0xF1E592), 20);
        customButton(buttonOK1, 25, new Color(0, 204, 0), Color.white);

        panel.add(reportLabel);
        panel.add(soldLabel);
        panel.add(grossLabel);
        panel.add(popularLabel);
        panel.add(popularBar);
        panel1.add(buttonOK1);
        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        lossAction();

        reportFrame.add(panel, BorderLayout.NORTH);
        reportFrame.add(panel1, BorderLayout.CENTER);
        reportFrame.add(panel2, BorderLayout.SOUTH);
        reportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportFrame.setTitle("Lemonade Stand");
        reportFrame.setIconImage(image.getImage());
        reportFrame.setPreferredSize(new Dimension(650, 550));
        reportFrame.setUndecorated(false);
        reportFrame.setResizable(false);
        reportFrame.pack();
        reportFrame.setVisible(true);
    }

    public void inventoryLoss(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 50, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 250, 30, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        panel.setLayout(new GridLayout(0,1, 0, 25));
        panel1.setLayout(new GridLayout(0,1, 0, 10));
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        customLabel(lossLabel, "Comic Sans", new Color(153, 0, 0), 30);
        customLabel(lemonLabel, "Comic Sans", Color.black, 20);
        customLabel(sugarLabel, "Comic Sans", Color.black, 20);
        customLabel(iceLabel, "Comic Sans", Color.black, 20);
        customButton(buttonOK2, 25, new Color(0, 204, 0), Color.white);

        panel.add(lossLabel);
        if(lemon >= 3){
            l++;
            lemon -= lemon / 3;
            panel.add(lemonLabel);
        }

        if(sugar > 0){
            s++;
            sugar = 0;
            panel.add(sugarLabel);
        }

        if(ice > 0){
            i++;
            ice = 0;
            panel.add(iceLabel);
        }

        if(l == 0){
            panel.add(blankLabel1);
        }

        if(s == 0){
            panel.add(blankLabel2);
        }

        if(i == 0){
            panel.add(blankLabel3);
        }
        panel1.add(buttonOK2);
        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        nextDayAction();

        lossFrame.add(panel, BorderLayout.NORTH);
        lossFrame.add(panel1, BorderLayout.CENTER);
        lossFrame.add(panel2, BorderLayout.SOUTH);
        lossFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lossFrame.setTitle("Lemonade Stand");
        lossFrame.setIconImage(image.getImage());
        lossFrame.setPreferredSize(new Dimension(650, 550));
        lossFrame.setUndecorated(false);
        lossFrame.setResizable(false);
        lossFrame.pack();
        lossFrame.setVisible(true);
    }

    public void lossAction(){
        buttonOK1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(lemon < 3 && sugar == 0 && ice == 0){
                    new Purchase(ls);
                }
                else{
                    inventoryLoss();
                }
                reportFrame.dispose();
            }
        });
    }

    public void nextDayAction(){
        buttonOK2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(ls);
                lossFrame.dispose();
            }
        });
    }

    public void customLabel(JLabel label, String font, Color color, int size){
        label.setFont(new Font(font, Font.BOLD, size));
        label.setForeground(color);
    }

    public void customProgressBar(JProgressBar bar, String font, Color color1, Color color2, int size){
        bar.setValue(counter);
        bar.setStringPainted(true);
        bar.setFont(new Font(font, Font.BOLD, size));
        bar.setForeground(color1);
        bar.setBackground(color2);
    }

    public void customButton(JButton button, int size, Color color, Color color1){
        button.setFont(new Font("Comic Sans", Font.BOLD, size));
        button.setBackground(color);
        button.setForeground(color1);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
    }
}
