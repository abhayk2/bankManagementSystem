package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno = "";
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page-3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,250,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4148");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel carddetail = new JLabel("Your 16 digit card number");
        carddetail.setFont(new Font("Raleway", Font.BOLD,12));
        carddetail.setBounds(100,330,300,15);
        add(carddetail);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pindetail = new JLabel("Your 4 digit pin");
        pindetail.setFont(new Font("Raleway", Font.BOLD,12));
        pindetail.setBounds(100,400,300,15);
        add(pindetail);

        JLabel pin_number = new JLabel("XXXX");
        pin_number.setFont(new Font("Raleway", Font.BOLD,22));
        pin_number.setBounds(330,370,300,30);
        add(pin_number);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD,22));
        services.setBounds(100,450,400,22);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);


    setSize(850,820);
    setLocation(350,0);
    getContentPane().setBackground(Color.YELLOW);
    setVisible(true);

    }
    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String accountType = "";
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }

//            System.out.println(accountType);

            Random rand = new Random();
            String cardNumber = ""+Math.abs((rand.nextLong()%90000000L)+5040936000000000L);
            String pinNumber = ""+ Math.abs((rand.nextLong()%9000L+1000L));

            String facility = "";
            if(c1.isSelected()){
                facility+=" ATM Card";
            }else if (c2.isSelected()){
                facility+=" Internet Banking";
            }else if (c3.isSelected()){
                facility+=" Mobile Banking";
            }else if (c4.isSelected()){
                facility+=" E-Mail & SMS Alerts";
            }else if (c5.isSelected()){
                facility+=" Cheque book";
            }else if (c6.isSelected()){
                facility+=" E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type Required");
                } else {
                    Connections conn = new Connections();
                    String query = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    conn.s.executeUpdate(query);
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number:"+cardNumber+"\nPIN:"+pinNumber);
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }

        } else if (e.getSource()==cancel) {
                setVisible(false);
                new Login().setVisible(true);
        }
    }
}
