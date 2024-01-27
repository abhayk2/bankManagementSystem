package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    MiniStatement(String pinNumber){
        setLayout(null);
        setTitle("Mini-Statement");

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("Your Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Connections con = new Connections();
            String query = "select * from login where pinNumber = '"+pinNumber+"'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number "+ rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            int bal = 0;

            Connections con = new Connections();
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                text.setText(text.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));

                }
            }
            balance.setText("Your Current Account Balance is Rs: "+ bal);

        }catch (Exception ae){
            ae.printStackTrace();
        }

        text.setBounds(20,140,400,200);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }

}
