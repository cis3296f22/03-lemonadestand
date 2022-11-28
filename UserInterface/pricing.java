package UserInterface;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.lang.InterruptedException;

public class pricing {
    int temperature = 0;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");

    //create buttons
    JButton buttonBankrupt = new JButton("Bankrupt!");
    JButton buttonStart = new JButton("OK");
    JButton buttonHelp = new JButton("Help");
    JButton buttonBack1 = new JButton("Back to Store!");
    JButton buttonBack2 = new JButton("Back");

    //create frames
    JFrame priceFrame = new JFrame();
    JFrame helpFrame = new JFrame();

    //set text for labels
    JLabel cupLabel = new JLabel("Cents");
    JLabel lemonLabel = new JLabel("Lemons");
    JLabel sugarLabel = new JLabel("Sugar");
    JLabel iceLabel = new JLabel("Ice");
    JLabel headLabel = new JLabel("Price/Quality Control", SwingConstants.CENTER);
    JLabel cupPerLabel = new JLabel("Price per Cup:");
    JLabel lemonPerLabel = new JLabel("Lemons per Pitcher:");
    JLabel sugarPerLabel = new JLabel("Sugar per Pitcher:");
    JLabel icePerLabel = new JLabel("Ice per Cup:");
    JLabel dayLabel = new JLabel("", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");

    //opens the pricing screen
    public pricing(LemonadeStandModel ls){
        //create panels
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //create spinners
        SpinnerModel model1 = new SpinnerNumberModel(ls.getPricePer(), 1, 99, 1);
        JSpinner spinner1 = new JSpinner(model1);
        SpinnerModel model2 = new SpinnerNumberModel(ls.getLemonsPer(), 0, 99, 1);
        JSpinner spinner2 = new JSpinner(model2);
        SpinnerModel model3 = new SpinnerNumberModel(ls.getSugarPer(), 0, 99, 1);
        JSpinner spinner3 = new JSpinner(model3);
        SpinnerModel model4 = new SpinnerNumberModel(ls.getIcePer(), 0, 99, 1);
        JSpinner spinner4 = new JSpinner(model4);

        //set text for bottom labels
        if(ls.getTotalDay() <= 30){
            dayLabel.setText("<html>Day " + (int)ls.getCurrentDay() + " of " + (int)ls.getTotalDay() + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");
        }
        else if(ls.getTotalDay() > 30){
            dayLabel.setText("<html>Day " + (int)ls.getCurrentDay() + " of " + ls.getTotalDay() + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");
        }

        //set empty border, layout, and background color of panels
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        panel.setLayout(new GridLayout(0,1, 0, 20));
        panel1.setLayout(new GridBagLayout());
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        //set grid bag layout
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 5, 5, 5);
        grid.ipadx = 40;
        grid.ipady = 30;

        //customize labels
        customLabel(headLabel, "Comic Sans", new Color(204, 0, 0), 25);
        customLabel(cupLabel, "Comic Sans", Color.black, 15);
        customLabel(lemonLabel, "Comic Sans", Color.black, 15);
        customLabel(sugarLabel, "Comic Sans", Color.black, 15);
        customLabel(iceLabel, "Comic Sans", Color.black, 15);
        customLabel(cupPerLabel, "Comic Sans", Color.black, 15);
        customLabel(lemonPerLabel, "Comic Sans", Color.black, 15);
        customLabel(sugarPerLabel, "Comic Sans", Color.black, 15);
        customLabel(icePerLabel, "Comic Sans", Color.black, 15);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        //customize buttons
        customButton(buttonBankrupt, 12, new Color(204, 0, 0), Color.white);
        customButton(buttonStart, 16, new Color(0, 204, 0), Color.white);
        customButton(buttonBack1, 16, Color.white, Color.black);
        customButton(buttonHelp, 14, new Color(255, 153, 0), Color.white);

        //add utilities to panels
        panel.add(headLabel);
        
        grid.insets = new Insets(5, 175, 5, 0);
        grid.gridy = 0;
        panel1.add(cupPerLabel, grid);

        grid.insets = new Insets(5, 200, 5, 0);
        grid.gridx = 1;
        panel1.add(spinner1, grid);

        grid.insets = new Insets(5, 0, 5, 30);
        grid.gridx = 2;
        panel1.add(cupLabel, grid);

        grid.insets = new Insets(5, 175, 5, 0);
        grid.gridx = 0;
        grid.gridy = 1;
        panel1.add(lemonPerLabel, grid);

        grid.insets = new Insets(5, 200, 5, 0);
        grid.gridx = 1;
        panel1.add(spinner2, grid);

        grid.insets = new Insets(5, 0, 5, 30);
        grid.gridx = 2;
        panel1.add(lemonLabel, grid);

        grid.insets = new Insets(5, 175, 5, 0);
        grid.gridx = 0;
        grid.gridy = 2;
        panel1.add(sugarPerLabel, grid);

        grid.insets = new Insets(5, 200, 5, 0);
        grid.gridx = 1;
        panel1.add(spinner3, grid);

        grid.insets = new Insets(5, 0, 5, 30);
        grid.gridx = 2;
        panel1.add(sugarLabel, grid);

        grid.insets = new Insets(5, 175, 5, 0);
        grid.gridx = 0;
        grid.gridy = 3;
        panel1.add(icePerLabel, grid);

        grid.insets = new Insets(5, 200, 5, 0);
        grid.gridx = 1;
        panel1.add(spinner4, grid);

        grid.insets = new Insets(5, 0, 5, 30);
        grid.gridx = 2;
        panel1.add(iceLabel, grid);

        grid.insets = new Insets(5, 0, 5, 100);
        grid.gridx = 1;
        grid.gridy = 5;
        panel1.add(buttonBack1, grid);

        grid.insets = new Insets(5, 150, 0, 50);
        grid.gridx = 0;
        grid.gridy = 6;
        panel1.add(buttonBankrupt, grid);

        grid.insets = new Insets(5, 50, 5, 150);
        grid.gridx = 1;
        panel1.add(buttonStart, grid);

        grid.insets = new Insets(5, 0, 5, 150);
        grid.gridx = 2;
        grid.gridy = 6;
        panel1.add(buttonHelp, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        //add action functions
        spinnerAction(spinner1, ls, 100);
        spinnerAction(spinner2, ls, 1);
        spinnerAction(spinner3, ls, 1);
        spinnerAction(spinner4, ls, 1);
        bankruptAction(ls);
        startAction(ls);
        instructAction(ls);
        goBack(ls);

        //add panels and objects to frame
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

    //action to bankrupt and end the game
    public void bankruptAction(LemonadeStandModel temp){
        buttonBankrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                double asset = (temp.getCups() * .0067 + temp.getLemons() * .0129 + temp.getSugar() * .0151 + temp.getIce() * .00216);
                temp.setLiquidate(temp.getLiquidate() + asset);
                new gameover(temp);
                priceFrame.dispose();
            }
        });
    }

    //action for opening the game view screen
    public void startAction(LemonadeStandModel temp){
        buttonStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        priceFrame.dispose();
                        try {
                            new GameView();
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
    }

    //action for returning to inventory screen
    public void goBack(LemonadeStandModel temp){
        buttonBack1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(temp);
                priceFrame.dispose();
            }
        });
    }

    //action for opening the instruction screen
    public void instructAction(LemonadeStandModel temp){
        buttonHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //set text for labels
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

                //create panels
                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                //set empty border and background color of panels
                panel.setBorder(BorderFactory.createEmptyBorder(50, 25, 10, 25));
                panel1.setBorder(BorderFactory.createEmptyBorder(10, 25, 25, 25));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));

                //customize labels
                customLabel(headLabel, "MV Boli", new Color(204,0,0), 30);
                customLabel(instructLabel, "Consolas", Color.black, 12);

                //customize back button
                customButton(buttonBack2, 20, Color.white, Color.black);

                //add utilities to panels
                panel.add(headLabel, BorderLayout.PAGE_START);
                panel.add(instructLabel);
                panel1.add(buttonBack2);

                //add back action
                backAction(helpFrame, temp);

                //add panels and objects to frame
                helpFrame.add(panel, BorderLayout.CENTER);
                helpFrame.add(panel1, BorderLayout.SOUTH);
                helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                helpFrame.setTitle("Lemonade Stand");
                helpFrame.setIconImage(image.getImage());
                helpFrame.setPreferredSize(new Dimension(650, 550));
                helpFrame.setUndecorated(false);
                helpFrame.setResizable(false);
                helpFrame.pack();
                helpFrame.setVisible(true);
                priceFrame.dispose();
            }
        });
    }

    //action to exit instruction screen
    public void backAction(JFrame backFrame, LemonadeStandModel temp){
        buttonBack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new pricing(temp);
                backFrame.dispose();
            }
        });  
    }

    //action for setting the price per values from the spinners
    public void spinnerAction(JSpinner spinner, LemonadeStandModel temp, int value){
        spinner.addChangeListener((ChangeListener) new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                temp.setPricePer(((double)spinner.getValue()) / value);
            }
        });
    }

    //function to customize the labels
    public void customLabel(JLabel label, String font, Color color, int size){
        label.setFont(new Font(font, Font.BOLD, size));
        label.setForeground(color);
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
