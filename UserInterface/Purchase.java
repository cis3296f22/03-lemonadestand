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
    JButton buttonCup = new JButton("Buy More Cups");
    JButton buttonLemon = new JButton("Buy More Lemons");
    JButton buttonSugar = new JButton("Buy More Sugar");
    JButton buttonIce = new JButton("Buy More Ice");
    JButton buttonBankrupt = new JButton("Bankrupt!");
    JButton buttonStart = new JButton("OK");
    JButton buttonHelp = new JButton("Help");
    JButton buttonBack = new JButton("Back");

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
                //new pricing();
                //inventoryFrame.dispose();
            }
        });  
    }

    public void lemonAction(){
        buttonLemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //inventoryFrame.dispose();
            }
        });
    }

    public void sugarAction(){
        buttonSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //inventoryFrame.dispose();
            }
        });
    }

    public void iceAction(){
        buttonIce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //inventoryFrame.dispose();
            }
        });
    }

    public void bankruptAction(){
        buttonBankrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new MainMenu();
                inventoryFrame.dispose();
            }
        });
    }

    public void startAction(){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new GameView();
                //inventoryFrame.dispose();
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