package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,exit,balanceEnquiry,miniStatement,pinChange,withdrawal,fastCash;
    String pinNumber;
    Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Calibri",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Withdrawl");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastCash = new JButton("Fastcash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini-Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(270,520,150,30);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(e.getSource()==withdrawal){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (e.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (e.getSource()==pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(e.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(e.getSource()==miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
}
