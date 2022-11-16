package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class pricing {
    //values for the bottom items
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");
    //buttons to go back
    JButton buttonBankrupt = new JButton("Bankrupt!");
    JButton buttonStart = new JButton("OK");
    JButton buttonHelp = new JButton("Help");
    JButton buttonBack1 = new JButton("Back to Store!");
    JButton buttonBack2 = new JButton("Back");
    //buttons to increase
    JFrame priceFrame = new JFrame();
    JFrame helpFrame = new JFrame();
    Button increase = new Button();
    Button decrease = new Button();
    //labels that show the amount
    JLabel cupLabel = new JLabel("Cents");
    JLabel lemonLabel = new JLabel("Lemons");
    JLabel sugarLabel = new JLabel("Sugar");
    JLabel iceLabel = new JLabel("Ice");
    JLabel headLabel = new JLabel("Price/Quality Control", SwingConstants.CENTER);
    JLabel cupPerLabel = new JLabel("Price per Cup:");
    JLabel lemonPerLabel = new JLabel("Lemons per Pitcher:");
    JLabel sugarPerLabel = new JLabel("Sugar per Pitcher:");
    JLabel icePerLabel = new JLabel("Ice per Cup:");
    //bottom items
    JLabel dayLabel = new JLabel("", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    //makes it look good
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");

    public pricing(LemonadeStandModel ls){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        //spinner
        SpinnerModel model1 = new SpinnerNumberModel(ls.getPricePer(), 1, 99, 1);
        JSpinner spinner1 = new JSpinner(model1);
        SpinnerModel model2 = new SpinnerNumberModel(ls.getLemonsPer(), 0, 99, 1);
        JSpinner spinner2 = new JSpinner(model2);
        SpinnerModel model3 = new SpinnerNumberModel(ls.getSugarPer(), 0, 99, 1);
        JSpinner spinner3 = new JSpinner(model3);
        SpinnerModel model4 = new SpinnerNumberModel(ls.getIcePer(), 0, 99, 1);
        JSpinner spinner4 = new JSpinner(model4);

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

        customButton(buttonBankrupt, 12, new Color(204, 0, 0), Color.white);
        customButton(buttonStart, 16, new Color(0, 204, 0), Color.white);
        customButton(buttonBack1, 16, Color.white, Color.black);
        customButton(buttonHelp, 14, new Color(255, 153, 0), Color.white);

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

        bankruptAction(ls);
        startAction(ls);
        instructAction(ls);
        goBack(ls);

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

    public void bankruptAction(LemonadeStandModel temp){
        buttonBankrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new gameover(temp);
                priceFrame.dispose();
            }
        });
    }

    public void startAction(LemonadeStandModel temp){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    new GameView();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                priceFrame.dispose();
            }
        });
    }

    public void goBack(LemonadeStandModel temp){
        buttonBack1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(temp);
                priceFrame.dispose();
            }
        });
    }

    public void instructAction(LemonadeStandModel temp){
        buttonHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
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

                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(50, 25, 10, 25));
                panel1.setBorder(BorderFactory.createEmptyBorder(10, 25, 25, 25));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));

                customLabel(headLabel, "MV Boli", new Color(204,0,0), 30);
                customLabel(instructLabel, "Consolas", Color.black, 12);

                customButton(buttonBack2, 20, Color.white, Color.black);

                panel.add(headLabel, BorderLayout.PAGE_START);
                panel.add(instructLabel);
                panel1.add(buttonBack2);

                backAction(helpFrame, temp);

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

    public void backAction(JFrame backFrame, LemonadeStandModel temp){
        buttonBack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new pricing(temp);
                backFrame.dispose();
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
