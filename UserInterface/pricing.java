package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class pricing extends JFrame{
    //values for the lemonade
    double money = 20.00;
    double price_per_cup = 1.00;
    int lemons = 4;
    int sugar = 4;
    int ice = 4;

    double monmax = 5.00;
    double monmin = 0.01;
    double monstep = .01;
    int max = 99;
    int min = 1;
    int step = 1;
    //values for the bottom itesm
    int temperature = 0;
    int currentDay = 1;
    int totalDay = 7;
    String weather = "Sunny";
    DecimalFormat df = new DecimalFormat("0.00");
    //buttons to go back
    JButton buttonBankrupt = new JButton("Bankrupt!");
    JButton buttonStart = new JButton("OK");
    JButton buttonHelp = new JButton("Help");
    JButton buttonBack = new JButton("Back to Store");
    //buttons to increase
    JFrame priceFrame = new JFrame();
    JFrame helpFrame = new JFrame();
    Button increase = new Button();
    Button decrease = new Button();
    //labels that show the amount
    JLabel ppc = new JLabel(" " + price_per_cup);
    JLabel amtlemon = new JLabel(" " + lemons);
    JLabel amtsugar = new JLabel(" " + sugar);
    JLabel amtice = new JLabel(" " + ice);

    JLabel headLabel = new JLabel("Price/Quality Control", SwingConstants.CENTER);
    JLabel ppc2 = new JLabel("Price per Cup: ");
    JLabel lems = new JLabel("Lemons per Pitcher: ");
    JLabel sugs = new JLabel("Sugar per Pitcher: ");
    JLabel icee = new JLabel("Ice per Cup: ");

    //spinner
    SpinnerModel model1 = new SpinnerNumberModel(price_per_cup, monmin, monmax, monstep);
    JSpinner spinner1 = new JSpinner(model1);
    //bottom items
    JLabel dayLabel = new JLabel("<html>Day " + currentDay + " of " + totalDay + "<br />Money: $" + df.format(money) + "</html>", SwingConstants.LEFT);
    JLabel weatherLabel = new JLabel("<html>Temperature: " + temperature + "&#8457<br />Weather: " + weather + "</html>", SwingConstants.RIGHT);
    //makes it look good
    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public static void main(String[] args) {
        new pricing();
    }

    public pricing(){
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
        customLabel(ppc2, "Comic Sans", Color.black, 20);
        customLabel(lems, "Comic Sans", Color.black, 20);
        customLabel(sugs, "Comic Sans", Color.black, 20);
        customLabel(icee, "Comic Sans", Color.black, 20);
        customLabel(dayLabel,"Georgia", Color.black, 20);
        customLabel(weatherLabel, "Georgia", Color.black, 20);

        
        customButton(buttonBankrupt, 18, Color.red, Color.white);
        customButton(buttonStart, 25, new Color(0, 204, 0), Color.white);
        customButton(buttonBack, 25, Color.white, Color.black);
        customButton(buttonHelp, 20, Color.orange, Color.white);

        panel.add(headLabel);
        

        grid.gridx = 0;
        grid.gridy = 0;
        panel1.add(ppc2, grid);

        grid.gridx = 1;
        panel1.add(spinner1, grid);

        grid.gridx = 2;
        panel1.add(ppc, grid);

        grid.gridx = 0;
        grid.gridy = 1;
        panel1.add(lems, grid);

        grid.gridx = 2;
        panel1.add(amtlemon, grid);

        grid.gridx = 0;
        grid.gridy = 2;
        panel1.add(sugs, grid);

        grid.gridx = 2;
        panel1.add(amtsugar, grid);

        grid.gridx = 0;
        grid.gridy = 3;
        panel1.add(icee, grid);

        grid.gridx = 2;
        panel1.add(amtice, grid);

        grid.gridx = 0;
        grid.gridy = 6;
        panel1.add(buttonBankrupt, grid);

        grid.insets = new Insets(5, 60, 5, 20);
        grid.gridx = 1;
        panel1.add(buttonStart, grid);

        grid.gridx = 1;
        grid.gridy = 5;
        panel1.add(buttonBack, grid);

        grid.gridx = 2;
        grid.gridy = 6;
        panel1.add(buttonHelp, grid);

        panel2.add(dayLabel);
        panel2.add(weatherLabel);

        bankruptAction();
        startAction();
        instructAction();
        goBack();

        priceFrame.add(panel, BorderLayout.NORTH);
        priceFrame.add(panel1, BorderLayout.CENTER);
        priceFrame.add(panel2, BorderLayout.SOUTH);
        priceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        priceFrame.setTitle("Lemonade Stand");
        priceFrame.setIconImage(image.getImage());
        priceFrame.setUndecorated(false);
        priceFrame.setResizable(false);
        priceFrame.pack();
        priceFrame.setVisible(true);
        device.setFullScreenWindow(priceFrame);
    }

    public void bankruptAction(){
        buttonBankrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new gameover();
                priceFrame.dispose();
            }
        });
    }

    public void startAction(){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new GameView();
                priceFrame.dispose();
            }
        });
    }

    public void goBack(){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Purchase();
                priceFrame.dispose();
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
                priceFrame.dispose();
            }
        });
    }

    public void backAction(JFrame backFrame){
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new pricing();
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
