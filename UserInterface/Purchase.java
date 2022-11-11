package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Purchase {
    double money = 20;
    int cup = 0;
    int lemon = 0;
    int sugar = 0;
    int ice = 0;
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
    JLabel moneyLabel = new JLabel("You have $" + df.format(money) + " and:", SwingConstants.CENTER);
    JLabel cupLabel = new JLabel(cup + " Paper Cups");
    JLabel lemonLabel = new JLabel(lemon + " Lemons");
    JLabel sugarLabel = new JLabel(sugar + " Cups of Sugar");
    JLabel iceLabel = new JLabel(ice + " Ice Cubes");
    JLabel dayLabel = new JLabel("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(money) + "</html>", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);

    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public Purchase(){
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
        customLabel(moneyLabel, "Comic Sans", Color.black, 35);
        customLabel(cupLabel, "Comic Sans", Color.black, 20);
        customLabel(lemonLabel, "Comic Sans", Color.black, 20);
        customLabel(sugarLabel, "Comic Sans", Color.black, 20);
        customLabel(iceLabel, "Comic Sans", Color.black, 20);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        customButton(buttonCup, 25, Color.white, Color.black);
        customButton(buttonLemon, 25, Color.white, Color.black);
        customButton(buttonSugar, 25, Color.white, Color.black);
        customButton(buttonIce, 25, Color.white, Color.black);
        customButton(buttonBankrupt, 18, Color.red, Color.white);
        customButton(buttonStart, 25, new Color(0, 204, 0), Color.white);
        customButton(buttonHelp, 20, Color.orange, Color.white);

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

        cupAction();
        lemonAction();
        sugarAction();
        iceAction();
        bankruptAction();
        startAction();
        instructAction();

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

    public void cupAction(){
        buttonCup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Paper Cups", cup, 25, 50, 100, .78, 1.66, 2.99);
                inventoryFrame.dispose();
            }
        });  
    }

    public void lemonAction(){
        buttonLemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Lemons", lemon, 10, 30, 75, .62, 2.41, 4.06);
                inventoryFrame.dispose();
            }
        });
    }

    public void sugarAction(){
        buttonSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Cups of Sugar", sugar, 8, 20, 48, .59, 1.61, 3.44);
                inventoryFrame.dispose();
            }
        });
    }

    public void iceAction(){
        buttonIce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                acquisition("Ice Cubes", ice, 100, 250, 500, .83, 2.15, 3.88);
                inventoryFrame.dispose();
            }
        });
    }

    public void acquisition(String ingredient, int item, int q1, int q2, int q3, double p1, double p2, double p3){
        JLabel acquisitionLabel = new JLabel("Acquisition: " + ingredient, SwingConstants.CENTER);
        JLabel ownLabel = new JLabel("You have " + item + " " + ingredient + " and $" + df.format(money), SwingConstants.CENTER);
        JLabel buyLabel = new JLabel("You can buy:");
        JLabel qp1Label = new JLabel(q1 + " " + ingredient + " for $" + df.format(p1));
        JLabel qp2Label = new JLabel(q2 + " " + ingredient + " for $" + df.format(p2));
        JLabel qp3Label = new JLabel(q3 + " " + ingredient + " for $" + df.format(p3));

        JPanel panel = new JPanel(new GridLayout(0,1, 100, 100));
        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel2 = new JPanel(new GridLayout(1,0, 100, 0));

        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 0, 75));
        panel1.setBorder(BorderFactory.createEmptyBorder(25, 450, 25, 450));
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 200, 75, 200));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.insets = new Insets(5, 50, 5, 50);
        grid.ipadx = 60;
        grid.ipady = 30;

        customLabel(acquisitionLabel, "Comic Sans", Color.red, 35);
        customLabel(ownLabel, "Comic Sans", Color.black, 35);
        customLabel(buyLabel, "Comic Sans", Color.black, 24);
        customLabel(qp1Label, "Comic Sans", Color.black, 20);
        customLabel(qp2Label, "Comic Sans", Color.black, 20);
        customLabel(qp3Label, "Comic Sans", Color.black, 20);

        customButton(buttonBuy1, 25, Color.white, Color.black);
        customButton(buttonBuy2, 25, Color.white, Color.black);
        customButton(buttonBuy3, 25, Color.white, Color.black);
        customButton(buttonOK, 35, new Color(0, 204, 0), Color.white);

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
        grid.insets = new Insets(5, 5, 5, 100);
        panel1.add(buttonOK, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        buyAction(buttonBuy1, ownLabel, qp1Label, ingredient, q1, p1, buttonBuy2, buttonBuy3, qp2Label, qp3Label, p2, p3);
        buyAction(buttonBuy2, ownLabel, qp2Label, ingredient, q2, p2, buttonBuy1, buttonBuy3, qp1Label, qp3Label, p1, p3);
        buyAction(buttonBuy3, ownLabel, qp3Label, ingredient, q3, p3, buttonBuy1, buttonBuy2, qp1Label, qp2Label, p1, p2);
        okAction();

        acquisitionFrame.add(panel, BorderLayout.NORTH);
        acquisitionFrame.add(panel1, BorderLayout.CENTER);
        acquisitionFrame.add(panel2, BorderLayout.SOUTH);
        acquisitionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        acquisitionFrame.setTitle("Lemonade Stand");
        acquisitionFrame.setIconImage(image.getImage());
        acquisitionFrame.setUndecorated(false);
        acquisitionFrame.setResizable(false);
        acquisitionFrame.pack();
        acquisitionFrame.setVisible(true);
        device.setFullScreenWindow(acquisitionFrame);
        inventoryFrame.dispose();
    }

    public void buyAction(JButton buttonBuy, JLabel haveLabel, JLabel qpLabel, String component, int quantity, double price, JButton buttonClose1, JButton buttonClose2, JLabel closeLabel1, JLabel closeLabel2, double cost1, double cost2){
        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(money > price){
                    money -= price;
                    if(component.equals("Paper Cups")){
                        cup += quantity;
                        haveLabel.setText("You have " + cup + " " + component + " and $" + df.format(money));
                    }

                    else if(component.equals("Lemons")){
                        lemon += quantity;
                        haveLabel.setText("You have " + lemon + " " + component + " and $" + df.format(money));
                    }

                    else if(component.equals("Cups of Sugar")){
                        sugar += quantity;
                        haveLabel.setText("You have " + sugar + " " + component + " and $" + df.format(money));
                    }

                    else if(component.equals("Ice Cubes")){
                        ice += quantity;
                        haveLabel.setText("You have " + ice + " " + component + " and $" + df.format(money));
                    }
                    dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(money) + "</html>");
                }

                if(money - price < price){
                    money -= price;
                    if(component.equals("Paper Cups")){
                        cup += quantity;
                        if(money < 0){
                            money += price;
                            cup -= quantity;
                        }
                        haveLabel.setText("You have " + cup + " " + component + " and $" + df.format(money));
                    }

                    else if(component.equals("Lemons")){
                        lemon += quantity;
                        if(money < 0){
                            money += price;
                            lemon -= quantity;
                        }
                        haveLabel.setText("You have " + lemon + " " + component + " and $" + df.format(money));
                    }

                    else if(component.equals("Cups of Sugar")){
                        sugar += quantity;
                        if(money < 0){
                            money += price;
                            sugar -= quantity;
                        }
                        haveLabel.setText("You have " + sugar + " " + component + " and $" + df.format(money));
                    }

                    else if(component.equals("Ice Cubes")){
                        ice += quantity;
                        if(money < 0){
                            money += price;
                            ice -= quantity;
                        }
                        haveLabel.setText("You have " + ice + " " + component + " and $" + df.format(money));
                    }
                    dayLabel.setText("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(money) + "</html>");
                    
                    if(money - cost1 < 0){
                        buttonClose1.setEnabled(false);
                        customLabel(closeLabel1 , "Comic Sans", Color.lightGray, 20);
                    }

                    if(money - cost2 < 0){
                        buttonClose2.setEnabled(false);
                        customLabel(closeLabel2 , "Comic Sans", Color.lightGray, 20);
                    }
                    buttonBuy.setEnabled(false);
                    customLabel(qpLabel , "Comic Sans", Color.lightGray, 20);
                }
            }
        });
    }

    public void okAction(){
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase();
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

    public void startAction(){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new pricing();
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
                
                headLabel.setFont(new Font("MV Boli", Font.BOLD, 35));
                instructLabel.setFont(new Font("Consolas", Font.BOLD, 16));
                headLabel.setForeground(Color.red);
                instructLabel.setForeground(Color.black);
                headLabel.setHorizontalTextPosition(JLabel.CENTER);

                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel1 = new JPanel();

                panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel1.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
                panel.setBackground(new Color(0xF1E592));
                panel1.setBackground(new Color(0xF1E592));
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
                helpFrame.setUndecorated(false);
                helpFrame.setResizable(false);
                helpFrame.pack();
                helpFrame.setVisible(true);
                device.setFullScreenWindow(helpFrame);
                inventoryFrame.dispose();
            }
        });
    }

    public void backAction(JFrame backFrame){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase();
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