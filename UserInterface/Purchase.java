package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Purchase {
    LemonadeStandModel ls;
    /*double money = 20;
    int cup = 0;
    int lemon = 0;
    int sugar = 0;
    int ice = 0;*/
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");

    JFrame inventoryFrame = new JFrame();
    JFrame helpFrame = new JFrame();
    JFrame acquisitionFrame = new JFrame();
    JButton buttonCup = new JButton("Buy More Cups");
    JButton buttonLemon = new JButton("Buy More Lemons");
    JButton buttonSugar = new JButton("Buy More Sugar");
    JButton buttonIce = new JButton("Buy More Ice");
    JButton buttonBankrupt = new JButton("Bankrupt!");
    JButton buttonStart = new JButton("OK");
    JButton buttonHelp = new JButton("Help");
    JButton buttonBack = new JButton("Back");
    JButton buttonBuy1 = new JButton("Buy It!");
    JButton buttonBuy2 = new JButton("Buy It!");
    JButton buttonBuy3 = new JButton("Buy It!");
    JButton buttonOK = new JButton("OK");

    JLabel headLabel = new JLabel("Inventory/Purchase", SwingConstants.CENTER);
    JLabel moneyLabel = new JLabel("", SwingConstants.CENTER);
    JLabel cupLabel = new JLabel("");
    JLabel lemonLabel = new JLabel("");
    JLabel sugarLabel = new JLabel("");
    JLabel iceLabel = new JLabel("");
    JLabel dayLabel = new JLabel("", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");

    public Purchase(LemonadeStandModel ls){
        moneyLabel.setText("You have $" + df.format(ls.getMoney()) + " and:");
        cupLabel.setText(ls.getCups() + " Paper Cups");
        lemonLabel.setText(ls.getLemons() + " Lemons");
        sugarLabel.setText(ls.getSugar() + " Cups of Sugar");
        iceLabel.setText(ls.getIce() + " Ice Cubes");

        dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(ls.getMoney()) + "</html>");

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

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
        grid.insets = new Insets(5, 0, 0, 5);
        grid.ipadx = 60;
        grid.ipady = 30;

        customLabel(headLabel, "Comic Sans", new Color(204, 0, 0), 25);
        customLabel(moneyLabel, "Comic Sans", Color.black, 25);
        customLabel(cupLabel, "Comic Sans", Color.black, 15);
        customLabel(lemonLabel, "Comic Sans", Color.black, 15);
        customLabel(sugarLabel, "Comic Sans", Color.black, 15);
        customLabel(iceLabel, "Comic Sans", Color.black, 15);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        customButton(buttonCup, 16, Color.white, Color.black);
        customButton(buttonLemon, 16, Color.white, Color.black);
        customButton(buttonSugar, 16, Color.white, Color.black);
        customButton(buttonIce, 16, Color.white, Color.black);
        customButton(buttonBankrupt, 12, new Color(204, 0, 0), Color.white);
        customButton(buttonStart, 16, new Color(0, 204, 0), Color.white);
        customButton(buttonHelp, 14, new Color(255, 153, 0), Color.white);

        panel.add(headLabel);
        panel.add(moneyLabel);

        grid.gridx = 0;
        grid.gridy = 0;
        panel1.add(cupLabel, grid);

        grid.gridx = 2;
        panel1.add(buttonCup, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        panel1.add(lemonLabel, grid);

        grid.gridx = 2;
        panel1.add(buttonLemon, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        panel1.add(sugarLabel, grid);

        grid.gridx = 2;
        panel1.add(buttonSugar, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        panel1.add(iceLabel, grid);

        grid.gridx = 2;
        panel1.add(buttonIce, grid);

        grid.gridx = 0;
        grid.gridy = 4;
        panel1.add(buttonBankrupt, grid);

        grid.insets = new Insets(5, 60, 5, 20);
        grid.gridx = 1;
        panel1.add(buttonStart, grid);

        grid.gridx = 2;
        panel1.add(buttonHelp, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        cupAction(ls);
        lemonAction(ls);
        sugarAction(ls);
        iceAction(ls);
        bankruptAction();
        startAction(ls);
        instructAction();

        inventoryFrame.add(panel, BorderLayout.NORTH);
        inventoryFrame.add(panel1, BorderLayout.CENTER);
        inventoryFrame.add(panel2, BorderLayout.SOUTH);
        inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventoryFrame.setTitle("Lemonade Stand");
        inventoryFrame.setIconImage(image.getImage());
        inventoryFrame.setPreferredSize(new Dimension(650, 550));
        inventoryFrame.setUndecorated(false);
        inventoryFrame.setResizable(false);
        inventoryFrame.pack();
        inventoryFrame.setVisible(true);
    }

    public void cupAction(LemonadeStandModel temp){
        buttonCup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Paper Cups", temp.getCups(), 25, 50, 100, .78, 1.66, 2.99, temp);
                inventoryFrame.dispose();
            }
        });  
    }

    public void lemonAction(LemonadeStandModel temp){
        buttonLemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Lemons", temp.getLemons(), 10, 30, 75, .62, 2.41, 4.06, temp);
                inventoryFrame.dispose();
            }
        });
    }

    public void sugarAction(LemonadeStandModel temp){
        buttonSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Cups of Sugar", temp.getSugar(), 8, 20, 48, .59, 1.61, 3.44, temp);
                inventoryFrame.dispose();
            }
        });
    }

    public void iceAction(LemonadeStandModel temp){
        buttonIce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Ice Cubes", temp.getIce(), 100, 250, 500, .83, 2.15, 3.88, temp);
                inventoryFrame.dispose();
            }
        });
    }

    public void acquisition(String ingredient, double item, int q1, int q2, int q3, double p1, double p2, double p3, LemonadeStandModel temp){
        JLabel acquisitionLabel = new JLabel("Acquisition: " + ingredient, SwingConstants.CENTER);
        JLabel ownLabel = new JLabel("You have " + item + " " + ingredient + " and $" + df.format(temp.getMoney()), SwingConstants.CENTER);
        JLabel buyLabel = new JLabel("You can buy:");
        JLabel qp1Label = new JLabel(q1 + " " + ingredient + " for $" + df.format(p1));
        JLabel qp2Label = new JLabel(q2 + " " + ingredient + " for $" + df.format(p2));
        JLabel qp3Label = new JLabel(q3 + " " + ingredient + " for $" + df.format(p3));

        JPanel panel = new JPanel(new GridLayout(0,1, 0, 20));
        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel2 = new JPanel(new GridLayout(1,0, 100, 0));

        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 25, 5, 25));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 0, 5, 0);
        grid.ipadx = 60;
        grid.ipady = 30;

        customLabel(acquisitionLabel, "Comic Sans", new Color(204, 0, 0), 25);
        customLabel(ownLabel, "Comic Sans", Color.black, 25);
        customLabel(buyLabel, "Comic Sans", Color.black, 20);
        customLabel(qp1Label, "Comic Sans", Color.black, 15);
        customLabel(qp2Label, "Comic Sans", Color.black, 15);
        customLabel(qp3Label, "Comic Sans", Color.black, 15);

        customButton(buttonBuy1, 18, Color.white, Color.black);
        customButton(buttonBuy2, 18, Color.white, Color.black);
        customButton(buttonBuy3, 18, Color.white, Color.black);
        customButton(buttonOK, 20, new Color(0, 204, 0), Color.white);

        panel.add(acquisitionLabel);
        panel.add(ownLabel);

        grid.gridx = 0;
        grid.gridy = 0;
        panel1.add(buyLabel, grid);

        grid.gridy = 1;
        panel1.add(qp1Label, grid);

        grid.gridy = 2;
        panel1.add(qp2Label, grid);

        grid.gridy = 3;
        panel1.add(qp3Label, grid);

        grid.gridx = 2;
        grid.gridy = 1;
        panel1.add(buttonBuy1, grid);

        grid.gridy = 2;
        panel1.add(buttonBuy2, grid);

        grid.gridy = 3;
        panel1.add(buttonBuy3, grid);

        grid.gridx = 1;
        grid.gridy = 4;
        grid.insets = new Insets(5, 0, 5, 100);
        panel1.add(buttonOK, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        buyAction(buttonBuy1, ownLabel, qp1Label, ingredient, q1, p1, buttonBuy2, buttonBuy3, qp2Label, qp3Label, p2, p3, temp);
        buyAction(buttonBuy2, ownLabel, qp2Label, ingredient, q2, p2, buttonBuy1, buttonBuy3, qp1Label, qp3Label, p1, p3, temp);
        buyAction(buttonBuy3, ownLabel, qp3Label, ingredient, q3, p3, buttonBuy1, buttonBuy2, qp1Label, qp2Label, p1, p2, temp);
        okAction(temp);

        acquisitionFrame.add(panel, BorderLayout.NORTH);
        acquisitionFrame.add(panel1, BorderLayout.CENTER);
        acquisitionFrame.add(panel2, BorderLayout.SOUTH);
        acquisitionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        acquisitionFrame.setTitle("Lemonade Stand");
        acquisitionFrame.setIconImage(image.getImage());
        acquisitionFrame.setPreferredSize(new Dimension(650, 550));
        acquisitionFrame.setUndecorated(false);
        acquisitionFrame.setResizable(false);
        acquisitionFrame.pack();
        acquisitionFrame.setVisible(true);
        inventoryFrame.dispose();
    }

    public void buyAction(JButton buttonBuy, JLabel haveLabel, JLabel qpLabel, String component, int quantity, double price, JButton buttonClose1, JButton buttonClose2, JLabel closeLabel1, JLabel closeLabel2, double cost1, double cost2, LemonadeStandModel temp){
        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(temp.getMoney() > price){
                    temp.setMoney(temp.getMoney() - price);
                    if(component.equals("Paper Cups")){
                        temp.addCups(quantity);
                        haveLabel.setText("You have " + temp.getCups() + " " + component + " and $" + df.format(temp.getMoney()));
                    }

                    else if(component.equals("Lemons")){
                        temp.addLemons(quantity);
                        haveLabel.setText("You have " + temp.getLemons() + " " + component + " and $" + df.format(temp.getMoney()));
                    }

                    else if(component.equals("Cups of Sugar")){
                        temp.addSugar(quantity);
                        haveLabel.setText("You have " + temp.getSugar() + " " + component + " and $" + df.format(temp.getMoney()));
                    }

                    else if(component.equals("Ice Cubes")){
                        temp.addIce(quantity);
                        haveLabel.setText("You have " + temp.getIce() + " " + component + " and $" + df.format(temp.getMoney()));
                    }
                    dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(temp.getMoney()) + "</html>");
                }

                if(temp.getMoney() - price < price){
                    temp.setMoney(temp.getMoney() - price);
                    if(component.equals("Paper Cups")){
                        temp.addCups(quantity);
                        if(temp.getMoney() < 0){
                            temp.addMoney(price);
                            temp.setCups(temp.getCups() - quantity);
                        }
                        haveLabel.setText("You have " + temp.getCups() + " " + component + " and $" + df.format(temp.getMoney()));
                    }

                    else if(component.equals("Lemons")){
                        temp.addLemons(quantity);
                        if(temp.getMoney() < 0){
                            temp.addMoney(price);
                            temp.setLemons(temp.getLemons() - quantity);
                        }
                        haveLabel.setText("You have " + temp.getLemons() + " " + component + " and $" + df.format(temp.getMoney()));
                    }

                    else if(component.equals("Cups of Sugar")){
                        temp.addSugar(quantity);
                        if(temp.getMoney() < 0){
                            temp.addMoney(price);
                            temp.setSugar(temp.getSugar() - quantity);
                        }
                        haveLabel.setText("You have " + temp.getSugar() + " " + component + " and $" + df.format(temp.getMoney()));
                    }

                    else if(component.equals("Ice Cubes")){
                        temp.addIce(quantity);
                        if(temp.getMoney() < 0){
                            temp.addMoney(price);
                            temp.setIce(temp.getIce() - quantity);
                        }
                        haveLabel.setText("You have " + temp.getIce() + " " + component + " and $" + df.format(temp.getMoney()));
                    }
                    dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(temp.getMoney()) + "</html>");
                    
                    if(temp.getMoney() - cost1 < 0){
                        buttonClose1.setEnabled(false);
                        customLabel(closeLabel1 , "Comic Sans", Color.lightGray, 15);
                    }

                    if(temp.getMoney() - cost2 < 0){
                        buttonClose2.setEnabled(false);
                        customLabel(closeLabel2 , "Comic Sans", Color.lightGray, 15);
                    }
                    buttonBuy.setEnabled(false);
                    customLabel(qpLabel , "Comic Sans", Color.lightGray, 15);
                }
            }
        });
    }

    public void okAction(LemonadeStandModel temp){
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(temp);
                acquisitionFrame.dispose();
            }
        });
    }

    public void bankruptAction(){
        buttonBankrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new gameover();
                inventoryFrame.dispose();
            }
        });
    }

    public void startAction(LemonadeStandModel temp){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new pricing(temp);
                inventoryFrame.dispose();
            }
        });
    }

    public void instructAction(){
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

                customButton(buttonBack, 20, Color.white, Color.black);

                panel.add(headLabel, BorderLayout.PAGE_START);
                panel.add(instructLabel);
                panel1.add(buttonBack);

                backAction(helpFrame);

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
                inventoryFrame.dispose();
            }
        });
    }

    public void backAction(JFrame backFrame){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase(ls);
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