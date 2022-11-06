package UserInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Purchase {
    public static void main(String[] args){
        new Purchase();
    }

    double money = 20;
    int cup = 0;
    int lemon = 0;
    int sugar = 0;
    int ice = 0;
    DecimalFormat df = new DecimalFormat("0.00");

    JFrame frame = new JFrame();
    JButton buttonCup = new JButton("Buy More Cups");
    JButton buttonLemon = new JButton("Buy More Lemons");
    JButton buttonSugar = new JButton("Buy More Sugar");
    JButton buttonIce = new JButton("Buy More Ice");
    JButton buttonBankrupt = new JButton("Bankrupt!");
    JButton buttonStart = new JButton("OK");
    JButton buttonHelp = new JButton("Help");;

    JLabel label = new JLabel("Inventory/Purchase", SwingConstants.CENTER);
    JLabel label1 = new JLabel("You have $" + df.format(money) + " and:", SwingConstants.CENTER);
    JLabel label2 = new JLabel(cup + " Paper Cups");
    JLabel label3 = new JLabel(lemon + " Lemons");
    JLabel label4 = new JLabel(sugar + " Cups of Sugar");
    JLabel label5 = new JLabel(ice + " Ice Cubes");

    ImageIcon image = new ImageIcon("UserInterface/LemonIcon.png");
    GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = graphics.getDefaultScreenDevice();

    public Purchase(){
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(75, 75, 0, 75));
        panel1.setBorder(BorderFactory.createEmptyBorder(25, 450, 25, 450));
        panel2.setBorder(BorderFactory.createEmptyBorder(50, 450, 75, 450));
        panel.setLayout(new GridLayout(0,1, 100, 100));
        panel1.setLayout(new GridLayout(4,2, 100, 15));
        panel2.setLayout(new GridLayout(1,0, 100, 0));
        panel.setBackground(new Color(0xF1E592));
        panel1.setBackground(new Color(0xF1E592));
        panel2.setBackground(new Color(0xF1E592));

        customLabel(label, Color.red, 35);
        customLabel(label1, Color.black, 35);
        customLabel(label2, Color.black, 20);
        customLabel(label3, Color.black, 20);
        customLabel(label4, Color.black, 20);
        customLabel(label5, Color.black, 20);

        customButton(buttonCup, 25, Color.white, Color.black);
        customButton(buttonLemon, 25, Color.white, Color.black);
        customButton(buttonSugar, 25, Color.white, Color.black);
        customButton(buttonIce, 25, Color.white, Color.black);
        customButton(buttonBankrupt, 18, Color.red, Color.white);
        customButton(buttonStart, 25, Color.green, Color.white);
        customButton(buttonHelp, 20, Color.orange, Color.white);

        panel.add(label);
        panel.add(label1);
        panel1.add(label2);
        panel1.add(buttonCup);
        panel1.add(label3);
        panel1.add(buttonLemon);
        panel1.add(label4);
        panel1.add(buttonSugar);
        panel1.add(label5);
        panel1.add(buttonIce);
        panel2.add(buttonBankrupt);
        panel2.add(buttonStart);
        panel2.add(buttonHelp);

        cupAction();
        lemonAction();
        sugarAction();
        iceAction();
        bankruptAction();
        startAction();
        helpAction();

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel1, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lemonade Stand");
        frame.setIconImage(image.getImage());
        frame.setUndecorated(false);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        device.setFullScreenWindow(frame);
    }

    public void cupAction(){
        buttonCup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //frame.dispose();
            }
        });  
    }

    public void lemonAction(){
        buttonLemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //frame.dispose();
            }
        });
    }

    public void sugarAction(){
        buttonSugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //frame.dispose();
            }
        });
    }

    public void iceAction(){
        buttonIce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //frame.dispose();
            }
        });
    }

    public void bankruptAction(){
        buttonBankrupt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new pricing();
                //frame.dispose();
            }
        });
    }

    public void startAction(){
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //new GameView();
                //frame.dispose();
            }
        });
    }

    public void helpAction(){
        buttonHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //main.instructAction;
                //frame.dispose();
            }
        });
    }

    public void customLabel(JLabel label, Color color, int size){
        label.setFont(new Font("Comic Sans", Font.BOLD, size));
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
