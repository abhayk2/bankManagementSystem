package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinTextField;
    JPasswordField rePinTextField;
    JButton change;
    JButton back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pinText = new JLabel("New PIN: ");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        pinText.setBounds(165,320,180,25);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,25));
        pinTextField.setBounds(330,320,180,25);
        image.add(pinTextField);

        JLabel rePinText = new JLabel("Re-Enter new PIN: ");
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System",Font.BOLD,16));
        rePinText.setBounds(165,360,180,25);
        image.add(rePinText);

        rePinTextField = new JPasswordField();
        rePinTextField.setFont(new Font("Raleway",Font.BOLD,25));
        rePinTextField.setBounds(330,360,180,25);
        image.add(rePinTextField);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
            try {
                String newPin = pinTextField.getText();
                String rePin = rePinTextField.getText();
                if (!newPin.equals(rePin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }

                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the new pin");
                }

                if(rePin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re enter the new pin");
                }

                Connections conn = new Connections();
                String query1 = "update bank set pin = '"+rePin+"' where pin = '"+pinNumber+"' ";
                String query2 = "update login set pinNumber = '"+rePin+"' where pinNumber = '"+pinNumber+"' ";
                String query3 = "update signupthree set pinNumber = '"+rePin+"' where pinNumber = '"+pinNumber+"' ";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed Successfully");
                setVisible(false);
                new Transaction(newPin).setVisible(true);
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }else{
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
}
