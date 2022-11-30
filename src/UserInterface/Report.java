package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Report {

    double income = 0;
    double soldCups ;
    double customer ;
    int l = 0;
    int s = 0;
    int i = 0;
    String reaction;
    DecimalFormat df = new DecimalFormat("0.00");

    //create frames
    JFrame reportFrame = new JFrame();
    JFrame lossFrame = new JFrame();

    //create buttons
    JButton buttonOK1 = new JButton("OK");
    JButton buttonOK2 = new JButton("OK");

    //create progress bar
    JProgressBar popularBar = new JProgressBar(0, 100);

    //create and set text for labels
    JLabel reportLabel = new JLabel("End of Day Report", SwingConstants.CENTER);
    JLabel lossLabel = new JLabel("Inventory Loss", SwingConstants.CENTER);
    JLabel popularLabel = new JLabel("Your Popularity:", SwingConstants.CENTER);
    JLabel lemonLabel = new JLabel(" ", SwingConstants.CENTER);
    JLabel sugarLabel = new JLabel("Bugs in the sugar! All remaining sugar needs discarding.", SwingConstants.CENTER);
    JLabel iceLabel = new JLabel("Your remaining ice has melted.", SwingConstants.CENTER);
    JLabel blankLabel1 = new JLabel(" ", SwingConstants.CENTER);
    JLabel blankLabel2 = new JLabel(" ", SwingConstants.CENTER);
    JLabel blankLabel3 = new JLabel(" ", SwingConstants.CENTER);
    JLabel dayLabel = new JLabel(" ", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("", SwingConstants.RIGHT);
    ImageIcon image = new ImageIcon("src/UserInterface/LemonIcon.png");

    public Report(LemonadeStandModel ls, WeatherForecast wf, int[] customers){
        //create panels
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //set text for bottom labels
        if(ls.getTotalDay() <= 30){
            dayLabel.setText("<html>Day " + (int)ls.getCurrentDay() + " of " + (int)ls.getTotalDay() + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");
        }
        else if(ls.getTotalDay() > 30){
            dayLabel.setText("<html>Day " + (int)ls.getCurrentDay() + " of " + ls.getTotalDay() + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");
        }
        weatherLabel.setText("<html>Temperature: " + wf.getTemperature() + "&#8457<br />Weather: " + wf.getWeather() + "</html>");
        lemonLabel.setText((int)(ls.getLemons() / 3) + " of your remaining lemons spoiled.");

        //give rating and set bar counter for day performance
        int[] customers1 = customers;
        soldCups = ls.getSoldCups();;
        customer = customers1[5];
        if((soldCups / customer) == 1){
            reaction = "AMAZING!";
            ls.setCounter((int)(ls.getCounter() + 100 / ls.getTotalDay()) + 1);
        }

        else if((soldCups / customer) >= .8 && (soldCups / customer) < 1){
            if(wf.getWeather().equals("Rainy")){
                reaction = "AMAZING!";
                ls.setCounter((int)(ls.getCounter() + 100 / ls.getTotalDay()) + 1);
            }
            else{
                reaction = "Great!";
                ls.setCounter((int)(ls.getCounter() + 80 / ls.getTotalDay()));
            }
        }

        else if((soldCups / customer) >= .5 && (soldCups / customer) < .8){
            if(wf.getWeather().equals("Rainy")){
                reaction = "Great!";
                ls.setCounter((int)(ls.getCounter() + 80 / ls.getTotalDay()));
            }
            else{
                reaction = "Decent.";
                ls.setCounter((int)(ls.getCounter() + 60 / ls.getTotalDay()));
            }
        }

        else if((soldCups / customer) < .5 && (soldCups / customer) >= .3){
            if(wf.getWeather().equals("Rainy")){
                reaction = "Decent.";
                ls.setCounter((int)(ls.getCounter() + 60 / ls.getTotalDay()));
            }
            else{
                reaction = "Pitiful.";
                ls.setCounter((int)(ls.getCounter() + 40 / ls.getTotalDay()));
            }
        }

        else{
            reaction = "Pitiful.";
        }
        JLabel soldLabel = new JLabel("<html>You managed to sell " + (int)soldCups + " cups to " + (int)customer + " potential customers." + "<br />&emsp;&emsp;Considering the weather, I'd say this is " + reaction + "</html>", SwingConstants.CENTER);

        //calculate generated income
        income = soldCups * (ls.getPricePer());
        JLabel grossLabel = new JLabel("Money generated from Day " + (int)ls.getCurrentDay() + ": $" + df.format(income), SwingConstants.CENTER);
        
        //set empty border, layout, and background color for panels
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 15, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(15, 250, 30, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        panel.setLayout(new GridLayout(0,1, 0, 10));
        panel1.setLayout(new GridLayout(0,1, 0, 10));
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        //customize labels
        customLabel(reportLabel, "Comic Sans", new Color(153, 0, 0), 30);
        customLabel(soldLabel, "Comic Sans", Color.black, 20);
        customLabel(popularLabel, "Comic Sans", Color.black, 20);
        customLabel(grossLabel, "Comic Sans", Color.black, 20);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);
        customProgressBar(popularBar, "Comic Sans", new Color(255, 153, 0), new Color(0xF1E592), 20, ls);
        customButton(buttonOK1, 25, new Color(0, 204, 0), Color.white);

        //add utilities to panels
        panel.add(reportLabel);
        panel.add(soldLabel);
        panel.add(grossLabel);
        panel.add(popularLabel);
        panel.add(popularBar);
        panel1.add(buttonOK1);
        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        //add inventory loss action
        lossAction(ls, wf);

        //add panels and objects to frame
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

    //inventory loss screen
    public void inventoryLoss(LemonadeStandModel ls, WeatherForecast wf){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //set empty border, layout, and background color for panels
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 50, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(50, 250, 30, 250));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        panel.setLayout(new GridLayout(0,1, 0, 25));
        panel1.setLayout(new GridLayout(0,1, 0, 10));
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        //customize labels
        customLabel(lossLabel, "Comic Sans", new Color(153, 0, 0), 30);
        customLabel(lemonLabel, "Comic Sans", Color.black, 20);
        customLabel(sugarLabel, "Comic Sans", Color.black, 20);
        customLabel(iceLabel, "Comic Sans", Color.black, 20);
        customButton(buttonOK2, 25, new Color(0, 204, 0), Color.white);

        //add utilities to panels
        panel.add(lossLabel);
        if(ls.getLemons() >= 3){
            int rand = (Math.random() <= 0.5) ? 1 : 2;
            if(rand == 1){
                l++;
                ls.setLemons(ls.getLemons() - (ls.getLemons() / 3));
                panel.add(lemonLabel);
            }
            else if(rand == 2){
                l = 0;
            }
        }

        if(ls.getSugar() > 0){
            int rand = (int) (Math.random() * (3 - 1 + 1) + 1);
            if(rand == 1){
                s++;
                ls.setSugar(0);
                panel.add(sugarLabel);
            }
            else if(rand == 2 || rand == 3){
                s = 0;
            }
        }

        if(ls.getIce() > 0){
            i++;
            ls.setIce(0);
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

        //add action to start next day
        nextDayAction(ls, wf);

        //add panels and objects to frame
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

    //action to open the inventory loss screen
    public void lossAction(LemonadeStandModel temp, WeatherForecast wfTemp){
        buttonOK1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                temp.setCurrentDay(temp.getCurrentDay() + 1);
                if(temp.getLemons() < 3 && temp.getSugar() == 0 && temp.getIce() == 0){
                    if(temp.getCurrentDay() > temp.getTotalDay()){
                        temp.setCurrentDay(temp.getCurrentDay() - 1);
                        double asset = (temp.getCups() * .0067 + temp.getLemons() * .0129 + temp.getSugar() * .0151 + temp.getIce() * .00216);
                        temp.setLiquidate(temp.getLiquidate() + asset);
                        new gameover(temp, wfTemp);
                    }
                    else{
                        WeatherForecast wfNext = new WeatherForecast();
                        temp.setWeatherForecast(wfNext);
                        temp.setSoldCups(0);
                        new Purchase(temp, wfNext);
                    }
                }
                else{
                    inventoryLoss(temp, wfTemp);
                }
                reportFrame.dispose();
            }
        });
    }

    //action to start the next day
    public void nextDayAction(LemonadeStandModel temp, WeatherForecast wfTemp){
        buttonOK2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(temp.getCurrentDay() > temp.getTotalDay()){
                    temp.setCurrentDay(temp.getCurrentDay() - 1);
                    double asset = (temp.getCups() * .0067 + temp.getLemons() * .0129 + temp.getSugar() * .0151 + temp.getIce() * .00216);
                    temp.setLiquidate(temp.getLiquidate() + asset);
                    new gameover(temp, wfTemp);
                }
                else{
                    WeatherForecast wfNext = new WeatherForecast();
                    temp.setWeatherForecast(wfNext);
                    temp.setSoldCups(0);
                    new Purchase(temp, wfNext);
                }
                lossFrame.dispose();
            }
        });
    }

    //function to customize the labels
    public void customLabel(JLabel label, String font, Color color, int size){
        label.setFont(new Font(font, Font.BOLD, size));
        label.setForeground(color);
    }

    //function to customize the progress bar
    public void customProgressBar(JProgressBar bar, String font, Color color1, Color color2, int size, LemonadeStandModel temp){
        bar.setValue((int)temp.getCounter());
        bar.setStringPainted(true);
        bar.setFont(new Font(font, Font.BOLD, size));
        bar.setForeground(color1);
        bar.setBackground(color2);
    }

    //function to customize the buttons
    public void customButton(JButton button, int size, Color color, Color color1){
        button.setFont(new Font("Comic Sans", Font.BOLD, size));
        button.setBackground(color);
        button.setForeground(color1);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
    }
}
