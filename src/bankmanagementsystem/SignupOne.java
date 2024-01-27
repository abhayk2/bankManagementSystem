package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener {

    Random ran;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinCodeTextField;
    JRadioButton male,female,divorcee,married,unmarried;
    JButton next;
    JDateChooser dateChooser;
    long random;

    SignupOne(){
        setLayout(null);
        ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);


        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        female = new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        add(male);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("E-mail: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(100,390,200,30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        divorcee = new JRadioButton("Divorced");
        divorcee.setBounds(630,390,100,30);
        add(married);
        add(unmarried);
        add(divorcee);
        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);
        maritalStatusGroup.add(divorcee);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pinCode = new JLabel("Pin-Code: ");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinCodeTextField.setBounds(300,590,400,30);
        add(pinCodeTextField);


        JButton next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.setBackground(Color.CYAN);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.YELLOW);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno =  ""+random; // Form No
        String name = nameTextField.getText(); // Name
        String fname = fnameTextField.getText(); //Father's name
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(male.isSelected()){
            gender = "male";
        }else if (female.isSelected()){
            gender = "female";
        }

        String email = emailTextField.getText();
        String marital = "";
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if (divorcee.isSelected()){
            marital = "Divorced";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinCodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Connections c = new Connections();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
